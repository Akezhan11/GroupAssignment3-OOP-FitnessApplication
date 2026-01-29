package service;

import entities.FitnessClass;
import repositories.FitnessClassRepository;

import java.util.List;

public class FitnessClassService {

    private final FitnessClassRepository repository;

    public FitnessClassService(FitnessClassRepository repository) {
        this.repository = repository;
    }

    public void addClass(FitnessClass fitnessClass) {
        repository.save(fitnessClass);
    }

    public List<FitnessClass> getAllClasses() {
        return repository.findAll();
    }

    public FitnessClass getById(int id) {
        return repository.findById(id);
    }
}
