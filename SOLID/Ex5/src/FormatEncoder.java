public interface FormatEncoder {
    byte[] encode(ExportRequest req);
    String contentType();
}