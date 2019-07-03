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

	JLabel[] data = new JLabel[7];
	JLabel notfound;

	boolean isDisplayed = false;
	boolean isNotFoundDisplayed = false;

	SearchPerson(){
		super("Individual Data");
		setLayout(null);
		getContentPane().setBackground(Color.BLUE);
		add(tag).setBounds(30, 30, 120 ,  35);
		add(cms).setBounds(150, 30, 150, 35);
		add(search).setBounds(320, 30, 100, 35);
		add(back).setBounds(450,30,100,35);
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
			for(int i = 0; i < 7; i++){
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
			data[4] = new JLabel(fetchData.getContact());
			data[5] = new JLabel(fetchData.getCMS());
			data[6] = new JLabel(fetchData.getAddress());
		
			for(int i = 0; i < 7; i++){
				add(data[i]).setBounds(100, 100 + (i*20), 200, 20);
				Font f=new Font("Serif", Font.BOLD,15);
				data[i].setFont(f);
				data[i].setForeground(Color.white);
			}

			isDisplayed = true;
			isNotFoundDisplayed = false;
		}else{
			
			JOptionPane.showMessageDialog(null," No User Founded ");
			
			//notfound = new JLabel("Data not found!");
			//add(notfound).setBounds(50, 150, 200, 30);
			//Font f=new Font("Serif", Font.BOLD,15);
			//notfound.setFont(f);
			//notfound.setForeground(Color.white);
			isNotFoundDisplayed = true;
			isDisplayed = false;
		}
	}
		
	}
}