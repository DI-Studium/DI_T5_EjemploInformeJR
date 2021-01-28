/**
 * 
 */
package es.studium.EjemploInformeJR;
import java.awt.Desktop; 
import java.io.File; 
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.util.HashMap; 
import net.sf.jasperreports.engine.JasperCompileManager; 
import net.sf.jasperreports.engine.JasperExportManager; 
import net.sf.jasperreports.engine.JasperFillManager; 
import net.sf.jasperreports.engine.JasperPrint; 
import net.sf.jasperreports.engine.JasperReport; 
import net.sf.jasperreports.engine.util.JRLoader; 
import net.sf.jasperreports.view.JasperViewer;
/**
 * @author Alvca
 *
 */
public class EjemploInforme {
	static Connection connection = null;
	static String servidor = "jdbc:mysql://localhost:3306/tiendecita?useSSL=false"; 
	static String usuarioDB = "ClaseStudium"; 
	static String passwordDB = "Studium2020;"; 
	static String driver = "com.mysql.jdbc.Driver";
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
			// Objeto para guardar parámetros necesarios para el informe 
			HashMap<String,Object> parametros = new HashMap<String,Object>();
			// Cargar el informe compilado 
			JasperReport report = (JasperReport) JRLoader.loadObjectFromFile("ArticulosTiendecita.jasper"); 
			// Conectar a la base de datos para sacar la información 
			
			
			//Cargar los controladores para el acceso a la BD
			Class.forName(driver);
			System.out.println("Conectando a la base de datos");
			//Establecer la conexión con la BD Empresa
			connection = DriverManager.getConnection(servidor, usuarioDB, passwordDB);
			
			// Completar el informe con los datos de la base de datos 
			JasperPrint print = JasperFillManager.fillReport(report, parametros, connection);
			// Mostrar el informe en JasperViewer 
			JasperViewer.viewReport(print, false); 
			// Para exportarlo a pdf 
			JasperExportManager.exportReportToPdfFile(print, "ArticulosTiendecita.pdf");
			// Abrir el fichero PDF generado 
			File path = new File ("ArticulosTiendecita.pdf");
			Desktop.getDesktop().open(path); 
		} 
		catch (Exception e) 
		{ 
			System.out.println("Error: " + e.toString()); 
		}
	}
}

