package bookmyshow.service;

import bookmyshow.model.Theatre;
import java.util.*;

public class TheatreService {

    private Map<String, List<Theatre>> cityTheatres = new HashMap<>();

    public void addTheatre(String city, Theatre theatre) {
        cityTheatres.putIfAbsent(city, new ArrayList<>());
        cityTheatres.get(city).add(theatre);
    }

    public List<Theatre> getTheatresByCity(String city) {
        return cityTheatres.getOrDefault(city, new ArrayList<>());
    }
}