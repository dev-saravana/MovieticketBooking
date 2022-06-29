package Moviebooking;
import java.util.*;
import java.sql.*;
public class Moviebooking {
static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Movies ","root","root");
Statement st=con.createStatement();
System.out.println("Welcome To MovieBookings");
int ch=1;
while(ch!=0) {
	ResultSet rs=st.executeQuery("select * from movieslist");
System.out.println("       Movies List!!!    ");
while(rs.next()) {
System.out.println(rs.getInt(1)+". "+rs.getString(2));
}
//rs.close();
System.out.println("enter your Movie choice");
int choice=sc.nextInt();
rs=st.executeQuery("select count(num) from movieslist");
rs.next();
if(choice>rs.getInt(1)) {
	System.out.println("Please Enter correct Movie Choice");
	continue;
}
rs=st.executeQuery("select name from movieslist where num="+choice);
rs.next();
String moviename=rs.getString(1);
System.out.println("     "+rs.getString(1)+" Movie");
System.out.println("Enter your name ");
sc.nextLine();
String name=sc.nextLine();
System.out.println("Enter your age");
int age=sc.nextInt();
System.out.println("Enter number of Tickets");
int ticket=sc.nextInt();
Booking b1=new Booking(moviename,name,age,ticket);
System.out.println("Total Cost is "+ticket+" X 120="+ticket*120);
System.out.println("Press 1 For payment");
int j=sc.nextInt();
if(j!=1) {
	System.out.println("Your Booking is cancelled ");
	break;
}
System.out.println("payment Done");
System.out.println("Your Booking is Confirmed ");
System.out.println("     Booking Details");
b1.setdata();
rs=st.executeQuery("select * from Booking");
while(rs.next()) {
	System.out.println(" Movie name : "+rs.getString(1));
	System.out.println(" Name : "+rs.getString(2));
	System.out.println(" age : "+rs.getInt(3));
	System.out.println(" Tickets : "+rs.getInt(5));
	System.out.println(" Booking Time : "+rs.getString(4));
	System.out.println();
}
rs.close();
ch=0;
}
	}
}
