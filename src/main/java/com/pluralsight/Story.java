package com.pluralsight;
import java.util.Scanner;
import java.io.*;
public class Story {
    public static void main(String[] args) {
        System.out.println("Story time");
        Scanner input = new Scanner(System.in);
        boolean keepGoing = true;

        while (keepGoing) {

            System.out.println("\nAvailable stories:");
            System.out.println("1. goldilocks");
            System.out.println("2. hansel_and_gretel");
            System.out.println("3. mary_had_a_little_lamb");
            System.out.println("Type the name of the story (without .txt), or type exit to quit.");
            System.out.print("Your choice: ");

            String choice = input.nextLine().trim();

            if (choice.equalsIgnoreCase("exit")) {
                keepGoing = false;
                System.out.println("Goodnight!");
                continue;
            }

            String filePath = choice + ".txt";

            try {
                BufferedReader reader = new BufferedReader(new FileReader(filePath));
                String line;
                int lineNumber = 1;

                System.out.println("\n--- Reading " + choice + " ---\n");

                while ((line = reader.readLine()) != null) {
                    System.out.println(lineNumber + ": " + line);
                    lineNumber++;
                }

                reader.close();

            } catch (IOException e) {
                System.out.println("Error: Story not found. Make sure the file name is correct.");
            }
        }


    }
}