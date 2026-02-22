import java.util.List;

public interface StudentRepository {
    void save(StudentRecord record);
    int count();
    List<StudentRecord> findAll();
}