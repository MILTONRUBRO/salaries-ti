package br.com.devmos.model;

public class Person {
	
	private int age;
	private String gender;
	private String educationLevel;
	private String jobTitle;
	private Double yearsOfExperience;
	private Double salary;
	
	public Person() {
		super();
	}
	
	public Person(int age, String gender, String educationLevel, String jobTitle, Double yearsOfExperience,
			Double salary) {
		super();
		this.age = age;
		this.gender = gender;
		this.educationLevel = educationLevel;
		this.jobTitle = jobTitle;
		this.yearsOfExperience = yearsOfExperience;
		this.salary = salary;
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEducationLevel() {
		return educationLevel;
	}
	public void setEducationLevel(String educationLevel) {
		this.educationLevel = educationLevel;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public Double getYearsOfExperience() {
		return yearsOfExperience;
	}
	public void setYearsOfExperience(Double yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "\n Idade = " + age + 
				"\n Gênero = " + gender + 
				"\n Educação = " + educationLevel + 
				"\n Profissão = "+ jobTitle + 
				"\n Anos de Experiência = " + yearsOfExperience + 
				"\n Salário = " + salary + "\n"+
				"==============================================";
	}

}
