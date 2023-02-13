import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Conexion {

	private static final String CONTROLADOR = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://db4free.net:3306/colegiohlcraj";
	private static final String USUARIO = "rajvgc";
	private static final String CLAVE = "DokkanBattle";
	
	static {
		try {
			Class.forName(CONTROLADOR);
		} catch (ClassNotFoundException e) {
			System.out.println("Error al cargar el controlador");
			e.printStackTrace();
		}
	}
	

	public Connection conectar() {
		Connection conexion = null;

		try {
			conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
			//System.out.println("Conexión OK");

		} catch (SQLException e) {
			//System.out.println("Error en la conexión");
			e.printStackTrace();
		}
		
		return conexion;
	}

}


