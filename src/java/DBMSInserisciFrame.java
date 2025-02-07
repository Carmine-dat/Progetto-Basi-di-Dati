import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class DBMSInserisciFrame extends JFrame {

	public DBMSInserisciFrame() {

		JPanel controlPanel = createControlPanel();

		JPanel modificaPanel = createModificaPanel();

		JPanel controlModificaPanel = new JPanel();
		controlModificaPanel.setLayout(new BorderLayout());

		controlModificaPanel.add(controlPanel, BorderLayout.NORTH);
		controlModificaPanel.add(modificaPanel, BorderLayout.CENTER);

		JPanel inserisciPanel = createInserisciPanel();

		add(controlModificaPanel, BorderLayout.NORTH);
		add(inserisciPanel, BorderLayout.CENTER);

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

		button2.setSelected(true);

		class RadioButtonListener implements ActionListener{
			public void actionPerformed(ActionEvent event) {
				if(button1.isSelected()) {
					setVisible(false);
					DBLoginFrame.interrogaFrame.setVisible(true);
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

	public JPanel createModificaPanel() {

		JComboBox combo = new JComboBox();
		combo.addItem("Aggiorna");
		combo.addItem("Inserisci");
		combo.addItem("Elimina");

		JButton button = new JButton("Vai");

		class ComboListener implements ActionListener{
			public void actionPerformed(ActionEvent event) {

				String modifica = (String) combo.getSelectedItem();

				if(modifica.equalsIgnoreCase("Aggiorna")) {
					setVisible(false);
					DBMSModificaFrame.aggiornaFrame.setVisible(true);
				}
				if(modifica.equalsIgnoreCase("Inserisci")) {
					setVisible(false);
					DBMSModificaFrame.inserisciFrame.setVisible(true);
				}
				if(modifica.equalsIgnoreCase("Elimina")) {
					setVisible(false);
					DBMSModificaFrame.eliminaFrame.setVisible(true);
				}
			}
		}

		ActionListener listener = new ComboListener();
		button.addActionListener(listener);

		JPanel modificaPanel = new JPanel();
		modificaPanel.add(combo);
		modificaPanel.add(button);

		return modificaPanel;
	}

	public JPanel createInserisciPanel() {

		JLabel functionLabel = new JLabel("Resistrazione esame di uno studente");
		JLabel matricolaLabel = new JLabel("* Matricola studente");
		JTextField matricolaTextField = new JTextField(LENGHT_TEXT_FIELD);
		JLabel codiceLabel = new JLabel("* Codice Corso");
		JTextField codiceTextField = new JTextField(LENGHT_TEXT_FIELD);
		JLabel dataLabel = new JLabel("* Data (AAAA/MM/GG)");
		JTextField dataTextField = new JTextField(LENGHT_TEXT_FIELD);
		JLabel votoLabel = new JLabel("*Voto");
		JTextField votoTextField = new JTextField(LENGHT_TEXT_FIELD);
		JLabel lodeLabel = new JLabel("Lode (Si/No)(Voto = 30)");
		JTextField lodeTextField = new JTextField(LENGHT_TEXT_FIELD);

		JPanel panel1 = new JPanel();
		panel1.add(functionLabel);


		JPanel panel2 = new JPanel();
		panel2.add(codiceLabel);
		panel2.add(codiceTextField);


		JPanel panel3 = new JPanel();
		panel3.add(matricolaLabel);
		panel3.add(matricolaTextField);

		JPanel panel4 = new JPanel();
		panel4.add(dataLabel);
		panel4.add(dataTextField);

		JPanel panel5 = new JPanel();
		panel5.add(votoLabel);
		panel5.add(votoTextField);

		JPanel panel6 = new JPanel();
		panel6.add(lodeLabel);
		panel6.add(lodeTextField);


		JPanel insertPanel = new JPanel();
		insertPanel.setLayout(new GridLayout(6, 1));

		insertPanel.add(panel1);
		insertPanel.add(panel2);
		insertPanel.add(panel3);
		insertPanel.add(panel4);
		insertPanel.add(panel5);
		insertPanel.add(panel6);

		JButton button = new JButton("Registra esame");

		class InserisciListener implements ActionListener{
			public void actionPerformed(ActionEvent event) {

				boolean esito = false;
				String codiceCorso = "";
				String matricolaStudente = "";
				String data = "";
				int voto = 0;
				String lode = "No";


				if(!codiceTextField.getText().isEmpty() && !matricolaTextField.getText().isEmpty() && 
						!dataTextField.getText().isEmpty() && !votoTextField.getText().isEmpty()) {
					codiceCorso = codiceTextField.getText();
					matricolaStudente = matricolaTextField.getText();
					data = dataTextField.getText();
					voto = Integer.parseInt(votoTextField.getText());


					if(voto < 18 || voto > 30)
						throw new VotoErratoException();

					if(!lodeTextField.getText().isEmpty()) {
						if(voto == 30) {
							if(lode.equalsIgnoreCase("si") || lode.equalsIgnoreCase("no"))
								lode = lodeTextField.getText();
							else throw new LodeNonValidaException();
						}
						else
							throw new LodeNonValidaException();
					}
				}
				else
					throw new InserimentoIncompletoException();

				esito = DBLoginFrame.db.insert(codiceCorso, matricolaStudente, data, voto, lode);

				if(esito)
					JOptionPane.showMessageDialog(insertPanel, "Esame registrato con successo!");
				else
					JOptionPane.showMessageDialog(insertPanel, "Errore. Esame non registrato");
			}
		}

		ActionListener listener = new InserisciListener();
		button.addActionListener(listener);

		JPanel buttonPanel = new JPanel();
		buttonPanel.add(button);

		JPanel inserisciPanel = new JPanel();
		inserisciPanel.setLayout(new BorderLayout());

		inserisciPanel.add(insertPanel, BorderLayout.NORTH);
		inserisciPanel.add(buttonPanel, BorderLayout.CENTER);

		return inserisciPanel;
	}

	private Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	private final int FRAME_WIDTH =  (int) screen.getWidth(), FRAME_HEIGHT = (int) screen.getHeight();
	private final int LENGHT_TEXT_FIELD = 10;

}
