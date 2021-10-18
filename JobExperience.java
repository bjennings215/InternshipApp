import java.util.Date;

public class JobExperience {
    private String company;
    private String cityLocation;
    private String stateLocation;
    private String description;
    private Date startDate;
    private Date endDate;

    public String getCompany(){
        return this.company;
    }
    public String getLocation(){
        return this.cityLocation+this.stateLocation;
    }
    public String getDescription(){
        return this.description;
    }
    public int getNumberOfMonths(){
     return 0;   
    }
}