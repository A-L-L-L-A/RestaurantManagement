package management.entities;

public class Dish {
	private int id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	private String nomination;
	public Dish() {
		super();
	}
	
	public Dish(String nomination, String dish_name, int price, int time_preparing) {
		super();
		this.nomination = nomination;
		this.dish_name = dish_name;
		this.price = price;
		this.time_preparing = time_preparing;
	}
	public Dish(int id, String nomination, String dish_name, int price, int time_preparing) {
		super();
		this.id = id;
		this.nomination = nomination;
		this.dish_name = dish_name;
		this.price = price;
		this.time_preparing = time_preparing;
	}
	private String dish_name;
	private int price;
	private int time_preparing;
	public void setPrice(int price) {
		this.price = price;
	}
	public void setTime_preparing(int time_preparing) {
		this.time_preparing = time_preparing;
	}
	public int getPrice() {
		return price;
	}
	public int getTime_preparing() {
		return time_preparing;
	}
	public String getNomination() {
		return nomination;
	}
	public void setNomination(String nomination) {
		this.nomination = nomination;
	}
	public String getDish_name() {
		return dish_name;
	}
	public void setDish_name(String dish_name) {
		this.dish_name = dish_name;
	}
	
}
