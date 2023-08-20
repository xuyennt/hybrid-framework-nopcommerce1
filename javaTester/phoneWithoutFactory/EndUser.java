package phoneWithoutFactory;

import phoneFactory.PhoneFactory;

public class EndUser {

	public static void main(String[] args) {
		PhoneFactory phone;
		phone = getPhone("iPhone");
//		phone.setPhoneName("iPhone 14 Pro");
	//	System.out.println(phone.getPhone);

	}
	public static PhoneFactory getPhone(String phoneType) {
		PhoneFactory phoneFactory = null;
		if(phoneType.equals("Reno")) {
			phoneFactory = new Reno();
			
		}else if(phoneType.equals("Samsung")) {
			phoneFactory = new Samsung();
		}
		else {
			phoneFactory = new IPhone();
		}
			
		return phoneFactory;
	}

}
