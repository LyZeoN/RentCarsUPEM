package buy;

public class CarSquelleton {
	private final String model;
	private double price;
	private int haveBeenRented = 0;
	
	public CarSquelleton() {
		model = "Empty Squelleton";
		price = 0;
		haveBeenRented = -145;
	}
	public CarSquelleton(String modeli,double pricei,int haveBRi) {
		model = modeli;
		price = pricei;
		haveBeenRented = haveBRi;
		
	}
}
