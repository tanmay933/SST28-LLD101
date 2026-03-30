package bookmyshow.controller;

import bookmyshow.model.Movie;
import bookmyshow.service.MovieService;

import java.util.List;

public class MovieController {

    private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    // list all movies in a city
    public List<Movie> getMovies(String city) {
        return movieService.getMoviesByCity(city);
    }
}