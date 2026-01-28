package entities;

public class FitnessClass {

    private int id;
    private String fitnessType;
    private String title;
    private int capacity;
    private int maxPlaces;

    public FitnessClass(int id, String title, int capacity, int maxPlaces) {
        this.id = id;
        this.title = title;
        this.capacity = capacity;
        setMaxPlaces(maxPlaces);
    }

    public FitnessClass(String title, int capacity) {
        this.title = title;
        this.capacity = capacity;
    }

    public FitnessClass() {}

    public void setId(int id){
        this.id = id;
    }

    public String getFitnessType() {
        return fitnessType;
    }

    public void setFitnessType(String fitnessType) {
        if (fitnessType == null || fitnessType.isEmpty()) {
            throw new IllegalArgumentException("Fitness type cannot be empty");
        }
        this.fitnessType = fitnessType;
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

    public int getMaxPlaces() {
        return maxPlaces;
    }

    public void setMaxPlaces(int maxPlaces) {
        if (maxPlaces <= 0) {
            throw new IllegalArgumentException("Max place must be > 0");
        }
        this.maxPlaces = maxPlaces;
    }
}
