public class EmailSender extends NotificationSender {

    public EmailSender(AuditLog audit) {
        super(audit, new NoOpValidator());
    }

    @Override
    protected void doSend(Notification n) {
        System.out.println("EMAIL -> to=" + n.email +
                " subject=" + n.subject +
                " body=" + n.body);
        audit.add("email sent");
    }
}