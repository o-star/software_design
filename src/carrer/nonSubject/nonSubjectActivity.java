package carrer.nonSubject;
import student.*;

class nonSubjectActivity{

    Student user = Student.getInstance();

    private boolean graduation_check=false;

    public void input_nonSubjectActivity(){ }; // 액셀 파일에서 정보를 추가하는 메소드

    public void scan_nonSubjectActivity(){ }; // 액셀 파일에서 정보를 가져오는 메소드

    public void change_nonSubjectActivity(){ }; // 액셀 파일에서 정보를 수정하는 메소드

    public void check_career(){ }; // 경력 조건 인정
}

class counseling_history extends nonSubjectActivity{

    private int counseling_number;
    private int counseling_data;
    private String counseling_name;

    @Override
    public void input_nonSubjectActivity(){

    }

    @Override
    public void scan_nonSubjectActivity(){ // 액셀 파일에서 정보를 가져오는 메소드

    }
}

class filed_practice extends nonSubjectActivity{

    private String filed_practice_instiution;
    private int practice_Start_data;
    private int practice_End_data;


}

class authorizedEnglish_score extends nonSubjectActivity{

    private String authorized_examName;
    private int examDate;
    private int examScore;
    private int certificationDate;
}


class alternative_EnglishCarrer extends nonSubjectActivity{

    private boolean alternatvie_value;

}

class linguistic_Carrer extends alternative_EnglishCarrer{

}

class laguageSchool_Carrer extends alternative_EnglishCarrer{

}

class English_multiple_minor_Carrer extends alternative_EnglishCarrer{

}




