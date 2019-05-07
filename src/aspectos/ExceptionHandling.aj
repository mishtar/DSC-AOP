package aspectos;

import java.sql.SQLException;

public aspect ExceptionHandling {
	pointcut sqlException() : handler(SQLException);
	
	before() : sqlException(){
		System.out.println("Simulando manejo de excepción desde aspecto.");
	}
}
