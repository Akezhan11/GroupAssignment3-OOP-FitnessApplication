package repositories;

import entities.Member;
import java.util.List;

public interface MemberRepository {

    void save(Member member);

    Member findById(int id);

    Member findByEmail(String email);

    Member findByPhone(String phone);

    List<Member> findAll();
}
