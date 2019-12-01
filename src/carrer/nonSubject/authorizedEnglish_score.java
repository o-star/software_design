package carrer.nonSubject;

import graduation_requirement.graduation_requirement;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

class authorizedEnglish_score extends nonSubjectActivity{

    private boolean authorizedEnglish_check = false;
    private String authorized_examName;
    private String essential_score; // 졸업요건정보에서 getter 로 가져와야 함..

    private int examDate;
    private int examScore;
    private int certificationDate;

    //private String major_track;

    graduation_requirement gradu = new graduation_requirement();
    @Override
    public void input_nonSubjectActivity(){

    }

    @Override
    public void scan_nonSubjectActivity(){ // 액셀 파일에서 정보를 가져오는 메소드
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
                    XSSFCell cell_student = row_student.getCell(10);            // cell index

                    this.examScore = Integer.parseInt(cell_workbook.getNumericCellValue() + "");
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
    public void change_nonSubjectActivity(int count){ // 액셀 파일에서 정보를 수정하는 메소드

    }

    @Override
    public void check_career(){ // 경력 조건 인정
        if(examScore >= Integer.parseInt(essential_score)) // essential_score 는 인트형으로 바뀔예정
        {
            authorizedEnglish_check = true;

        }
    }
}