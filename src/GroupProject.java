import java.sql.Connection;
import java.util.Scanner;

public class GroupProject {
	static Connection connection;
	private static final String COMMAND_ONE = "a";
	private static final String COMMAND_TWO = "b";
	private static final String COMMAND_THREE = "c";
	private static final String COMMAND_FOUR = "d";
	private static final String COMMAND_FIVE = "e";
	private static final String QUIT_COMMAND = "q";
	private static final String HELP_COMMAND = "h";
	private static final String INTRO_LINE = "Welcome! Type h for help. ";
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


			
			} else if (parts[0].equals(COMMAND_FOUR)) {


			
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
		String commandOneDiscription = "Given a address, what ward does it belong to and who (councillor) is in charge of said ward, and how do i get in contact with him.";
		commandOneDiscription += "\n\tEscalating event at a certain location? Lets you contact the councillor in charge to help resolve conflict.";

		String commandTwoDiscription = "Given a minimun space constaint (in square hectors), shows all the parks and open spaces in the city and the land and water area (in Hectors) elnclosed within each park.";
		commandTwoDiscription += "\n\tPlanning a outdoor city event? Take a look at park and open spaces that may be able to accomodate your a event";

		String commandThreeDiscription = "";

		String commandFourDiscription = "";
		
		String commandFiveDiscription = "What were the most service requests in the city, and which ward they occured, and which councillors were in charge of said ward (and in which year they were in charge).";
		commandFiveDiscription += "\n\tEssentially, lets you take a look at what were the dificianncies of the councillor and in wards these dificiancies occured. It also shows which year the councillors where in charge";

		System.out.println(DBMS_NAME);
		System.out.println("Commands:");
		System.out.println(COMMAND_ONE + " <desired address to look up> - " + commandOneDiscription);
		System.out.println(COMMAND_TWO + " <minimun area needed> - " + commandTwoDiscription);
		System.out.println(COMMAND_THREE + " - " + commandThreeDiscription);
		System.out.println(COMMAND_FOUR + " - " + commandFourDiscription);
		System.out.println(COMMAND_FIVE + " - " + commandFiveDiscription);
		System.out.println(HELP_COMMAND + " - Get help");
		System.out.println(QUIT_COMMAND + " - Exit the program");
		System.out.println("---- end help ----- ");
	}

}

