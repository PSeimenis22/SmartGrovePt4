package Polymorphism;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class DatabaseManager {
    public void saveTreeToDatabase(OliveTree tree) {
        // I use the command getenv so the password is not typed publicly.
        String myUrl = System.getenv("DB_URL");
        String myUser = System.getenv("DB_USER");
        String myPassword = System.getenv("DB_PASS");
        // This is a safe check so if the password is incorrect it doesnt crash the code.
        if (myUrl == null || myUser == null || myPassword == null) {
            System.out.println("The database passwords are not set up in IntelliJ.");
            return;
        }

        try {
            System.out.println("Trying to connect to the database...");
            Connection myConnection = DriverManager.getConnection(myUrl, myUser, myPassword); // Open a connection.
            Statement myStatement = myConnection.createStatement(); // Create statement tool.
            // Now I brake the commands into pieces so it easier for me to understand what I wrote.
            // I write a long stride of text so it is understandable for MySQL.
            String sqlText = "INSERT INTO olive_grove (id, plant_year, olive_type, oil_content, is_alternate_bearing) VALUES (";
            sqlText = sqlText + tree.getId() + ", ";
            sqlText = sqlText + tree.getPlantYear() + ", ";
            sqlText = sqlText + "'" + tree.getOliveType() + "', ";
            sqlText = sqlText + tree.getOilContent() + ", ";
            sqlText = sqlText + tree.isAlternateBearing() + ")";
            // Sending the command to MySQL.
            System.out.println("Sending data for Tree ID: " + tree.getId());
            myStatement.executeUpdate(sqlText);

            System.out.println("SUCCESS! Tree saved safely to the database.");
            // It is really important to close those 2 lines so the computer doesnt run out of memory.
            myStatement.close();
            myConnection.close();
            // I catch the error and block it if anything goes wrong like Duplicate Entries etc.
        } catch (SQLException error) {
            System.out.println("Database error!");
            System.out.println(error.getMessage());
        }
    }
}
