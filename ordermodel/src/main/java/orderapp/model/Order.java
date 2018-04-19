package orderapp.model;

public class Order {

	private int id = -1;
	private String productId = "";
	private int accountId = -1;

	public Order() {}
	
	public Order(String productId, int accountId, String name) {
		super();
		this.productId = productId;
		this.accountId = accountId;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", productId=" + productId + ", accountId=" + accountId + "]";
	}
	
}
