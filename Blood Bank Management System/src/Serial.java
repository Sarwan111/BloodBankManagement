import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class Serial{

	private int records;
	private String path = "src\\Data/";
	
	private void checkRecords(){
		try{
			File open = new File(path + "totalPeople.txt");
			Scanner scan = new Scanner(open);
			
			while(scan.hasNextLine()){
				records = Integer.parseInt(scan.nextLine());
			}

			scan.close();
		}
		
		catch(Exception ea){
			records = 0;
		}
	}

	private void listRecord(String bloodGroup, String CMS){

		FileWriter fw = null;
		BufferedWriter bw = null;		

		try {
			File file = new File(path + bloodGroup + "/listPersons.txt");

			if (!file.exists()) {
				file.createNewFile();
				fw = new FileWriter(file.getAbsoluteFile(), true);
				bw = new BufferedWriter(fw);
				bw.write(CMS);
			}else{
				fw = new FileWriter(file.getAbsoluteFile(), true);
				bw = new BufferedWriter(fw);
				bw.newLine();
				bw.write(CMS);
			}

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}
		}
	}

	public int addRecord(String bloodGroup, String CMS){
		
		checkRecords();
		records++;		
		listRecord(bloodGroup, CMS);		

		try{
			PrintWriter write = new PrintWriter(path + "totalPeople.txt");
			write.println(records);
			write.close();
		}
		
		catch(Exception ea){
			
		}

		return records;
	}

	public int totalPeople(String bloodGroup){
		int total = 0;
		String read;
		
		try{
			File open = new File(path + bloodGroup + "/listPersons.txt");
			Scanner scan = new Scanner(open);
			
			while(scan.hasNextLine()){
				read = scan.nextLine();
				total++;
			}

			scan.close();
		}
		
		catch(Exception ea){
			return 0;
		}

		return total;
		
	}
	
	public int totalPeople(String bloodGroup, String path){
		int total = 0;
		String read;
		
		try{
			File open = new File(this.path + "/deleted.txt");
			Scanner scan = new Scanner(open);
			
			while(scan.hasNextLine()){
				read = scan.nextLine();
				total++;
			}

			scan.close();
		}
		
		catch(Exception ea){
			return 0;
		}

		return total;
		
	}

	public String getPerson(int readWhile, String bloodGroup){
		
		String personNumber = " ";

		try{
			File open = new File(path + bloodGroup + "/listPersons.txt");
			Scanner scan = new Scanner(open);
			
			for(int i = 0; i < readWhile; i++){
				personNumber = scan.nextLine();
			}

			scan.close();
		}
		
		catch(Exception ea){
			return personNumber;
		}

		return personNumber;
	}

public String getPerson(int readWhile, String bloodGroup, String cash){
		
		String personNumber = " ";

		try{
			File open = new File(path + "deleted.txt");
			Scanner scan = new Scanner(open);
			
			for(int i = 0; i < readWhile; i++){
				personNumber = scan.nextLine();
			}

			scan.close();
		}
		
		catch(Exception ea){
			return personNumber;
		}

		return personNumber;
	}
	
	private boolean bloodGroup(String CMS, String bloodGroup){
		

		File file;

		try{
			file = new File(path + bloodGroup + "/" + CMS + ".txt");
		}
		
		catch(Exception ea){
			return false;
		}

		return file.exists();
	}

	public String getBloodGroup(String CMS){
		String bloodGroups[] = new String[]{"A+", "B+", "O+", "AB+", "A-", "B-", "O-", "AB-"};

		for(int i = 0; i < 8; i++){
			if(bloodGroup(CMS, bloodGroups[i])){
				return bloodGroups[i];
			}
		}

		return "none";
	}
	
	public boolean notDeleted(String CMS){
		try {
			File file = new File(path + "deleted.txt");
			Scanner scan = new Scanner(file);
			while(scan.hasNextLine()) {
				if(scan.nextLine().equals(CMS)) {
					return false;
				}
			}
		}
		
		catch(Exception ea) {
			
		}
		return true;
	}
	
	public void deleteEntry(String CMS) {
		FileWriter fw = null;
		BufferedWriter bw = null;		

		try {
			File file = new File(path + "deleted.txt");

			fw = new FileWriter(file.getAbsoluteFile(), true);
			bw = new BufferedWriter(fw);
			bw.write(CMS);
			bw.newLine();

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}
		}
	}
}