package model.DAO;

import model.Articolo;
import java.sql.*;


public class ArticoloDAO {
	
	public void insert(Articolo a) throws SQLException {
		
		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;
		
		try {
			String driver = "com.mysql.jdbc.Driver";
			
			Class.forName(driver);
			
			//Creiamo una stringa di connessione
			String url = "jdbc:mysql://localhost:3306/Magazzino?useUnicode=true&useJDVCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			//Connessione tramite id e password del notrso db		
			dbConnection = DriverManager.getConnection(url,"root","roar");	
			//non iseriamo il parametro codie dato che è un auto incremtn e lo farà im automatico sql
			String updateTableSQL= "INSERT INTO Articolo(descrizione,quantita) VALUES(?,?)";
			cmd = dbConnection.prepareStatement(updateTableSQL);
			//inseriamo il valore del primo parametro(descrizione)
			cmd.setString(1, a.getDescrizione());
			//insermiamo il valore del secondo parametro(quantita)
			cmd.setInt(2, a.getQuantita());
			//eseguiamo il codice sql
			cmd.executeUpdate();
			
			
		}
		catch(Exception e){
			e.printStackTrace();
		}finally {
			if(cmd!=null) {
				cmd.close();
			}
			if(dbConnection != null) {
				dbConnection.close();
			}
		}
	}
}
