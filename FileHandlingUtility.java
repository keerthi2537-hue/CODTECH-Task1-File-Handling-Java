package keerthi;

import java.io.*;
import java.util.Scanner;

public class FileHandlingUtility {

    static String fileName = "sample.txt";

    public static void writeFile(String text) {
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write(text);
            writer.close();
            System.out.println("File written successfully!");
        } catch (IOException e) {
            System.out.println("Error writing file.");
        }
    }

    public static void readFile() {
        try {
            File file = new File(fileName);
            Scanner reader = new Scanner(file);
            System.out.println("\nFile Content:");
            while (reader.hasNextLine()) {
                System.out.println(reader.nextLine());
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }

    public static void appendFile(String text) {
        try {
            FileWriter writer = new FileWriter(fileName, true);
            writer.write("\n" + text);
            writer.close();
            System.out.println("File modified successfully!");
        } catch (IOException e) {
            System.out.println("Error modifying file.");
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("1. Write File");
        System.out.println("2. Read File");
        System.out.println("3. Modify File");
        System.out.print("Choose option: ");

        int choice = input.nextInt();
        input.nextLine();

        if (choice == 1) {
            System.out.print("Enter text: ");
            String text = input.nextLine();
            writeFile(text);
        } else if (choice == 2) {
            readFile();
        } else if (choice == 3) {
            System.out.print("Enter text to append: ");
            String text = input.nextLine();
            appendFile(text);
        } else {
            System.out.println("Invalid choice!");
        }

        input.close();
    }
}

