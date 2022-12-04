package hw8;

public class textbook {
	private int SKU;
	private double price;
	private int quantity;
	private String title;
	
	//Constructor
	public textbook(int SKU, String title, int quantity, double price) {
		this.SKU = SKU;
		this.price = price;
		this.quantity = quantity;
		this.title = title;
	}
	
	
	//Getters and Setters.
	public int getSKU() {
		return SKU;
	}
	public void setSKU(int sKU) {
		SKU = sKU;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	/*
	 * creating our own compareTo function that uses the SKU
	 * values to get the value/location of the textbook
	 */
	public int compareTo(textbook textbook) {
		return this.SKU - textbook.SKU;
	}
	public String toString(textbook textbook) {
		return "Book ID: " + textbook.getSKU() + "\nName: " 
				+ textbook.getTitle() + "\nPriced at: " +
				textbook.getPrice();
	}
}
