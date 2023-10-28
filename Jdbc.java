package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Jdbc {

	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		student std = new student();
		Scanner scan = new Scanner(System.in);
	    while(true) {
        System.out.println("enter 1 ====> Insert");
        System.out.println("enter 2 ====> Display");
        System.out.println("enter 3 ====> get by Id");
        System.out.println("enter 4 ====> Update");
        System.out.println("enter 5 ====> Delete");
        System.out.println("enter 6 ====> Exit");


        int n = scan.nextInt();
        switch(n) {
        
        case 1: 
        	std.insert();

        	break;
        case 2 : try {
				std.Retrieve();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} break;
        case 3:
        	try {
        	std.GetOne();
        	} catch(ClassNotFoundException | SQLException e)
        	{
        		e.printStackTrace();
        	} break;
        case 4:
        	try {
        		std.update();
        	} catch(SQLException e)
        	{
        		e.printStackTrace();
        	} break;
        	
        case 5:
        	try {
        		std.delete();
        	}catch(SQLException e) {
        		e.printStackTrace();
        	} break;
        case 6:
        	System.exit(0);
        }
		} 
	
	}
}
