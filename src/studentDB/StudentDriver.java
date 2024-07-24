package studentDB;

import java.util.Scanner;

public class StudentDriver {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StudentManagementImpl sm = new StudentManagementImpl();
		boolean repeatMyApp = true;
		do {
			System.out.println("Welcome to Student DataBase Management");
			System.out.println("Choose the Input");
			System.out.println("1. Add Student\n2. Search Student\n3. Display All the Student"
					+ "\n4. Remove Student\n5. Sort Student\n6. Search Highest Marks\n7. Clear Student\n8. Exit");
			int userInput = sc.nextInt();
			switch(userInput) {
			case 1:
				sm.addStudent();
				break;
			case 2:
				sm.searchStudent();
				break;
			case 3:
				sm.displayAllStudent();
				break;
			case 4:
				sm.removeStudent();
				break;
			case 5:
				sm.sortStudent();
				break;
			case 6:
				sm.searchHighestMark();
				break;
			case 7:
				sm.clearStudent();
				break;
			case 8:
				repeatMyApp = false;
				break;
			default:
				System.out.println("Invalid Input!");
				break;
			}
		} while (repeatMyApp);
		System.out.println("Thank you for visiting us!");
		sc.close();
	}
}