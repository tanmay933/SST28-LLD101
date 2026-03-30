package bookmyshow.model;

import java.util.List;

public class Theatre {
    private String id;
    private String name;
    private String city;
    private List<Screen> screens;

    public Theatre(String id, String name, String city, List<Screen> screens) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.screens = screens;
    }

    public String getCity() { return city; }
    public List<Screen> getScreens() { return screens; }
}