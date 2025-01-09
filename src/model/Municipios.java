package model;
// Generated 8 ene 2025, 8:27:49 by Hibernate Tools 6.5.1.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Municipios generated by hbm2java
 */
public class Municipios implements java.io.Serializable {

	private Integer idMunicipio;
	private Provincias provincias;
	private String nombre;
	private String descripcion;
	private Integer codMunicipio;
	private Set municipiosEspaciosNats = new HashSet(0);
	private Set centrosMeteorologicoses = new HashSet(0);

	public Municipios() {
	}

	public Municipios(Provincias provincias, String nombre, String descripcion, Integer codMunicipio,
			Set municipiosEspaciosNats, Set centrosMeteorologicoses) {
		this.provincias = provincias;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.codMunicipio = codMunicipio;
		this.municipiosEspaciosNats = municipiosEspaciosNats;
		this.centrosMeteorologicoses = centrosMeteorologicoses;
	}

	public Integer getIdMunicipio() {
		return this.idMunicipio;
	}

	public void setIdMunicipio(Integer idMunicipio) {
		this.idMunicipio = idMunicipio;
	}

	public Provincias getProvincias() {
		return this.provincias;
	}

	public void setProvincias(Provincias provincias) {
		this.provincias = provincias;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getCodMunicipio() {
		return this.codMunicipio;
	}

	public void setCodMunicipio(Integer codMunicipio) {
		this.codMunicipio = codMunicipio;
	}

	public Set getMunicipiosEspaciosNats() {
		return this.municipiosEspaciosNats;
	}

	public void setMunicipiosEspaciosNats(Set municipiosEspaciosNats) {
		this.municipiosEspaciosNats = municipiosEspaciosNats;
	}

	public Set getCentrosMeteorologicoses() {
		return this.centrosMeteorologicoses;
	}

	public void setCentrosMeteorologicoses(Set centrosMeteorologicoses) {
		this.centrosMeteorologicoses = centrosMeteorologicoses;
	}
	
	@Override
	public String toString() {
		return this.nombre;
	}
	

}
