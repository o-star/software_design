import java.util.*;

public class Main {


    static int min_cnt = 100;
    static int cnt=0;

    public static int operate(int number) {



        if (number % 3 == 0) {
            number /= 3;
            ++cnt;
            operate(number);

        } else if (number % 2 == 0) {
            number /= 2;
            ++cnt;
            operate(number);
        } else {
            number--;
            ++cnt;
            operate(number);
        }

        if (number == 1) {

            if (min_cnt > cnt){
                min_cnt=cnt;
                cnt=0;
                number=10;
                return 0;
            }

        }

        return 0;
    }



    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int number = input.nextInt();
        int oper_cnt;

       oper_cnt=operate(number);

       System.out.println(oper_cnt);


    }




}




