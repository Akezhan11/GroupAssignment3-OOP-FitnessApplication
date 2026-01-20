package entities;

public class FitnessClass {

    private int id;
    private String title;
    private int capacity;

    public FitnessClass(int id, String title, int capacity) {
        this.id = id;
        this.title = title;
        this.capacity = capacity;
    }

    public FitnessClass(String title, int capacity) {
        this.title = title;
        this.capacity = capacity;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getCapacity() {
        return capacity;
    }
}
