import java.nio.charset.StandardCharsets;

public class PdfEncoder implements FormatEncoder {

    @Override
    public byte[] encode(ExportRequest req) {
        String fakePdf = "PDF(" + req.title + "):" + req.body;
        return fakePdf.getBytes(StandardCharsets.UTF_8);
    }

    @Override
    public String contentType() {
        return "application/pdf";
    }
}