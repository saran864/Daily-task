package skart.model;

public class DeliveryAddress {
	String streetAddress;
	String town_city;
	String state_country;
	int postcode;
	long mobno;
	
	public DeliveryAddress(String streetAddress, String town_city, String state_country, int postcode,long mobno) {
		super();
		this.streetAddress = streetAddress;
		this.town_city = town_city;
		this.state_country = state_country;
		this.postcode = postcode;
		this.mobno=mobno;
		
	}
	public String getStreetAddress() {
		return streetAddress;
	}
	public String getTown_city() {
		return town_city;
	}
	public String getState_country() {
		return state_country;
	}
	public int getPostcode() {
		return postcode;
	}
	public long getmobno() {
		return mobno;
	}

}
