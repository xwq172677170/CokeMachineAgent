package domain;

public class Coke implements Item {
	
	public static final Integer PRICE = 15;

	@Override
	public Integer getPrice() {
		return PRICE;
	}

}
