package graduation_requirement;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class graduation_requirement {
    protected double complete_credit_amount;       // 총 이수 학점
    protected double english_grade;               // 공인 영어 성적
    private int counseling;                    // 상담횟수
    protected String track_name;             // 전공 트랙명

    public void change_graduation_requirement(String s) throws IOException {
    }

    public String setter(int sheetnum, int rownum, int columnnum){
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
}
