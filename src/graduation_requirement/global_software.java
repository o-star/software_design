package graduation_requirement;

public class global_software extends graduation_requirement {       // 글로벌소프트웨어 전공
    boolean multi_major;            // 다중전공여부
    int career_counseling = 4;      // 진로설계상담횟수

    public global_software()
    {
        super.major_track = "글로벌 소프트웨어";
        super.complete_credit_amount = 130;
    }
}
