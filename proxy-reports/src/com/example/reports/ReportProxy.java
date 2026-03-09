package com.example.reports;

/**
 * TODO (student):
 * Implement Proxy responsibilities here:
 * - access check
 * - lazy loading
 * - caching of RealReport within the same proxy
 */
public class ReportProxy implements Report {

    private final String reportId;
    private final String title;
    private final String classification;
    private final AccessControl accessControl = new AccessControl();

    // cached real report
    private RealReport realReport;

    public ReportProxy(String reportId, String title, String classification) {
        this.reportId = reportId;
        this.title = title;
        this.classification = classification;
    }

    @Override
    public void display(User user) {

        // access control
        if (!accessControl.canAccess(user, classification)) {
            System.out.println("ACCESS DENIED for " + user.getName()
                    + " to report " + reportId + " (" + classification + ")");
            return;
        }

        // lazy loading
        if (realReport == null) {
            System.out.println("[proxy] loading real report...");
            realReport = new RealReport(reportId, title, classification);
        }

        // delegate to real subject
        realReport.display(user);
    }
}