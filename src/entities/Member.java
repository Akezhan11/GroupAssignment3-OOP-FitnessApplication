package entities;

import java.time.LocalDate;

public class Member {

    private int id;
    private String name;
    private String email;
    private LocalDate membershipEnd;

    public Member(int id, String name, String email, LocalDate membershipEnd) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.membershipEnd = membershipEnd;
    }

    public Member(String name, String email, LocalDate membershipEnd) {
        this.name = name;
        this.email = email;
        this.membershipEnd = membershipEnd;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getMembershipEnd() {
        return membershipEnd;
    }

    public boolean isMembershipActive() {
        return membershipEnd.isAfter(LocalDate.now());
    }
}
