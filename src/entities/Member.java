package entities;

import java.time.LocalDate;

public class Member {

    private int id;
    private String gender;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private LocalDate membershipEnd;
    private static int idGEN;

    public Member(int id,String gender, String name, String surname, String email,String phone, LocalDate membershipEnd) {
        this.id = idGEN++;
        setGender(gender);
        setName(name);
        setSurname(surname);
        setEmail(email);
        setPhone(phone);
        //setMembershipend(membershipEnd);
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
    public LocalDate getMembershipEnd() {
        return membershipEnd;
    }
    public boolean isMembershipActive() {
        return membershipEnd.isAfter(LocalDate.now());
    }



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
        if(gender!="Male" || gender!="Female"){
            throw new IllegalArgumentException("Write Male or Female");
        }
        this.gender=gender;
    }
}
