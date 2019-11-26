package graduation_requirement;

public class deep_computer extends graduation_requirement {     // 심화 컴퓨터 전공
    private int practical_grade;            // 현장실습 이수학점
    private String[] essential_major;       // 필수전공 과목
    private String[] essential_foundation;  // 필수전공기반 과목
    private int refinement_credit;          // 교양 이수학점
    private int majorbase_credit;           // 전공기반 이수학점
    private int major_credit;               // 전공 이수학점

    public deep_computer()
    {
        super.track_name = "심화 컴퓨터";
        super.complete_credit_amount = 150;
        super.english_grade = 700;
    }
}
