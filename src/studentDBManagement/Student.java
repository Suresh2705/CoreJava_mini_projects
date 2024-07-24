package studentDBManagement;

public class Student implements Comparable<Student> {
	static int id = 1;
	String name, gender;
	int age, sid;
	float mark;
	static int count = 0;
	private String username = "admin";
	private String password = "Admin@123";

	Student() {
//		loi
	}

	Student(String name, int age, String gender, float mark) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.mark = mark;
		this.sid = id;
		id++;
	}

	@Override
	public String toString() {
		String sid = "Student ID: " + this.sid;
		String name = "Student Name: " + this.name;
		String age = "Student Age: " + this.age;
		String gender = "Student Gender: " + this.gender;
		String mark = "Student Mark: " + this.mark;
		return sid + "\n" + name + "\n" + age + "\n" + gender + "\n" + mark
				+ "\n*********************************************";
	}

	@Override
	public int compareTo(Student o) {
		int n = (int) (this.mark - o.mark);
		return n;
	}

	public boolean loginPage(String userName, String password) {
		if (userName.equals(this.username) && password.equals(this.password))
			return true;
		else
			return false;
	}
}