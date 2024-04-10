import java.sql.Connection;
import java.util.Scanner;

public class GroupProject {
	static Connection connection;
	private static final String COMMAND_ONE = "locationInfo";
	private static final String COMMAND_TWO = "space";
	private static final String COMMAND_THREE = "council";
	private static final String COMMAND_FOUR = "potholes";
	private static final String COMMAND_FIVE = "devArea";
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
			} else{
				System.out.println("Read the help with h, or find help somewhere else.");
			}

			System.out.print(CURSOR);
			line = console.nextLine();
		}

		console.close();
	}

	private static void printHelp() {
		String commandOneDiscription = "Given a address, which ward does it belong to and who (councillor) is in charge of said ward, and how do i get in contact with him.";
		commandOneDiscription += "\nEscalating event at a certain location? Lets you contact the councillor in charge to help resolve conflict.";

		String commandTwoDiscription = "Given a minimun space constaint (in square hectors), shows all the parks and open spaces in the city and the land and water area (in Hectors) elnclosed within each park.";
		commandTwoDiscription += "\nPlanning a outdoor city event? Take a look at park and open spaces that may be able to accomodate your a event";

		String commandThreeDiscription = "List all the CURRENT councillors and the wards they are in charge of and their contact info.";
		commandThreeDiscription += "\n";

		String commandFourDiscription = "List the neighbourhood that has has more than 8 pothole complaint in the last 2 years stright";
		//commandFourDiscription += "Areas in need of public infastructure repair on a macro scale\n";

		String commandFiveDiscription = "Top 10 Neighbourhoods with biggest water area near them";
		commandFiveDiscription += "\nRevenue shrinking? Looking for developers to invest in the city? Here's some fancy neighbourhoods with water flowing through it's parks";

		System.out.println("\n" + DBMS_NAME);
		System.out.println("Commands:\n");
		System.out.println(COMMAND_ONE + " <desired address to look up>\n" + commandOneDiscription + "\n");
		System.out.println(COMMAND_TWO + " <minimun area needed>\n" + commandTwoDiscription + "\n");
		System.out.println(COMMAND_THREE + "\n" + commandThreeDiscription + "\n");
		System.out.println(COMMAND_FOUR + "\n" + commandFourDiscription + "\n");
		System.out.println(COMMAND_FIVE + "\n" + commandFiveDiscription + "\n");
		System.out.println(HELP_COMMAND + " - Get help" + "\n");
		System.out.println(QUIT_COMMAND + " - Exit the program" + "\n");
		System.out.println("---- end help ----- ");
	}

}

