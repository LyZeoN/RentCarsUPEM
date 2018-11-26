package buy;

public class ObservationSquelleton {
	private int carroserieMark;
	private String carroserieDescription;
	private int moteurMark;
	private String moteurDescription;
	private int roueMark;
	private String roueDescription;
	private String firstName;
	private String lastName;
	public ObservationSquelleton() {
		
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public ObservationSquelleton(String firstName, String lastName,int carroserieMarki,String carroserieDescriptioni, int moteurMarki,String moteurDescriptioni, int roueMarki,String roueDescriptioni) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		carroserieMark = carroserieMarki;
		carroserieDescription = carroserieDescriptioni;
		moteurMark = moteurMarki;
		moteurDescription = moteurDescriptioni;
		roueMark = roueMarki;
		roueDescription = roueDescriptioni;
	
	}

	public int getCarroserieMark() {
		return carroserieMark;
	}

	public void setCarroserieMark(int carroserieMark) {
		this.carroserieMark = carroserieMark;
	}

	public String getCarroserieDescription() {
		return carroserieDescription;
	}

	public void setCarroserieDescription(String carroserieDescription) {
		this.carroserieDescription = carroserieDescription;
	}

	public int getMoteurMark() {
		return moteurMark;
	}

	public void setMoteurMark(int moteurMark) {
		this.moteurMark = moteurMark;
	}

	public String getMoteurDescription() {
		return moteurDescription;
	}

	public void setMoteurDescription(String moteurDescription) {
		this.moteurDescription = moteurDescription;
	}

	public int getRoueMark() {
		return roueMark;
	}

	public void setRoueMark(int roueMark) {
		this.roueMark = roueMark;
	}

	public String getRoueDescription() {
		return roueDescription;
	}

	public void setRoueDescription(String roueDescription) {
		this.roueDescription = roueDescription;
	}
}
