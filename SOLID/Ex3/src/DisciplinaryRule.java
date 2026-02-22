import java.util.Optional;

public class DisciplinaryRule implements EligibilityRule {

    @Override
    public Optional<String> validate(StudentProfile student) {
        if (student.disciplinaryFlag != LegacyFlags.NONE) {
            return Optional.of("disciplinary flag present");
        }
        return Optional.empty();
    }
}