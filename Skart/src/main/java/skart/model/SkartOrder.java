package skart.model;

public class SkartOrder {
	String userId;
	String vendorId;
	int prodId;
	String productName;
	int productPrice;
	int productQty;
	String paymentType;
	int deliveryCharge;
	long mobileNumber;
	


	

public SkartOrder(String userId ,int prodId,String productName, int productPrice, int productQty, String paymentType, int deliveryCharge,
		String vendorId) {
		super();
		this.userId=userId;
		this.vendorId=vendorId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productQty = productQty;
		this.paymentType = paymentType;
		this.deliveryCharge = deliveryCharge;
		this.prodId=prodId;
	
	}
public SkartOrder (){}
public long getMobileNumber() {
	return mobileNumber;
}

	public String getVendorId() {
	return vendorId;
   }
   public void setVendorId(String vendorId) {
	this.vendorId = vendorId;
   }
   public int getProdId() {
		return prodId;
	}

	public String getProductName() {
		return productName;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public int getProductQty() {
		return productQty;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public int getDeliveryCharge() {
		return deliveryCharge;
	}
	
	public String getUserId() {
		return userId;
	}

	
	
	
	

}
