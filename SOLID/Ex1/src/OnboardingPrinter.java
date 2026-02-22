import java.util.List;

public class OnboardingPrinter {

    public void printErrors(List<String> errors) {
        System.out.println("ERROR: cannot register");
        for (String e : errors) {
            System.out.println("- " + e);
        }
    }

    public void printSuccess(String id, StudentRecord rec, int totalCount) {
        System.out.println("OK: created student " + id);
        System.out.println("Saved. Total students: " + totalCount);
        System.out.println("CONFIRMATION:");
        System.out.println(rec);
    }

    public void printInput(String raw) {
        System.out.println("INPUT: " + raw);
    }
}