package graduation_requirement;

public class globalsoft_multi_track extends global_software {

    public void setEnglish_grade(){
        /* 엑셀파일로부터 다중전공 공인영어성적 setting */

        english_grade = Double.parseDouble(super.setter(1, 1, 5));
    }
    public void setComplete_credit_amount(){
        /* 엑셀파일로부터 총 이수학점 setting */

        complete_credit_amount = Double.parseDouble(super.setter(1, 1, 0));
    }

    public void setMajor_credit() {
        /* 엑셀파일로부터 공학전공 이수학점 setting */

        major_credit = Double.parseDouble(super.setter(1, 1, 2));
    }

    public void setRefinement_credit() {
        /* 엑셀파일로부터 교양 이수학점 setting */

        refinement_credit = Double.parseDouble(super.setter(1, 1, 1));
    }

    public double getMajor_credit() {
        setMajor_credit();
        return major_credit;
    }

    public double getRefinement_credit() {
        setRefinement_credit();
        return refinement_credit;
    }

    public double getEnglish_grade() {
        setEnglish_grade();
        return super.english_grade;
    }
    public double getComplete_credit_amount() {
        setComplete_credit_amount();
        return super.complete_credit_amount;
    }
}
