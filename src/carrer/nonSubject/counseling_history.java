package carrer.nonSubject;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class counseling_history extends nonSubjectActivity{

    private int counseling_number; // 상담횟수
    private int essential_count;
    private boolean counseling_check = false; // 졸업요건 상담횟수 충족 확인

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
    }

    @Override
    // #### 상담횟수가 0일때는 초기값 설정해줘야함
    public void change_nonSubjectActivity(int count){ // 액셀 파일에서 정보를 수정하는 메소드
        int changed_counseling = this.counseling_number + count;

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
                    System.out.println(changed_counseling);

                    try {
                        FileOutputStream fileoutputstream = new FileOutputStream("학생경력정보.xlsx");
                        workbook.write(fileoutputstream);
                        fileoutputstream.close();
                        System.out.println("엑셀파일생성성공");
                    } catch (IOException e) {
                        e.printStackTrace();
                        System.out.println("엑셀파일생성실패");
                    }
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
    public boolean check_career() { // 경력 조건 인정
        if(essential_count <= counseling_number){
            counseling_check = true;
        }

        return this.counseling_check;
    }
}