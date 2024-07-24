package studentDB;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class StudentManagementImpl implements StudentManagement {
	static Scanner sc = new Scanner(System.in);
	static LinkedHashMap<Integer, Student> lhm = new LinkedHashMap<>();

	@Override
	public void addStudent() {
		System.out.println("Enter the No. of Student");
		int count = sc.nextInt();
		for (int i = 1; i <= count; i++) {
			System.out.println("Enter the Student ID");
			int id = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter the Student Name");
			String name = sc.nextLine();
			System.out.println("Enter the Student Age");
			int age = sc.nextInt();
//			sc.nextLine();
			System.out.println("Enter the Student Gender");
			String gender = sc.next();
			sc.nextLine();
			System.out.println("Enter the Student Address");
			String address = sc.nextLine();
			System.out.println("Enter the Student Marks");
			float marks = sc.nextFloat();
			System.out.println("*******************************");
			lhm.put(id, new Student(name, age, gender, address, marks));
		}
		System.out.println("Student Details Added Successfully!");
	}

	@Override
	public void searchStudent() {
		System.out.println("Enter the Student ID");
		int key = sc.nextInt();
		if (lhm.containsKey(key)) {
			Student stuDetails = lhm.get(key);
			System.out.println(stuDetails);
		} else
			System.out.println("Student details not found!");
	}

	@Override
	public void displayAllStudent() {
		if (!(lhm.isEmpty())) {
			System.out.println(lhm.values());
		} else
			System.out.println("No data found!");
	}

	@Override
	public void removeStudent() {
		System.out.println("Enter the Student ID");
		int key = sc.nextInt();
		if (lhm.containsKey(key)) {
			lhm.remove(key);
			System.out.println("Student details removed Successfully!");
		} else
			System.out.println("Student details Not found!");
	}

	@Override
	public void sortStudent() {
		System.out.println("Select the input element with respect to Sort");
		System.out.println("1.Name\n2.Age\n3.Gender\n4.Marks\n5.ID");
		int sortInput = sc.nextInt();
		switch (sortInput) {
		case 1:
			System.out.println("Need to update");
			break;
		case 2:
			System.out.println("Need to update");
			break;
		case 3:
			System.out.println("Need to update");
			break;
		case 4:
			System.out.println("Need to update");
			break;
		case 5:
			System.out.println("Need to update");
			break;
		default:
			System.out.println("Invalid Input!");
			break;
		}
	}

	@Override
	public double searchHighestMark() {
		System.out.println("Need to update");
		return 0;
	}

	@Override
	public void clearStudent() {
		System.out.println("Are you sure want to delete all the Student details?");
		String clearStu = sc.next();
		if (clearStu == "yes") {
			if (!(lhm.isEmpty())) {
				lhm.clear();
				System.out.println("All the Student details are removed!");
			} else
				System.out.println("No data present to delete!");
		} else
			System.out.println("No data were deleted!");
	}
}