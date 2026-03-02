import com.example.tickets.IncidentTicket;
import com.example.tickets.TicketService;

import java.util.List;

public class TryIt {

    public static void main(String[] args) {

        TicketService service = new TicketService();

        IncidentTicket t = service.createTicket(
                "TCK-1001",
                "reporter@example.com",
                "Payment failing on checkout"
        );

        System.out.println("Created: " + t);

        t = service.assign(t, "agent@example.com");
        t = service.escalateToCritical(t);

        System.out.println("\nAfter updates (new instances): " + t);

        // Attempt external mutation
        try {
            List<String> tags = t.getTags();
            tags.add("HACKED_FROM_OUTSIDE");
        } catch (Exception e) {
            System.out.println("\nTags are immutable from outside.");
        }

        System.out.println("\nFinal ticket: " + t);
    }
}