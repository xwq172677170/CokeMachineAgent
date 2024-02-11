package domain;

public enum Coin {
	
	NICKEL(5),
	DIME(10);
	
	public Integer value;
	
	Coin(Integer value) {
		this.value = value;
	}
}
