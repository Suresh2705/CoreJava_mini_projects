package superMarketDBManagement;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DBMethods {
	static Scanner sc = new Scanner(System.in);
	Connection c = null;

	public Connection establishConnection() throws ClassNotFoundException, SQLException {
//		1. Load the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
//		2. Establish Connection
		c = DriverManager.getConnection("jdbc:mysql://localhost:3306/product_db", "root", "root");

		return c;
	}

	public void closeConnection() {
		if (c != null) {
			try {
				c.close();
				System.out.println("Connection closed!");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else
			System.out.println("Connection not established!");
	}

	public void addProducts(Products p) throws ClassNotFoundException, SQLException {
		c = establishConnection();
		PreparedStatement ps = c.prepareStatement("insert into products values(?,?,?,?)");
		ps.setInt(1, p.getPid());
		ps.setString(2, p.getName());
		ps.setDouble(3, p.getPrice());
		ps.setString(4, p.getBrand());
		ps.executeUpdate();
		System.out.println("Data saved!");
	}

	public Products fetchProductById(int pid) throws ClassNotFoundException, SQLException {
		c = establishConnection();
		PreparedStatement ps = c.prepareStatement("select * from products where pid = ?");
		ps.setInt(1, pid);

		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			int id = rs.getInt(1);
			String name = rs.getString(2);
			double price = rs.getDouble(3);
			String brand = rs.getString(4);

			Products p = new Products();
			p.setPid(id);
			p.setName(name);
			p.setPrice(price);
			p.setBrand(brand);

			return p;
		}
		return null;
	}

	public List<Products> fetchAllProducts() throws ClassNotFoundException, SQLException {
		ArrayList<Products> al = new ArrayList<Products>();

		c = establishConnection();
		Statement s = c.createStatement();
		ResultSet rs = s.executeQuery("select * from products");

		while (rs.next()) {
			int pid = rs.getInt(1);
			String name = rs.getString(2);
			double price = rs.getDouble(3);
			String brand = rs.getString(4);

			Products p = new Products();
			p.setPid(pid);
			p.setName(name);
			p.setPrice(price);
			p.setBrand(brand);

			al.add(p);
		}
		return al;
	}

	public void removeProductById(int pid) throws ClassNotFoundException, SQLException {
		c = establishConnection();
		PreparedStatement ps = c.prepareStatement("delete from products where pid = ?");
		ps.setInt(1, pid);
		ps.executeUpdate();
		System.out.println("Data deleted sucessfully!");
	}
	
	public void removeAllProducts() throws ClassNotFoundException, SQLException {
		c = establishConnection();
		Statement s = c.createStatement();
		System.out.println("This action can't be undone!\nAre you sure want to delete all the products?\nType 'yes' to continue!");
		String userInput = sc.nextLine();
		if(userInput.equalsIgnoreCase("yes")) {
			s.executeUpdate("truncate table products");
			System.out.println("All the data have been deleted!");
		}else
			System.out.println("No data were deleted!");
	}
	public void updateProduct(Products p) throws ClassNotFoundException, SQLException {
		c = establishConnection();
		
		PreparedStatement ps = c.prepareStatement("update products set name=?, price=?, brand=? where pid = ?");
		ps.setString(1, p.getName());
		ps.setDouble(2, p.getPrice());
		ps.setString(3, p.getBrand());
		ps.setInt(4, p.getPid());
		ps.executeUpdate();
	}
}