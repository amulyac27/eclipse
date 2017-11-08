package storedprocedure;

import java.awt.Window.Type;
import java.sql.*;

public class Procedure {

	public static void main(String[] args) {
	
		try {
			
			 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping_cart", "root", "");
				
			 int customer_id=3;
			CallableStatement pstmt = conn.prepareCall("{call usp_namebyCustID(?,?)");
			pstmt.setInt(1, customer_id);
			pstmt.registerOutParameter(2,Type.char);

			pstmt.executeUpdate();

			String name = pstmt.getString(2);
			System.out.print("The name of the customer is " + name + "for the ID " + customer_id);
			pstmt.close();
			conn.close();
			}

		  catch(SQLException ex)
	      {
	    	  ex.printStackTrace();
	      }	 }

	}

}
