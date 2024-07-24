package studentResult;

import java.util.Scanner;

public class StudentResultCalculator {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Your Name");
		String name = sc.nextLine();
		System.out.println("Enter Your Register no: ");
		int reg = sc.nextInt();
		System.out.println("Enter 5 subjects marks: ");
		int tamil = sc.nextInt();
		int english = sc.nextInt();
		int maths = sc.nextInt();
		int science = sc.nextInt();
		int social = sc.nextInt();
		int total = tamil + english + maths + science + social;
		float avg = total / 5;
		System.out.println("Student Name: " + name);
		System.out.println("Student Reg No: " + reg);
		if (avg > 0 && avg <= 100) {
			System.out.println("Total Marks: " + total);
			System.out.print("Result: ");
			if (tamil >= 35 && english >= 35 && maths >= 35 && science >= 35 && social >= 35) {
				System.out.println("Pass");
				System.out.println("Percentage: " + avg);
				System.out.print("Your Grade is: ");
				if (avg == 100)
					System.out.println("Centum");
				else if (avg >= 90 && avg < 100)
					System.out.println("First Class with A+ Grade");
				else if (avg >= 80 && avg < 90)
					System.out.println("First Class with Distinction");
				else if (avg >= 60 && avg < 80)
					System.out.println("First Class");
				else if (avg >= 45 && avg < 60)
					System.out.println("Second Class");
				else if (avg >= 35 && avg < 45)
					System.out.println("Third Class");
				else if (avg < 35)
					System.out.println("Fail");
			} else
				System.out.println("Fail");
		} else
			System.out.println("Invalid Mark(s)");
		sc.close();
	}
}