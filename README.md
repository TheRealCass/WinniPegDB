# City of Winnipeg DB

This is a Java-based console application that interacts with the City of Winnipeg's database. The database was created to help the Mayor make better-informed decisions for the city.

## Getting Started

1. To run the application, you need to have Java installed on your machine.
2. After that, you can run the `GroupProject` class which contains the `main` method. Alternatively, just type in `make run` and hit enter,and DBMS should be initated
3. Type in `h` and hit enter to see all the avalable commands.

## Commands

The application supports the following commands:

1. `locationInfo <desired address to look up>`: Given an address, it returns the ward it belongs to, who (councillor) is in charge of said ward, and how to get in contact with them. This is useful for escalating events at a certain location.

2. `space <minimum area needed>`: Given a minimum space constraint (in square hectares), it shows all the parks and open spaces in the city and the land and water area (in hectares) enclosed within each park. This is useful for planning outdoor city events.

3. `council`: Lists all the current councillors and the wards they are in charge of, along with their contact info.

4. `potholes`: Lists the neighbourhoods that have had more than 8 pothole complaints in the last 2 years straight.

5. `devArea`: Displays the top 10 neighbourhoods with the biggest water area near them. This is useful for developers looking to invest in the city.

6. `addCouncil <ward,name,year>`: Given a ward, a new person (and their contact info), and a new year (must be greater than 2023), it onboards them as a Councillor in the DB. This is useful for quickly changing who is the new councillor in charge to keep the DB up-to-date.

Additionally, you can use `q` to exit the program.

## Exiting the Program

To exit the program, simply type `q` at the `db > ` prompt.



