
public class Users {
	private String name, position, country;

	public Users(String name, String position, String country) {
		super();
		this.name = name;
		this.position = position;
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public String getPosition() {
		return position;
	}

	public String getCountry() {
		return country;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", position=" + position + ", country=" + country + "]";
	}

	
}
