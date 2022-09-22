package ar.edu.utn.link.correlativas;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Collection;

public class Materia {

	@NotBlank
	private String nombre;
	@Min(1)
	private int anio;
	private Collection<Materia> correlativas;

	public Materia() {}
	
	public Materia(String nombre, int anio) {
		super();
		this.anio = anio;
		this.nombre = nombre;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Collection<Materia> getCorrelativas() {
		return correlativas;
	}
	public void setCorrelativas(Collection<Materia> correlativas) {
		this.correlativas = correlativas;
	}
	
	

}
