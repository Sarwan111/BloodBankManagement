import javax.swing.*;
import java.awt.ActiveEvent.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class BloodDonarList extends JFrame implements ActionListener{
	
	String path = "src/Data/";
	JButton search = new JButton("Show List");
	JButton back = new JButton("Back");
	
	String labelNames[] = new String[]{"List of Blood Donars", "Name", "Weight", "Disease", "Blood Group",  "Contact#", "Adress", "CMS"};
	JLabel labels[] = new JLabel[8];

	boolean isDataDisplayed = false;
	int totalpeople = 0;
	JLabel[][] people;


	BloodDonarList(){
		super("Blood Donars List");
		setLayout(null);
		getContentPane().setBackground(Color.BLUE);

		for(int i = 0; i < 8; i++){
			labels[i] = new JLabel(labelNames[i]);
		}

		add(labels[0]).setBounds(50, 40, 400, 50);
		add(search).setBounds(600, 50, 100, 30);
		add(back).setBounds(800, 50, 100, 30);
		//ColortoFirstLabel
		labels[0].setForeground(Color.CYAN);
		labels[0].setFont(new Font("", Font.BOLD, 40));
		for(int i = 1; i < 8; i++){
			add(labels[i]).setBounds(50 + ((i-1)*150), 100, 150, 50);
			add(labels[i]).setForeground(Color.WHITE);
		}

		search.addActionListener(this);
		back.addActionListener(this);
		
	}
	
		
	
	public static void main(String args[]){
		BloodDonarList window = new BloodDonarList();
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
		totalpeople = total.totalPeople(path + "deleted.txts", " ");
		people = new JLabel[totalpeople][7];
		System.out.println(totalpeople);
		for(int i = 0; i < totalpeople; i++){
			repaint();
			FetchData getData = new FetchData(total.getPerson(i + 1, " ", " "), total.getBloodGroup(total.getPerson(i + 1, " ", " ")));
			people[i][0] = new JLabel(getData.getName());
			people[i][1] = new JLabel(Integer.toString(getData.getWeight()));
			people[i][2] = new JLabel(getData.getDisease());
			people[i][3] = new JLabel(getData.getBloodGroup());
			people[i][4] = new JLabel(getData.getContact());
			people[i][5] = new JLabel(getData.getAddress());
			people[i][6] = new JLabel(getData.getCMS());
			
		}
		
		for(int i = 0; i < totalpeople; i++){
			for(int j = 0; j < 7; j++){
				add(people[i][j]).setBounds(50 + (j*150), 170 + (i*(30)), 150, 20);
				add(people[i][j]).setForeground(Color.WHITE);
			}
		}
		
		isDataDisplayed = true;
	}
}