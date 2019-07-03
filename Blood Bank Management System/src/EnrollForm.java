
import javax.swing.*;
import java.awt.ActiveEvent.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class EnrollForm extends JFrame implements ActionListener{
	JLabel nameLabel , bloodGroupLabel , cellNumberLabel , weightLabel, addressLabel , diseaseLabel, CMSLabel;  
	JTextField nameTextField , bloodGroupTextField , cellNumberTextField , weightTextfield , diseaseTextField , addressTextField, CMSTextField;
	JButton addRecord , back;
	String[] bloodGroups = new String[]{ "A+", "B+", "O+", "AB+", "A-", "B-", "O-", "AB-" };
	JComboBox<String> bloodGroupList;
	boolean emptyField;
	
	EnrollForm ()
	{
		super("New Entry");
		setLayout(null);
		
		getContentPane().setBackground(Color.BLUE);
		//Labels
		nameLabel = new JLabel("Full Name ");
		
		bloodGroupLabel = new  JLabel ("Blood Group");
		weightLabel = new JLabel("Weight ");
		diseaseLabel = new JLabel ("Disease (if any) ");
		cellNumberLabel = new JLabel ("Contact Number ");
		addressLabel = new JLabel("Address : ");
		CMSLabel = new JLabel("CMS : ");
		
		
		// Labels Color
		nameLabel.setForeground(Color.WHITE);
		bloodGroupLabel.setForeground(Color.WHITE);
		weightLabel.setForeground(Color.WHITE);
		diseaseLabel.setForeground(Color.WHITE);
		cellNumberLabel.setForeground(Color.WHITE);
		addressLabel.setForeground(Color.WHITE);
		CMSLabel.setForeground(Color.WHITE);
		//TextFields
		nameTextField = new JTextField();
		//nameTextField.setBackground(Color.BLUE);
		bloodGroupList = new JComboBox<>(bloodGroups);
		weightTextfield = new JTextField("");
		diseaseTextField = new JTextField("");
		cellNumberTextField = new JTextField("");
		addressTextField = new JTextField("");
		CMSTextField = new JTextField("");
		//Button
		addRecord = new JButton ("Add Record");
		back = new JButton ("Back");
		
		
		//Labels
		add(nameLabel).setBounds(40 , 40 , 150 , 30);
		add(bloodGroupLabel).setBounds(40 , 80 , 150, 30);
		add(weightLabel).setBounds(40 , 120 , 150 , 30);
		add(diseaseLabel).setBounds(40 , 160 , 150 , 30);
		add(cellNumberLabel).setBounds(40 , 200 , 150 , 30);
		add(CMSLabel).setBounds(40, 240 , 150 , 30);
		add(addressLabel).setBounds(40, 280 , 150 , 30);
		//TextFields
		add(nameTextField).setBounds(210 , 40 , 150 , 30);
		add(bloodGroupList).setBounds(210 , 80 , 150 ,30);
		add(weightTextfield).setBounds(210 , 120 , 150 , 30);
		add(diseaseTextField).setBounds(210 , 160 , 150 , 30);
		add(cellNumberTextField).setBounds(210 , 200 , 150 , 30);
		add(CMSTextField).setBounds(210 , 240 , 150, 30);
		add(addressTextField).setBounds(210 , 280 , 250 , 100);
		//Button
		add(addRecord).setBounds(100 , 400 , 100 , 30 );
		add(back).setBounds(230 , 400 , 100 , 30);
		
		addRecord.addActionListener(this);
		back.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==addRecord) {
			
			emptyField = (nameTextField.getText().isEmpty() ||
	weightTextfield.getText().isEmpty() || diseaseTextField.getText().isEmpty()
	|| cellNumberTextField.getText().isEmpty() || addressTextField.getText().isEmpty()
	|| CMSTextField.getText().isEmpty());
			
			if(emptyField) {
				JOptionPane.showMessageDialog(null, "Fill all the Text Fields");
			}else
			{
				Form writeData = new Form();
				writeData.setName(nameTextField.getText());
				writeData.setBloodGroup(bloodGroupList.getItemAt(bloodGroupList.getSelectedIndex()));
				writeData.setWeight(weightTextfield.getText());
				writeData.setDisease(diseaseTextField.getText());
				writeData.setContact(cellNumberTextField.getText());
				writeData.setAddress(addressTextField.getText());
				writeData.setCMS(CMSTextField.getText());
				writeData.submit();
				JOptionPane.showMessageDialog(null,"Data added Successfully");
				nameTextField.setText(null);
				weightTextfield.setText(null);
				diseaseTextField.setText(null);
				cellNumberTextField.setText(null);
				addressTextField.setText(null);
				CMSTextField.setText(null);
			}
		}else if(e.getSource()==back) {
				NewProject window = new NewProject();
				String[] args = {};
				window.main(args);
				dispose();
		}
	}
	
	
	public static void main (String args[])
	{
		
		EnrollForm j = new EnrollForm();
	j.setVisible(true);
	j.setExtendedState(JFrame.MAXIMIZED_BOTH);
	j.setDefaultCloseOperation(j.EXIT_ON_CLOSE);

	}

}

