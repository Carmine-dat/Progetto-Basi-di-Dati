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

public class DBMSAggiornaFrame extends JFrame {

	public DBMSAggiornaFrame() {
		
		JPanel controlPanel = createControlPanel();
		
		JPanel modificaPanel = createModificaPanel();
		
		JPanel controlModificaPanel = new JPanel();
		controlModificaPanel.setLayout(new BorderLayout());
		
		controlModificaPanel.add(controlPanel, BorderLayout.NORTH);
		controlModificaPanel.add(modificaPanel, BorderLayout.CENTER);
		
		JPanel aggiornaPanel = createAggiornaPanel();
		
		add(controlModificaPanel, BorderLayout.NORTH);
		add(aggiornaPanel, BorderLayout.CENTER);
		
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
	
	public JPanel createAggiornaPanel() {
		
		JLabel functionLabel = new JLabel("Aggiorna lo stipendio di un docente");
		JLabel matricolaLabel = new JLabel("* Matricola docente");
		JTextField matricolaTextField = new JTextField(LENGHT_TEXT_FIELD);
		JLabel stipendioLabel = new JLabel("* Stipendio");
		JTextField stipendioTextField = new JTextField(LENGHT_TEXT_FIELD);
		
		JPanel panel1 = new JPanel();
		panel1.add(functionLabel);
		
		JPanel panel2 = new JPanel();
		panel2.add(matricolaLabel);
		panel2.add(matricolaTextField);
		
		JPanel panel3 = new JPanel();
		panel3.add(stipendioLabel);
		panel3.add(stipendioTextField);
		
		
		JPanel insertPanel = new JPanel();
		insertPanel.setLayout(new GridLayout(3, 1));
		
		insertPanel.add(panel1);
		insertPanel.add(panel2);
		insertPanel.add(panel3);
		
		JButton button = new JButton("Aggiorna");
		
		class AggiornaListener implements ActionListener{
			public void actionPerformed(ActionEvent event) {
				if(!matricolaTextField.getText().isEmpty() && !stipendioTextField.getText().isEmpty()) {
					
					String matricola = matricolaTextField.getText();
					float stipendio = Float.parseFloat(stipendioTextField.getText());
					
					if(stipendio < 0)
						throw new StipendioNegativoException();
					
					boolean esito = DBLoginFrame.db.update(stipendio, matricola);
					
					if(esito)
						JOptionPane.showMessageDialog(insertPanel, "Stipendio aggiornato con successo!");
					else
						JOptionPane.showMessageDialog(insertPanel, "Errore. Stipendio non aggiornato");
				}
				else throw new InserimentoIncompletoException();
			}
		}
		
		ActionListener listener = new AggiornaListener();
		button.addActionListener(listener);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(button);
		
		JPanel aggiornaPanel = new JPanel();
		aggiornaPanel.setLayout(new BorderLayout());
		
		aggiornaPanel.add(insertPanel, BorderLayout.NORTH);
		aggiornaPanel.add(buttonPanel, BorderLayout.CENTER);
		
		return aggiornaPanel;
	}
	
	private Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	private final int FRAME_WIDTH =  (int) screen.getWidth(), FRAME_HEIGHT = (int) screen.getHeight();
	private final int LENGHT_TEXT_FIELD = 10;
}
