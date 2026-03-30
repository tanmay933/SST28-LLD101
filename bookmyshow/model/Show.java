package bookmyshow.model;

import java.util.List;

public class Show {
    private String id;
    private Movie movie;
    private Screen screen;
    private long startTime;
    private List<ShowSeat> showSeats;

    public Show(String id, Movie movie, Screen screen, long startTime, List<ShowSeat> showSeats) {
        this.id = id;
        this.movie = movie;
        this.screen = screen;
        this.startTime = startTime;
        this.showSeats = showSeats;
    }

    public Movie getMovie() { return movie; }
    public List<ShowSeat> getShowSeats() { return showSeats; }
}