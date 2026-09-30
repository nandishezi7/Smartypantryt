package za.co.smartpantrymanager.model;

public class Recipe {

    private int id;
    private String name;
    private String method;
    private int minutes;
    private int servings;

    public Recipe(int id, String name, String method,
                  int minutes, int servings) {
        this.id = id;
        this.name = name;
        this.method = method;
        this.minutes = minutes;
        this.servings = servings;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMethod() {
        return method;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getServings() {
        return servings;
    }
}
