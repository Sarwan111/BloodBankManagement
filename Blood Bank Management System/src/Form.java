import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;

public class Form{
	private String name;
	private String bloodGroup;
	private String weight;
	private String disease;
	private String contact;
	private String address;
	private int recordNumber;
	private String CMS;
	private String path = "src\\Data/";

	public void setName(String name){
		this.name = name;
	}
	
	public void setBloodGroup(String bloodGroup){
		this.bloodGroup = bloodGroup;
	}

	public void setWeight(String weight){
		this.weight = weight;
	}

	public void setDisease(String disease){
		this.disease = disease;
	}

	public void setContact(String contact){
		this.contact = contact;
	}

	public void setAddress(String address){
		this.address = address;
	}

	public void setCMS(String CMS){
		this.CMS = CMS;
	}

	public void submit(){
		Serial record = new Serial();

		try{	
			recordNumber = record.addRecord(bloodGroup, CMS);
			PrintWriter write = new PrintWriter(path + bloodGroup + "/" + CMS + ".txt");
			write.println(name);
			write.println(bloodGroup);
			write.println(weight);
			write.println(disease);
			write.println(contact);
			write.println(address);
			write.println(CMS);
			write.close();
		}
		
		catch(Exception ex){
			
		}
		
		
	}
}