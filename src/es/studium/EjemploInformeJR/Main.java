/**
 * 
 */
package es.studium.EjemploInformeJR;
import net.sf.jasperreports.engine.JasperCompileManager;
/**
 * @author Alvca
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try 
		{ 
			// Compilar el informe generando fichero jasper
			JasperCompileManager.compileReportToFile("ArticulosTiendecita.jrxml"); 
			System.out.println("Fichero ArticulosTiendecita.jasper generado CORRECTAMENTE!"); 
		} 
		catch (Exception e) 
		{
			System.out.println("Error: " + e.toString()); 
		}
	}
}
