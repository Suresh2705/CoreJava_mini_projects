package studentDBManagement;

import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class StudentDriver {

	public static void main(String[] args) {
		StudentManagementImpl studentManagementImpl = new StudentManagementImpl();
		Scanner scanner = new Scanner(System.in);

		SortByName sortName = new SortByName();
		SortByAge sortAge = new SortByAge();
		boolean repeat = true;
		do {
			Student stu = new Student();
			System.out.println("Enter the Username: ");
			String uname = scanner.nextLine();
			System.out.println("Enter the Password: ");
			String pass = scanner.next();
			boolean login = stu.loginPage(uname, pass);
			if (login) {
				System.out.println("Login Successful!");
				boolean repeatMyApp = true;
				do {
					System.out.println("*********************************************");
					System.out.println("Welcome to Student Database Management!");
					System.out.println(
							"Choose any option:\n1. Add Student\n2. Search Student by ID\n3. Display All the Student\n4. Remove Student\n5. Sort Students\n6. Show Highest Mark\n7. Remove All the Students\n8. Exit");
					System.out.println("*********************************************");
					int userInput = scanner.nextInt();
					scanner.nextLine();
					switch (userInput) {
					case 1: {
						System.out.println("Enter the Student Name: ");
						String name = scanner.nextLine();
						System.out.println("Enter the Student Age: ");
						int age = scanner.nextInt();
						System.out.println("Enter the Student Gender: ");
						String gender = scanner.next();
						System.out.println("Enter the Student Mark: ");
						float mark = scanner.nextFloat();
						System.out.println("*********************************************");
						Student s = new Student(name, age, gender, mark);
						studentManagementImpl.addStudent(s);
						System.out.println("Student Details Added Successfully!");
						break;
					}
					case 2: {
						if (Student.count == 0)
							System.out.println("DataBase is Empty!");
						else {
							System.out.println("Enter the Student ID: ");
							int id = scanner.nextInt();
							if (studentManagementImpl.searchStudent(id) == null)
								System.out.println("Invalid Student ID");
							else {
								System.out.println(studentManagementImpl.searchStudent(id));
							}
						}
						break;
					}
					case 3: {
						List<Student> displayAllStudents = studentManagementImpl.displayAllStudents();
						if (Student.count == 0 || displayAllStudents.size() == 0)
							System.out.println("DataBase is Empty!");
						else {
							for (Student s : displayAllStudents) {
								System.out.println(s);
							}
						}
						break;
					}
					case 4: {
						if (Student.count == 0)
							System.out.println("DataBase is Empty!");
						else {
							System.out.println("Enter the Student ID: ");
							int id = scanner.nextInt();
							Student removed = studentManagementImpl.removeStudent(id);
							if (removed == null) {
								System.out.println("Invalid Student ID!");
							} else {
								System.out.println("Student Details Removed! See the Details Below:\n" + removed);
							}
						}
						break;
					}
					case 5: {
						if (Student.count == 0)
							System.out.println("DataBase is Empty!");
						else {
							System.out.println("Select the input element with respect to Sort");
							System.out.println("1.Name\n2.Age\n3.Marks\n4.ID");
							int sortInput = scanner.nextInt();
							switch (sortInput) {
							case 1: {
								Set<Student> sname = studentManagementImpl.sortStudent(sortName);
								for (Student sn : sname) {
									System.out.println(sn);
								}
								break;
							}
							case 2: {
								Set<Student> sage = studentManagementImpl.sortStudent(sortAge);
								for (Student sa : sage) {
									System.out.println(sa);
								}
								break;
							}
							case 3: {
								Set<Student> ts = new TreeSet<Student>();
								ts.addAll(StudentManagementImpl.l);
								for (Student s : ts) {
									System.out.println(s);
								}
								break;
							}
							case 4: {
								List<Student> displayAllStudents = studentManagementImpl.displayAllStudents();
								if (Student.count == 0 || displayAllStudents.size() == 0)
									System.out.println("DataBase is Empty!");
								else {
									for (Student s : displayAllStudents) {
										System.out.println(s);
									}
								}
								break;
							}
							default: {
								System.out.println("Invalid Input!");
								break;
							}
							}
						}
						break;
					}
					case 6: {
						if (Student.count == 0)
							System.out.println("DataBase is Empty!");
						else {
							Student last = studentManagementImpl.searchHighestMark();
							System.out.println("The highest marks is: " + last.mark);
							System.out.println(
									"Details of the Student is:\n" + studentManagementImpl.searchHighestMark());
						}
						break;
					}
					case 7: {
						if (Student.count == 0)
							System.out.println("DataBase is Already Empty!");
						else {
							System.out.println(
									"This action cannot be undone!\nAre you sure want to delete all the Student details!\nType 'yes' to continue..");
							String userOption = scanner.next();
							if (userOption.equalsIgnoreCase("yes")) {
								studentManagementImpl.clearStudent();
								System.out.println("All the Student Details are Removed!");
							} else
								System.out.println("No Student Details were Deleted!");
						}
						break;
					}
					case 8: {
						repeatMyApp = false;
						break;
					}
					default: {
						System.out.println("Invalid Input!");
						break;
					}
					}

				} while (repeatMyApp);
				System.out.println("Thanks for visiting us!");
				repeat = false;
			} else
				System.out.println(
						"Username or Password invalid!\nPlease enter the valid Credentials!\n*********************************************");
		} while (repeat);
		scanner.close();
	}
}