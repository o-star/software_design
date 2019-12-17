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

    private boolean field_practice_check;
    private int field_credit; // #### class diagram 에 추가되어야 하는 attribute , (1,11) cell 에 있음
    private double essential_field_credit; // 3학점 이상 채우면 pass!

    Data_nonSubject data = Data_nonSubject.getInstance();

    public boolean isField_practice_check() {
        return field_practice_check;
    }

    public int getField_credit() {
        return field_credit;
    }

    public field_practice(){
        scan_nonSubjectActivity();
    }

    @Override
    public void scan_nonSubjectActivity(){
        this.field_credit=data.getField_credit();
    }


    @Override
    public void change_nonSubjectActivity(int count){ // 액셀 파일에서 정보를 수정하는 메소드

        int changed_field_credit=field_credit+count;

        try {
            FileInputStream stu_file = new FileInputStream("학생경력정보.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(stu_file);
            XSSFSheet sheet_workbook = workbook.getSheetAt(0);     // sheet index

            boolean condition = true;
            int i = 1;
            int total_score=0;

            while (condition) { // ##### iterator로 수정할 필요..
                XSSFRow row_workbook = sheet_workbook.getRow(i);             // row index
                XSSFCell cell_workbook = row_workbook.getCell(1);            // cell index
                if ((cell_workbook.getStringCellValue() + "").equals(user.getStudent_code()) == true) {
                    XSSFSheet sheet_student = workbook.getSheetAt(i);     // sheet index
                    XSSFRow row_student = sheet_student.getRow(1);             // row index
                    XSSFCell cell_student = row_student.getCell(9);            // cell index
                    cell_student.setCellValue(Integer.toString(changed_field_credit)); // 수정된 상담횟수를 문자열로 다시 입력

                    cell_student=row_student.getCell(1);
                    total_score=Integer.parseInt(cell_student.getStringCellValue()+"");
                    total_score=total_score+field_credit;
                    cell_student.setCellValue(Integer.toString(total_score));
                    field_credit = changed_field_credit;

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
                i++; // #### 마찬가지로 수정해야함
            }

            stu_file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean check_career(){ // 경력 조건 인정

        essential_field_credit=graduation.getPractical_grade();

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