package carrer.nonSubject;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class counseling_history extends nonSubjectActivity{

    private static counseling_history history;
    private int counseling_number; // 상담횟수

    private boolean counseling_check = false; // 졸업요건 상담횟수 충족 확인

    public static counseling_history getHistory() {
        return history;
    }

    public void setHistory(counseling_history history) {
        this.history = history;
    }

    public int getCounseling_number() {
        return counseling_number;
    }

    public void setCounseling_number(int counseling_number) {
        this.counseling_number = counseling_number;
    }

    public boolean isCounseling_check() {
        return counseling_check;
    }

    public void setCounseling_check(boolean counseling_check) {
        this.counseling_check = counseling_check;
    }

    @Override
    public void scan_nonSubjectActivity() { // 액셀 파일에서 정보를 가져오는 메소드
        /* 엑셀파일에서 상담이력 setting */
        int x, y; // row, col
        try {
            FileInputStream stu_file = new FileInputStream("학생경력정보.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(stu_file);
            XSSFSheet sheet_workbook = workbook.getSheetAt(0);     // sheet index

            boolean condition = true;
            int i = 1;

            while (condition) {
                XSSFRow row_workbook = sheet_workbook.getRow(i);             // row index
                XSSFCell cell_workbook = row_workbook.getCell(1);            // cell index
                if ((cell_workbook.getStringCellValue() + "").equals(user.getStudent_code()) == true) {
                    XSSFSheet sheet_student = workbook.getSheetAt(i);     // sheet index
                    XSSFRow row_student = sheet_student.getRow(1);             // row index
                    XSSFCell cell_student = row_student.getCell(12);            // cell index

                    this.counseling_number = Integer.parseInt(cell_student.getNumericCellValue() + "");
                    condition = false;
                }
                i++;
            }

            stu_file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    // #### 상담횟수가 0일때는 초기값 설정해줘야함
    public void change_nonSubjectActivity(int count){ // 액셀 파일에서 정보를 수정하는 메소드
        int changed_counseling = this.counseling_number + count;
        int sheet_no; // sheet number

        try {
            FileInputStream stu_file = new FileInputStream("학생경력정보.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(stu_file);
            XSSFSheet sheet_workbook = workbook.getSheetAt(0);     // sheet index


            boolean condition = true;
            int i = 1;

            while (condition) { // ##### iterator로 수정할 필요..
                XSSFRow row_workbook = sheet_workbook.getRow(i);             // row index
                XSSFCell cell_workbook = row_workbook.getCell(1);            // cell index
                if ((cell_workbook.getStringCellValue() + "").equals(user.getStudent_code()) == true) {
                    XSSFSheet sheet_student = workbook.getSheetAt(i);     // sheet index
                    XSSFRow row_student = sheet_student.getRow(1);             // row index
                    XSSFCell cell_student = row_student.getCell(12);            // cell index
                    cell_student.setCellValue(Integer.toString(changed_counseling)); // 수정된 상담횟수를 문자열로 다시 입력

                    try {
                        FileOutputStream fileoutputstream = new FileOutputStream("졸업요건.xlsx");
                        workbook.write(fileoutputstream);
                        fileoutputstream.close();
                        System.out.println("엑셀파일생성성공");
                    } catch (IOException e) {
                        e.printStackTrace();
                        System.out.println("엑셀파일생성실패");
                    }
                    condition = false;
                }
                i++; // #### 마찬가지로 수정해야함
            }

            stu_file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void check_career(){ // 경력 조건 인정
        int sheet_no; // sheet number
        int essential_number; // 졸업 요건 상담 횟수

        try {
            FileInputStream stu_file = new FileInputStream("학생경력정보.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(stu_file);
            XSSFSheet sheet_workbook = workbook.getSheetAt(0);     // sheet index

            FileInputStream graduation_file = new FileInputStream("졸업요건.xlsx");
            XSSFWorkbook graduation_workbook = new XSSFWorkbook(graduation_file);


            boolean condition = true;
            int i = 1;

            while (condition) { // iterator로 수정할 필요..
                XSSFRow row_workbook = sheet_workbook.getRow(i);             // row index
                XSSFCell cell_workbook = row_workbook.getCell(12);            // cell index
                if ((cell_workbook.getStringCellValue() + "").equals(user.getStudent_code()) == true) {
                    XSSFSheet sheet_graduation = graduation_workbook.getSheetAt(i);     // sheet index
                    XSSFRow row_graduation = sheet_graduation.getRow(1);             // row index
                    XSSFCell cell_graduation = row_graduation.getCell(9);            // cell index

                    essential_number = Integer.parseInt(cell_workbook.getNumericCellValue()+"");
                    if(essential_number <= counseling_number)
                        this.counseling_check = true;

                    condition = false;
                }
                i++; // 마찬가지로 수정해야함
            }

            stu_file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
