import java.util.*;

public class InMemoryInvoiceRepository implements InvoiceRepository {

    private final Map<String, String> files = new HashMap<>();

    @Override
    public void save(String id, String content) {
        files.put(id, content);
    }

    @Override
    public int countLines(String id) {
        String c = files.getOrDefault(id, "");
        if (c.isEmpty()) return 0;
        return c.split("\n").length;
    }
}