import java.util.ArrayList;

public class Resume {

    private String firstName;
    private String lastName;
    private String gradeLevel;
    private String gradePointAverage;
    private ArrayList<JobExperience> jobExperiences;
    private ArrayList<String> skills;
    private ArrayList<String> extracurriculars;
    private Education education;

    public Resume() {

    }

    public Resume(String firstName, String lastName, String gradePointAverage, String gradeLevel,
            ArrayList<JobExperience> jobExperiences, ArrayList<String> skills, ArrayList<String> extracurriculars, Education education) {

                this.firstName = firstName;
                this.lastName = lastName;
                this.gradePointAverage = gradePointAverage;
                this.gradeLevel = gradeLevel;
                this.jobExperiences = jobExperiences;
                this.skills = skills;
                this.extracurriculars = extracurriculars;
                this.education = education;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getGradePointAverage() {
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

    public ArrayList<String> getSkills() {
        return this.skills;
    }

    public ArrayList<String> getExtracurriculars() {
        return this.extracurriculars;
    }

    public void addNewJob(JobExperience jobExperience) {
        this.getJobExperiences().add(jobExperience);
    }

    public void addNewSkills(ArrayList<String> skills) {
        for(String skill:skills) {
            
        }
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

    public String shortToString() {
        return "Name: " + this.firstName + " " + this.lastName + "\nGrade Level: " + this.gradeLevel + "GPA; " + this.gradePointAverage;
                
    }

    public String longToString() {
        return "";
    }
}