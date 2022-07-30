package JavaStreamApi;

public class Country {

	private int id;
	private String country_Name;

	public Country(int id, String country_Name) {
		super();
		this.id = id;
		this.country_Name = country_Name;
	}

	public Country() {
		super();

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountry_Name() {
		return country_Name;
	}

	public void setCountry_Name(String country_Name) {
		this.country_Name = country_Name;
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", country_Name=" + country_Name + "]";
	}
	
	

}
