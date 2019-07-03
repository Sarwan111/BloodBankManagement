import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;


public class NewProject extends JFrame implements ActionListener{
	JButton b1,b2,b3,b4,b5;
	JButton logout = new JButton("Log Out");
	JLabel bl1,bl2,bl3,bl4,bl5, p1;
	JTextField b1t,b2t,b3t,b4t,b5t;
	ImageIcon img,b1img,b2img,b3img,b4img,b5img;
	Container c;
	private String path = "src\\Data/";
	NewProject(){
		super("Main Manu");
		setLayout(null);
		
		add(logout).setBounds(1000, 40, 100, 30);
		c=this.getContentPane();
		
		
		img=new ImageIcon(path + "B1.jpg");
		p1=new JLabel(img);
		p1.setSize(img.getIconWidth(), img.getIconHeight());
		p1.setLocation(650, 130);
		c.add(p1);
		bl1=new JLabel("New Entry");
		bl1.setBounds(570, 140, 60, 30);
		add(bl1);
		b1img=new ImageIcon(path + "add user.png");
		b1=new JButton(b1img);
		b1.setSize(b1img.getIconWidth(),b1img.getIconHeight());
		b1.setLocation(500, 130);
	//b1.setBackground(Color.white);
		add(b1);
		bl2=new JLabel("Search");
		bl2.setBounds(570, 230, 60, 30);
		add(bl2);
		b2img=new ImageIcon(path + "search.png");
		b2=new JButton(b2img);
		b2.setSize(b2img.getIconWidth(),b2img.getIconHeight());
		b2.setLocation(500,220);
		//b2.setBackground(Color.white);
		add(b2);
		bl3=new JLabel("List Data");
		bl3.setBounds(570, 320, 90, 30);
		add(bl3);
		b3img=new ImageIcon(path + "list.png");
		b3=new JButton(b3img);
		b3.setSize(b3img.getIconWidth(),b3img.getIconHeight());
		b3.setLocation(500,310);
		//b4.setBackground(Color.white);
		add(b3);
		bl4=new JLabel("Enter Donar");
		bl4.setBounds(570, 410, 70, 30);
		add(bl4);
		b4img=new ImageIcon(path + "blooddonar.jpg");
		b4=new JButton(b4img);
		b4.setSize(b4img.getIconWidth(),b4img.getIconHeight());
		b4.setLocation(500,400);
		//b5.setBackground(Color.white);
		add(b4);

		bl5=new JLabel("Donar List");
		bl5.setBounds(570, 490, 60, 30);
		add(bl5);
		b5img=new ImageIcon(path + "blooddonars.jpg");
		b5=new JButton(b5img);
		b5.setSize(b5img.getIconWidth(),b5img.getIconHeight());
		b5.setLocation(500,490);
		//b5.setBackground(Color.white);
		add(b5);

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		logout.addActionListener(this);
		 getContentPane().setBackground(Color.gray);
				 
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1) {
			EnrollForm obj = new EnrollForm();
			String[] args = {};
			obj.main(args);
			dispose();
		}
		else if(e.getSource()==b2) {
			SearchPerson sp= new SearchPerson();
			String[] args = {};
			sp.main(args);
			dispose();
			
		}
		else if(e.getSource()==b3) {
			DisplayData display=new DisplayData();
			String[] args = {};
			display.main(args);
			dispose();
		}else if(e.getSource() == logout) {
			Login d = new Login();
			String[] args = {};
			d.main(args);
			dispose();
 		}else if(e.getSource() == b5) {
 			BloodDonarList w = new BloodDonarList();
 			String[] args = {};
			w.main(args);
			dispose();
 		}else if(e.getSource() == b4) {
 			BloodDonar w = new BloodDonar();
 			String[] args = {};
			w.main(args);
			dispose();
 		}
	}
	

public static void main(String[] args) {
	NewProject np=new NewProject();	
	np.setVisible(true);
	np.setDefaultCloseOperation(np.EXIT_ON_CLOSE);
	np.setExtendedState(JFrame.MAXIMIZED_BOTH);
}
}