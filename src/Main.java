import student.Student;
import carrer.nonSubject.*;
import Data.*;

public class Main {

    public static void main(String[] args) {

        Student user = Student.getInstance();
        counseling_history h = new counseling_history();
        h.scan_nonSubjectActivity();
        System.out.println(h.getCounseling_number());
        h.change_nonSubjectActivity(6);

        nonSubjectActivity n = new nonSubjectActivity();
        System.out.println(n.check_all_nonSubject());
        Data_nonSubject d = Data_nonSubject.getInstance();
        System.out.println(d.getCounseling_number());
        System.out.println(d.getExamScore());
        System.out.println(d.getField_credit());



    }

}




