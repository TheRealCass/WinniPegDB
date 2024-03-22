import java.sql.Connection;
import java.util.Scanner;

public class CS3380A3Q3 {
	static Connection connection;
	public static final String COMMAND_ONE = "pc";
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
		System.out.println("pc - Get WFPS Performence Mesures");
		System.out.println("danger - Moto Vehicle Incident prone areas");
		System.out.println("rank1 <year> - ranking WFPS teams by the number of incidents they responeded in a time period of a year");
		System.out.println("rank2 - <year> not read by its own author");
		System.out.println(".");
		System.out.println(".");
		System.out.println(".");
		
		System.out.println("q - Exit the program");

		System.out.println("---- end help ----- ");
	}

}

