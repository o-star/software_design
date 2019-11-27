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
        /* 엑셀파일로부터 복수전공 이수학점 setting */

        double_credit = Double.parseDouble(super.setter(5, 1, 0));
    }


    public double getDouble_credit() {
        setDouble_credit();
        return double_credit;
    }
}
