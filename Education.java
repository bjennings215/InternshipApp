import java.util.Date;

public class Education {
	String university;
	String major;
	String minor;
	String location;
	String concentration;
	Date graduationDate;
	GradeLevel gradeLevel;
	
	public Education() {
		
	}
	
	public String getUniversity() {
		return university;
	}
	
	public String getcampusLocation() {
		return location;
	}
	
	public String getMajor() {
		return major;
	}
	
	public String getMinor() {
		return minor;
	}
	
	public String getConcentration() {
		return concentration;
	}
	
	public Date getGradutationDate() {
		return graduationDate;
	}
	
	public GradeLevel getGradeLevel() {
		return gradeLevel;
	}
}
