import student.Student;
import carrer.nonSubject.*;
import Data.*;
import curriculum_career.*;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        Student user = Student.getInstance();
        System.out.println(user.getTrack());
        Data_nonSubject d = Data_nonSubject.getInstance();
        data_curriculum p = data_curriculum.getInstance();
        graduation_requirement g = graduation_requirement.getInstance();


        field_practice a = new field_practice();
        System.out.println(a.getField_credit());




    }

}




