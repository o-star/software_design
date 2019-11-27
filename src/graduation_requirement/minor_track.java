package graduation_requirement;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.*;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class minor_track extends graduation_requirement {
    private double credit;             // 부전공 이수학점

    public minor_track()
    {
        super.track_name = "부전공 트랙";
    }
    public void setCredit(){
        /* 엑셀파일로부터 부전공 이수학점 setting */

        credit = Double.parseDouble(super.setter(6, 1, 0));
    }


    public double getCredit() {
        setCredit();
        return credit;
    }


    @Override
    public void change_graduation_requirement(String s) throws IOException {
        super.change_graduation_requirement(s);

        FileInputStream file = new FileInputStream("C:\\Users\\user\\Desktop\\소설 구현\\졸업요건.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(file);

        double num = Double.parseDouble(s);
        XSSFSheet sheet=workbook.getSheetAt(6);     // sheet index
        XSSFRow row=sheet.getRow(1);             // row index
        XSSFCell cell=row.getCell(0);            // cell index
        cell.setCellValue(num);                 //생성한 셀에 데이터 삽입
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
}
