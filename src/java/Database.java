import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Database {

	public Database(String db_url, String username, String password) {

		try {
			conn = DriverManager.getConnection(db_url, username, password);
			stmt = conn.createStatement();
		}
		catch(SQLException e) {
			System.out.println(e);
		}
	}


	public String query1() {

		String result = "";
		boolean flag = false;

		try {
			rs = stmt.executeQuery(QUERY1);
			while(rs.next()) {
				flag = true;
				String matricola = rs.getString("Matricola");
				String cognome = rs.getString("Cognome");
				String nome = rs.getString("Nome");
				String dipartimento = rs.getString("Dipartimento");
				float stipendio = rs.getFloat("Stipendio");

				result += "[Matricola: " + matricola + "],  [Cognome: " + cognome + "],  [Nome: " + nome + 
						"],  [Dipartimento: " + dipartimento + ",  [Stipendio: "  + stipendio + "]\n";
			}
			if(!flag) result = "Empty Set";
		}
		catch(SQLException e) {
			System.out.println(e);
		}

		return result;
	}

	public String query2() {

		String result = "";
		boolean flag = false;

		try {
			rs = stmt.executeQuery(QUERY2);
			while(rs.next()) {
				flag = true;
				String matricola = rs.getString("Matricola");
				String cognome = rs.getString("Cognome");
				String nome = rs.getString("Nome");
				int voto = rs.getInt("Voto");
				String lode = rs.getString("Lode");

				result += "[Matricola: " + matricola + "],  [Cognome: " + cognome + "],  [Nome: " + nome + 
						"],  [Voto: "  + voto + "],  [Lode: " + lode + "]\n";
			}
			if(!flag) result = "Empty Set";
		}
		catch(SQLException e) {
			System.out.println(e);
		}

		return result;
	}

	public String query3() {

		String result = "";
		boolean flag = false;

		try {
			rs = stmt.executeQuery(QUERY3);
			while(rs.next()) {
				flag = true;
				float totaleStipendi = rs.getFloat("TotaleStipendi");

				result += "[Totale stipendi: " + totaleStipendi + "]";
			}
			if(!flag) result = "Empty Set";
		}
		catch(SQLException e) {
			System.out.println(e);
		}

		return result;
	}

	public String query4() {

		String result = "";
		boolean flag = false;

		try {
			rs = stmt.executeQuery(QUERY4);
			while(rs.next()) {
				flag = true;
				String dipartimento = rs.getString("Dipartimento");
				float totaleStipendi = rs.getFloat("TotaleStipendi");

				result += "[Dipartimento: " + dipartimento + "],  [Totale Stipendi: " + totaleStipendi + "]\n";
			}
			if(!flag) result = "Empty Set";
		}
		catch(SQLException e) {
			System.out.println(e);
		}

		return result;
	}

	public String query5() {

		String result = "";
		boolean flag = false;

		try {
			rs = stmt.executeQuery(QUERY5);
			while(rs.next()) {
				flag = true;
				String dipartimento = rs.getString("Dipartimento");
				float totaleStipendi = rs.getFloat("TotaleStipendi");

				result += "[Dipartimento: " + dipartimento + "],  [Totale Stipendi: " + totaleStipendi + "]\n";
			}
			if(!flag) result = "Empty Set";
		}
		catch(SQLException e) {
			System.out.println(e);
		}

		return result;
	}

	public String query6() {

		String result = "";
		boolean flag = false;

		try {
			rs = stmt.executeQuery(QUERY6);
			while(rs.next()) {
				flag = true;
				String dipartimento = rs.getString("Dipartimento");
				float totaleStipendi = rs.getFloat("TotaleStipendi");

				result += "[Dipartimento: " + dipartimento + "],  [Totale Stipendi: " + totaleStipendi + "]\n";
			}
			if(!flag) result = "Empty Set";
		}
		catch(SQLException e) {
			System.out.println(e);
		}

		return result;
	}

	public String query7() {

		String result = "";
		boolean flag = false;
		
		String first = "drop view if exists vista;";
		String second = "create view vista as\n"
				+ "select d.Matricola\n"
				+ "from Insegnamento i, Docente d, Corso c \n"
				+ "where i.Docente = d.Matricola and i.Corso = c.Codice and c.Facolta = \"Informatica\" \n"
				+ "and d.Matricola in \n"
				+ "(select i1.Docente\n"
				+ "from Insegnamento i1, Corso c1\n"
				+ "where i1.Corso = c1.Codice and c1.Facolta = \"Computer Science\");";
		
		try {
			stmt.execute(first);
			stmt.execute(second);
		}
		catch (SQLException e1) {
			System.out.println(e1);
		}
		

		try {
			rs = stmt.executeQuery(QUERY7);
			while(rs.next()) {
				flag = true;
				String matricola = rs.getString("Matricola");
				String cognome = rs.getString("Cognome");
				String nome = rs.getString("Nome");
				String corso = rs.getString("Corso");
				String facolta = rs.getString("Facolta");
				
				result += "[Matricola: " + matricola + "],  [Cognome: " + cognome + "],  [Nome: " + nome + 
						"],  [Corso: " + corso + "],  [Facoltà: " + facolta + "]\n";
			}
			if(!flag) result = "Empty Set";
		}
		catch(SQLException e) {
			System.out.println(e);
		}
		
		String third = "drop view vista";
		
		try {
			stmt.execute(third);
		} 
		catch (SQLException e) {
			System.out.println(e);
		}

		return result;
	}

	public String query8() {

		String result = "";
		boolean flag = false;

		try {
			rs = stmt.executeQuery(QUERY8);
			while(rs.next()) {
				flag = true;
				String matricola = rs.getString("Matricola");
				String cognome = rs.getString("Cognome");
				String nome = rs.getString("Nome");
				String facolta = rs.getString("Facolta");

				result += "[Matricola: " + matricola + "],  [Cognome: " + cognome + "],  [Nome: " + nome + 
						"],  [Facoltà: " + facolta + "]\n";
			}
			if(!flag) result = "Empty Set";
		}
		catch(SQLException e) {
			System.out.println(e);
		}

		return result;
	}

	public String query9() {

		String result = "";
		boolean flag = false;

		try {
			rs = stmt.executeQuery(QUERY9);
			while(rs.next()) {
				flag = true;
				String nome = rs.getString("Nome");
				String citta = rs.getString("Citta");
				String via = rs.getString("Via");
				String civico = rs.getString("Civico");
				String cap = rs.getString("CAP");
				String provincia = rs.getString("Provincia");
				int docenti = rs.getInt("Docenti");

				result += "[Nome: " + nome + "],  [Indirizzo: " + citta + ", " + via + " " + civico +
						", " + cap + " (" + provincia + "),  [Docenti: " + docenti + "]\n";
			}
			if(!flag) result = "Empty Set";
		} catch (SQLException e) {
			System.out.println(e);
		}

		return result;
	}

	public String query10() {

		String result = "";
		boolean flag = false;

		try {
			rs = stmt.executeQuery(QUERY10);
			while(rs.next()) {
				flag = true;
				String nome = rs.getString("Nome");
				String dipartimento = rs.getString("Dipartimento");

				result += "[Nome: " + nome + "],  [Dipartimento: " + dipartimento + "]\n";
			}
			if(!flag) result = "Empty Set";
		} catch (SQLException e) {
			System.out.println(e);
			result = "Empty Set";
		}

		return result;
	}

	public String query11() {

		String result = "";
		boolean flag = false;

		try {
			rs = stmt.executeQuery(QUERY11);
			while(rs.next()) {
				flag = true;
				String codice = rs.getString("Codice");
				String nome = rs.getString("Nome");
				String facolta = rs.getString("Facolta");
				int cfu = rs.getInt("CFU");
				int docenti = rs.getInt("Docenti");

				result += "[Codice: " + codice + "],  [Nome: " + nome + "],  [Facolta: " + facolta + 
						"],  [CFU: " + cfu + "],  [Docenti: " + docenti + "]\n";
			}
			if(!flag) result = "Empty Set";
		} catch (SQLException e) {
			System.out.println(e);
			result = "Empty Set";

		}

		return result;
	}

	public String query12() {

		String result = "";
		boolean flag = false;

		try {
			rs = stmt.executeQuery(QUERY12);
			while(rs.next()) {
				flag = true;
				String matricola = rs.getString("Matricola");
				String nome = rs.getString("Nome");
				String cognome = rs.getString("Cognome");
				String dipartimento = rs.getString("Dipartimento");
				String email = rs.getString("Email");

				result += "[Matricola: " + matricola + "],  [Cognome: " + cognome + "],  [Nome: " + nome + 
						"],  [Dipartimento: " + dipartimento + ",  [Email: " + email + "]\n";
			}
			if(!flag) result = "Empty Set";
		} catch (SQLException e) {
			System.out.println(e);
			result = "Empty Set";
		}

		return result;
	}

	public String query13() {

		String result = "";
		boolean flag = false;

		try {
			rs = stmt.executeQuery(QUERY13);
			while(rs.next()) {
				flag = true;
				String matricola = rs.getString("Matricola");
				String nome = rs.getString("Nome");
				String cognome = rs.getString("Cognome");
				String immatricolazione = rs.getString("Immatricolazione");
				String email = rs.getString("Email");
				String facolta = rs.getString("Facolta");

				result += "[Matricola: " + matricola + "],  [Cognome: " + cognome + 
						"],  [Nome: " + nome + "],  [Immatricolazione: " + immatricolazione + 
						",  [Email: " + email + "],  [Facoltà: " + facolta + "]\n";
			}
			if(!flag) result = "Empty Set";
		} catch (SQLException e) {
			System.out.println(e);
			result = "Empty Set";
		}

		return result;
	}
	
	public String query14() {

		String result = "";
		boolean flag = false;

		try {
			rs = stmt.executeQuery(QUERY14);
			while(rs.next()) {
				flag = true;
				String matricola = rs.getString("Matricola");
				String nome = rs.getString("Nome");
				String cognome = rs.getString("Cognome");
				String stipendio = rs.getString("Stipendio");

				result += "[Matricola: " + matricola + "],  [Cognome: " + cognome + 
						"],  [Nome: " + nome + "],  [Stipendio: " + stipendio + "]\n";
			}
			if(!flag) result = "Empty Set";
		} catch (SQLException e) {
			System.out.println(e);
			result = "Empty Set";
		}

		return result;
	}
	
	public String query15() {

		String result = "";
		boolean flag = false;

		try {
			rs = stmt.executeQuery(QUERY15);
			while(rs.next()) {
				flag = true;
				String matricola = rs.getString("Matricola");
				String nome = rs.getString("Nome");
				String cognome = rs.getString("Cognome");
				String facolta = rs.getString("Facolta");
				String corso = rs.getString("Corso");
				int voto = rs.getInt("Voto");
				String data = rs.getString("Data");
				String lode = rs.getString("Lode");

				result += "[Matricola: " + matricola + "],  [Cognome: " + cognome + 
						"],  [Nome: " + nome + "],  [Facoltà: " + facolta + "],  [Corso: " + corso + 
						"],  [Voto: " + voto + "],  [Data: " + data + "],  [Lode: " + lode + "]\n";
			}
			if(!flag) result = "Empty Set";
		} catch (SQLException e) {
			System.out.println(e);
			result = "Empty Set";
		}

		return result;
	}

	public boolean update(float stipendio, String matricola) {

		boolean flag = false;
		UPDATE = "update Docente\n"
				+ "set Stipendio = " + stipendio + "\n"
				+ "where Matricola = " + matricola + ";";

		try {
			stmt.executeUpdate(UPDATE);
			flag = true;
		} catch (SQLException e) {
			System.out.println(e);
		}

		return flag;
	}

	public boolean insert(String corso, String studente, String data, int voto, String lode) {

		boolean flag = false;
		INSERT = "insert into Esame values\n"
				+ "(\"" + corso + "\", \"" + studente + "\", \"" + data + "\", \"" +  voto
				+ "\", \"" + lode + "\");";
		try {
			stmt.executeUpdate(INSERT);
			flag = true;
		} catch (SQLException e) {
			System.out.println(e);
		}

		return flag;
	}

	public boolean delete(String matricola) {

		boolean flag = false;
		String query = "select Dipartimento from Docente where Matricola = \"" + matricola + "\";";
		String dipartimento = "";

		DELETE = "delete from Docente\n"
				+ "where Matricola = \"" + matricola + "\";";

		try {
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				dipartimento = rs.getString("Dipartimento");
			}

			stmt.execute(DELETE);

			String update = "update Dipartimento set Docenti = (Docenti - 1) where Nome = \"" + dipartimento + "\";";
			stmt.executeUpdate(update);
			flag = true;

		} catch (SQLException e) {
			e.printStackTrace();;
		}

		return flag;
	}

	public boolean isConnected() {
		return conn != null ? true : false;
	}


	private Connection conn;
	private Statement stmt;
	private ResultSet rs;

	private final String QUERY1 = "select Matricola, Cognome, Nome, Dipartimento, Stipendio\n"
			+ "from Docente\n"
			+ "where Stipendio > 1500 and (Dipartimento = \"Farmacia\" or Dipartimento = \"Chimica e Biologia\")\n"
			+ "order by Cognome;";

	private final String QUERY2 = "select s.Matricola, s.Nome, s.Cognome, e.Voto, e.Lode\n"
			+ "from Esame e, Studente s, Corso c\n"
			+ "where e.Corso = c.Codice and e.Studente = s.Matricola and c.Facolta = \"Informatica\" and c.Nome = \"Basi di Dati\";";

	private final String QUERY3 = "select sum(Stipendio) as TotaleStipendi\n"
			+ "from Docente;";

	private final String QUERY4 = "select Dipartimento, sum(Stipendio) as TotaleStipendi\n"
			+ "from Docente\n"
			+ "group by Dipartimento;";

	private final String QUERY5 = "select Dipartimento, sum(Stipendio) as TotaleStipendi\n"
			+ "from Docente\n"
			+ "group by Dipartimento\n"
			+ "having TotaleStipendi > 10000;";

	private final String QUERY6 = "select Dipartimento, sum(Stipendio) as TotaleStipendi\n"
			+ "from Docente\n"
			+ "group by Dipartimento\n"
			+ "having TotaleStipendi >= all\n"
			+ "(select sum(d.Stipendio)\n"
			+ "from Docente d\n"
			+ "group by d.Dipartimento);";

	private final String QUERY7 = "select d.Matricola, d.Cognome, d.Nome, c.Facolta, c.Nome as Corso\n"
			+ "from Insegnamento i, Docente d, Corso c, vista v\n"
			+ "where d.Matricola = v.Matricola and i.Docente = d.Matricola and i.Corso = c.Codice;";

	private final String QUERY8 = "select s.Matricola, s.Cognome, s.Nome, s.Facolta\n"
			+ "from Studente s\n"
			+ "where not exists\n"
			+ "(select *\n"
			+ "from Corso c\n"
			+ "where c.Facolta = s.Facolta and not exists\n"
			+ "(select *\n"
			+ "from Frequenza f\n"
			+ "where f.Corso = c.Codice and f.Studente = s.Matricola));";

	private final String QUERY9 = "select * from Dipartimento;";

	private final String QUERY10 = "select * from Facolta;";

	private final String QUERY11 = "select * from Corso;";

	private final String QUERY12 = "select Matricola, Cognome, Nome, Email, Dipartimento\n"
			+ "from Docente;";

	private final String QUERY13 = "select Matricola, Cognome, Nome, Immatricolazione, Email, Facolta\n"
			+ "from Studente;";

	private final String QUERY14 = "select Matricola, Cognome, Nome, Stipendio\n"
			+ "from Docente\n"
			+ "order by Cognome;";

	private final String QUERY15 = "select s.Matricola, s.Cognome, s.Nome, s.Facolta, c.Nome as Corso, e.Data, e.Voto, e.Lode\n"
			+ "from Esame e, Studente s, Corso c\n"
			+ "where e.Corso = c.Codice and e.Studente = s.Matricola\n"
			+ "order by s.Cognome;";
	
	private String UPDATE;
	private String INSERT;
	private String DELETE;
}
