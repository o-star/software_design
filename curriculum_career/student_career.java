package curriculum_career;

import org.apache.commons.collections4.ListUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import graduation_requirement.graduation_requirement;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.DoubleToLongFunction;
import java.lang.*;

public class student_career {
    boolean graduation_check = false; // 학생교과경력 졸업요건 충족 여부

    Scanner keyboard = new Scanner(System.in);
    double refinement_credit; //교양과목 이수학점
    double majorbase_credit; //전공기반 이수학점
    double base_refinement_credit;//기본소양 이수학점
    double major_credit; //전공 이수학점
    double all_creadit;//총이수학점
    String track;
    String num;
    double global_capability;
    double startup_capability;
    boolean double_up = false;//재이수
    int credit;//학점

    String subject_name = keyboard.nextLine(); //과목명
    String curriculum_classification = keyboard.nextLine(); //교과구분
    String grade = keyboard.nextLine();//성적
    data_curriculum data ;
    graduation_requirement gr;

    public student_career() throws IOException {
        data = new data_curriculum();
        track = data.stu.getTrack();
        num = data.stu.getStudent_code();
        refinement_credit = data.getRefinement_credit(); //교양과목 이수학점
        majorbase_credit = data.getMajorbase_credit(); //전공기반 이수학점
        base_refinement_credit = data.getBase_refinement_credit();//기본소양 이수학점
        major_credit = data.getMajor_credit(); //전공 이수학점
        all_creadit = data.getAll_creadit();//총이수학점
        gr = graduation_requirement.getInstance();
        global_capability = data.getGlobal_capability();
        startup_capability = data.getStartup_capability();

        ///###  String subject_name = keyboard.nextLine(); //과목명
        ///###  String curriculum_classification = keyboard.nextLine(); //교과구분
    }

