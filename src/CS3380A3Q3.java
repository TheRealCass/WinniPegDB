import java.sql.Connection;
import java.util.Scanner;

public class CS3380A3Q3 {
	static Connection connection;
	public static final String COMMAND_ONE = "command1";
	public static final String COMMAND_TWO = "command2";
	public static final String COMMAND_THREE = "command3";
	public static final String COMMAND_FOUR = "command4";
	public static final String COMMAND_FIVE = "command5";

	public static void main(String[] args) throws Exception {

		// startup sequence
		MyDatabase db = new MyDatabase();
		runConsole(db);

		System.out.println("Exiting...");
	}

	public static void runConsole(MyDatabase db) {

		Scanner console = new Scanner(System.in);
		System.out.print("Welcome! Type h for help. ");
		System.out.print("db > ");
		String line = console.nextLine();
		String[] parts;
		String arg = "";

		while (line != null && !line.equals("q")) {
			parts = line.split("\\s+");
			if (line.indexOf(" ") > 0){
				arg = line.substring(line.indexOf(" ")).trim();
			}

			if (parts[0].equals("h")) {
				printHelp();


			} else if (parts[0].equals(COMMAND_ONE)) {


			
			} else if (parts[0].equals(COMMAND_TWO)) {


			
			} else if (parts[0].equals(COMMAND_THREE)) {


			
			} else if (parts[0].equals(COMMAND_FOUR)) {


			
			} else if (parts[0].equals(COMMAND_FIVE)) {


			
			} else{
				System.out.println("Read the help with h, or find help somewhere else.");
			}

			System.out.print("db > ");
			line = console.nextLine();
		}

		console.close();
	}

	private static void printHelp() {
		System.out.println("Library database");
		System.out.println("Commands:");
		System.out.println("h - Get help");
		System.out.println("s <name> - Search for a name");
		System.out.println("l <id> - Search for a user by id");
		System.out.println("sell <author id> - Search for a stores that sell books by this id");
		System.out.println("notread - Books not read by its own author");

		System.out.println("q - Exit the program");

		System.out.println("---- end help ----- ");
	}

}

