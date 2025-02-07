import javax.swing.JOptionPane;

public class VotoErratoException extends RuntimeException {

	public VotoErratoException() {
		JOptionPane.showMessageDialog(null, "Errore. Voto non valido!");
	}
	
	public VotoErratoException(String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}
}
