package carrer.nonSubject;

import student.*;


class nonSubjectActivity{

    Student user = Student.getInstance();

    private boolean graduation_check=false;

    public void input_nonSubjectActivity(){ }; // 액셀 파일에서 정보를 추가하는 메소드

    public void scan_nonSubjectActivity(){ }; // 액셀 파일에서 정보를 가져오는 메소드

    public void change_nonSubjectActivity(int count){ }; // 액셀 파일에서 정보를 수정하는 메소드

    public void check_career(){ }; // 경력 조건 인정
}







/*                         삭 쩨 !
class alternative_EnglishCareer extends nonSubjectActivity{

    private boolean alternative_value;

    public void check_pracEngCareer(boolean studiedPracEng){
        if(studiedPracEng == true)
            this.alternative_value = true;
    }

    @Override
    public void scan_nonSubjectActivity(){ // 액셀 파일에서 정보를 가져오는 메소드

    }

    @Override
    public void change_nonSubjectActivity(int count){ // 액셀 파일에서 정보를 수정하는 메소드

    }

    @Override
    public void check_career(){ // 경력 조건 인정

    }
}

class linguistic_Career extends alternative_EnglishCareer{
    private String country;
    private String university;
    private String trainingPeriod;

    @Override
    public void check_career(){  // 경력 조건 인정

    };
}

class languageSchool_Career extends alternative_EnglishCareer{
    private String lecture;
    private int studiedPeriod;
    private int studiedTime;

}

class English_multiple_minor_Career extends alternative_EnglishCareer{
    private String major;
    private String [] completedMajorSubject;

}*/