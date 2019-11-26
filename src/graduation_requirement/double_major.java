package graduation_requirement;

import java.io.FileInputStream;
import java.lang.*;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class double_major extends graduation_requirement {
    private double double_credit;             // 복수전공 이수학점

    public double_major()
    {
        super.track_name = "복수전공 트랙";
    }

    public void setDouble_credit(){
        /* 엑셀파일에서 복수전공 이수학점 setting */

        try {
            FileInputStream file = new FileInputStream("C:\\Users\\user\\Desktop\\소설 구현\\졸업요건.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            XSSFSheet sheet=workbook.getSheetAt(5);     // sheet index
            XSSFRow row=sheet.getRow(1);             // row index
            XSSFCell cell=row.getCell(0);            // cell index

            double_credit = Double.parseDouble(cell.getNumericCellValue()+"");
            file.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }


    public double getDouble_credit() {
        setDouble_credit();
        return double_credit;
    }
}
