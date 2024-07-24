package hotelFoodOrderAndBillingManagement;

import java.util.Scanner;

public class SwiggyFoodOrderAndBilling {

	static Scanner sc = new Scanner(System.in);

	// static double bill;
	public static void paymentApp(double price) {
		double bill;
		System.out.println("Enter the Quantity");
		int quantity = sc.nextInt();
		bill = quantity * price;
		System.out.println("Your bill Amount is: " + bill);
		System.out.println("Select Your Payment method");
		System.out.println("1. G-Pay\n2. Phone Pay");
		int payment_app = sc.nextInt();
		switch (payment_app) {
		case 1:
		case 2: {
			System.out.println("Total bill amount: ");
			double user_entered_amount = sc.nextDouble();
			if (bill == user_entered_amount) {
				int sys_otp = (int) (Math.random() * 9999 + 9999);
				System.out.println("Your otp is: " + sys_otp);
				System.out.println("Enter the OTP:");
				int user_otp = sc.nextInt();
				if (user_otp == sys_otp)
					System.out.println("Order placed Successfully!\nThank you for using Swiggy application!");
				else
					System.out.println("OTP not matching, Payment failed!\nPlease try again!");
			} else
				System.out.println("Bill amount is not correct, Payment failed!\nPlease try again!");
			break;
		}
		default: {
			System.out.println("Invalid Input!\nPlease try again!");
		}
		}
	}

	public static void main(String[] args) {
		System.out.println("Welcome To Swiggy");
		System.out.println("Select the Hotel");
		System.out.println("**********************");
		System.out.println("1. Buhari\n2. A2B\n3. SS Hydrabad");
		int select_hotel = sc.nextInt();
		switch (select_hotel) {
		case 1: {
			System.out.println("Thank You for Selecting Buhari");
			System.out.println("Select Your Food");
			System.out.println("1. Mutton Biriyani\n2. Chicken Briyani\n3. Beef Biriyani\n4. Grill Chicken");
			int select_food = sc.nextInt();
			switch (select_food) {
			case 1: {
				// double price = 380;
				paymentApp(380);
				break;
			}
			case 2: {
				// double price = 300;
				paymentApp(300);
				break;
			}
			case 3: {
				// double price = 280;
				paymentApp(280);
				break;
			}
			case 4: {
				// double price = 400;
				paymentApp(400);
				break;
			}
			default: {
				System.out.println("Invalid Selection\nPlease try again!");
			}
			}
			break;
		}
		case 2: {
			System.out.println("Thank You for Selecting A2B");
			System.out.println("Select Your Food");
			System.out.println("1. Full Meals\n2. Sambar Rice\n3. Veg Rice\n4. Ghee Rice\n5. Curd Rice");
			int select_food = sc.nextInt();
			switch (select_food) {
			case 1: {
				// double price = 220;
				paymentApp(220);
				break;
			}
			case 2: {
				// double price = 100;
				paymentApp(100);
				break;
			}
			case 3: {
				// double price = 120;
				paymentApp(120);
				break;
			}
			case 4: {
				// double price = 150;
				paymentApp(150);
				break;
			}
			case 5: {
				// double price = 100;
				paymentApp(100);
				break;
			}
			default: {
				System.out.println("Invalid Selection\nPlease try again!");
			}
			}
			break;
		}
		case 3: {
			System.out.println("Thank You for Selecting SS Hydrabad");
			System.out.println("Select Your Food");
			System.out.println("1. Hydrabad Mutton Biriyani\n2. Thandhuri\n3. Chicken 65\n4. BBQ");
			int select_food = sc.nextInt();
			switch (select_food) {
			case 1: {
				// double price = 430;
				paymentApp(430);
				break;
			}
			case 2: {
				// double price = 420;
				paymentApp(420);
				break;
			}
			case 3: {
				// double price = 180;
				paymentApp(180);
				break;
			}
			case 4: {
				// double price = 450;
				paymentApp(450);
				break;
			}
			default: {
				System.out.println("Invalid Selection\nPlease try again!");
			}
			}
			break;
		}
		default: {
			System.out.println("Invalid Selection\nPlease try again!");
		}
		}
	}
}