import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DBLoginFrame extends JFrame{

	public DBLoginFrame() {
		
		createInterrogateFrame();
		createUpdateFrame();
		
		JPanel inputPanel = createInputPanel();
		
		JPanel buttonPanel = createButtonPanel();
		
		add(inputPanel, BorderLayout.NORTH);
		add(buttonPanel);
		
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setTitle("Database Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	
	public JPanel createInputPanel() {
		
		db_urlLabel = new JLabel("URL Database");
		db_urlTextField = new JTextField(LENGHT_TEXT_FIELD);
		usernameLabel = new JLabel("Username");
		usernameTextField = new JTextField(LENGHT_TEXT_FIELD);
		passwordLabel = new JLabel("Password");
		passwordTextField = new JTextField(LENGHT_TEXT_FIELD);
		
		
		JPanel panel1 = new JPanel();
		panel1.add(db_urlLabel);
		panel1.add(db_urlTextField);
		
		JPanel panel2 = new JPanel();
		panel2.add(usernameLabel);
		panel2.add(usernameTextField);
		
		JPanel panel3 = new JPanel();
		panel3.add(passwordLabel);
		panel3.add(passwordTextField);
		
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new GridLayout(3, 1));
		
		inputPanel.add(panel1);
		inputPanel.add(panel2);
		inputPanel.add(panel3);
		
		return inputPanel;
	}
	
	public JPanel createButtonPanel() {

		JButton button = new JButton("Connetti");

		class ButtonConnettiListener implements ActionListener{
			public void actionPerformed(ActionEvent event) {
				if(!db_urlTextField.getText().isEmpty() && !usernameTextField.getText().isEmpty() &&
						!passwordTextField.getText().isEmpty()) {
					String db_url = db_urlTextField.getText();
					String username = usernameTextField.getText();
					String password = passwordTextField.getText();

					db = new Database(db_url, username, password);

					if(db.isConnected()) {
						setVisible(false);
						interrogaFrame.setVisible(true);
					}
					else throw new LoginErratoException();
				}
				else throw new InserimentoIncompletoException();
			}
		}

		ActionListener listener = new ButtonConnettiListener();
		button.addActionListener(listener);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(button);
		
		return buttonPanel;
	}
	
	public void createInterrogateFrame() {
		interrogaFrame = new DBMSInterrogaFrame();
		interrogaFrame.setVisible(false);
	}
	
	public void createUpdateFrame() {
		modificaFrame = new DBMSModificaFrame();
		modificaFrame.setLocationRelativeTo(null);
		modificaFrame.setVisible(false);
	}
	
	public static void main(String[] args) {
		JFrame frame = new DBLoginFrame();
	}


	private final int FRAME_WIDTH = 500, FRAME_HEIGHT = 300;
	private final int LENGHT_TEXT_FIELD = 25;
	private JLabel db_urlLabel, usernameLabel, passwordLabel;
	private JTextField db_urlTextField, usernameTextField, passwordTextField;
	public static Database db;
	private String db_url = "jdbc:mysql://localhost:3306/Universita";
	public static JFrame interrogaFrame;
	public static JFrame modificaFrame;
}
