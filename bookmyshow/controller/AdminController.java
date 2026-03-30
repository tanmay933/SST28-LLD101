package bookmyshow.controller;

import bookmyshow.model.*;
import bookmyshow.service.*;

public class AdminController {

    private MovieService movieService;
    private TheatreService theatreService;
    private ShowService showService;

    public AdminController(MovieService movieService,
                           TheatreService theatreService,
                           ShowService showService) {
        this.movieService = movieService;
        this.theatreService = theatreService;
        this.showService = showService;
    }

    public void addMovie(String city, Movie movie) {
        movieService.addMovie(city, movie);
    }

    public void addTheatre(String city, Theatre theatre) {
        theatreService.addTheatre(city, theatre);
    }

    public void addShow(Show show) {
        showService.addShow(show);
    }
}