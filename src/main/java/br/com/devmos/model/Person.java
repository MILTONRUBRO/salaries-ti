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
		return "Person [age=" + age + ", gender=" + gender + ", educationLevel=" + educationLevel + ", jobTitle="
				+ jobTitle + ", yearsOfExperience=" + yearsOfExperience + ", salary=" + salary + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((educationLevel == null) ? 0 : educationLevel.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((jobTitle == null) ? 0 : jobTitle.hashCode());
		result = prime * result + ((salary == null) ? 0 : salary.hashCode());
		result = prime * result + ((yearsOfExperience == null) ? 0 : yearsOfExperience.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (educationLevel == null) {
			if (other.educationLevel != null)
				return false;
		} else if (!educationLevel.equals(other.educationLevel))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (jobTitle == null) {
			if (other.jobTitle != null)
				return false;
		} else if (!jobTitle.equals(other.jobTitle))
			return false;
		if (salary == null) {
			if (other.salary != null)
				return false;
		} else if (!salary.equals(other.salary))
			return false;
		if (yearsOfExperience == null) {
			if (other.yearsOfExperience != null)
				return false;
		} else if (!yearsOfExperience.equals(other.yearsOfExperience))
			return false;
		return true;
	}
}
