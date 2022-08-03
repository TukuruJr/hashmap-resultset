import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import javax.swing.JOptionPane;

public class PopulateHashmaps {
	private Connection cn;
	private PreparedStatement pst;
	private HashMap<Integer, Users> users;

	public PopulateHashmaps() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated constructor stub
		
		if(conn()!=null) {
			FetchUsers();
		}
		
	}

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		new PopulateHashmaps();

	}
	
	
	private Connection conn() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return cn = DriverManager.getConnection("jdbc:mysql://localhost/Users","root","");
		
	}
	private void FetchUsers() throws SQLException {
		
		 users = new HashMap<Integer, Users>(); //initialize 
		pst = cn.prepareStatement("select * from users");  //fetch all data from table users
		ResultSet rs = pst.executeQuery();  //rs has all data we need
		
		while(rs.next()) {
			//fetch all data and store in variables
			int id = rs.getInt(1);
			String name = rs.getString(2);
			String position = rs.getString(3);
			String country = rs.getString(4);
			
			Users us = new Users(name,position,country);
			users.put(id, us);
		}
		
		for(int i:users.keySet()) { //iterate through the total keysets in the HashMap
			Users user = users.get(i);  //fetch an instance of Users with key
			System.out.println(user.toString()); //display
		}
	   
	 
		
		
	}
	
	
}
