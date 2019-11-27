package graduation_requirement;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class global_software extends graduation_requirement {       // 글로벌소프트웨어 전공
    protected double global_credit;              // 글로벌역량 학점
    protected double startup_credit;             // 기술창업역량 학점
    protected boolean multi_major;            // 다중전공여부
    protected double career_counseling = 4;      // 진로설계상담횟수
    protected String[] essential_major;       // 필수전공 수강과목
    protected double major_credit;               // 전공 이수 학점
    protected double refinement_credit;          // 교퍙 이수 학점

    public global_software()
    {
        super.track_name = "글로벌 소프트웨어";
    }
}
