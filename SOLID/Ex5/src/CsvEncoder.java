import java.nio.charset.StandardCharsets;

public class CsvEncoder implements FormatEncoder {

    @Override
    public byte[] encode(ExportRequest req) {
        String body = req.body == null
                ? ""
                : req.body.replace("\n", " ").replace(",", " ");

        String csv = "title,body\n" + req.title + "," + body + "\n";
        return csv.getBytes(StandardCharsets.UTF_8);
    }

    @Override
    public String contentType() {
        return "text/csv";
    }
}