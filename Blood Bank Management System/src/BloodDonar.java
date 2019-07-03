import javax.swing.*;
import java.awt.ActiveEvent.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class BloodDonar extends JFrame implements ActionListener{
	
	JLabel tag = new JLabel("Enter CMS ");
	JButton search = new JButton("Enter");
	JButton back = new JButton("Back");
	JTextField cms = new JTextField();

	BloodDonar(){
		super("Blood Donar");
		setLayout(null);
		
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
		BloodDonar window = new BloodDonar();
		window.setExtendedState(JFrame.MAXIMIZED_BOTH);
		window.setVisible(true);
		window.setDefaultCloseOperation(window.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e){
		
		if(e.getSource() == search) {
			Serial donar = new Serial();
			if(donar.getBloodGroup(cms.getText()).equals("none")) {
				JOptionPane.showMessageDialog(null,"Person not in database");
			}else{
				donar.deleteEntry(cms.getText());
				JOptionPane.showMessageDialog(null,"Person entered in donar list");
			}
			
		}else if(e.getSource() == back) {
			NewProject f1 = new NewProject();
			String[] args = {};
			f1.main(args);
			dispose();
		}
	}
}