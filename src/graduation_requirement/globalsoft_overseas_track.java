package graduation_requirement;

public class globalsoft_overseas_track extends global_software {

    public void setStartup_credit(){
        /* 엑셀파일로부터 창업교과목 학점 setting */
        startup_credit = Double.parseDouble(setter(2, 1, 8));
    }
    public void setEssential_major(){
        /* 엑셀파일로부터 필수전공 과목 seting */
        essential_major = ary_setter(2,11);
    }
    public void setCounseling(){
        /* 엑셀파일로부터 상담횟수 seting */

        counseling = Double.parseDouble(setter(2, 1, 13));
    }
    public void setEnglish_grade(){
        /* 엑셀파일로부터 외국복수학위 공인영어성적 setting */

        english_grade = Double.parseDouble(setter(2, 1, 12));
    }
    public void setComplete_credit_amount(){
        /* 엑셀파일로부터 총 이수학점 setting */

        complete_credit_amount = Double.parseDouble(setter(2, 1, 1));
    }

    public void setMajorbase_credit() {
        /* 엑셀파일로부터 전공기반 이수학점 setting */

        majorbase_credit = Double.parseDouble(super.setter(2, 1, 4));
    }

    public void setRefinement_credit() {
        /* 엑셀파일로부터 교양 이수학점 setting */

        refinement_credit = Double.parseDouble(setter(2, 1, 2));
    }



    public double getStartup_credit() {
        setStartup_credit();
        return startup_credit;
    }
    public String[] getEssential_major() {
        setEssential_major();
        return essential_major;
    }
    public double getCounseling() {
        setCounseling();
        return counseling;
    }
    public double getMajorbase_credit() {
        setMajorbase_credit();
        return majorbase_credit;
    }

    public double getRefinement_credit() {
        setRefinement_credit();
        return refinement_credit;
    }

    public double getEnglish_grade() {
        setEnglish_grade();
        return english_grade;
    }
    public double getComplete_credit_amount() {
        setComplete_credit_amount();
        return complete_credit_amount;
    }
}