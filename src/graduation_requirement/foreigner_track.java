package graduation_requirement;

import java.io.FileInputStream;
import java.lang.*;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class foreigner_track extends graduation_requirement {
    private int foreign_credit;             // 외국인 복수학위 이수학점
    private int termtime;                   // 재학기간

    public foreigner_track()
    {
        super.track_name = "외국인 복수 전공 트랙";
    }
}
