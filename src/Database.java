import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class MyDatabase {
	private Connection connection;

	public MyDatabase() {
		try {
			String url = "jdbc:sqlite:library.db";
			// create a connection to the database
			connection = DriverManager.getConnection(url);
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}

	}

	//1
	public void commandOne() {
        
        
       

	}

	//2
	public void commandTwo() {
        

	}

	//3
	public void commandThree() {
		
		

	}


	//4
	public void commandFour() {
		
	}

	//5
	public void commandFive() {
			
	}

	
}
