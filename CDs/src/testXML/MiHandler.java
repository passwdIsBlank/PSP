package testXML;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MiHandler extends DefaultHandler {

	private boolean title = false;
	private boolean artist = false;
	private boolean country = false;
	private boolean company = false;
	private boolean price = false;
	private boolean year = false;

	private ArrayList<Cd> cds = new ArrayList<Cd>();
	private Cd cd = new Cd();

	@Override
	public void startElement(String uri, String localName, String Name, Attributes attributos) throws SAXException {
		switch (Name.toUpperCase()) {
		case "TITLE":
			this.title = true;
			break;
		case "ARTIST":
			this.artist = true;
			break;
		case "COUNTRY":
			this.country = true;
			break;
		case "COMPANY":
			this.company = true;
			break;
		case "PRICE":
			this.price = true;
			break;
		case "YEAR":
			this.year = true;
			break;
		}

	}

	public ArrayList<Cd> obtenerCds() {
		return cds;
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {

		if (this.title) {
			this.cd.setTitle(new String(ch, start, length));
			this.title = false;
		}
		
		if (this.artist) {
			this.cd.setArtist(new String(ch, start, length));
			this.artist = false;
		}
		
		if (this.country) {
			this.cd.setCountry(new String(ch, start, length));
			this.country = false;
		}
		
		if (this.company) {
			this.cd.setCompany(new String(ch, start, length));
			this.company = false;
		}
		
		if (this.price) {
			this.cd.setPrice(Double.parseDouble(new String(ch, start, length)));
			this.price = false;
		}
		
		if (this.year) {
			this.cd.setYear(Integer.parseInt(new String(ch, start, length)));
			this.year = false;
		}

	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equals("CD")) {
			this.cds.add(this.cd);
			this.cd = new Cd();
		}

	}

}
