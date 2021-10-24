import java.util.Date;
import java.util.Calendar;

public class JobExperience {
    private String company;
    private String cityLocation;
    private String stateLocation;
    private String description;
    private Date startDate;
    private Date endDate;

    public String getCompany() {
        return this.company;
    }

    public String getLocation() {
        return this.cityLocation + this.stateLocation;
    }

    public String getDescription() {
        return this.description;
    }

    public int getNumberOfMonths() {
        int numberofMonths;
        Calendar first = Calendar.getInstance();
        first.setTime(startDate);
        int firstMonth = first.get(Calendar.MONTH); // this will give the month of the start date

        Calendar second = Calendar.getInstance();
        first.setTime(startDate);
        int secondMonth = second.get(Calendar.MONTH);
        numberofMonths = secondMonth - firstMonth; // this will giv the month of the end date
        return numberofMonths;
    }

    public String toString() {
        return "Company: " + this.company + "\nLocation: " + this.stateLocation + ", " + this.cityLocation
                + "\nLength: " + this.startDate + " - " + this.endDate + this.description;
    }
}