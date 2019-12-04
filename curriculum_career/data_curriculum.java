package curriculum_career;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.DoubleToLongFunction;

import student.*;

public class data_curriculum {
    Scanner keyboard = new Scanner(System.in);
    Student stu = Student.getInstance();

    private double all_creadit;//총이수학점
    private double refinement_credit; //교양과목 이수학점
    private double base_refinement_credit;//기본소양 이수학점
    private double majorbase_credit; //전공기반 이수학점
    private double major_credit; //전공 이수학점
    private double global_capability;   // 글로벌 역량 학점
    private double startup_capability;  // 창업 역량 학점
    private String[] subject_name;      //과목명
    private String[] credit;      //학점
    private String[] curriculum_classification; //교과구분

    String num= stu.getStudent_code();

    public data_curriculum() throws IOException { setter(); }

    void setter() throws IOException {
        FileInputStream file = new FileInputStream("C:\\Users\\HyunSU\\Desktop\\software_design-mook\\학생경력정보.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet work_sheet=workbook.getSheetAt(0);
        int work_value=0;
        String s;

        XSSFSheet sheet=workbook.getSheetAt(0);     // sheet index
        int rows = sheet.getPhysicalNumberOfRows(); // 해당 시트의 행의 개수
        for (int rowIndex = 0; rowIndex < rows; rowIndex++) {
            XSSFRow row = sheet.getRow(rowIndex); // 각 행을 읽어온다
            if (row != null) {
                XSSFCell cell = row.getCell(1);//학번 비교하기
                String value = cell.getStringCellValue() + "";
                if (value.equals(num)) {
                    XSSFCell num_cell = row.getCell(0);//몇번째 시트인지 찾기
                    work_value = Integer.parseInt(num_cell.getStringCellValue() + "");
                    work_sheet = workbook.getSheetAt(work_value);//시트 도착
                    break;
                }
            }
        }
        XSSFRow row = work_sheet.getRow(1);
        XSSFCell cell;

        cell = row.getCell(1);
        s = String.valueOf(cell);
        if(!s.equals(""))
            all_creadit  = Double.parseDouble(cell.getStringCellValue()+"");  //총이수학점
        cell = row.getCell(2);
        s = String.valueOf(cell);
        if(!s.equals(""))
            refinement_credit  = Double.parseDouble(cell.getStringCellValue()+"");  //교양과목 이수학점
        cell = row.getCell(3);
        s = String.valueOf(cell);
        if(!s.equals(""))
            base_refinement_credit  = Double.parseDouble(cell.getStringCellValue()+"");  //기본소양 이수학점
        cell = row.getCell(4);
        s = String.valueOf(cell);
        if(!s.equals(""))
            majorbase_credit  = Double.parseDouble(cell.getStringCellValue()+"");  //전공기반 이수학점
        cell = row.getCell(5);
        s = String.valueOf(cell);
        if(!s.equals(""))
            major_credit  = Double.parseDouble(cell.getStringCellValue()+"");  //전공 이수학점
        cell = row.getCell(6);
        s = String.valueOf(cell);
        if(!s.equals(""))
            global_capability  = Double.parseDouble(cell.getStringCellValue()+"");   // 글로벌 역량 학점
        cell = row.getCell(7);
        s = String.valueOf(cell);
        if(!s.equals(""))
            startup_capability  = Double.parseDouble(cell.getStringCellValue()+"");  // 창업 역량 학점


        subject_name = ary_setter(workbook, work_value, 11);      //과목명
        credit = ary_setter(workbook, work_value, 12);     //학점
        curriculum_classification = ary_setter(workbook, work_value, 13); //교과구분
    }

    private String[] ary_setter(XSSFWorkbook workbook, int sheetnum, int columnnum){
        /* 엑셀파일로부터 정보를 불러올 setter */

        String[] value = new String[100];
        int i=1;

        try {
            XSSFSheet sheet=workbook.getSheetAt(sheetnum);     // sheet index

            int rows = sheet.getPhysicalNumberOfRows();

            for(i=1; i<rows; i++){
                XSSFRow row=sheet.getRow(i);              // row index
                XSSFCell cell = row.getCell(columnnum);             // cell index
                if(cell.getStringCellValue() == "")
                    break;
                value[i-1] = cell.getStringCellValue()+"";
            }

        }catch(Exception e) {
            e.printStackTrace();
        }
        String[] real_value = Arrays.copyOfRange(value, 0, i-1);
        return real_value;
    }

    public double getRefinement_credit() {
        return refinement_credit;
    }

    public double getMajorbase_credit() {
        return majorbase_credit;
    }

    public double getMajor_credit() {
        return major_credit;
    }

    public double getAll_creadit() {
        return all_creadit;
    }

    public double getGlobal_capability() {
        return global_capability;
    }

    public double getBase_refinement_credit() {
        return base_refinement_credit;
    }

    public double getStartup_capability() {
        return startup_capability;
    }

    public String[] getSubject_name(){
        return subject_name;
    }

    public String[] getCredit(){
        return credit;
    }

    public String[] getCurriculum_classification(){
        return curriculum_classification;
    }

}
