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

        credit = Double.parseDouble(setter(6, 1, 1));
    }


    public double getCredit() {
        setCredit();
        return credit;
    }
}
