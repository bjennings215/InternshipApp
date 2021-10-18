import java.sql.Date;

public class Education {
    private String university;
    private String campusLocation;
    private String major;
    private String minor;
    private String concentration;
    private Date graduationDate;
    private GradeLevel gradeLevel;

    public String getUniversity()
    {
        return this.university;
    }

    public String getCampusLocation()
    {
        return this.campusLocation;
    }

    public String getMajor()
    {
        return this.major;
    }

    public String getMinor()
    {
        return this.minor;
    }

    public String getConcentration()
    {
        return this.concentration;
    }

    public Date getGraduationDate()
    {
        return this.graduationDate;
    }

    public GradeLevel getGradeLevel()
    {
        return this.gradeLevel;
    }
}