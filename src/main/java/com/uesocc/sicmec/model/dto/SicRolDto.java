/**
 * 
 */
package com.uesocc.sicmec.model.dto;

import java.io.Serializable;

/**
 * @author xtiyo
 *
 */
public class SicRolDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String idSicRol;
    private String nombreRol;
    private String descripcionRol;
    private String fxCreado;
    private String creadoPor;
    private String fxModicado;
    private String modicadoPor;
    
	/**
	 * @return the idSicRol
	 */
	public String getIdSicRol() {
		return idSicRol;
	}
	/**
	 * @param idSicRol the idSicRol to set
	 */
	public void setIdSicRol(String idSicRol) {
		this.idSicRol = idSicRol;
	}
	/**
	 * @return the nombreRol
	 */
	public String getNombreRol() {
		return nombreRol;
	}
	/**
	 * @param nombreRol the nombreRol to set
	 */
	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}
	/**
	 * @return the descripcionRol
	 */
	public String getDescripcionRol() {
		return descripcionRol;
	}
	/**
	 * @param descripcionRol the descripcionRol to set
	 */
	public void setDescripcionRol(String descripcionRol) {
		this.descripcionRol = descripcionRol;
	}
	/**
	 * @return the fxCreado
	 */
	public String getFxCreado() {
		return fxCreado;
	}
	/**
	 * @param fxCreado the fxCreado to set
	 */
	public void setFxCreado(String fxCreado) {
		this.fxCreado = fxCreado;
	}
	/**
	 * @return the creadoPor
	 */
	public String getCreadoPor() {
		return creadoPor;
	}
	/**
	 * @param creadoPor the creadoPor to set
	 */
	public void setCreadoPor(String creadoPor) {
		this.creadoPor = creadoPor;
	}
	/**
	 * @return the fxModicado
	 */
	public String getFxModicado() {
		return fxModicado;
	}
	/**
	 * @param fxModicado the fxModicado to set
	 */
	public void setFxModicado(String fxModicado) {
		this.fxModicado = fxModicado;
	}
	/**
	 * @return the modicadoPor
	 */
	public String getModicadoPor() {
		return modicadoPor;
	}
	/**
	 * @param modicadoPor the modicadoPor to set
	 */
	public void setModicadoPor(String modicadoPor) {
		this.modicadoPor = modicadoPor;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SicRolDto [idSicRol=" + idSicRol + ", nombreRol=" + nombreRol
				+ ", descripcionRol=" + descripcionRol + ", fxCreado="
				+ fxCreado + ", creadoPor=" + creadoPor + ", fxModicado="
				+ fxModicado + ", modicadoPor=" + modicadoPor + "]";
	}


}
