package Data;

import student.*;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class graduation_requirement {
    private double complete_credit_amount;       // 총 이수 학점
    private double refinement_credit;          // 교양 이수 학점
    private double basic_credit;                // 기본소양 학점
    private double majorbase_credit;           // 전공기반 이수학점
    private double major_credit;               // 전공 이수학점
    private double global_credit;              // 글로벌역량 학점
    private double practical_grade;            // 현장실습 이수학점
    private double startup_credit;             // 창업교과목 학점
    private boolean startup_status;             // 스타트업 창업 여부
    private String[] essential_foundation;      // 필수전공기반 과목
    private String[] essential_major;           // 필수전공 수강과목
    private double english_grade;               // 공인 영어 성적
    private double counseling;                    // 상담횟수

    private static graduation_requirement requirement;

    public static graduation_requirement getInstance() {

        if(requirement == null)
            requirement = new graduation_requirement();
        return requirement;
    }

    graduation_requirement(){
        setter();
    }

    public void setter(){
        /* 엑셀파일로부터 정보를 불러올 setter */

        Student user = Student.getInstance();
        String s;

        try {
            FileInputStream file = new FileInputStream("C:\\Users\\user\\Desktop\\소설 구현\\졸업요건.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            XSSFSheet sheet = workbook.getSheetAt(0);
            XSSFRow row = sheet.getRow(0);
            XSSFCell cell = row.getCell(0);

            int sheets = workbook.getNumberOfSheets();
            int rows = sheet.getPhysicalNumberOfRows();

            int sheetnum;
            for(sheetnum=0; sheetnum<sheets; sheetnum++) {
                sheet = workbook.getSheetAt(sheetnum);     // sheet index
                row = sheet.getRow(1);              // row index
                cell = row.getCell(0);             // cell index
                if(user.getTrack().equals(cell.getStringCellValue()+"") == true)
                    break;
            }

            cell = row.getCell(1);
            s = String.valueOf(cell);
            if(!s.equals(""))
                complete_credit_amount = Double.parseDouble(cell.getStringCellValue()+"");       // 총 이수 학점
            cell = row.getCell(2);
            s = String.valueOf(cell);
            if(!s.equals(""))
                refinement_credit= Double.parseDouble(cell.getStringCellValue()+"");          // 교양 이수 학점
            cell = row.getCell(3);
            s = String.valueOf(cell);
            if(!s.equals(""))
                basic_credit= Double.parseDouble(cell.getStringCellValue()+"");                // 기본소양 학점
            cell = row.getCell(4);
            s = String.valueOf(cell);
            if(!s.equals(""))
                majorbase_credit= Double.parseDouble(cell.getStringCellValue()+"");           // 전공기반 이수학점
            cell = row.getCell(5);
            s = String.valueOf(cell);
            if(!s.equals(""))
                major_credit= Double.parseDouble(cell.getStringCellValue()+"");               // 전공 이수학점
            cell = row.getCell(6);
            s = String.valueOf(cell);
            if(!s.equals(""))
                global_credit= Double.parseDouble(cell.getStringCellValue()+"");              // 글로벌역량 학점
            cell = row.getCell(7);
            s = String.valueOf(cell);
            if(!s.equals(""))
                practical_grade= Double.parseDouble(cell.getStringCellValue()+"");            // 현장실습 이수학점
            cell = row.getCell(8);
            s = String.valueOf(cell);
            if(!s.equals(""))
                startup_credit= Double.parseDouble(cell.getStringCellValue()+"");             // 창업교과목 학점
            cell = row.getCell(9);
            s = String.valueOf(cell);
            if(!s.equals(""))
                startup_status = true;             // 스타트업 창업 여부


            essential_foundation = ary_setter(workbook, sheetnum, 10);      // 필수전공기반 과목

            essential_major = ary_setter(workbook, sheetnum, 11);           // 필수전공 수강과목

            cell = row.getCell(12);
            if(cell.equals("") == false)
                english_grade= Double.parseDouble(cell.getStringCellValue()+"");               // 공인 영어 성적
            cell = row.getCell(13);
            if(cell.equals("") == false)
                counseling= Double.parseDouble(cell.getStringCellValue()+"");                   // 상담횟수

            file.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    protected String[] ary_setter(XSSFWorkbook workbook, int sheetnum, int columnnum){
        /* 엑셀파일로부터 정보를 불러올 setter */

        String[] value = new String[30];
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

    public void change_graduation_requirement(String s, int sheetnum, int rownum, int columnnum) throws IOException {

        FileInputStream file = new FileInputStream("C:\\Users\\user\\Desktop\\소설 구현\\졸업요건.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(file);

        XSSFSheet sheet=workbook.getSheetAt(sheetnum);     // sheet index
        XSSFRow row=sheet.getRow(rownum);             // row index
        XSSFCell cell=row.getCell(columnnum);            // cell index
        cell.setCellValue(s);                 //생성한 셀에 데이터 삽입
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

    public double getComplete_credit_amount() {
        return complete_credit_amount;
    }

    public boolean isStartup_status() {
        return startup_status;
    }

    public double getBasic_credit() {
        return basic_credit;
    }

    public double getCounseling() {
        return counseling;
    }

    public double getGlobal_credit() {
        return global_credit;
    }

    public double getEnglish_grade() {
        return english_grade;
    }

    public double getMajor_credit() {
        return major_credit;
    }

    public double getMajorbase_credit() {
        return majorbase_credit;
    }

    public double getPractical_grade() {
        return practical_grade;
    }

    public double getRefinement_credit() {
        return refinement_credit;
    }

    public double getStartup_credit() {
        return startup_credit;
    }

    public String[] getEssential_foundation() {
        return essential_foundation;
    }

    public String[] getEssential_major() {
        return essential_major;
    }
}
