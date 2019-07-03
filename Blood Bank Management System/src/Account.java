import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;

public class Account{
	
	private String path = "src\\Data\\Login/";
	
	private boolean CheckAccount(String username){
		try{
			File file = new File(path + username + ".txt");
			if(file.exists()) {
				return true;
			}
		}

		catch(Exception ea){

		}
		return false;
	}

	public boolean CreateAccount(String username, String password) {
		try{
				if(CheckAccount(username)){
					return false;
				}
					
				PrintWriter file = new PrintWriter(path + username + ".txt");
				file.println(password);
				file.close();
				
		}

		catch(Exception ea){
		}
		return true;
	}

	public String login(String username){
		String password;
		try{
			File file = new File(path + username + ".txt");
			Scanner scan = new Scanner(file);
			password = scan.nextLine();
			scan.close();
		}

		catch(Exception ea){
			return "";
		}
		
		return password;
		
	}

}