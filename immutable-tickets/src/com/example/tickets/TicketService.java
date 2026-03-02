package com.example.tickets;

public class TicketService {

    public IncidentTicket createTicket(String id, String reporterEmail, String title) {

        return IncidentTicket.builder()
                .id(id)
                .reporterEmail(reporterEmail)
                .title(title)
                .addTag("NEW")
                .build();
    }

    public IncidentTicket escalateToCritical(IncidentTicket t) {

        return t.toBuilder()
                .priority("CRITICAL")
                .addTag("ESCALATED")
                .build();
    }

    public IncidentTicket assign(IncidentTicket t, String assigneeEmail) {

        return t.toBuilder()
                .assigneeEmail(assigneeEmail)
                .build();
    }
}