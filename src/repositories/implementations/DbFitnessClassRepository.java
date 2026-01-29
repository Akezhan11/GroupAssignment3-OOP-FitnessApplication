package repositories.implementations;

import edu.aitu.oop3.db.DatabaseConnection;
import entities.FitnessClass;
import repositories.FitnessClassRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbFitnessClassRepository implements FitnessClassRepository {

    @Override
    public void save(FitnessClass fitnessClass) {

        String sql = """
                INSERT INTO classes (title, capacity, max_places)
                VALUES (?, ?, ?)
                """;

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement st = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            st.setString(1, fitnessClass.getTitle());
            st.setInt(2, fitnessClass.getCapacity());
            st.setInt(3, fitnessClass.getMaxPlaces());

            st.executeUpdate();

            try (ResultSet rs = st.getGeneratedKeys()) {
                if (rs.next()) {
                    fitnessClass.setId(rs.getInt(1));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error saving class", e);
        }
    }

    @Override
    public FitnessClass findById(int id) {

        String sql = "SELECT * FROM classes WHERE id = ?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement st = con.prepareStatement(sql)) {

            st.setInt(1, id);

            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    return mapClass(rs);
                }
            }

            return null;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public FitnessClass findByType(String fitnessType) {
        // DB-де fitness_type деген колонка бар болса ғана жұмыс істейді
        // Егер ондай колонка жоқ болса — бұл методты қолданбаңдар
        String sql = "SELECT * FROM classes WHERE fitness_type = ?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement st = con.prepareStatement(sql)) {

            st.setString(1, fitnessType);

            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    return mapClass(rs);
                }
            }

            return null;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // ✅ интерфейс бойынша List қайтару керек
    @Override
    public List<FitnessClass> findByTrainerName(String fitnessTrainerName, String fitnessTrainerSurname) {
        // Егер classes таблицаңда trainer_name / trainer_surname колонкалары жоқ болса
        // бұл методты қолданбайсыңдар, бірақ compile үшін тұрады
        throw new UnsupportedOperationException();
    }

    // ✅ интерфейс бойынша List қайтару керек
    @Override
    public List<FitnessClass> findByCost(int fitnessCost) {
        // Егер classes таблицаңда cost колонкасы жоқ болса
        // бұл методты қолданбайсыңдар, бірақ compile үшін тұрады
        throw new UnsupportedOperationException();
    }

    @Override
    public List<FitnessClass> findAll() {

        String sql = "SELECT * FROM classes";
        List<FitnessClass> list = new ArrayList<>();

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement st = con.prepareStatement(sql);
             ResultSet rs = st.executeQuery()) {

            while (rs.next()) {
                list.add(mapClass(rs));
            }

            return list;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private FitnessClass mapClass(ResultSet rs) throws SQLException {
        return new FitnessClass(
                rs.getInt("id"),
                rs.getString("title"),
                rs.getInt("capacity"),
                rs.getInt("max_places")
        );
    }
}
