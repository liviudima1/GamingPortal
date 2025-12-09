
public class CheckAge {
	
	private String age;

	public CheckAge() {
		
	}
	
	public String checkInputAge() {
		
		int ageInt = Integer.parseInt(age);
		if(ageInt >= 18) {
			return "over18";
		}
		else {
			return "under18";
		}
		
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	
	
	

}
