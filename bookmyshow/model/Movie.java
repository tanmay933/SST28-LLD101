package bookmyshow.model;

public class Movie {
    private String id;
    private String name;
    private int duration;

    public Movie(String id, String name, int duration) {
        this.id = id;
        this.name = name;
        this.duration = duration;
    }

    public String getId() { return id; }
    public String getName() { return name; }
}