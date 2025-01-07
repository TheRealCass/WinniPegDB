import java.sql.Connection;
import java.util.Scanner;

public class GroupProject {
	static Connection connection;
	private static final String COMMAND_ONE = "locationInfo";
	private static final String COMMAND_TWO = "space";
	private static final String COMMAND_THREE = "council";
	private static final String COMMAND_FOUR = "potholes";
	private static final String COMMAND_FIVE = "devArea";
	private static final String COMMAND_SIX = "addCouncil";
	private static final String QUIT_COMMAND = "q";
	private static final String HELP_COMMAND = "h";
	private static final String BUILD_RESON = "This DB was creadted so that the Mayor could make better informed decition for WPG city\n";
	private static final String INTRO_LINE = "Welcome!\n" + BUILD_RESON + "Type h for help. ";
	private static final String CURSOR = "db > ";
	private static final String DBMS_NAME = "City of Winnipeg DB";

	public static void main(String[] args) throws Exception {

		// startup sequence
		MyDatabase db = new MyDatabase();
		runConsole(db);

		System.out.println("Exiting...");
	}

	public static void runConsole(MyDatabase db) {
		String dilimiter = "\\s+";

		Scanner console = new Scanner(System.in);
		System.out.print(INTRO_LINE);
		System.out.print(CURSOR);
		String line = console.nextLine();
		String[] parts;
		String arg = "";

		while (line != null && !line.equals(QUIT_COMMAND)) {
			parts = line.split(dilimiter);
			if (line.indexOf(" ") > 0){
				arg = line.substring(line.indexOf(" ")).trim();
			}

			if (parts[0].equals(HELP_COMMAND)) {
				printHelp();

			} else if (parts[0].equals(COMMAND_ONE)) {
				
				if (parts.length >= 2) {
					db.commandOne(arg);
				} else {
					System.out.println("Require an argument for this command");
				}
			
			} else if (parts[0].equals(COMMAND_TWO)) {
				
				try {
					if (parts.length >= 2)
						db.commandTwo(arg);
					else
						System.out.println("Require an argument for this command");
				} catch (Exception e) {
					System.out.println("id must be an integer");
				}

			} else if (parts[0].equals(COMMAND_THREE)) {
				
				db.commandThree();
			
			} else if (parts[0].equals(COMMAND_FOUR)) {

				db.commandFour();
			
			} else if (parts[0].equals(COMMAND_FIVE)) {

				db.commandFive();

			} else if (parts[0].equals(COMMAND_SIX)) {
				
				try {
					if (parts.length >= 2)
						db.commandSix(arg);
					else
						System.out.println("Require an argument for this command");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

			}else{
				System.out.println("Read the help with h, or find help somewhere else.");
			}

			System.out.print(CURSOR);
			line = console.nextLine();
		}

		console.close();
	}

	private static void printHelp() {
		String commandOneDescription = "Given an address, identify the corresponding ward and the councillor in charge. Contact information for the councillor is also provided.";
		commandOneDescription += "\nIn case of an escalating event at a specific location, contact the responsible councillor to help resolve the conflict.";

		String commandTwoDescription = "Given a minimum space constraint (in square hectares), list all parks and open spaces in the city that meet the requirement, including land and water areas enclosed within each park.";
		commandTwoDescription += "\nUseful for planning outdoor city events by identifying suitable parks and open spaces.";

		String commandThreeDescription = "List all current councillors along with the wards they oversee and their contact information.";

		String commandFourDescription = "List neighbourhoods with more than 8 pothole complaints in the last 2 years.";

		String commandFiveDescription = "Identify the top 10 neighbourhoods with the largest water areas nearby.";
		commandFiveDescription += "\nUseful for attracting developers by highlighting neighbourhoods with water features in their parks.";

		String commandSixDescription = "Given a ward, new councillor's name, and year (must be greater than 2023), onboard them as a councillor in the database.";
		commandSixDescription += "\nQuickly change who is the new councillor in charge to keep the database up-to-date.";

		System.out.println("\n" + DBMS_NAME);
		System.out.println("Commands:\n");
		System.out.println(COMMAND_ONE + " <desired address to look up>\n" + commandOneDescription + "\n");
		System.out.println(COMMAND_TWO + " <minimum area needed>\n" + commandTwoDescription + "\n");
		System.out.println(COMMAND_THREE + "\n" + commandThreeDescription + "\n");
		System.out.println(COMMAND_FOUR + "\n" + commandFourDescription + "\n");
		System.out.println(COMMAND_FIVE + "\n" + commandFiveDescription + "\n");
		System.out.println(COMMAND_SIX + " <ward,name,year>\n" + commandSixDescription + "\n");
		System.out.println(HELP_COMMAND + " - Get help" + "\n");
		System.out.println(QUIT_COMMAND + " - Exit the program" + "\n");
		System.out.println("---- end help ----- ");

	}

}

