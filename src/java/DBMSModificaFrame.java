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

public class DBMSModificaFrame extends JFrame{

	public DBMSModificaFrame() {
		
		createAggiornaFrame();
		createInserisciFrame();
		createEliminaFrame();
		
		JPanel controlPanel = createControlPanel();

		JPanel modificaPanel = createModificaPanel();
		
		add(controlPanel, BorderLayout.NORTH);
		add(modificaPanel);
		
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
					aggiornaFrame.setVisible(true);
				}
				if(modifica.equalsIgnoreCase("Inserisci")) {
					setVisible(false);
					inserisciFrame.setVisible(true);
				}
				if(modifica.equalsIgnoreCase("Elimina")) {
					setVisible(false);
					eliminaFrame.setVisible(true);
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
	
	public void createAggiornaFrame() {
		aggiornaFrame = new DBMSAggiornaFrame();
		aggiornaFrame.setLocationRelativeTo(null);
		aggiornaFrame.setVisible(false);
	}
	
	public void createInserisciFrame() {
		inserisciFrame = new DBMSInserisciFrame();
		inserisciFrame.setLocationRelativeTo(null);
		inserisciFrame.setVisible(false);
	}
	
	public void createEliminaFrame() {
		eliminaFrame = new DBMSEliminaFrame();
		eliminaFrame.setLocationRelativeTo(null);
		eliminaFrame.setVisible(false);
	}
	
	private Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	private final int FRAME_WIDTH =  (int) screen.getWidth(), FRAME_HEIGHT = (int) screen.getHeight();
	public static JFrame aggiornaFrame;
	public static JFrame inserisciFrame;
	public static JFrame eliminaFrame;
}
