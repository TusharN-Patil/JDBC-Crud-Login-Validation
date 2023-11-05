package org.jspider.StudentManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentManagement {
	private static Scanner sc = new Scanner(System.in);
private static int x;
	public static void main(String[] args) {
		do {
			System.out.println("1:- Insert The Student Record!!!!");
			System.out.println("2:- Update The Student Record!!!!");
			System.out.println("3:- Delete The Student Record!!!!");
			System.out.println("4:- Find The Student Record!!!!");
			System.out.println("Enter the Choice");
			int choice = sc.nextInt();
			switch (choice) {
			case 1: {
				insert();
				break;
			}
			case 2: {
				update();
				break;
			}
			case 3: {
				delete();
				break;
			}
			case 4: {
				System.out.println("Student Login Valideation!");
				fetchAllStudent();
				break;
			}
			case 5:{
				System.out.println("Thank you From Performing StudentManagement System Project");
				return;
			}
			
			}
			repeted();
		} while (x <= 1);
		System.out.println("Completet The Program!!!!");
	}

	public static void repeted() {
      System.out.println("Enter 1 To Perform Opreation and Enter 2 if you Not want to Perform!!!!");
		x=sc.nextInt();
	}

	public static void fetchAllStudent() {
		System.out.println("Enter Student Rollno");
		int id = sc.nextInt();
		System.out.println("Enter Student Name");
		String name = sc.next();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		String qry = "select * from college.students where ROLLNO=? and NAME=?";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			pstmt = con.prepareStatement(qry);
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			rst = pstmt.executeQuery();
			if (rst.next()) {
				System.out.println("Student Id:-" +rst.getInt("ROLLNO") );
				System.out.println("Student name:-" + rst.getString("NAME"));
				System.out.println("Student marks:-" + rst.getDouble("MARKS"));
				System.out.println("Student grads:-" + rst.getString("GRADS"));
				System.out.println("Student city:-" + rst.getString("CITY"));
				System.out.println("==========================================");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (rst != null) {
				try {
					rst.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	public static void delete() {
		System.out.println("Enter the Student Roolno To Delete The Student Record");
		int id = sc.nextInt();

		Connection con = null;
		PreparedStatement pstmt = null;
		String qry = "delete from college.students where ROLLNO=?";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			pstmt = con.prepareStatement(qry);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			System.err.println("Student Record Is Deletet with id:-" + id);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	public static void update() {

		System.out.println("Enter The Student Name");
		String name = sc.next();
		System.out.println("Enter The Student Marks");
		double marks = sc.nextDouble();
		System.out.println("Enter The Student Grads");
		String grads = sc.next();
		System.out.println("Enter The Student City");
		String city = sc.next();

		System.out.println("Enter the Student Rollno!");
		int id = sc.nextInt();
		Connection con = null;
		PreparedStatement pstmt = null;
		String qry = "update college.students set NAME=?, MARKS=?,GRADS=?,CITY=? where ROLLNO=?";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			pstmt = con.prepareStatement(qry);
			pstmt.setString(1, name);
			pstmt.setDouble(2, marks);
			pstmt.setString(3, grads);
			pstmt.setString(4, city);
			pstmt.setInt(5, id);
			pstmt.executeUpdate();
			System.err.println("Student Record Is Updatet with id:-" + id);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	public static void insert() {
		System.out.println("Enter the Student Rollno!");
		int id = sc.nextInt();
		System.out.println("Enter The Student Name");
		String name = sc.next();
		System.out.println("Enter The Student Marks");
		double marks = sc.nextDouble();
		System.out.println("Enter The Student Grads");
		String grads = sc.next();
		System.out.println("Enter The Student City");
		String city = sc.next();

		Connection con = null;
		PreparedStatement pstmt = null;
		String qry = "insert into college.students values(?,?,?,?,?)";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			pstmt = con.prepareStatement(qry);
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setDouble(3, marks);
			pstmt.setString(4, grads);
			pstmt.setString(5, city);
			pstmt.executeUpdate();
			System.err.println("Student Record Is save with id:-" + id);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
