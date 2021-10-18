import java.util.ArrayList;

public class Resume {

    private String firstName;
    private String lastName;
    private GradeLevel gradeLevel;
    private double gradePointAverage;
    private ArrayList<JobExperience> jobExperiences;
    private ArrayList<String> skills;
    private ArrayList<String> extracurriculars;
    private Education education;

    public Resume() {

    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public GradeLevel getGradeLevel() {
        return this.gradeLevel;
    }

    public double getGradePointAverage() {
        return this.gradePointAverage;
    }

    public ArrayList<JobExperience> getJobExperiences() {
        return this.jobExperiences;
    }

    public ArrayList<String> getSkills() {
        return this.skills;
    }

    public ArrayList<String> getExtracurriculars() {
        return this.extracurriculars;
    }

    public void addNewJob(JobExperience jobExperience) {

    }

    public void addNewSkill(String skill) {

    }

    public void addNewExtracurricular(String extracurricular) {

    }
}