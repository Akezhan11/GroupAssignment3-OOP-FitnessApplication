package entities;

public class FitnessClass {

    private int id;
    private String title;
    private int capacity;
    private final int maxPlaces;

    public FitnessClass(int id, String title, int capacity, int maxPlaces) {
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
