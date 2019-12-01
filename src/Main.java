import student.Student;
import carrer.nonSubject.*;


public class Main {

    public static void main(String[] args) {

        Student user = Student.getInstance();
        counseling_history h = new counseling_history();
        h.scan_nonSubjectActivity();
        System.out.println(h.getCounseling_number());

    }

}




