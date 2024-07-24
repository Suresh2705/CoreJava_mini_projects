package trainTicketBooking;

public class Passenger {
	static int pid = 1;
	String name;
	int age;
	char berthPreference;
	int passengerId;
	String alloted;
	int seatNo;
	
	public Passenger(){
		//loi
	}
	public Passenger(String name, int age, char berthPreference) {
		this.name = name;
		this.age = age;
		this.berthPreference = berthPreference;
		this.passengerId = pid++;
		alloted = "";
		seatNo = -1;
	}
}