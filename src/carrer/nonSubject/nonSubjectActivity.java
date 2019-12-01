package carrer.nonSubject;

import student.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.*;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class nonSubjectActivity{

    Student user = Student.getInstance();

    private boolean graduation_check=false;

    public void input_nonSubjectActivity(){
    }; // 액셀 파일에서 정보를 추가하는 메소드

    public void scan_nonSubjectActivity(){ }; // 액셀 파일에서 정보를 가져오는 메소드

    public void change_nonSubjectActivity(int count){ }; // 액셀 파일에서 정보를 수정하는 메소드

    public void check_career(){ }; // 경력 조건 인정
}

class filed_practice extends nonSubjectActivity{

    //private String filed_practice_instiution;
    //private int practice_Start_data;
    //private int practice_End_data;
    private boolean field_practice_check = false;
    private String student_id;
    private int field_credit; // #### class diagram 에 추가되어야 하는 attribute
    private int essential_field_credit = 3; // 3학점 이상 채우면 pass!
    @Override
    public void input_nonSubjectActivity(){


    }

    @Override
    public void scan_nonSubjectActivity(){ // 액셀 파일에서 정보를 가져오는 메소드

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
                    XSSFCell cell_student = row_student.getCell(11);            // cell index

                    this.field_credit = Integer.parseInt(cell_workbook.getNumericCellValue() + "");
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
        if(this.field_credit >= this.essential_field_credit)
            this.field_practice_check = true;
        else
            this.field_practice_check = false;
    }
}

class authorizedEnglish_score extends nonSubjectActivity{

    private String authorized_examName;
    private int examDate;
    private int examScore;
    private int certificationDate;

    @Override
    public void input_nonSubjectActivity(){

    }

    @Override
    public void scan_nonSubjectActivity(){ // 액셀 파일에서 정보를 가져오는 메소드

    }

    @Override
    public void change_nonSubjectActivity(int count){ // 액셀 파일에서 정보를 수정하는 메소드

    }

    @Override
    public void check_career(){ // 경력 조건 인정

    }
}


class alternative_EnglishCarrer extends nonSubjectActivity{

    private boolean alternative_value;

    public void check_pracEngCareer(boolean studiedPracEng){
        if(studiedPracEng == true)
            this.alternative_value = true;
    }

    @Override
    public void scan_nonSubjectActivity(){ // 액셀 파일에서 정보를 가져오는 메소드

    }

    @Override
    public void change_nonSubjectActivity(int count){ // 액셀 파일에서 정보를 수정하는 메소드

    }

    @Override
    public void check_career(){ // 경력 조건 인정

    }
}

class linguistic_Carrer extends alternative_EnglishCarrer{
    private String country;
    private String university;
    private String trainingPeriod;

    @Override
    public void check_career(){  // 경력 조건 인정

    };
}

class languageSchool_Carrer extends alternative_EnglishCarrer{
    private String lecture;
    private int studiedPeriod;
    private int studiedTime;

    @Override
    public void check_career(){  // 경력 조건 인정

    };
}

class English_multiple_minor_Carrer extends alternative_EnglishCarrer {
    private String major;
    private String[] completedMajorSubject;

    @Override
    public void check_career() {  // 경력 조건 인정

    }


}
