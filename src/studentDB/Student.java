package studentDB;

public class Student {
//	int sid;
	String name, gender, address;
	int age;
	float marks;
	
	Student(String name, int age, String gender, String address, float marks){
//		this.sid = sid;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.marks = marks;
	}
	@Override
	public String toString() {
//		String sid = "Student ID: "+this.sid;
		String name = "Student Name: "+this.name;
		String age = "Student Age: "+this.age;
		String gender = "Student Gender: "+this.gender;
		String address = "Student Address: "+this.address;
		String marks = "Student Marks: "+this.marks;
		return name+"\n"+age+"\n"+gender+"\n"+address+"\n"+marks;
	}
}