import javax.swing.*;
import java.awt.ActiveEvent.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class DisplayData extends JFrame implements ActionListener{
	
	String[] bloodGroups = new String[]{ "A+", "B+", "O+", "AB+", "A-", "B-", "O-", "AB-" };
	JComboBox<String> bloodGroupList = new JComboBox<>(bloodGroups);
	JButton search = new JButton("Search");
	JButton back = new JButton("Back");
	
	String labelNames[] = new String[]{"Select Blood Group ", "Name", "Weight", "Disease", "Blood Group",  "Contact#", "Adress", "CMS"};
	JLabel labels[] = new JLabel[8];

	boolean isDataDisplayed = false;
	int totalpeople = 0;
	JLabel[][] people;


	DisplayData(){
		super("Information");
		setLayout(null);
		getContentPane().setBackground(Color.BLUE);

		for(int i = 0; i < 8; i++){
			labels[i] = new JLabel(labelNames[i]);
		}

		add(labels[0]).setBounds(50, 50, 125, 20);
		add(bloodGroupList).setBounds(190, 50, 100, 30);
		add(search).setBounds(300, 50, 100, 30);
		add(back).setBounds(800, 50, 100, 30);
		//ColortoFirstLabel
		labels[0].setForeground(Color.WHITE);
		for(int i = 1; i < 8; i++){
			add(labels[i]).setBounds(50 + ((i-1)*150), 100, 150, 50);
			add(labels[i]).setForeground(Color.WHITE);
		}

		search.addActionListener(this);
		back.addActionListener(this);
		
	}
	
		
	
	public static void main(String args[]){
		DisplayData window = new DisplayData();
		window.setExtendedState(JFrame.MAXIMIZED_BOTH);
		window.setVisible(true);
		window.setDefaultCloseOperation(window.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e){
		
		if(e.getSource() == back){
			NewProject f1 = new NewProject();
			String[] args = {};
			f1.main(args);
			dispose();
		}

		//Coloring to remove previous data
		if(isDataDisplayed){
			for(int i = 0; i < totalpeople; i++){
				for(int j = 0; j < 7; j++){
					people[i][j].setVisible(false);
				}
			}
		}
		
		getContentPane().setBackground(Color.BLUE);
		Serial total = new Serial();
		String bloodGroup = bloodGroupList.getItemAt(bloodGroupList.getSelectedIndex());
		totalpeople = total.totalPeople(bloodGroup);
		people = new JLabel[totalpeople][7];
		
		

		for(int i = 0; i < totalpeople; i++){
			repaint();
			FetchData getData = new FetchData(total.getPerson(i + 1, bloodGroup), bloodGroup);
			people[i][0] = new JLabel(getData.getName());
			people[i][1] = new JLabel(Integer.toString(getData.getWeight()));
			people[i][2] = new JLabel(getData.getDisease());
			people[i][3] = new JLabel(getData.getBloodGroup());
			people[i][4] = new JLabel(getData.getContact());
			people[i][5] = new JLabel(getData.getAddress());
			people[i][6] = new JLabel(getData.getCMS());
			
		}
		
		int keep = 0;
		
		for(int i = 0; i < totalpeople; i++){
			if(total.notDeleted(people[i][6].getText())) {
				for(int j = 0; j < 7; j++){
					add(people[i][j]).setBounds(50 + (j*150), 170 + ((i+keep)*(30)), 150, 20);
					add(people[i][j]).setForeground(Color.WHITE);
				}
			}else {
				keep--;
			}
		}
		
		isDataDisplayed = true;
	}
}