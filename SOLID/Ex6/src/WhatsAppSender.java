public class WhatsAppSender extends NotificationSender {

    public WhatsAppSender(AuditLog audit) {
        super(audit, new E164PhoneValidator());
    }

    @Override
    protected void doSend(Notification n) {
        System.out.println("WA -> to=" + n.phone +
                " body=" + n.body);
        audit.add("wa sent");
    }
}