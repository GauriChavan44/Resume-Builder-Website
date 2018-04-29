package neu.edu.entity;
// Generated Nov 23, 2016 1:00:50 AM by Hibernate Tools 5.1.0.Alpha1

/**
 * ProjectTable generated by hbm2java
 */
public class ProjectTable implements java.io.Serializable {

	private String userName;
	private String project1title;
	private String project1description;
	private String project2title;
	private String project2description;
	private String project3title;
	private String project3description;

	public ProjectTable() {
	}

	public ProjectTable(String userName) {
		this.userName = userName;
	}

	public ProjectTable(String userName, String project1title, String project1description, String project2title,
			String project2description, String project3title, String project3description) {
		this.userName = userName;
		this.project1title = project1title;
		this.project1description = project1description;
		this.project2title = project2title;
		this.project2description = project2description;
		this.project3title = project3title;
		this.project3description = project3description;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getProject1title() {
		return this.project1title;
	}

	public void setProject1title(String project1title) {
		this.project1title = project1title;
	}

	public String getProject1description() {
		return this.project1description;
	}

	public void setProject1description(String project1description) {
		this.project1description = project1description;
	}

	public String getProject2title() {
		return this.project2title;
	}

	public void setProject2title(String project2title) {
		this.project2title = project2title;
	}

	public String getProject2description() {
		return this.project2description;
	}

	public void setProject2description(String project2description) {
		this.project2description = project2description;
	}

	public String getProject3title() {
		return this.project3title;
	}

	public void setProject3title(String project3title) {
		this.project3title = project3title;
	}

	public String getProject3description() {
		return this.project3description;
	}

	public void setProject3description(String project3description) {
		this.project3description = project3description;
	}

}