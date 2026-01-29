package service;

import entities.Member;
import exception.MemberNotFoundException;
import repositories.MemberRepository;

import java.util.List;

public class MemberService {

    private final MemberRepository repository;

    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    public void addMember(Member member) {
        repository.save(member);
    }

    public Member getById(int id) {
        Member member = repository.findById(id);
        if (member == null) {
            throw new MemberNotFoundException("Member not found: id=" + id);
        }
        return member;
    }

    public Member getByEmail(String email) {
        Member member = repository.findByEmail(email);
        if (member == null) {
            throw new MemberNotFoundException("Member not found: email=" + email);
        }
        return member;
    }

    public Member getByPhone(String phone) {
        Member member = repository.findByPhone(phone);
        if (member == null) {
            throw new MemberNotFoundException("Member not found: phone=" + phone);
        }
        return member;
    }

    public List<Member> getAllMembers() {
        return repository.findAll();
    }
}
