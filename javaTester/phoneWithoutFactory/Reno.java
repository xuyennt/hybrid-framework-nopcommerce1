package phoneWithoutFactory;

import phoneFactory.PhoneFactory;

public class Reno extends PhoneFactory {

	@Override
	public void setPhoneName(String phoneName) {
		super.phoneName = phoneName;

	}

	@Override
	protected String getPhoneName() {

		return super.phoneName;
	}

}
