import javax.swing.JOptionPane;

public class InserimentoIncompletoException extends RuntimeException{

	public InserimentoIncompletoException() {
		JOptionPane.showMessageDialog(null, "Errore. Devi inserire tutti i campi!");
	}
	
	public InserimentoIncompletoException(String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}
}
