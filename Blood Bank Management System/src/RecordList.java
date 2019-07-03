import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class RecordList{

	private int records;

	private void checkRecords(){
		try{
			File open = new File("Data/listPersons.txt");
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

	private void listRecord(){
		FileWriter fw = null;
		BufferedWriter bw = null;

		try {
			File file = new File("Data/listPersons.txt");

			if (!file.exists()) {
				file.createNewFile();
			}else{
				bw.newLine();
			}

			// true = append file
			fw = new FileWriter(file.getAbsoluteFile(), true);
			bw = new BufferedWriter(fw);
			
			bw.write(records);

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

	public int addRecord(){
		
		checkRecords();
		records++;		
		listRecord();		

		try{
			PrintWriter write = new PrintWriter("Data/RecordList.txt");
			write.println(records);
			write.close();
		}
		
		catch(Exception ea){
			
		}

		return records;
	}


}