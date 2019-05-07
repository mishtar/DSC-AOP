package org.pl.eshop.aspectos;

public aspect ConsultasSQL {
	pointcut modificarCategoria() : execution(* *.modificar(..));
	pointcut agregarCategoria() : execution(* *.agregar(..));
	pointcut consultasSQL() : call(* java.sql.*Statement.execute*(..));
	
	before() : agregarCategoria(){
		System.out.println("Simulando antes de ejecutar la agregaci�n de una categor�a.");
	}
	
	before() : modificarCategoria(){
		System.out.println("Simulando antes de ejecutar la modificaci�n de una categor�a.");
	}
	
	before() : consultasSQL(){
		System.out.println("Simulando antes de ejecutar un llamado a la BD");
	}
}
