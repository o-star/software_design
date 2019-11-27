package graduation_requirement;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class deep_computer extends graduation_requirement {     // 심화 컴퓨터 전공
    private int practical_grade;            // 현장실습 이수학점
    private String[] essential_major;       // 필수전공 과목
    private String[] essential_foundation;  // 필수전공기반 과목
    private double refinement_credit;          // 교양 이수학점
    private double majorbase_credit;           // 전공기반 이수학점
    private double major_credit;               // 전공 이수학점

    public deep_computer()
    {
        super.track_name = "심화 컴퓨터";
    }

    public void setComplete_credit_amount(){
        /* 엑셀파일로부터 심화컴퓨터전공 총 이수학점 setting */

            super.complete_credit_amount = Double.parseDouble(super.setter(0, 1, 0));
    }

    public void setEnglish_grade(){
        /* 엑셀파일로부터 심화컴퓨터전공 공인영어성적 setting */

        super.english_grade = Double.parseDouble(super.setter(0, 1, 6));
    }

    public void setRefinement_credit() {
        /* 엑셀파일로부터 심화컴퓨터전공 교양 이수학점 setting */

        refinement_credit = Double.parseDouble(super.setter(0, 1, 1));
    }

    public void setMajorbase_credit() {
        /* 엑셀파일로부터 심화컴퓨터전공 전공기반 이수학점 setting */

        majorbase_credit = Double.parseDouble(super.setter(0, 1, 2));
    }

    public void setMajor_credit() {
        /* 엑셀파일로부터 심화컴퓨터전공 공학전공 이수학점 setting */

        major_credit = Double.parseDouble(super.setter(0, 1, 3));
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

    public double getMajorbase_credit() {
        setMajorbase_credit();
        return majorbase_credit;
    }

    public double getMajor_credit() {
        setMajor_credit();
        return major_credit;
    }
}
