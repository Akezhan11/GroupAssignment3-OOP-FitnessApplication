package entities;

public class MembershipType{
    private String type;
    private int cost;
    private String description;
    private int durationDays;

    public MembershipType(String type, int cost, String description, int durationDays) {
        setType(type);
        setCost(cost);
        setDescription(description);
        setDurationDays(durationDays);
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        if(type == null || type.isEmpty()) {
            throw new IllegalArgumentException("type cannot be null or empty");
        }
        this.type = type;
    }


    public int getCost(){
        return cost;
    }
    public void setCost(int cost){
        if(cost < 0) {
            throw new IllegalArgumentException("cost cannot be negative");
        }
        this.cost = cost;
    }


    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        if(description == null || description.isEmpty()) {
            throw new IllegalArgumentException("description cannot be null or empty");
        }
        this.description = description;
    }
    public int getDurationDays(){
        return durationDays;
    }
    public void setDurationDays(int durationDays){
        if(durationDays < 0) {
            throw new IllegalArgumentException("durationDays cannot be negative");
        }
        this.durationDays = durationDays;
    }
    @Override
    public String toString() {
        return "type: " + getType() + "\n"
                + "Description: " + description + "\n"
                + "cost of the membership" + cost;
    }
}
