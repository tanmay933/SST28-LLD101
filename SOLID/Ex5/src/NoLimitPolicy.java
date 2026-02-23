public class NoLimitPolicy implements DeliveryPolicy {
    @Override
    public void validate(ExportRequest req) {
        // No restrictions
    }
}