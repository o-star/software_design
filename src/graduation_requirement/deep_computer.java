package graduation_requirement;

public class deep_computer extends graduation_requirement {     // 심화 컴퓨터 전공
    private int practical_grade = 3;        // 현장실습 이수학점
    private int refinement_credit = 15;     // 교양 이수학점
    private int majorbase_credit = 22;      // 전공기반 이수학점
    private int major_credit =75;           // 공학전공 이수학점

    public deep_computer()
    {
        super.major_track = "심화 컴퓨터";
        super.complete_credit_amount = 150;
        super.english_grade = 700;
    }
}
