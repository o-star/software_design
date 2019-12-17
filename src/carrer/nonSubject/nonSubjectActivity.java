package carrer.nonSubject;

import Data.Data_nonSubject;
import student.*;
import Data.graduation_requirement;

public class nonSubjectActivity{

    Student user = Student.getInstance();
    graduation_requirement graduation = graduation_requirement.getInstance();

    private boolean graduation_check=false;

    public void input_nonSubjectActivity(){ }; // 액셀 파일에서 정보를 추가하는 메소드

    public void scan_nonSubjectActivity(){ }; // 액셀 파일에서 정보를 가져오는 메소드

    public void change_nonSubjectActivity(int count){ }; // 액셀 파일에서 정보를 수정하는 메소드

    public boolean check_career(){ return true; }; // 경력 조건 인정


    public boolean isGraduation_check() {
        return graduation_check;
    }

    public void setGraduation_check(boolean graduation_check) {
        this.graduation_check = graduation_check;
    }

    public boolean check_all_nonSubject(){  // 졸업요건 충족현황 확인

        field_practice field = new field_practice();
        authorizedEnglish_score authorizedEnglish = new authorizedEnglish_score();
        counseling_history counseling = new counseling_history();

        if(field.check_career() == true && authorizedEnglish.check_career() == true && counseling.check_career() == true)
        {
             setGraduation_check(true);
        }
        else
            setGraduation_check(false);

        return isGraduation_check();
    }
}
