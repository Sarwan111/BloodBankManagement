import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener{
	JLabel l,l1,l2,l3,bl1,bl2,nl1,nl2;
	JLabel sl1,sl2,sl3,sl4;
	JButton b1,b2;
	JTextField t1,st1,st2,st3;
	Color cl;
	ImageIcon i1,i2,i3;
	JPanel jp1,jp2;
	JPasswordField p1,p2;
	Container c;
	Connection con;
	Statement s;
	ResultSet rs;
	private String path = "src\\Data/";
	Login(){
		super("Login Screen");
		setLayout(null);
		c=this.getContentPane();
		
		cl=new Color(255,255,255,80);
		
		i3=new ImageIcon(path + "first aid.png");
		nl2=new JLabel(i3);
		nl2.setSize(i3.getIconWidth(),i3.getIconHeight());
		nl2.setLocation(400,100);
		
		
		jp1=new JPanel();
		jp1.setSize(500,200);
		jp1.setLocation(405,120);
		jp1.setLayout(null);
		jp1.setBackground(cl);
		
		jp2=new JPanel();
		jp2.setSize(500,250);
		jp2.setLocation(405,340);
		jp2.setLayout(null);
		jp2.setBackground(cl);
		
		
		l=new JLabel("WELCOME TO BLOOD BANK");
		l.setBounds(80,20,500,20);
		l.setForeground(Color.red);
		Font f=new Font("ALGERIAN",Font.BOLD,25);
		l.setFont(f);
		//add(l);
		jp1.add(l);
		
		
		l1=new JLabel("username");
		l1.setBounds(450,200,70,30);
		Font f1=new Font("Serif",Font.BOLD,15);
		l1.setFont(f1);
		add(l1);
				
		t1=new JTextField();
		t1.setBounds(570,205,150,20);
		add(t1);
		
		l2=new JLabel("Password");
		l2.setBounds(450,235,70,30);
		Font f2=new Font("Serif",Font.BOLD,15);
		l2.setFont(f2);
		add(l2);
		
		p1=new JPasswordField();
		p1.setBounds(570,240,150,20);
		add(p1);
		
		b1=new JButton("log in");
		b1.setBounds(570,270,150,20);
		add(b1);
		
		/*nl1=new JLabel("Sign Up");
		nl1.setBounds(100,250,70,20);
		nl1.setForeground(Color.blue);
		Font f6=new Font("ALGERIAN",Font.BOLD,20);
		nl1.setFont(f6);
		jp2.add(nl1);
		*/
		sl1=new JLabel("First Name");
		sl1.setBounds(430,360,70,30);
		add(sl1);
		
		st3=new JTextField();
		st3.setBounds(500,365,130,20);
		add(st3);

		sl2=new JLabel("Last Name");
		sl2.setBounds(660,360,70,30);
		add(sl2);
		
		st2=new JTextField();
		st2.setBounds(730,365,130,20);
		add(st2);
		
		sl3=new JLabel("New ID");
		sl3.setBounds(430,390,70,30);
		add(sl3);
		
		st1=new JTextField();
		st1.setBounds(500,395,130,20);
		add(st1);
		
		sl4=new JLabel("Password");
		sl4.setBounds(660,390,70,30);
		add(sl4);
		
		p2=new JPasswordField();
		p2.setBounds(730,395,130,20);
		add(p2);

		b2=new JButton("Sign up");
		b2.setBounds(560,450,150,20);
		add(b2);
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		c.add(jp1);
		c.add(jp2);
		c.add(nl2);
		//c.add(nl1);
	}
	
	public static void main(String[] args) {
		Login lg=new Login();
		lg.setVisible(true);
		lg.setExtendedState(JFrame.MAXIMIZED_BOTH);
		lg.setDefaultCloseOperation(lg.EXIT_ON_CLOSE);
	}
	
		public void actionPerformed(ActionEvent e) {
			
			Account account = new Account();
			
			if(e.getSource() == b1) {
				String givenPass = new String(p1.getPassword());
				String orginalPass = account.login(t1.getText());
				System.out.println(givenPass + " " + orginalPass);
				if(givenPass.equals(orginalPass)) {
					NewProject open = new NewProject();
					String[] args = {};
					open.main(args);
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "Incorrect login details");
				}
				
			}else if(e.getSource() == b2) {
				if(st1.getText().isEmpty() || st2.getText().isEmpty() || st3.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Fill all the Text Fields");
				}else {
					if(p2.getPassword().length == 0) {
						JOptionPane.showMessageDialog(null, "Fill all the Text Fields");
					}else {
						String one = new String(p2.getPassword());
						if(account.CreateAccount(st1.getText(), one)) {
							JOptionPane.showMessageDialog(null, "Account created successfully");
						}else {
							JOptionPane.showMessageDialog(null, "Account already exixt with same username.");
						}
						
					}
				}
			}
			
		}
	
}
