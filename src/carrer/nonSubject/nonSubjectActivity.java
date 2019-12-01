package carrer.nonSubject;

import student.*;
import graduation_requirement.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.*;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

class nonSubjectActivity{

    Student user = Student.getInstance();

    private boolean graduation_check=false;

    public void input_nonSubjectActivity(){ }; // 액셀 파일에서 정보를 추가하는 메소드

    public void scan_nonSubjectActivity(){ }; // 액셀 파일에서 정보를 가져오는 메소드

    public void change_nonSubjectActivity(int count){ }; // 액셀 파일에서 정보를 수정하는 메소드

    public void check_career(){ }; // 경력 조건 인정
}


class field_practice extends nonSubjectActivity{

    private boolean field_practice_check = false;
    private int field_credit; // #### class diagram 에 추가되어야 하는 attribute , (1,11) cell 에 있음
    private int essential_field_credit = 3; // 3학점 이상 채우면 pass!

    public int get_credit(){
        return field_credit;
    }

    @Override
    public void scan_nonSubjectActivity(){ // 액셀 파일에서 정보를 가져오는 메소드

        /* 엑셀파일에서 현장실습경력 setting */
        try {
            FileInputStream stu_file = new FileInputStream("C:\\Users\\HyunSU\\Desktop\\개발\\학생경력정보.xlsx");
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

        int changed_field_credit = field_credit + count;
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
                    XSSFCell cell_student = row_student.getCell(11);            // cell index
                    cell_student.setCellValue(Integer.toString(changed_field_credit)); // 수정된 상담횟수를 문자열로 다시 입력
                    field_credit = changed_field_credit;
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
    public void check_career(){ // 경력 조건 인정
        if(this.field_credit >= this.essential_field_credit)
        {
            this.field_practice_check = true;
            System.out.println("현장실습경력PASS");
        }
        else {
            this.field_practice_check = false;
            System.out.println("현장실습경력FAILED");
        }
    }
}

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
            FileInputStream stu_file = new FileInputStream("C:\\Users\\HyunSU\\Desktop\\개발\\학생경력정보.xlsx");
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

class alternative_EnglishCareer extends nonSubjectActivity{

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

class linguistic_Career extends alternative_EnglishCareer{
    private String country;
    private String university;
    private String trainingPeriod;

    @Override
    public void check_career(){  // 경력 조건 인정

    };
}

class languageSchool_Career extends alternative_EnglishCareer{
    private String lecture;
    private int studiedPeriod;
    private int studiedTime;

}

class English_multiple_minor_Career extends alternative_EnglishCareer{
    private String major;
    private String [] completedMajorSubject;

}