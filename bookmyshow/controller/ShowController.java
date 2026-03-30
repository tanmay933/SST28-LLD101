package bookmyshow.controller;

import bookmyshow.model.*;
import bookmyshow.service.ShowService;

import java.util.List;

public class ShowController {

    private ShowService showService;

    public ShowController(ShowService showService) {
        this.showService = showService;
    }

    public List<Show> getShows(Movie movie) {
        return showService.getShowsByMovie(movie);
    }

    public List<ShowSeat> getSeats(Show show) {
        return show.getShowSeats();
    }
}