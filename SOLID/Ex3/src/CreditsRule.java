import java.util.Optional;

public class CreditsRule implements EligibilityRule {

    @Override
    public Optional<String> validate(StudentProfile student) {
        if (student.earnedCredits < 20) {
            return Optional.of("credits below 20");
        }
        return Optional.empty();
    }
}