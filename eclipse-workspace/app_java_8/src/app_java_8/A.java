//Prog to take input from user and save it to a text file.
package app_java_8;
import java.io.FileWriter;
import java.util.Scanner;

public class A {
	public static void main(String[] args) {
		try {
			Scanner scan = new Scanner(System.in);
			System.out.print("Enter your text: ");
			String userText = scan.nextLine();
		
			FileWriter fw = new FileWriter("H:\\JAVA_PSA\\eclipse-workspace\\app_java_8\\src\\app_java_8\\log.txt");
			fw.write(userText);
			fw.close();
			scan.close();			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
