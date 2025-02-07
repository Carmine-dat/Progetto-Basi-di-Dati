import javax.swing.JOptionPane;

public class LodeNonValidaException extends RuntimeException {

	public LodeNonValidaException() {
		JOptionPane.showMessageDialog(null, "Errore. Lode non valida!");
	}
	
	public LodeNonValidaException(String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}
}
