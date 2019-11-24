package student;

public class Student{ // singleTorn

    private static Student student;

    private String track;
    private String name;
    private int student_code;
    private int pw;
    private int birthday_date;


    public Student() {
        this.track = "";
        this.name = "";
        this.student_code = -1;
        this.pw = -1;
        this.birthday_date = -1;
    }

    public static Student getInstance(){
        if(student==null)
            student=new Student();
        return student;
    }

    public String getTrack() {
        return track;
    }
    public void setTrack(String track) {
        this.track = track;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getStudent_code() {
        return student_code;
    }
    public void setStudent_code(int student_code) {
        this.student_code = student_code;
    }
    public int getPw() {
        return pw;
    }
    public void setPw(int pw) {
        this.pw = pw;
    }
    public int getBirthday_date() {
        return birthday_date;
    }
    public void setBirthday_date(int birthday_date) {
        this.birthday_date = birthday_date;
    }
}
