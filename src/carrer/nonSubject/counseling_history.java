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

    // private int counseling_data; // 상담일시
    // private String counseling_name; // 상담교수
    //nonSubjectActivity n = new nonSubjectActivity();
    //nonSubjectActivity();

    public void counseling_history()
    {
        scan_nonSubjectActivity();
    }

    @Override
    public void scan_nonSubjectActivity() { // 액셀 파일에서 정보를 가져오는 메소드
        /* 엑셀파일에서 상담이력 setting */
        int x, y; // row, col
        try {
            FileInputStream stu_file = new FileInputStream("C:\\Users\\HyunSU\\Desktop\\개발\\학생경력정보.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(stu_file);
            XSSFSheet sheet_workbook = workbook.getSheetAt(0);     // sheet index

            FileInputStream graduation_file = new FileInputStream("C:\\Users\\HyunSU\\Desktop\\개발\\졸업요건.xlsx");
            XSSFWorkbook graduation_workbook = new XSSFWorkbook(graduation_file);

            boolean condition = true;
            int i = 1;

            while (condition) {
                XSSFRow row_workbook = sheet_workbook.getRow(i);             // row index
                XSSFCell cell_workbook = row_workbook.getCell(1);            // cell index
                if ((cell_workbook.getStringCellValue() + "").equals(user.getStudent_code()) == true) {
                    XSSFSheet sheet_student = workbook.getSheetAt(i);     // sheet index
                    XSSFRow row_student = sheet_student.getRow(1);             // row index
                    XSSFCell cell_student = row_student.getCell(12);

                    for(i=0; i<9; i++)
                    {
                        XSSFSheet sheet_graduation = graduation_workbook.getSheetAt(i);
                        XSSFRow row_graduation = sheet_graduation.getRow(1);
                        XSSFCell cell_graduation = row_graduation.getCell(0);            // cell index
                        if((cell_graduation.getStringCellValue()+"").equals(user.getTrack()) == true)
                        {
                            XSSFCell cell_counseling = row_graduation.getCell(13);
                            essential_count = Integer.parseInt(cell_counseling.getStringCellValue()+"");
                        }
                    }
                    this.counseling_number = Integer.parseInt(cell_student.getStringCellValue() + "");
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
            FileInputStream stu_file = new FileInputStream("C:\\Users\\HyunSU\\Desktop\\개발\\학생경력정보.xlsx");
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
                        FileOutputStream fileoutputstream = new FileOutputStream("C:\\Users\\user\\Desktop\\개발\\졸업요건.xlsx");
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
    public void check_career() { // 경력 조건 인정
        if(essential_count <= counseling_number){
            counseling_check = true;
        }
    }
}