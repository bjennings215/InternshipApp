import java.util.Date;

public class Education {
	private String university;
	private String major;
	private String minor;
	private String location;
	private String concentration;
	private Date graduationDate;
	private GradeLevel gradeLevel;
	
	public Education() {
		
	}
	
	public String getUniversity() {
		return this.university;
	}
	
	public String getcampusLocation() {
		return this.location;
	}
	
	public String getMajor() {
		return this.major;
	}
	
	public String getMinor() {
		return this.minor;
	}
	
	public String getConcentration() {
		return this.concentration;
	}
	
	public Date getGradutationDate() {
		return this.graduationDate;
	}
	
	public GradeLevel getGradeLevel() {
		return this.gradeLevel;
	}
}
