public class Exporter {

    private final FormatEncoder encoder;
    private final DeliveryPolicy policy;

    public Exporter(FormatEncoder encoder, DeliveryPolicy policy) {
        this.encoder = encoder;
        this.policy = policy;
    }

    public ExportResult export(ExportRequest req) {

        if (req == null)
            throw new IllegalArgumentException("Request cannot be null");

        policy.validate(req);

        byte[] bytes = encoder.encode(req);

        if (bytes == null)
            throw new IllegalStateException("Encoder returned null");

        return new ExportResult(encoder.contentType(), bytes);
    }
}