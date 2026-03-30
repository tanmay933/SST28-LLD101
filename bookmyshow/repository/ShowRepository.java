package bookmyshow.repository;

import bookmyshow.model.Show;
import java.util.*;

public class ShowRepository {

    private List<Show> shows = new ArrayList<>();

    public void addShow(Show show) {
        shows.add(show);
    }

    public List<Show> getAllShows() {
        return shows;
    }
}