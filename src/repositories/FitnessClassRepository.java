package repositories;

import entities.FitnessClass;
import java.util.List;
public interface FitnessClassRepository {
    void save(FitnessClass fitnessClass);
    FitnessClass findById(int id);
    FitnessClass findByType(String fitnessType);
    FitnessClass findByTrainerName(String fitnessTrainerName);
    FitnessClass findByCost(int fitnessCost);
    List<FitnessClass> findAll();
}
