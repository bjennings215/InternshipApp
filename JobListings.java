import java.util.ArrayList;

public class JobListings {
    
        private static JobListings joblistings = null;
        private static ArrayList<JobListing> joblist= new ArrayList<JobListing>();
    
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
        public boolean haveUser(String jobTitle) {
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
        public void addJob() {
            joblist.add(new JobListing());
            DataWriter.saveUsers();
        }
    
        //removes user from ArrayList and removes from JSON file(database)
        public void removeJob(String jobTitle) {
            for(int i = 0; i < joblist.size(); i++){
                if(joblist.get(i).getJobTitle().equals(jobTitle)){
                    joblist.remove(i);
                    DataWriter.saveUsers();
                }
            }
        }
    
    
        public void editJob(String jobTitle) {
            for(int i = 0; i < joblist.size(); i++){
                if(joblist.get(i).getJobTitle().equals(jobTitle)){
                    joblist.set(i, new JobListing());
                    DataWriter.saveUsers();
                }
            }
        }
    
        public void logout(){
            DataWriter.saveUsers();
        }
    
}
