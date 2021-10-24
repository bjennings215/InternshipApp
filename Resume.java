import java.util.ArrayList;

public class Resume {

    private String firstName;
    private String lastName;
    private String gradeLevel;
    private double gradePointAverage;
    private ArrayList<JobExperience> jobExperiences;
    private String[] skillsAndExtracurriculars;
    private Education education;

    public Resume() {

    }

    public Resume(String firstName, String lastName, double gradePointAverage, String gradeLevel,
            ArrayList<JobExperience> jobExperiences, String[] skillsAndExtracurriculars, Education education) {

    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public double getGradePointAverage() {
        return this.gradePointAverage;
    }

    public String getGradeLevel() {
        return this.gradeLevel;
    }

    public Education getEducation() {
        return this.education;
    }

    public ArrayList<JobExperience> getJobExperiences() {
        return this.jobExperiences;
    }

    public String[] getSkillsAndExtracurriculars() {
        return this.skillsAndExtracurriculars;
    }

    public void addNewEducation(Education education) {

    }

    public void addNewJob(JobExperience jobExperience) {

    }

    public void addNewSkillAndExtracurricular(String skill) {

    }

    public boolean removeEducation(Education education) {
        return true;
    }

    public boolean removeJobExperience(JobExperience jobExperience) {
        return true;
    }

    public boolean removeSkillOrExtracurricular(String skillOrExtracurricular) {
        return true;
    }
}