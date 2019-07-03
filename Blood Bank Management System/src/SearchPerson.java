import javax.swing.*;
import java.awt.ActiveEvent.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class SearchPerson extends JFrame implements ActionListener{
	
	JLabel tag = new JLabel("Enter CMS ");
	JButton search = new JButton("Search");
	JButton back = new JButton("Back");
	JTextField cms = new JTextField();

	JLabel[] data = new JLabel[4];
	JLabel[] tags = new JLabel[4];
	JLabel notfound;
	String[] tagsName = new String[]{"Name", "BloodGroup", "Weight", "Disease"};
			
	boolean isDisplayed = false;
	boolean isNotFoundDisplayed = false;

	SearchPerson(){
		super("Individual Data");
		setLayout(null);
		
		for(int i = 0; i < 4; i++) {
			tags[i] = new JLabel(tagsName[i]);
		}
		
		for(int i = 0; i < 4; i++) {
			add(tags[i]).setBounds(500, 200 + (i*40), 200, 20);
			tags[i].setForeground(Color.WHITE);	
		}
		
		getContentPane().setBackground(Color.BLUE);
		add(tag).setBounds(430, 130, 120 ,  35);
		add(cms).setBounds(550, 130, 150, 35);
		add(search).setBounds(720, 130, 100, 35);
		add(back).setBounds(850,130,100,35);
		//FontColors
		tag.setForeground(Color.WHITE);	
		back.addActionListener(this);
		search.addActionListener(this);
	}

	public static void main(String args[]){
		SearchPerson window = new SearchPerson();
		window.setExtendedState(JFrame.MAXIMIZED_BOTH);
		window.setVisible(true);
		window.setDefaultCloseOperation(window.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e){
		if(e.getSource()==back)
		{
			NewProject window = new NewProject();
			String[] args = {};
			window.main(args);
			dispose();

		}else if(e.getSource() == search){
		Serial bloodgroup = new Serial();
		String bloodGroup = bloodgroup.getBloodGroup(cms.getText());
		
		if(isDisplayed){
			for(int i = 0; i < 4; i++){
				data[i].setVisible(false);
			}
		}else if(isNotFoundDisplayed){
			notfound.setVisible(false);
		}

		if(bloodGroup != "none"){
			FetchData fetchData = new FetchData(cms.getText(), bloodGroup);
			data[0] = new JLabel(fetchData.getName());
			data[1] = new JLabel(fetchData.getBloodGroup());
			data[2] = new JLabel(Integer.toString(fetchData.getWeight()));
			data[3] = new JLabel(fetchData.getDisease());
		
			for(int i = 0; i < 4; i++){
				add(data[i]).setBounds(600, 200 + (i*40), 200, 20);
				Font f=new Font("Serif", Font.BOLD,15);
				data[i].setFont(f);
				data[i].setForeground(Color.white);
			}

			isDisplayed = true;
			isNotFoundDisplayed = false;
		}else{
			
			JOptionPane.showMessageDialog(null," No User Founded ");
			isNotFoundDisplayed = true;
			isDisplayed = false;
		}
	}
		
	}
}