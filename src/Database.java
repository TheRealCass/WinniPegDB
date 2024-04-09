import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class MyDatabase {
	private Connection connection;

	public MyDatabase() {
		try {
			String url = "jdbc:sqlite:assets/storage.db";
			// create a connection to the database
			connection = DriverManager.getConnection(url);
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}

	}

	//1
	public void commandOne(String address) { 
	
		String sql =    "SELECT " +
							"a.Ward AS Ward, " +
							"c.Person AS Councillor, " +
							"c.Phone AS Phone " + 
						"FROM " +  
							"Addresses a " + 
						"JOIN " +  
							"Councillors c " + 
						"ON " +  
							"a.Ward = c.WardName " + 
						"WHERE " +  
							"LOWER(a.FullAddress) = LOWER(?) " + 
						"GROUP BY " + 
							"Councillor";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);

			//using our wildcard to set variables in sql statemet
            pstmt.setString(1, address);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
				String ward = rs.getString("Ward");
				String councillor = rs.getString("Councillor");
				String phoneNumber = rs.getString("Phone");
				String msg = councillor + " is in charge of " + ward + " which covers " + address + ". Their contact info is " + phoneNumber + ".";
                System.out.println( msg);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
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

		String sql =    "SELECT " +
							"ServiceRequest AS Event, " + 
							"Person AS Councillor, " + 
							"ward, year " + 
						"FROM " + 
							"ServiceCalls " +
						"JOIN " + 
							"Councillors " + 
						"ON " +
							"ServiceCalls.Ward = Council.WardName " + 
						"GROUP BY " + 
							"ServiceRequest";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

			System.out.println("ward\t\tservice request\t\tcouncillor in charge\t\tyear of office");
            while (rs.next()) {
				String serviceRequest = rs.getString("Event");
				String councillor = rs.getString("Councillor");
				String ward = rs.getString("ward");
				String year = rs.getString("year");
				String msg = ward + " has the most complains regarding " + serviceRequest + ". " + councillor + " was in charge of this ward in " + year + ".";
				//String msg = ward + "\t\t" + serviceRequest + "\t\t" + councillor + "\t\t" + year;
                System.out.println( msg);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
			
	}

	
}
