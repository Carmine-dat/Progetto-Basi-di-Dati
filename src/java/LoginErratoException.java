import javax.swing.JOptionPane;

public class LoginErratoException extends RuntimeException {

	public LoginErratoException() {
		JOptionPane.showMessageDialog(null, "I dati non sono corretti!");
	}
	
	public LoginErratoException(String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}
}
