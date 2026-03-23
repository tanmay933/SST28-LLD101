package parkinglot.repository;

import parkinglot.model.Ticket;
import java.util.*;

public class TicketRepository {
    private Map<String, Ticket> map = new HashMap<>();

    public void save(String id, Ticket t) { map.put(id, t); }
    public Ticket get(String id) { return map.get(id); }
}