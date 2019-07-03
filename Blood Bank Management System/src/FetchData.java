import java.util.Scanner;
import java.io.IOException;
import java.io.File;

public class FetchData{
	private String name;
	private String bloodGroup;
	private String weight;
	private String disease;
	private String contact;
	private String address;
	private int recordNumber;
	private String CMS;
	private String path = "src\\Data/";

	FetchData(String CMS, String bloodGroup){
		this.CMS = CMS;
		
		try{
			File file = new File(path + bloodGroup + "/" + CMS + ".txt");
			Scanner scan = new Scanner(file);

			name = scan.nextLine();
			this.bloodGroup = scan.nextLine();
			weight = scan.nextLine();
			disease = scan.nextLine();
			contact = scan.nextLine();
			address = scan.nextLine();
		}

		catch(Exception ea){

		}
	}

	public String getName(){
		return name;
	}
	
	public String getBloodGroup(){
		return bloodGroup;
	}

	public int getWeight(){
		int integerWeight = Integer.parseInt(weight);
		return integerWeight;
	}

	public String getDisease(){
		return disease;
	}

	public String getContact(){
		return contact;
	}

	public String getAddress(){
		return address;
	}

	public String getCMS(){
		return CMS;
	}
	
}