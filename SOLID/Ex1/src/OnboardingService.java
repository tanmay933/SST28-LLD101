import java.util.*;

public class OnboardingService {
    private final StudentRepository repository;
    private final StudentParser parser;
    private final StudentValidator validator;
    private final OnboardingPrinter printer;

    public OnboardingService(
            StudentRepository repository,
            StudentParser parser,
            StudentValidator validator,
            OnboardingPrinter printer) {
        this.repository = repository;
        this.parser = parser;
        this.validator = validator;
        this.printer = printer;
    }

    // Intentionally violates SRP: parses + validates + creates ID + saves + prints.
    public void registerFromRawInput(String raw) {
        printer.printInput(raw);

        Map<String, String> kv = parser.parse(raw);

        String name = kv.getOrDefault("name", "");
        String email = kv.getOrDefault("email", "");
        String phone = kv.getOrDefault("phone", "");
        String program = kv.getOrDefault("program", "");

        // validation inline, printing inline
        List<String> errors = validator.validate(name, email, phone, program);

        if (!errors.isEmpty()) {
            printer.printErrors(errors);
            return;
        }

        String id = IdUtil.nextStudentId(repository.count());
        StudentRecord rec = new StudentRecord(id, name, email, phone, program);

        repository.save(rec);
        printer.printSuccess(id, rec, repository.count());
    }
}
