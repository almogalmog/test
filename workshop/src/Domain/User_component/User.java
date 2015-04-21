package Domain.User_component;


public class User implements I_User {
	private String name;

	public User(String name){
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}
}
