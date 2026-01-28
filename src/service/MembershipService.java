package service;

import entities.Member;
import entities.MembershipType;
import exception.MembershipExpiredException;
import repositories.MemberRepository;

public class MembershipService {

    private final MemberRepository memberRepository;

    public MembershipService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void buyMembership(Member member, MembershipType type) {
        member.setMembership(type);
        memberRepository.save(member);
    }

    public void checkMembershipActive(Member member) {
        if (member.isExpired()) {
            throw new MembershipExpiredException();
        }
    }
}
