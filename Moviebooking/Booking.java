package Moviebooking;
//import java.time.*;
import java.sql.*;


public class Booking {
	String movie;
	String name;
	int age;
	int ticket;
	String date;
	public Booking(String movie,String name,int age,int tickets) {
		this.movie=movie;
		this.name=name;
		this.age=age;
		this.ticket=tickets;
	}
	public void setdata() throws SQLException {
		try{String query="insert into Booking values(?,?,?,?,?)";
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Movies ","root","root@1234");
		PreparedStatement st=con.prepareStatement(query);
		st.setString(1,movie);
		st.setString(2,name);
		st.setInt(3, age);
		java.util.Date d=new java.util.Date();
		String s=d.toString();
		//long d=System.currentTimeMillis();
		//java.sql.Date dt=new java.sql.Date(d);
		st.setString(4,s);
		st.setInt(5, ticket);
	    st.executeUpdate();
		}catch(SQLException e) {
			System.out.println(e);
		}
	}

}
