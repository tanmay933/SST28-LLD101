public class TextTable {
    public static String render3(StudentRepository repository) {
        StringBuilder sb = new StringBuilder();
        sb.append("| ID             | NAME | PROGRAM |\n");

        for (StudentRecord r : repository.findAll()) {
            sb.append(String.format(
                "| %-14s | %-4s | %-7s |\n",
                r.id, r.name, r.program
            ));
        }

        return sb.toString();
    }
}