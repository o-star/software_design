package graduation_requirement;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class global_software extends graduation_requirement {       // 글로벌소프트웨어 전공
    private double global_credit;              // 글로벌역량 학점
    private double startup_credit;             // 기술창업역량 학점
    private boolean multi_major;            // 다중전공여부
    private double career_counseling = 4;      // 진로설계상담횟수
    private String[] essential_major;       // 필수전공 수강과목
    private double major_credit;               // 전공 이수 학점
    private double refinement_credit;          // 교퍙 이수 학점

    public global_software()
    {
        super.track_name = "글로벌 소프트웨어";
    }

    public void setComplete_credit_amount(){
        /* 엑셀파일로부터 글로벌소프트웨어전공 총 이수학점 setting */

        super.complete_credit_amount = Double.parseDouble(super.setter(1, 1, 0));
    }

    public void setEnglish_grade(){
        /* 엑셀파일로부터 글로벌소프트웨어전공 공인영어성적 setting */

        super.english_grade = Double.parseDouble(super.setter(1, 1, 5));
    }

    public void setMajor_credit() {
        /* 엑셀파일로부터 글로벌소프트웨어전공 공학전공 이수학점 setting */

        major_credit = Double.parseDouble(super.setter(1, 1, 2));
    }

    public void setRefinement_credit() {
        /* 엑셀파일로부터 글로벌소프트웨어전공 교양 이수학점 setting */

        refinement_credit = Double.parseDouble(super.setter(1, 1, 1));
    }

    public double getMajor_credit() {
        setMajor_credit();
        return major_credit;
    }

    public double getComplete_credit_amount() {
        setComplete_credit_amount();
        return super.complete_credit_amount;
    }

    public double getEnglish_grade() {
        setEnglish_grade();
        return super.english_grade;
    }

    public double getRefinement_credit() {
        setRefinement_credit();
        return refinement_credit;
    }
}
