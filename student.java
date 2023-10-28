package jdbc;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class student {

	Connection con;
	PreparedStatement stm;
	String query;
	String user = "root";
	String pass = "system";
	String url = "jdbc:mysql://localhost:3306/School";

	public void Retrieve() throws ClassNotFoundException, SQLException
	{
	
		   
		Class.forName("com.mysql.cj.jdbc.Driver");
		 con = DriverManager.getConnection(url, user, pass);
		 query = "select * from student ";
		 stm =  con.prepareStatement(query);
		ResultSet rs = stm.executeQuery();
		
		while(rs.next())
		{
			String name = rs.getString(1);
			System.out.print(name+ " ");
			int id = rs.getInt(2);
			System.out.print(id+ " ");

			String email = rs.getString(3);
			System.out.print(email+ " ");

			int rollno = rs.getInt(4);
			System.out.print(rollno + " ");
			
			System.out.println();

		}
		con.close();
		stm.close();
	}
		
		public void insert() throws SQLException 
		{
					try {	   
				Class.forName("com.mysql.cj.jdbc.Driver");
			    con = DriverManager.getConnection(url, user, pass);
				query = "insert into student values(?,?,?,?)";
				 stm =  con.prepareStatement(query);
				Scanner scan =new Scanner(System.in);
				System.out.println("enter name of student");
				String name1 = scan.next();
				stm.setString(1, name1);
				
				System.out.println("enter id of student");
				int id1 = scan.nextInt();
				stm.setLong(2, id1);
				
				System.out.println("enter email of student");
				String email1 = scan.next();
				stm.setString(3, email1);
				
				System.out.println("enter rollno of student");
				int rn = scan.nextInt();
				stm.setLong(4, rn);
				
				 int ra = stm.executeUpdate();
				 if(ra > 0 )
				 {
					 System.out.println("insertion succeful");
				 }
				 else {
					 System.out.println("failed");
					 }
				 
					}
				catch(ClassNotFoundException | SQLException e)
				{
					e.printStackTrace();
				}
					
				
				con.close();
				stm.close();
				
					}
	
		public void GetOne() throws ClassNotFoundException, SQLException
		{
		
			   
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection(url, user, pass);
			 query = "select * from student where id = ?";
			 stm =  con.prepareStatement(query);
			 System.out.println("enter the id to get the data ");
			 Scanner sc = new Scanner(System.in);
			 int id = sc.nextInt();
			
			stm.setInt(1, id);
			ResultSet rs = stm.executeQuery();
			while(rs.next())
			{
				String name = rs.getString(1);
				System.out.print(name+ " ");
				int id1 = rs.getInt(2);
				System.out.print(id1+ " ");

				String email = rs.getString(3);
				System.out.print(email+ " ");

				int rollno = rs.getInt(4);
				System.out.print(rollno + " ");
				
				System.out.println();

			}
			con.close();
			stm.close();
		}
		
		public void update() throws SQLException 
		{
					try {	   
				Class.forName("com.mysql.cj.jdbc.Driver");
			    con = DriverManager.getConnection(url, user, pass);
				query = "update student set name=? , email=?,rollno=? where id=?";
				 stm =  con.prepareStatement(query);
				 Scanner s = new Scanner(System.in);
				 System.out.println("enetr name ");
				 String updatedname = s.next();
				 stm.setString(1, updatedname);
				 
				 System.out.println("enetr id ");
				 int updatedid = s.nextInt();
				 stm.setInt(4, updatedid);
				 
				 System.out.println("enetr email ");
				 String updatedemail = s.next();
				 stm.setString(2, updatedemail);
				 
				 System.out.println("enetr rol no ");
				 int updatedrollno = s.nextInt();
				 stm.setInt(3, updatedrollno);
				
				 int ra = stm.executeUpdate();
				 if(ra > 0 )
				 {
					 System.out.println("insertion succeful");
				 }
				 else {
					 System.out.println("failed");
					 }
				 
					}
				catch(ClassNotFoundException | SQLException e)
				{
					e.printStackTrace();
				}
					
				
				con.close();
				stm.close();
				
					}
		public void delete() throws SQLException 
		{
					try {	   
				Class.forName("com.mysql.cj.jdbc.Driver");
			    con = DriverManager.getConnection(url, user, pass);
				query = "delete from student where id =?";
				 stm =  con.prepareStatement(query);
				 Scanner s1 = new Scanner(System.in);
				 System.out.println("enter the id to remove the data");
				 int id2 = s1.nextInt();
				 stm.setInt(1, id2);
				
				 int ra = stm.executeUpdate();
				 if(ra > 0 )
				 {
					 System.out.println("delete succeful");
				 }
				 else {
					 System.out.println("failed");
					 }
				 
					}
				catch(ClassNotFoundException | SQLException e)
				{
					e.printStackTrace();
				}
					
				
				con.close();
				stm.close();
				
					}
}
