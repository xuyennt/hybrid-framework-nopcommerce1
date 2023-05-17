package phuongHoaXuan;

public class CoffeNEO {
	
	public String espresso = "Cafe Espresso";
	
	public void shipEspresso() {
		System.out.println("Ship cafe: " + espresso);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CoffeNEO neo = new CoffeNEO();
		neo.shipEspresso();
	}

}