    public void Curriculum_Career_input() throws IOException//교과 경력 입력
    {

        FileInputStream file = new FileInputStream("C:\\Users\\leehandsub\\Desktop\\학생경력정보.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(file);

        XSSFSheet sheet = workbook.getSheetAt(0);     // sheet index
        int rows = sheet.getPhysicalNumberOfRows(); // 해당 시트의 행의 개수
        for (int rowIndex = 0; rowIndex < rows; rowIndex++) {
            XSSFRow row = sheet.getRow(rowIndex); // 각 행을 읽어온다
            if (row != null) {
                XSSFCell cell = row.getCell(1);//학번 비교하기
                String value = cell.getStringCellValue() + "";
                if (value.equals(num)) {
                    XSSFCell num_cell = row.getCell(0);//몇번째 시트인지 찾기
                    String work_value = num_cell.getNumericCellValue() + "";
                    XSSFSheet work_sheet = workbook.getSheetAt(Integer.parseInt(work_value));//시트 도착
                    if (curriculum_classification.equals("전공기반"))//L index 11
                    {
                        int work_rows = work_sheet.getPhysicalNumberOfRows(); // 해당 시트의 행의 개수
                        for (int i = 0; i < work_rows; i++) {
                            XSSFRow work_row = work_sheet.getRow(i);
                            XSSFCell work_cell = work_row.getCell(11);
                            String s = cell.getStringCellValue() + "";
                            if (s.equals(null) || s.equals("")) {
                                work_cell.setCellValue(subject_name);
                                work_cell = work_row.getCell(12);
                                work_cell.setCellValue(Integer.toString(credit));
                            }
                        }
                    } else if (curriculum_classification.equals("전공"))//N index 13
                    {
                        int work_rows = work_sheet.getPhysicalNumberOfRows(); // 해당 시트의 행의 개수
                        for (int i = 0; i < work_rows; i++) {
                            XSSFRow work_row = work_sheet.getRow(i);
                            XSSFCell work_cell = work_row.getCell(13);
                            String s = work_cell.getStringCellValue() + "";
                            if (s.equals(null) || s.equals("")) {
                                work_cell.setCellValue(subject_name);
                                work_cell = work_row.getCell(14);
                                work_cell.setCellValue(Integer.toString(credit));
                            }
                        }
                    } else if (curriculum_classification.equals("교양"))//P index 15
                    {
                        int work_rows = work_sheet.getPhysicalNumberOfRows(); // 해당 시트의 행의 개수
                        for (int i = 0; i < work_rows; i++) {
                            XSSFRow work_row = work_sheet.getRow(i);
                            XSSFCell work_cell = work_row.getCell(15);
                            String s = work_cell.getStringCellValue() + "";
                            if (s.equals(null) || s.equals("")) {
                                work_cell.setCellValue(subject_name);
                                work_cell = work_row.getCell(16);
                                work_cell.setCellValue(Integer.toString(credit));
                            }
                        }
                    } else//기본소양 R 17
                    {
                        int work_rows = work_sheet.getPhysicalNumberOfRows(); // 해당 시트의 행의 개수
                        for (int i = 0; i < rows; i++) {
                            XSSFRow work_row = work_sheet.getRow(i);
                            XSSFCell work_cell = work_row.getCell(17);
                            String s = work_cell.getStringCellValue() + "";
                            if (s.equals(null) || s.equals("")) {
                                work_cell.setCellValue(subject_name);
                                work_cell = work_row.getCell(18);
                                work_cell.setCellValue(Integer.toString(credit));
                            }
                        }
                    }
                }

            }
            break;
        }

        file.close();

        try {
            FileOutputStream fileoutputstream = new FileOutputStream("C:\\Users\\leehandsub\\Desktop\\학생경력정보.xlsx");
            workbook.write(fileoutputstream);
            fileoutputstream.close();
            System.out.println("엑셀파일생성성공");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("엑셀파일생성실패");
        }

    }

    public void Curriculum_Career_inquiry()//교과 경력 조회
    {
        /// data.getAll_creadit();     이 메서드는 뭔지 모름....
    }

    public void Curriculum_Career_Modify() throws IOException//교과 경력 수정
    {
        FileInputStream file = new FileInputStream("C:\\Users\\user\\Desktop\\소설 구현\\졸업요건.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(file);

        XSSFSheet sheet = workbook.getSheetAt(0);     // sheet index
        int rows = sheet.getPhysicalNumberOfRows(); // 해당 시트의 행의 개수
        for (int rowIndex = 0; rowIndex < rows; rowIndex++) {
            XSSFRow row = sheet.getRow(rowIndex); // 각 행을 읽어온다
            if (row != null) {
                XSSFCell cell = row.getCell(1);//학번 비교하기
                String value = cell.getStringCellValue() + "";
                if (value.equals(num)) {
                    XSSFCell num_cell = row.getCell(0);//몇번째 시트인지 찾기
                    String work_value = num_cell.getNumericCellValue() + "";
                    XSSFSheet work_sheet = workbook.getSheetAt(Integer.parseInt(work_value));//시트 도착
                    if (curriculum_classification.equals("전공기반"))//L index 11
                    {
                        int work_rows = work_sheet.getPhysicalNumberOfRows(); // 해당 시트의 행의 개수
                        for (int i = 0; i < work_rows; i++) {
                            XSSFRow work_row = work_sheet.getRow(i);
                            XSSFCell work_cell = work_row.getCell(11);
                            String s = work_cell.getStringCellValue() + "";
                            if (s.equals(subject_name)) {
                                work_cell = work_row.getCell(12);
                                work_cell.setCellValue(Integer.toString(credit));
                            }
                        }
                    } else if (curriculum_classification.equals("전공"))//N index 13
                    {
                        int work_rows = work_sheet.getPhysicalNumberOfRows(); // 해당 시트의 행의 개수
                        for (int i = 0; i < work_rows; i++) {
                            XSSFRow work_row = work_sheet.getRow(i);
                            XSSFCell work_cell = work_row.getCell(13);
                            String s = work_cell.getStringCellValue() + "";
                            if (s.equals(subject_name)) {
                                work_cell = work_row.getCell(14);
                                work_cell.setCellValue(Integer.toString(credit));
                            }
                        }
                    } else if (curriculum_classification.equals("교양"))//P index 15
                    {
                        int work_rows = work_sheet.getPhysicalNumberOfRows(); // 해당 시트의 행의 개수
                        for (int i = 0; i < work_rows; i++) {
                            XSSFRow work_row = work_sheet.getRow(i);
                            XSSFCell work_cell = work_row.getCell(15);
                            String s = work_cell.getStringCellValue() + "";
                            if (s.equals(subject_name)) {
                                work_cell = work_row.getCell(16);
                                work_cell.setCellValue(Integer.toString(credit));
                            }
                        }
                    } else//기본소양 R 17
                    {
                        int work_rows = work_sheet.getPhysicalNumberOfRows(); // 해당 시트의 행의 개수
                        for (int i = 0; i < rows; i++) {
                            XSSFRow work_row = work_sheet.getRow(i);
                            XSSFCell work_cell = work_row.getCell(17);
                            String s = work_cell.getStringCellValue() + "";
                            if (s.equals(subject_name)) {
                                work_cell = work_row.getCell(18);
                                work_cell.setCellValue(Integer.toString(credit));
                            }
                        }
                    }
                }

            }
            break;
        }
        file.close();

        try {
            FileOutputStream fileoutputstream = new FileOutputStream("C:\\Users\\user\\Desktop\\소설 구현\\졸업요건.xlsx");
            workbook.write(fileoutputstream);
            fileoutputstream.close();
            System.out.println("엑셀파일생성성공");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("엑셀파일생성실패");
        }
    }

    public void Studied_Creadit_upadate() throws IOException//이수학점 업데이트
    {
        FileInputStream file = new FileInputStream("C:\\Users\\leehandsub\\Desktop\\학생경력정보.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(file);

        XSSFSheet sheet = workbook.getSheetAt(0);     // sheet index
        int rows = sheet.getPhysicalNumberOfRows(); // 해당 시트의 행의 개수
        for (int rowIndex = 0; rowIndex < rows; rowIndex++) {
            XSSFRow row = sheet.getRow(rowIndex); // 각 행을 읽어온다
            if (row != null) {
                XSSFCell cell = row.getCell(1);//학번 비교하기
                String value = cell.getStringCellValue() + "";
                if (value.equals(num)) {
                    XSSFCell num_cell = row.getCell(0);//몇번째 시트인지 찾기
                    String work_value = num_cell.getNumericCellValue() + "";
                    XSSFSheet work_sheet = workbook.getSheetAt(Integer.parseInt(work_value));//시트 도착
                    XSSFRow work_row = work_sheet.getRow(1);             // row index
                    XSSFCell work_cell = work_row.getCell(1);
                    String s = work_cell.getStringCellValue() + "";
                    if (s.equals(null) || s.equals("")) {//총이수학점 0이면 나머지 0이다.
                        refinement_credit = 0; //교양과목 이수학점
                        base_refinement_credit = 0;//기본소양 이수학점
                        majorbase_credit = 0; //전공기반 이수학점
                        major_credit = 0; //전공 이수학점
                        all_creadit = 0;//총이수학점
                    } else//파일에잇는 정보 가져오기
                    {
                        all_creadit = (int) Double.parseDouble(s);
                        work_cell = work_row.getCell(2);
                        s = work_cell.getStringCellValue() + "";
                        refinement_credit = Integer.parseInt(s);
                        work_cell = work_row.getCell(3);
                        s = work_cell.getStringCellValue() + "";
                        base_refinement_credit = Integer.parseInt(s);
                        work_cell = work_row.getCell(4);
                        s = work_cell.getStringCellValue() + "";
                        majorbase_credit = Integer.parseInt(s);
                        work_cell = work_row.getCell(5);
                        s = work_cell.getStringCellValue() + "";
                        major_credit = Integer.parseInt(s);
                    }
                    if (curriculum_classification.equals("전공기반"))//L index 11
                    {
                        all_creadit += credit;
                        majorbase_credit += credit;
                        //work_row=work_sheet.getRow(1);
                        work_cell = work_row.getCell(1);
                        work_cell.setCellValue(Double.toString(all_creadit));
                        work_cell = work_row.getCell(5);
                        work_cell.setCellValue(Double.toString(majorbase_credit));


                    } else if (curriculum_classification.equals("전공"))//N index 13
                    {
                        all_creadit += credit;
                        major_credit += credit;
                        //work_row=work_sheet.getRow(1);
                        work_cell = work_row.getCell(1);
                        work_cell.setCellValue(Double.toString(all_creadit));
                        work_cell = work_row.getCell(4);
                        work_cell.setCellValue(Double.toString(major_credit));
                    } else if (curriculum_classification.equals("교양"))//P index 15
                    {
                        all_creadit += credit;
                        refinement_credit += credit;
                        //work_row=work_sheet.getRow(1);
                        work_cell = work_row.getCell(1);
                        work_cell.setCellValue(Double.toString(all_creadit));
                        work_cell = work_row.getCell(2);
                        work_cell.setCellValue(Double.toString(refinement_credit));
                    } else//기본소양 R 17
                    {
                        all_creadit += credit;
                        base_refinement_credit += credit;
                        //work_row=work_sheet.getRow(1);
                        work_cell = work_row.getCell(1);
                        work_cell.setCellValue(Double.toString(all_creadit));
                        work_cell = work_row.getCell(3);
                        work_cell.setCellValue(Double.toString(base_refinement_credit));
                    }
                }

            }
            break;
        }
        file.close();
    }

    public boolean check_essential_major()
    {
        String [] essential_major = gr.getEssential_major();
        String [] passed_subject_name = data.getSubject_name();
        List diff = ListUtils.subtract(Arrays.asList(essential_major), Arrays.asList(passed_subject_name));
        if(diff.size() == 0) {   // 필수전공과목을 모두 수강하였다면.
            return true;
        }
        return false;
    }
    public boolean check_essential_majorbase()
    {
        String [] essential_majorbase = gr.getEssential_foundation();
        String [] passed_subject_name = data.getSubject_name();
        List diff = ListUtils.subtract(Arrays.asList(essential_majorbase), Arrays.asList(passed_subject_name));
        if(diff.size() == 0) {   // 필수전공기반과목을 모두 수강하였다면.
            return true;
        }
        return false;
    }

    public void State_update() throws IOException//상태 업데이트
    {
        data_curriculum d = new data_curriculum();
        if (track.equals("심화퓨터전공")) {
            boolean all_creadit_pass = false;
            boolean base_refinement_credit_pass = false;
            boolean majorbase_credit_pass = false;
            boolean major_credit_pass = false;
            boolean essential_major_pass = false;
            boolean essential_majorbase_pass = false;

            if (all_creadit >= 150){ //총이수
                all_creadit_pass = true;
            }
            if (base_refinement_credit >= 15){ //기본소양
                base_refinement_credit_pass = true;
            }
            if (majorbase_credit >= 22){ //전공기반
                majorbase_credit_pass = true;
            }
            if (major_credit >= 75){ //전공
                major_credit_pass = true;
            }
            if(check_essential_major()){//필수전공 체크
               essential_major_pass = true;
            }
            if(check_essential_majorbase()){//필수전공기반 체크
                essential_majorbase_pass = true;
            }
            if(all_creadit_pass && base_refinement_credit_pass && majorbase_credit_pass && major_credit_pass && essential_major_pass && essential_majorbase_pass ){
                graduation_check = true;
            }

        } else if (track.equals("다중전공트랙")) {
            boolean all_creadit_pass = false;
            boolean refinement_credit_pass = false;
            boolean major_credit_pass = false;
            boolean global_capability_pass = false;
            boolean startup_capability_pass = false;
            boolean essential_major_pass = false;

            if (all_creadit >= 130) {
                all_creadit_pass = true;
            }
            if (refinement_credit >= 24) {
                refinement_credit_pass = true;
            }
            if (major_credit >= 51) {
                major_credit_pass = true;
            }
            if (global_capability >= 9) {
                global_capability_pass = true;
            }
            if (startup_capability >= 9) {
                startup_capability_pass = true;
            }
            if(check_essential_major()){//필수전공 체크
                essential_major_pass = true;
            }
            if(all_creadit_pass && refinement_credit_pass && major_credit_pass && global_capability_pass && startup_capability_pass && essential_major_pass){ //필수전공 체크
                graduation_check = true;
            }
        } else if (track.equals("해외복수학위트랙")) {
            boolean all_creadit_pass = false;
            boolean refinement_credit_pass = false;
            boolean major_credit_pass = false;
            boolean global_capability_pass = false;
            boolean startup_capability_pass = false;
            boolean essential_major_pass = false;

            if (all_creadit >= 130) {
                all_creadit_pass = true;
            }
            if (refinement_credit >= 24) {
                refinement_credit_pass = true;
            }
            if (major_credit >= 51) {
                major_credit_pass = true;
            }
            if (global_capability >= 36)//글로벌역량 (복수학위 년수)
            {
                global_capability_pass = true;
            }
            if (startup_capability >= 3) {
                startup_capability_pass = true;
            }
            if(check_essential_major()) { //필수전공 체크
                essential_major_pass = true;
            }
            if(all_creadit_pass && refinement_credit_pass && major_credit_pass && global_capability_pass && startup_capability_pass && essential_major_pass){ //필수전공 체크
                graduation_check = true;
            }

        } else if (track.equals("학석사연계트랙")) {
            boolean all_creadit_pass = false;
            boolean refinement_credit_pass = false;
            boolean major_credit_pass = false;
            boolean global_capability_pass = false;
            boolean essential_major_pass = false;

            if (all_creadit >= 130) {
                all_creadit_pass = true;
            }
            if (refinement_credit >= 24) {
                refinement_credit_pass = true;
            }
            if (major_credit >= 51) {
                major_credit_pass = true;
            }
            if (global_capability >= 6)//글로벌역량
            {
                global_capability_pass = true;
            }
            if (check_essential_major())
            {
                essential_major_pass = true;
            }
            if(all_creadit_pass && refinement_credit_pass && major_credit_pass && global_capability_pass &&  essential_major_pass){ //필수전공 체크
                graduation_check = true;
            }

        } else if (track.equals("융합전공")) {
            boolean all_creadit_pass = false;
            if (all_creadit >= 36) {
                all_creadit_pass = true;
                graduation_check = true;
            }
        } else if (track.equals("복수전공")) {
            boolean all_creadit_pass = false;
            if (all_creadit >= 65) {
                all_creadit_pass = true;
                graduation_check = true;
            }
        } else if (track.equals("부전공")) {
            boolean all_creadit_pass = false;
            if (all_creadit >= 21) {
                all_creadit_pass = true;
                graduation_check = true;
            }
        } else if (track.equals("외국인복수전공")) {
            boolean all_creadit_pass = false;
            if (all_creadit >= 38) {
                all_creadit_pass = true;
                graduation_check = true;
            }
        } else if (track.equals("외국인교환학생")) {
            boolean all_creadit_pass = false;
            if (all_creadit >= 21) {
                all_creadit_pass = true;
                graduation_check = true;
            }
        }
    }

    public void setMajor_credit(int major_credit) {
        this.major_credit = major_credit;
    }

    public double getMajor_credit() {
        return major_credit;
    }

    public void setMajorbase_credit(int majorbase_credit) {
        this.majorbase_credit = majorbase_credit;
    }

    public double getMajorbase_credit() {
        return majorbase_credit;
    }

    public void setRefinement_credit(int refinement_credit) {
        this.refinement_credit = refinement_credit;
    }

    public double getRefinement_credit() {
        return refinement_credit;
    }

    public void setCurriculum_classification(String curriculum_classification) {
        this.curriculum_classification = curriculum_classification;
    }

    public String getCurriculum_classification() {
        return curriculum_classification;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getGrade() {
        return grade;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public String getSubject_name() {
        return subject_name;
    }
}