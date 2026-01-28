package entities;

import java.time.LocalDate;

public class Member {

    private int id;
    private String gender;
    private String name;
    private String surname;
    private String email;
    private String phone;

    private MembershipType membershipType;
    private LocalDate membershipEndDate;

    private static int idGEN=1;

    public Member(int id,String gender, String name, String surname, String email,String phone, LocalDate membershipEnd) {
        this.id = id;
        setGender(gender);
        setName(name);
        setSurname(surname);
        setEmail(email);
        setPhone(phone);
        setMembershipEndDate(membershipEnd);
    }

    public void setMembership(MembershipType type) {
        this.membershipType = type;
        this.membershipEndDate = LocalDate.now().plusDays(type.getDurationDays());
    }
    public boolean isExpired(){
        return membershipEndDate == null || membershipEndDate.isBefore(LocalDate.now());
    }
    public int getId() {
        return id;
    }
    public String getGender() { return gender;}
    public String getName() {
        return name;
    }
    public String getSurname() {return surname;}
    public String getEmail() {
        return email;
    }
    public String getPhone() {return phone;}
    public LocalDate getMembershipEndDate() { return membershipEndDate; }




    public void setName(String name){
        if(name == null || name.isEmpty()){
            throw new IllegalArgumentException("Write your Name");
        }
        this.name=name;
    }
    public void setSurname(String surname){
        if(surname == null || surname.isEmpty()){
            throw new IllegalArgumentException("Write your Surname");
        }
        this.surname=surname;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public void setPhone(String phone){
        this.phone=phone;
    }


    public void setGender(String gender) {
        if (gender == null) {
            throw new IllegalArgumentException("Write Male or Female");
        }

        if (!gender.equals("Male") && !gender.equals("Female")) {
            throw new IllegalArgumentException("Write Male or Female");
        }

        this.gender = gender;
    }
    public void setMembershipEndDate(LocalDate membershipEndDate) {
        if (membershipEndDate == null) {
            throw new IllegalArgumentException("Membership end date cannot be null");
        }
        this.membershipEndDate = membershipEndDate;
    }

}


