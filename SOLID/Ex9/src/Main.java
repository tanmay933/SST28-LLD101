public class Main {
    public static void main(String[] args) {

        System.out.println("=== Evaluation Pipeline ===");

        Submission sub = new Submission("23BCS1007", "public class A{}", "A.java");

        PlagiarismService plag = new PlagiarismChecker();
        GradingService grader = new CodeGrader();
        ReportService writer = new ReportWriter();
        Rubric rubric = new Rubric();

        EvaluationPipeline pipeline =
                new EvaluationPipeline(plag, grader, writer, rubric);

        pipeline.evaluate(sub);
    }
}