import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class DBMSInterrogaFrame extends JFrame{

	public DBMSInterrogaFrame() {

		JPanel controlPanel = createControlPanel();

		JPanel interrogatePanel = createInterrogatePanel();

		add(controlPanel, BorderLayout.NORTH);
		add(interrogatePanel);

		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setTitle("Database Università");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public JPanel createControlPanel() {

		JRadioButton button1 = new JRadioButton("Interroga");
		JRadioButton button2 = new JRadioButton("Modifica");

		ButtonGroup group = new ButtonGroup();
		group.add(button1);
		group.add(button2);

		button1.setSelected(true);

		class RadioButtonListener implements ActionListener{
			public void actionPerformed(ActionEvent event) {
				if(button2.isSelected()) {
					setVisible(false);
					DBLoginFrame.modificaFrame.setVisible(true);
				}
			}
		}

		ActionListener listener = new RadioButtonListener();
		button1.addActionListener(listener);
		button2.addActionListener(listener);
		
		JPanel controlPanel = new JPanel();
		controlPanel.add(button1);
		controlPanel.add(button2);

		return controlPanel;
	}

	public JPanel createInterrogatePanel() {

		JComboBox box = new JComboBox();
		box.addItem(QUERY1);
		box.addItem(QUERY2);
		box.addItem(QUERY3);
		box.addItem(QUERY4);
		box.addItem(QUERY5);
		box.addItem(QUERY6);
		box.addItem(QUERY7);
		box.addItem(QUERY8);
		box.addItem(QUERY9);
		box.addItem(QUERY10);
		box.addItem(QUERY11);
		box.addItem(QUERY12);
		box.addItem(QUERY13);
		box.addItem(QUERY14);
		box.addItem(QUERY15);

		JButton button = new JButton("Cerca");
		
		textArea = new JTextArea(TEXT_AREA_ROWS, TEXT_AREA_COLUMNS);
		textArea.setEditable(false);
		scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
				
		class ExecuteQueryListener implements ActionListener{
			public void actionPerformed(ActionEvent event) {

				String query = (String) box.getSelectedItem();
				String result = "";

				if(query.equalsIgnoreCase(QUERY1)) {
					result = DBLoginFrame.db.query1();
				}
				if(query.equalsIgnoreCase(QUERY2)) {
					result = DBLoginFrame.db.query2();
				}
				if(query.equalsIgnoreCase(QUERY3)) {
					result = DBLoginFrame.db.query3();
				}
				if(query.equalsIgnoreCase(QUERY4)) {
					result = DBLoginFrame.db.query4();
				}
				if(query.equalsIgnoreCase(QUERY5)) {
					result = DBLoginFrame.db.query5();
				}
				if(query.equalsIgnoreCase(QUERY6)) {
					result = DBLoginFrame.db.query6();
				}
				if(query.equalsIgnoreCase(QUERY7)) {
					result = DBLoginFrame.db.query7();
				}
				if(query.equalsIgnoreCase(QUERY8)) {
					result = DBLoginFrame.db.query8();
				}
				if(query.equalsIgnoreCase(QUERY9)) {
					result = DBLoginFrame.db.query9();
				}
				if(query.equalsIgnoreCase(QUERY10)) {
					result = DBLoginFrame.db.query10();
				}
				if(query.equalsIgnoreCase(QUERY11)) {
					result = DBLoginFrame.db.query11();
				}
				if(query.equalsIgnoreCase(QUERY12)) {
					result = DBLoginFrame.db.query12();
				}
				if(query.equalsIgnoreCase(QUERY13)) {
					result = DBLoginFrame.db.query13();
				}
				if(query.equalsIgnoreCase(QUERY14)) {
					result = DBLoginFrame.db.query14();
				}
				if(query.equalsIgnoreCase(QUERY15)) {
					result = DBLoginFrame.db.query15();
				}

				textArea.setText(result);
			}
		}

		ActionListener listener = new ExecuteQueryListener();
		button.addActionListener(listener);

		JPanel comboBoxPanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(button);
		
		comboBoxPanel.setLayout(new BorderLayout());
		comboBoxPanel.add(box, BorderLayout.NORTH);
		comboBoxPanel.add(buttonPanel);

		JPanel interrogatePanel = new JPanel();
		interrogatePanel.setLayout(new BorderLayout());

		interrogatePanel.add(comboBoxPanel, BorderLayout.NORTH);
		interrogatePanel.add(scroll);		
		
		return interrogatePanel;
	}

	private Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	private final int FRAME_WIDTH =  (int) screen.getWidth(), FRAME_HEIGHT = (int) screen.getHeight();
	private final int TEXT_AREA_ROWS = 100, TEXT_AREA_COLUMNS = 100;
	private JTextArea textArea;
	private JScrollPane scroll;

	private final String QUERY1 = "1) Docenti del Dipartimento di Chimica e Biologia o Farmacia con uno stipendio > 1500 ordinati per cognome in modo crescente (Matricola, Nome, Cognome, Dipartimento, Stipendio)";

	private final String QUERY2 = "2) Studenti che hanno superato l'esame di Basi di Dati della facoltà di Informatica (Matricola, Cognome, Nome, Voto, Lode)";

	private final String QUERY3 = "3) Somma degli stipendi di tutti i docenti (TotaleStipendi)";

	private final String QUERY4 = "4) Somma degli stipendi per ogni dipartimento (Dipartimento, TotaleStipendi)";

	private final String QUERY5 = "5) Dipartimenti la cui somma degli stipendi dei docenti è > 10000 (Dipartimento, TotaleStipendi)";

	private final String QUERY6 = "6) Dipartimenti la cui somma degli stipendi è la più alta (Dipartimento, TotaleStipendi)";

	private final String QUERY7 = "7) Docenti che insegnano corsi nelle facoltà di Informatica e Computer Science (Matricola, Cognome, Nome, Corso, Facoltà)";

	private final String QUERY8 = "8) Studenti che hanno frequentato tutti i corsi (Matricola, Cognome, Nome, Facoltà)";

	private final String QUERY9 = "9) Lista dei Dipartimenti";

	private final String QUERY10 = "10) Lista delle Facolta";

	private final String QUERY11 = "11) Lista dei Corsi";

	private final String QUERY12 = "12) Lista dei Docenti (Matricola, Cognome, Nome, Email, Dipartimento)";

	private final String QUERY13 = "13) Lista degli Studenti (Matricola, Cognome, Nome, Immatricolazione, Email, Facoltà)";
	
	private final String QUERY14 = "14) Stipendi di tutti i docenti ordinati per cognome (Matricola, Cognome, Nome, Stipendio)";
			
	private final String QUERY15 = "15) Esami di tutti gli studenti ordinati per cognome (Matricola, Cognome, Nome, Facoltà, Corso, Data, Voto, Lode)";
	
}
