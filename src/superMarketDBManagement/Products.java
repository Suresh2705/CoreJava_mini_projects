package superMarketDBManagement;

public class Products {
	int pid;
	String name;
	double price;
	String brand;
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	@Override
	public String toString() {
		return "Product ID: "+getPid()+"\nProduct Name: "+getName()+"\nProduct Price: "+getPrice()+"\nProduct Brand:"+getBrand();
	}
}