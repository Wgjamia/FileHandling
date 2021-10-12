package ly.file.handling;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class FileHandling {

	// Create Main Class of File Handling

	public static void main(String args[]) throws FileNotFoundException, IOException {

			Scanner in = new Scanner(System.in);
			
			
			System.out.println("Please select one of the below operations:");
			System.out.println(" w: For write mode ");
			System.out.println(" r: for read mode ");
			System.out.println(" a: for append mode ");
			System.out.println(" q: for exit program");
			
			char operator = in.nextLine().charAt(0);
			switch (operator) {
			case 'w': // Option For Writing File
				writingToFile(operator);
				break;
			case 'r': // Option For Reading File
				FReading();
				break;
			case 'a': // Option For Append File
				writingToFile(operator);
				break;
			case 'q': // Option For Close the Program.
				System.exit(0);
				break;
			default:
				System.out.println("Sorry you try to do unexpected, better luck next time ");
				break;
			}
			in.close();
	
	}

	public static void printWelcomeScreen() {

		Scanner in = null;
		System.out.println("Please select one of the below operations:");
		System.out.println(" w: For write mode ");
		System.out.println(" r: for read mode ");
		System.out.println(" a: for append mode ");
		System.out.println(" q: for exit program");

		char operator = in.nextLine().charAt(0);
		switch (operator) {
		case 'w': // Option For Writing File
			writingToFile(operator);
			break;
		case 'r': // Option For Reading File
			FReading();
			break;
		case 'a': // Option For Append File
			writingToFile(operator);
			break;
		case 'q': // Option For Close the Program.
			System.out.close();
			break;
		default:
			System.out.println("Sorry you try to do unexpected, better luck next time ");
			break;
		}

		// in.close();

	}

	public static void writingToFile(char operator) {

		// Clear the variable for Scanner.
		Scanner inw = new Scanner(System.in);

		try {
			String source = "";
			File f = new File("Wesam.txt");
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			// For writing new Content Every Time you run
			FileWriter f0 = null;

			if (operator == 'w') {
				f0 = new FileWriter(f, false);
				System.out.println(
						" CAUTION >> Please understand it will overwrite the content of the file, Plesase (no,yes): ");
				String s1 = inw.nextLine();
				if (s1.equalsIgnoreCase("no")) {
					System.exit(0);
				}else if (s1.equalsIgnoreCase("yes")){
					System.out.println(" Write 'stop' when you finish writing file ");
					f.delete();
					f.createNewFile();
					while (!(source = bf.readLine()).equalsIgnoreCase("stop")) {
						f0.write(source + System.getProperty("line.separator"));
					}
				}else
				{
					System.out.println("Sorry you try to do unexpected!!!");
					System.exit(0);
				}
				inw.close();
			}
			// For appending the content
			else if (operator == 'a') {
				f0 = new FileWriter(f, true);
				System.out.println(" Write 'stop' when you finish appending file ");
				while (!(source = bf.readLine()).equalsIgnoreCase("stop")) {
					f0.append(source + System.getProperty("line.separator"));
				}
			}
			f0.close();
		} catch (Exception e) {
			System.out.println("Error : ");
			e.printStackTrace();
		}
	}

	public static void FReading() {
		String str = "";
		try {
			File f5 = new File("Wesam.txt");

			if (!f5.exists())
				f5.createNewFile();
			FileReader fl = new FileReader(f5);
			BufferedReader bf = new BufferedReader(fl);
			// For reading till end
			while ((str = bf.readLine()) != null) {
				System.out.println(str);
			}
			fl.close();
		} catch (Exception e) {
			System.out.println("Error : ");
			e.printStackTrace();
		}
	}
}
