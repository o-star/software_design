//import student.
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.*;

class nonSubjectActivity{

    //student user = student.getInstance();

    private boolean graduation_check=false;

    public void input_nonSubjectActivity(){ }; // 액셀 파일에서 정보를 추가하는 메소드

    public void scan_nonSubjectActivity(){ }; // 액셀 파일에서 정보를 가져오는 메소드

    public void change_nonSubjectActivity(){ }; // 액셀 파일에서 정보를 수정하는 메소드

    public void check_career(){ }; // 경력 조건 인정
}

class counseling_history extends nonSubjectActivity{

    private int counseling_number; // 상담횟수
    private String student_id; // 학번
    private boolean counseling_check = false; // 졸업요건 상담횟수 충족 확인

    // private int counseling_data; // 상담일시
    // private String counseling_name; // 상담교수
    //nonSubjectActivity n = new nonSubjectActivity();
    //nonSubjectActivity();

    public void counseling_history(String s_id)
    {
        this.student_id = s_id;
        scan_nonSubjectActivity();
    }

    @Override
    public void scan_nonSubjectActivity() { // 액셀 파일에서 정보를 가져오는 메소드
        /* 엑셀파일에서 상담이력 setting */
        int sheet_no; // sheet number
        int x, y; // row, col
        try {
            FileInputStream stu_file = new FileInputStream("C:\\Users\\HyunSU\\Desktop\\개발\\학생경력정보.xlsx");
            XSSFWorkbook stu_info = new XSSFWorkbook(stu_file);
            XSSFSheet sheet_stuinfo = stu_info.getSheetAt(0);     // sheet index

            boolean condition = true;
            int i = 1;

            while (condition) {
                XSSFRow row_stuinfo = sheet_stuinfo.getRow(i);             // row index
                XSSFCell cell_stuinfo = row.getCell(1);            // cell index
                if ((cell_stuinfo.getStringCellValue() + "").equals(student_id) == true) {
                    sheet_no = i + 1;
                    XSSFSheet sheet = stu_info.getSheetAt(sheet_no);     // sheet index
                    XSSFRow row_stu_info = sheet.getRow(1);             // row index
                    XSSFCell cell_stu_info = row.getCell(11);            // cell index

                    this.counseling_number = Integer.parseDouble(cell.getNumericCellValue() + "");
                    condition = false;
                }
                i++;
            }

            stu_file.close();
            gradu_require_file.close();
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
            XSSFWorkbook stu_info = new XSSFWorkbook(stu_file);
            XSSFSheet sheet_stuinfo = stu_info.getSheetAt(0);     // sheet index


            boolean condition = true;
            int i = 1;

            while (condition) { // ##### iterator로 수정할 필요..
                XSSFRow row_stuinfo = sheet.getRow(i);             // row index
                XSSFCell cell_stuinfo = row_stuinfo.getCell(1);            // cell index
                if ((cell_stuinfo.getStringCellValue() + "").equals(student_id) == true) {
                    sheet_no = i + 1;
                    XSSFSheet sheet = stu_info.getSheetAt(sheet_no);     // sheet index
                    XSSFRow row_stu_info = sheet.getRow(1);             // row index
                    XSSFCell cell_stu_info = row_stu_info.getCell(11);            // cell index
                    cell.setCellValue(integer.toString(changed_counseling)); // 수정된 상담횟수를 문자열로 다시 입력

                    try {
                        FileOutputStream fileoutputstream = new FileOutputStream("C:\\Users\\user\\Desktop\\개발\\졸업요건.xlsx");
                        stu_info.write(fileoutputstream);
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
            FileInputStream stu_file = new FileInputStream("C:\\Users\\HyunSU\\Desktop\\개발\\학생경력정보.xlsx");
            XSSFWorkbook stu_info = new XSSFWorkbook(stu_file);
            XSSFSheet sheet_stuinfo = stu_info.getSheetAt(0);     // sheet index

            FileInputStream gradu_require_file = new FileInputStream("C:\\Users\\HyunSU\\Desktop\\개발\\졸업요건.xlsx");
            XSSFWorkbook gradu_require_info = new XSSFWorkbook(gradu_require_file);


            boolean condition = true;
            int i = 1;

            while (condition) { // iterator로 수정할 필요..
                XSSFRow row_stuinfo = sheet.getRow(i);             // row index
                XSSFCell cell_stuinfo = row_stuinfo.getCell(1);            // cell index
                if ((cell_stuinfo.getStringCellValue() + "").equals(student_id) == true) {
                    sheet_no = i + 1;
                    XSSFSheet sheet = gradu_require_info.getSheetAt(sheet_no);     // sheet index
                    XSSFRow row_gradu_require_info = sheet.getRow(1);             // row index
                    XSSFCell cell_gradu_require_info = row_gradu_require_info.getCell(9);            // cell index

                    essential_number = Integer.parseInt(cell.getNumericCellValue()+"");
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

class filed_practice extends nonSubjectActivity{

    private String filed_practice_instiution;
    private int practice_Start_data;
    private int practice_End_data;

    @Override
    public void input_nonSubjectActivity(){

    }

    @Override
    public void scan_nonSubjectActivity(){ // 액셀 파일에서 정보를 가져오는 메소드

    }

    @Override
    public void change_nonSubjectActivity(){ // 액셀 파일에서 정보를 수정하는 메소드

    }

    @Override
    public void check_career(){ // 경력 조건 인정

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
    public void change_nonSubjectActivity(){ // 액셀 파일에서 정보를 수정하는 메소드

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
    public void change_nonSubjectActivity(){ // 액셀 파일에서 정보를 수정하는 메소드

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

class English_multiple_minor_Carrer extends alternative_EnglishCarrer{
    private String major;
    private String [] completedMajorSubject;

    @Override
    public void check_career(){  // 경력 조건 인정

    };
}
