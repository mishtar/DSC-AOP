import java.sql.SQLException;
import java.util.List;

import org.pl.eshop.dto.Categoria;
import org.pl.eshop.dto.CategoriaDAOMySQL;;

public class Main {
	public static void main(String [] args)
	{
		System.out.println("Programa iniciado.");
		try{
			CategoriaDAOMySQL catM = new CategoriaDAOMySQL();
			Categoria cat = new Categoria(1,"Prueba1","Descripcion1");
			System.out.println("Agregando nueva categoría");
			catM.agregar(cat);
			System.out.println("Nueva categoría agregada con Nombre:" + cat.getNombre());
			System.out.println("Obteniendo todas las categorías");
			List<Categoria> cats = catM.obtenerTodas();
			System.out.println("Obtenidas " + cats.size() + " categoría(s).");
			System.out.println("Obteniendo categoría previamente creada con id:" + cats.get(0).getId());
			Categoria cat2 = catM.obtenerPorId(cats.get(0).getId());
			System.out.println("Categoria obtenida con nombre:" + cat2.getNombre());		
			cat2.setNombre("CambioPrueba1");
			System.out.println("Cambiando el nombre de la categoría a:" + cat2.getNombre());
			catM.modificar(cat2);
			System.out.println("Nombre de la categoría con Id:" + cat2.getId() +" Cambiado a:" + cat2.getNombre());;
			System.out.println("Eliminando categoría con nombre:" + cat2.getNombre());
			catM.eliminar(cat2);		
			System.out.println("Categoría eliminada.");
			System.out.println("Tratando de obtener la categoría con id: 1");
			Categoria cat3 = catM.obtenerPorId(1);	
			System.out.println("Tirando excepción para manejarla por aspecto");
			catM.SimularExcepcion();
		}
		catch(SQLException se){
			System.out.println("Excepción obtenida en el código.");
		}
		System.out.println("Programa finalizado.");
	}
}
