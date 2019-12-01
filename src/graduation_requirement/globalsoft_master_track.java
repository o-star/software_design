package graduation_requirement;

public class globalsoft_master_track extends global_software {

    public void setEssential_major(){
        /* 엑셀파일로부터 필수전공 과목 seting */
        essential_major = ary_setter(2,11);
    }
    public void setPractical_grade(){
        /* 엑셀파일로부터 현장실습학점 seting */
        practical_grade = Double.parseDouble(setter(3, 1, 7));
    }
    public void setCounseling(){
        /* 엑셀파일로부터 상담횟수 seting */

        counseling = Double.parseDouble(setter(3, 1, 13));
    }
    public void setEnglish_grade(){
        /* 엑셀파일로부터 학석사연계트랙 공인영어성적 setting */

        english_grade = Double.parseDouble(setter(3, 1, 12));
    }
    public void setComplete_credit_amount(){
        /* 엑셀파일로부터 총 이수학점 setting */

        complete_credit_amount = Double.parseDouble(setter(3, 1, 2));
    }

    public void setMajorbase_credit() {
        /* 엑셀파일로부터 전공기반 이수학점 setting */

        majorbase_credit = Double.parseDouble(super.setter(3, 1, 4));
    }

    public void setRefinement_credit() {
        /* 엑셀파일로부터 교양 이수학점 setting */

        refinement_credit = Double.parseDouble(setter(3, 1, 1));
    }



    public String[] getEssential_major() {
        setEssential_major();
        return essential_major;
    }
    public double getPractical_grade() {
        setPractical_grade();
        return practical_grade;
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
