import java.util.ArrayList;

public class JobListings {
    
        private static JobListings joblistings = null;
        private static ArrayList<JobListing> joblist = new ArrayList<JobListing>();
    
        private JobListings() {
            joblist = JobListingDataLoader.InputJobListing();
        }
    
        //Singleton 
        public static JobListings getInstance() {
            if(joblistings == null) {
            joblistings = new JobListings();
            }
            return joblistings;
        }
    
        //check to see if user already exist
        public boolean haveJobListing(String jobTitle) {
            for(JobListing jobListing : joblist) {
                if(jobListing.getJobTitle().equals(jobTitle)) {
                    return true;
                }
            }
            return false;
        }
    
        //gets User from Arraylist of Users
        public JobListing getJobListing(String jobTitle) {
            for(JobListing jobListing : joblist) {
                if(jobListing.getJobTitle().equals(jobTitle)) {
                    return jobListing;
                }
            }
            return null;
        }
    
        //return Arraylist of Users
        public ArrayList<JobListing> getJobList() {
            return joblist;
        }
    
    
        //adds user to Arraylist and writes to JSON file(database)
        public void addJob(String link, String jobTitle, String jobCompany, String jobDescription, String jobCityLocation, 
        String jobStateLocation, String numofMonths, String jobWagePerHour,ArrayList<String> jobSkills, ArrayList<Student> studentsApplied, String jobExpDate) {
            joblist.add(new JobListing(link, jobTitle,  jobCompany,  jobDescription,jobCityLocation, 
            jobStateLocation, numofMonths, jobWagePerHour, jobSkills,  studentsApplied,  jobExpDate));
            JobListingDataWriter.saveJobListng();
        }
    
        //removes user from ArrayList and removes from JSON file(database)
        public void removeJob(String jobTitle) {
            for(int i = 0; i < joblist.size(); i++){
                if(joblist.get(i).getJobTitle().equals(jobTitle)){
                    joblist.remove(i);
                    JobListingDataWriter.saveJobListng();
                }
            }
        }
    
    
        public void editJob(String link, String jobTitle, String jobCompany, String jobDescription, String jobCityLocation, 
        String jobStateLocation, String numofMonths, String jobWagePerHour,ArrayList<String> jobSkills, ArrayList<Student> studentsApplied, String jobExpDate) {
            for(int i = 0; i < joblist.size(); i++){
                if(joblist.get(i).getJobTitle().equals(jobTitle)){
                    joblist.set(i, new JobListing(link, jobTitle,  jobCompany,  jobDescription,jobCityLocation, 
                    jobStateLocation, numofMonths, jobWagePerHour, jobSkills,  studentsApplied,  jobExpDate));
                    JobListingDataWriter.saveJobListng();
                }
            }
        }
    
        public void logout(){
            DataWriter.saveUsers();
        }
    
}
