import java.util.*;

class JobSubmission {
    private String jobId;
    private String userId;
    private String resume;

    public JobSubmission(String jobId, String userId, String resume) {
        this.jobId = jobId;
        this.userId = userId;
        this.resume = resume;
    }

    public String getJobId() {
        return jobId;
    }

    public String getUserId() {
        return userId;
    }

    public String getResume() {
        return resume;
    }

    // Override equals to compare based on jobId and userId
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        JobSubmission that = (JobSubmission) obj;
        return Objects.equals(jobId, that.jobId) && Objects.equals(userId, that.userId);
    }

    // Override hashCode to generate a hash based on jobId and userId
    @Override
    public int hashCode() {
        return Objects.hash(jobId, userId);
    }

    @Override
    public String toString() {
        return "JobSubmission{" +
                "jobId='" + jobId + '\'' +
                ", userId='" + userId + '\'' +
                ", resume='" + resume + '\'' +
                '}';
    }
}

public class RemoveDuplicateJobSubmissions {
    public static List<JobSubmission> removeDuplicates(List<JobSubmission> submissions) {
        // Use a LinkedHashSet to maintain insertion order while removing duplicates
        return new ArrayList<>(new LinkedHashSet<>(submissions));
    }

    public static void main(String[] args) {
        List<JobSubmission> submissions = Arrays.asList(
                new JobSubmission("101", "user1", "resume1.pdf"),
                new JobSubmission("102", "user2", "resume2.pdf"),
                new JobSubmission("101", "user1", "resume3.pdf"), // Duplicate of the first
                new JobSubmission("103", "user3", "resume4.pdf"),
                new JobSubmission("102", "user2", "resume5.pdf")  // Duplicate of the second
        );

        System.out.println("Before removing duplicates:");
        submissions.forEach(System.out::println);

        List<JobSubmission> uniqueSubmissions = removeDuplicates(submissions);

        System.out.println("\nAfter removing duplicates:");
        uniqueSubmissions.forEach(System.out::println);
    }
}
