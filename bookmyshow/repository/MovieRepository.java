package bookmyshow.repository;

import bookmyshow.model.Movie;
import java.util.*;

public class MovieRepository {

    private Map<String, List<Movie>> cityMovies = new HashMap<>();

    public void addMovie(String city, Movie movie) {
        cityMovies.putIfAbsent(city, new ArrayList<>());
        cityMovies.get(city).add(movie);
    }

    public List<Movie> getMoviesByCity(String city) {
        return cityMovies.getOrDefault(city, new ArrayList<>());
    }
}