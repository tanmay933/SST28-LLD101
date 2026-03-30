package bookmyshow.service;

import bookmyshow.model.*;
import java.util.*;

public class ShowService {

    private List<Show> shows = new ArrayList<>();

    public void addShow(Show show) {
        shows.add(show);
    }

    public List<Show> getShowsByMovie(Movie movie) {
        List<Show> result = new ArrayList<>();

        for (Show show : shows) {
            if (show.getMovie().getId().equals(movie.getId())) {
                result.add(show);
            }
        }

        return result;
    }
}