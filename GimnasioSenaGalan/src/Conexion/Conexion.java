package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {

private String nombrebd="gimsena";
private String usuario="root";
private String password="";
private String url="jdbc:mysql://localhost:3306/"+nombrebd;

Connection conn=null;

public Conexion(){
	try{
		Class.forName("com.mysql.jdbc.Driver");
		conn=DriverManager.getConnection(url,usuario,password);
		if(conn!=null){
			System.out.println("Conexion Exitosa");
		}else
		{
			System.out.println("No se puso conectar ");
		}	
	}
	catch (ClassNotFoundException e) {
		System.out.println("ocurre una classnotfoundexception" + e.getMessage());
	}
	catch (SQLException e) {
		System.out.println("ocurre una sqlexception" + e.getMessage());
		System.out.println("verifique que el mysql este encendido");
	}
}
public Connection getConnection(){
	return conn;
}
public void desconectar(){
	conn=null;
}
}
