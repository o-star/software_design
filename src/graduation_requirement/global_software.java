package graduation_requirement;

public class global_software extends graduation_requirement {       // 글로벌소프트웨어 전공
    private int global_credit;              // 글로벌역량 학점
    private int startup_credit;             // 기술창업역량 학점
    private boolean multi_major;            // 다중전공여부
    private int career_counseling = 4;      // 진로설계상담횟수
    private String[] essential_major;       // 필수전공 수강과목
    private int major_credit;               // 전공 이수 학점
    private int refinement_credit;          // 교퍙 이수 학점

    public global_software()
    {
        super.track_name = "글로벌 소프트웨어";
        super.complete_credit_amount = 130;
    }
}
