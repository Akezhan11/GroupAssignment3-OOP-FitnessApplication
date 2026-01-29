package repositories.implementations;

import edu.aitu.oop3.db.DatabaseConnection;
import entities.Member;
import exception.MemberNotFoundException;
import repositories.MemberRepository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

public class DbMemberRepository implements MemberRepository {

    @Override
    public void save(Member member) {
        String sql = """
                INSERT INTO members (gender, name, surname, email, phone, membership_end_date)
                VALUES (?, ?, ?, ?, ?, ?)
                """;

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement st = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            st.setString(1, member.getGender());
            st.setString(2, member.getName());
            st.setString(3, member.getSurname());
            st.setString(4, member.getEmail());
            st.setString(5, member.getPhone());
            st.setDate(6, Date.valueOf(member.getMembershipEndDate()));

            st.executeUpdate();

            // DB берген id-ны Member-ге қою (сенде setId бар ✅)
            try (ResultSet rs = st.getGeneratedKeys()) {
                if (rs.next()) {
                    member.setId(rs.getInt(1));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error saving member", e);
        }
    }

    @Override
    public Member findById(int id) {
        String sql = "SELECT id, gender, name, surname, email, phone, membership_end_date FROM members WHERE id = ?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement st = con.prepareStatement(sql)) {

            st.setInt(1, id);

            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) return mapMember(rs);
            }

            throw new MemberNotFoundException("Member not found with id=" + id);

        } catch (SQLException e) {
            throw new RuntimeException("Error finding member by id", e);
        }
    }

    @Override
    public Member findByEmail(String email) {
        String sql = "SELECT id, gender, name, surname, email, phone, membership_end_date FROM members WHERE email = ?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement st = con.prepareStatement(sql)) {

            st.setString(1, email);

            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) return mapMember(rs);
            }

            throw new MemberNotFoundException("Member not found with email=" + email);

        } catch (SQLException e) {
            throw new RuntimeException("Error finding member by email", e);
        }
    }

    @Override
    public Member findByPhone(String phone) {
        String sql = "SELECT id, gender, name, surname, email, phone, membership_end_date FROM members WHERE phone = ?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement st = con.prepareStatement(sql)) {

            st.setString(1, phone);

            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) return mapMember(rs);
            }

            throw new MemberNotFoundException("Member not found with phone=" + phone);

        } catch (SQLException e) {
            throw new RuntimeException("Error finding member by phone", e);
        }
    }

    @Override
    public List<Member> findAll() {
        String sql = "SELECT id, gender, name, surname, email, phone, membership_end_date FROM members ORDER BY id";

        List<Member> list = new ArrayList<>();

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement st = con.prepareStatement(sql);
             ResultSet rs = st.executeQuery()) {

            while (rs.next()) {
                list.add(mapMember(rs));
            }

            return list;

        } catch (SQLException e) {
            throw new RuntimeException("Error finding all members", e);
        }
    }

    private Member mapMember(ResultSet rs) throws SQLException {
        // Сенің Member конструкторың: Member(String gender, String name, String surname, String email, String phone, LocalDate membershipEnd)
        Member m = new Member(
                rs.getString("gender"),
                rs.getString("name"),
                rs.getString("surname"),
                rs.getString("email"),
                rs.getString("phone"),
                rs.getDate("membership_end_date").toLocalDate()
        );

        // DB-дағы id-ны кейін қоямыз
        m.setId(rs.getInt("id"));

        return m;
    }
}
