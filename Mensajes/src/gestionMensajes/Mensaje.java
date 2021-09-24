package gestionMensajes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Mensaje {
	private LocalDate fecha;
	private String hora, from, to, subject, body;
	
	public Mensaje(String fecha, String hora, String from, String to, String subject, String body) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		formatter = formatter.withLocale( Locale.CANADA_FRENCH ); //yyyy-MM-dd
		
		this.fecha = LocalDate.parse(fecha, formatter);
		this.hora = hora;
		this.from = from;
		this.to = to;
		this.subject = subject;
		this.body = body;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	
	@Override
	public String toString() {
		return "Fecha -> " + this.fecha + "\rHora -> " + this.hora + "\rDe -> " + this.to + "\rA -> " + this.from + "\rAsunto -> " + this.subject + "\rMensaje -> " + this.body;
	}
	
	public String[] toArray() {
		return new String[] {this.fecha.toString(), this.hora, this.to, this.from, this.subject, this.body};
	}

}
