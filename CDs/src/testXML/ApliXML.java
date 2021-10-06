package testXML;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class ApliXML {

	public static void main(String[] args) {
		
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			MiHandler miHandler = new MiHandler();
			SAXParser parser = factory.newSAXParser();
			parser.parse("cd_catalog.xml", miHandler);
			
			ArrayList<Cd> misCds = miHandler.obtenerCds();
			
			ArrayList<Cd> cdMasCaros = new ArrayList<Cd>();
			ArrayList<Cd> cdMasBaratos = new ArrayList<Cd>();
			
			double precioMasAlto = 0;
			double precioMasBajo = Double.MAX_VALUE;
			
			for (Cd cd : misCds) {
				System.out.printf("CD: %s\r", misCds.indexOf(cd) + 1);
				System.out.printf("\tTítulo: %s\r", cd.getTitle());
				System.out.printf("\tArtista: %s\r", cd.getArtist());
				System.out.printf("\tPaís: %s\r", cd.getCountry());
				System.out.printf("\tSello: %s\r", cd.getCompany());
				System.out.printf("\tPrecio: %s\r", cd.getPrice());
				System.out.printf("\tAño: %s\r", cd.getYear());
				
				if (cd.getPrice() >= precioMasAlto) {
					precioMasAlto = cd.getPrice();
				}
				
				if (cd.getPrice() <= precioMasBajo) {
					precioMasBajo = cd.getPrice();
				}
			}
			
			for (Cd cd : misCds) {
				if (cd.getPrice() == precioMasAlto) cdMasCaros.add(cd);
				if (cd.getPrice() == precioMasBajo) cdMasBaratos.add(cd);
			}
			 
			 System.out.printf("\rNúmero de discos %s\r", misCds.size());
			 System.out.println("Precios");
			 cdMasCaros.forEach( cd -> System.out.printf("\tEl albúm más caro (nº CD) %s; precio: %s\r", misCds.indexOf(cd) + 1, cd.getPrice()));
			 cdMasBaratos.forEach( cd -> System.out.printf("\tEl albúm más barato (nº CD) %s; precio: %s\r", misCds.indexOf(cd) + 1, cd.getPrice()));
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		

	}

}
