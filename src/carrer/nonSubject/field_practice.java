package carrer.nonSubject;

import Data.Data_nonSubject;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class field_practice extends nonSubjectActivity{

    private boolean field_practice_check = false;
    private int field_credit; // #### class diagram 에 추가되어야 하는 attribute , (1,11) cell 에 있음
    private int essential_field_credit = 3; // 3학점 이상 채우면 pass!

    public int get_credit(){
        return field_credit;
    }

    @Override
    public void scan_nonSubjectActivity(){ // 액셀 파일에서 정보를 가져오는 메소드

    }


    @Override
    public void change_nonSubjectActivity(int count){ // 액셀 파일에서 정보를 수정하는 메소드

        int changed_field_credit = field_credit + count;
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
                    XSSFCell cell_student = row_student.getCell(11);            // cell index
                    cell_student.setCellValue(Integer.toString(changed_field_credit)); // 수정된 상담횟수를 문자열로 다시 입력
                    field_credit = changed_field_credit;
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
    public boolean check_career(){ // 경력 조건 인정
        if(this.field_credit >= this.essential_field_credit)
        {
            this.field_practice_check = true;
            System.out.println("현장실습경력PASS");
        }
        else {
            this.field_practice_check = false;
            System.out.println("현장실습경력FAILED");
        }

        return this.field_practice_check;
    }
}