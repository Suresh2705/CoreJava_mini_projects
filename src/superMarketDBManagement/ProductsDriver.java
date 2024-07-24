package superMarketDBManagement;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ProductsDriver {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		DBMethods db = new DBMethods();
		Products p = new Products();
		Scanner sc = new Scanner(System.in);
		boolean repeatMyApp = true;
		do {
			System.out.println("******************************************");
			System.out.println("Welcome to Sezhin SuperMarket!");
			System.out.println(
					"Choose any option to proceed!\n1. Add Product\n2. Fetch a Product\n3. Fetch all the product\n4. Remove Product\n5. Update product\n6. Remove All the products\n7. Exit");
			int userInput = sc.nextInt();
			switch (userInput) {
			case 1: {
				System.out.println("Enter the Product ID: ");
				int pid = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter the Product Name: ");
				String name = sc.nextLine();
				System.out.println("Enter the Product Price: ");
				double price = sc.nextDouble();
				sc.nextLine();
				System.out.println("Enter the Product Brand: ");
				String brand = sc.nextLine();

				p.setPid(pid);
				p.setName(name);
				p.setPrice(price);
				p.setBrand(brand);

				db.addProducts(p);
				break;
			}
			case 2: {
				System.out.println("Enter the product ID:");
				int pid = sc.nextInt();
				p = db.fetchProductById(pid);
				System.out.println(p);
				break;
			}
			case 3: {
				List<Products> l = db.fetchAllProducts();
				for (Products lp : l) {
					System.out.println(lp);
				}
				break;
			}
			case 4: {
				System.out.println("Enter the Product ID");
				int pid = sc.nextInt();
				db.removeProductById(pid);
				break;
			}
			case 5: {
				System.out.println("Enter the Product ID: ");
				int pid = sc.nextInt();
				p = db.fetchProductById(pid);
				if (p != null) {
					System.out.println("Please choose the detail to update\n1.Name\n2.Price\n3.Brand");
					int userInp = sc.nextInt();
					sc.nextLine();
					switch (userInp) {
					case 1: {
						System.out.println("Enter the Product Name: ");
						String name = sc.nextLine();
						p.setName(name);
						break;
					}
					case 2: {
						System.out.println("Enter the Product Price: ");
						double price = sc.nextDouble();
						p.setPrice(price);
						break;
					}
					case 3: {
						System.out.println("Enter the Product Brand: ");
						String brand = sc.nextLine();
						p.setBrand(brand);
						break;
					}
					default: {
						System.out.println("Invalid input!");
						break;
					}
					}
					db.updateProduct(p);
					System.out.println("Data updated!");
				} else
					System.out.println("Details not found!");
				break;
			}
			case 6: {
				db.removeAllProducts();
				break;
			}
			case 7: {
				db.closeConnection();
				repeatMyApp = false;
				break;
			}
			default: {
				System.out.println("Invalid Input!");
				break;
			}
			}
		} while (repeatMyApp);
		System.out.println("Thank you for visiting us!");
		sc.close();
	}
}