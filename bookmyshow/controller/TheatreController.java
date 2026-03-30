package bookmyshow.controller;

import bookmyshow.model.Theatre;
import bookmyshow.service.TheatreService;

import java.util.List;

public class TheatreController {

    private TheatreService theatreService;

    public TheatreController(TheatreService theatreService) {
        this.theatreService = theatreService;
    }

    // list theatres in city
    public List<Theatre> getTheatres(String city) {
        return theatreService.getTheatresByCity(city);
    }
}