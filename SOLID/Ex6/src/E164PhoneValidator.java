public class E164PhoneValidator implements NotificationValidator {
    @Override
    public void validate(Notification n) {
        if (n.phone == null || !n.phone.startsWith("+")) {
            throw new IllegalArgumentException("phone must start with + and country code");
        }
    }
}