package student;

public class Student { // singleTorn

    private static Student student;

    private String track;
    private String student_code;
    private String pw;
    private String birthday_date;


    public Student() {
        this.track = "";
        this.student_code = "2017091283";
        this.pw = "981230";
    }

    public static Student getInstance() {
        if (student == null)
            student = new Student();
        return student;
    }

    public void getData() { // 학생의 name에 맞게 액셀파일에서 정보를 불러오는 메소드

    }

    public static Student getStudent() {
        return student;
    }

    public static void setStudent(Student student) {
        Student.student = student;
    }

    public String getTrack() {
        return track;
    }

    public void setTrack(String track) {
        this.track = track;
    }

    public String getStudent_code() {
        return student_code;
    }

    public void setStudent_code(String student_code) {
        this.student_code = student_code;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }
}
