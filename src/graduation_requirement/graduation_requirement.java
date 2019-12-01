package graduation_requirement;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class graduation_requirement {
    protected double complete_credit_amount;       // 총 이수 학점
    protected double english_grade;               // 공인 영어 성적
    protected double counseling;                    // 상담횟수
    protected String track_name;             // 전공 트랙명

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


    protected String setter(int sheetnum, int rownum, int columnnum){
        /* 엑셀파일로부터 정보를 불러올 setter */

        String value = "";

        try {
            FileInputStream file = new FileInputStream("C:\\Users\\user\\Desktop\\소설 구현\\졸업요건.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            XSSFSheet sheet=workbook.getSheetAt(sheetnum);     // sheet index
            XSSFRow row=sheet.getRow(rownum);              // row index
            XSSFCell cell=row.getCell(columnnum);             // cell index

            value = cell.getStringCellValue()+"";

            file.close();
        }catch(Exception e) {
            e.printStackTrace();
        }

        return value;
    }
    protected String[] ary_setter(int sheetnum, int columnnum){
        /* 엑셀파일로부터 정보를 불러올 setter */

        String[] value = new String[30];
        int i=1;

        try {
            FileInputStream file = new FileInputStream("C:\\Users\\user\\Desktop\\소설 구현\\졸업요건.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            XSSFSheet sheet=workbook.getSheetAt(sheetnum);     // sheet index

            int rows = sheet.getPhysicalNumberOfRows();

            for(i=1; i<rows; i++){
                XSSFRow row=sheet.getRow(i);              // row index
                XSSFCell cell = row.getCell(columnnum);             // cell index
                if(cell.getStringCellValue() == "")
                    break;
                value[i-1] = cell.getStringCellValue()+"";
            }

            file.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
        String[] real_value = Arrays.copyOfRange(value, 0, i-1);
        return real_value;
    }
}
