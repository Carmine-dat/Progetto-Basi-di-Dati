import javax.swing.JOptionPane;

public class StipendioNegativoException extends RuntimeException {

	public StipendioNegativoException() {
		JOptionPane.showMessageDialog(null, "Errore. Lo stipendio deve essere positivo!");
	}
	
	public StipendioNegativoException(String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}
}
