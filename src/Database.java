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
							"c.Phone AS Phone, " + 
							"c.Year AS year " + 
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
				String year = rs.getString("year");
				if (phoneNumber == null ) {
					phoneNumber = "not avalable in this database";
				}
				String msg = "In " + year + ", " + councillor + "was in charge of " + ward + "which covers " + address + ".\n\tTheir phone number is " + phoneNumber + ".";
                System.out.println( msg);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
	}

	//2
	public void commandTwo(String maxArea) {
		String sql =    "SELECT " +
							"ParkName, " +
							"(TotalAreainHectares-WaterAreainHectares) AS LandArea, " +
							"WaterAreainHectares AS waterArea, " +
							"LocationDescription AS location " +
						"FROM " +
							"Parks " +
						"WHERE " + 
							"TotalAreainHectares >= ?" + 
						"ORDER BY " +
							"TotalAreainHectares DESC ";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
			
			//using our wildcard to set variables in sql statemet
            pstmt.setString(1, maxArea);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
				String name = rs.getString("ParkName");
				String land = rs.getString("LandArea");
				String water = rs.getString("waterArea");
				String location = rs.getString("location");
				String msg = name + " has " + land + " square hectors of land and " + water + " square hectors of water.\n\tIt is located at " + location + ".";
                System.out.println( msg);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
			
	}

	//3
	public void commandThree() {

		String sql =    "SELECT " +
							"person, " + 
							"WardName, " + 
							"Position, " +
							"phone, " + 
							"fax " + 
						"FROM " + 
							"Councillors " +
						"WHERE " +
							"CurrentCouncil = 'TRUE' ";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
				String person = rs.getString("person");
				String ward = rs.getString("WardName");
				String rank = rs.getString("Position");
				String phone = rs.getString("phone");
				String fax = rs.getString("fax");
				String msg = person + " is the " + rank + " of " + ward + ".\n\tTheir phone number is " + phone + ".\n\tTheir fax number is " + fax + ".";
                System.out.println(msg);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
			
	}


	//4
	public void commandFour() {

		int potholeComplainThrushold = 8;
		
		String sql =    "SELECT " +
							"Neighbourhood, " +
							"COUNT(*) AS PotholeRequests " +
						"FROM " +
							"ServiceCalls " +
						"WHERE " +
							"ServiceRequest = 'Potholes' " +
								"AND " +
									"(Year = 2022 OR Year = 2023) " +
						"GROUP BY " +
							"Neighbourhood " +
						"HAVING COUNT(DISTINCT Year) = 2 " +
							"AND " +
								"PotholeRequests > " + potholeComplainThrushold + " " +
						"ORDER BY " +
							"PotholeRequests " +
								"DESC;";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
				String neighbourhood = rs.getString("Neighbourhood");
				String requestCount = rs.getString("PotholeRequests");
				String msg = neighbourhood + "\t----->\t" + requestCount + " complaints.";
                System.out.println(msg);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
		
	}

	//5
	public void commandFive() {

		String sql =    "SELECT " +
							"LOWER(Neighbourhood) AS ngbhd, " +
							"MAX(WaterAreainHectares) AS MaxWaterArea " +
						"FROM " +
							"Parks " +
						"GROUP BY " +
							"ngbhd " +
						"ORDER BY " +
							"MaxWaterArea " +
								"DESC " +
						"LIMIT " +
							"10";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
				String neighbourhood = rs.getString("ngbhd");
				String water = rs.getString("MaxWaterArea");
				String msg = neighbourhood + " \t---->\t" + water + " sqaure hectors of water area enclosed within it.";
                System.out.println(msg);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
			
	}

	
}
