package entities;
public class ClassBooking {
    private Member member;
    private FitnessClass fitnessClass;

    public ClassBooking(Member member, FitnessClass fitnessClass) {
        setFitnessClass(fitnessClass);
        setMember(member);
    }

    public FitnessClass getFitnessClass() {
        return fitnessClass;
    }
    public void setFitnessClass(FitnessClass fitnessClass) {
        this.fitnessClass = fitnessClass;
    }

    public Member getMember() {
        return member;
    }
    public void setMember(Member member) {
        this.member = member;
    }
}
