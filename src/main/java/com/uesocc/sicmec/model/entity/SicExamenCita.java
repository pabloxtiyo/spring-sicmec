/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.uesocc.sicmec.model.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author xtiyo
 */
@Entity
@Table(name = "sic_examen_cita", catalog = "sicmec_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SicExamenCita.findAll", query = "SELECT s FROM SicExamenCita s"),
    @NamedQuery(name = "SicExamenCita.findByIdSicExamenCita", query = "SELECT s FROM SicExamenCita s WHERE s.idSicExamenCita = :idSicExamenCita"),
    @NamedQuery(name = "SicExamenCita.findByComentario", query = "SELECT s FROM SicExamenCita s WHERE s.comentario = :comentario"),
    @NamedQuery(name = "SicExamenCita.findByPediente", query = "SELECT s FROM SicExamenCita s WHERE s.pediente = :pediente"),
    @NamedQuery(name = "SicExamenCita.findByResultado", query = "SELECT s FROM SicExamenCita s WHERE s.resultado = :resultado"),
    @NamedQuery(name = "SicExamenCita.findByFxCreado", query = "SELECT s FROM SicExamenCita s WHERE s.fxCreado = :fxCreado"),
    @NamedQuery(name = "SicExamenCita.findByCreadoPor", query = "SELECT s FROM SicExamenCita s WHERE s.creadoPor = :creadoPor"),
    @NamedQuery(name = "SicExamenCita.findByFxModificado", query = "SELECT s FROM SicExamenCita s WHERE s.fxModificado = :fxModificado"),
    @NamedQuery(name = "SicExamenCita.findByModificadoPor", query = "SELECT s FROM SicExamenCita s WHERE s.modificadoPor = :modificadoPor")})
public class SicExamenCita implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_sic_examen_cita")
    private Integer idSicExamenCita;
    @Basic(optional = false)
    private String comentario;
    private Boolean pediente;
    @Basic(optional = false)
    private String resultado;
    @Column(name = "fx_creado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fxCreado;
    @Column(name = "creado_por")
    private String creadoPor;
    @Column(name = "fx_modificado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fxModificado;
    @Column(name = "modificado_por")
    private String modificadoPor;
    @JoinColumn(name = "fk_sic_examen", referencedColumnName = "id_sic_examen")
    @ManyToOne(optional = false)
    private SicExamen fkSicExamen;
    @JoinColumn(name = "fk_sic_cita_medica", referencedColumnName = "id_sic_cita_medica")
    @ManyToOne(optional = false)
    private SicCitaMedica fkSicCitaMedica;

    public SicExamenCita() {
    }

    public SicExamenCita(Integer idSicExamenCita) {
        this.idSicExamenCita = idSicExamenCita;
    }

    public SicExamenCita(Integer idSicExamenCita, String comentario, String resultado) {
        this.idSicExamenCita = idSicExamenCita;
        this.comentario = comentario;
        this.resultado = resultado;
    }

    public Integer getIdSicExamenCita() {
        return idSicExamenCita;
    }

    public void setIdSicExamenCita(Integer idSicExamenCita) {
        this.idSicExamenCita = idSicExamenCita;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Boolean getPediente() {
        return pediente;
    }

    public void setPediente(Boolean pediente) {
        this.pediente = pediente;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public Date getFxCreado() {
        return fxCreado;
    }

    public void setFxCreado(Date fxCreado) {
        this.fxCreado = fxCreado;
    }

    public String getCreadoPor() {
        return creadoPor;
    }

    public void setCreadoPor(String creadoPor) {
        this.creadoPor = creadoPor;
    }

    public Date getFxModificado() {
        return fxModificado;
    }

    public void setFxModificado(Date fxModificado) {
        this.fxModificado = fxModificado;
    }

    public String getModificadoPor() {
        return modificadoPor;
    }

    public void setModificadoPor(String modificadoPor) {
        this.modificadoPor = modificadoPor;
    }

    public SicExamen getFkSicExamen() {
        return fkSicExamen;
    }

    public void setFkSicExamen(SicExamen fkSicExamen) {
        this.fkSicExamen = fkSicExamen;
    }

    public SicCitaMedica getFkSicCitaMedica() {
        return fkSicCitaMedica;
    }

    public void setFkSicCitaMedica(SicCitaMedica fkSicCitaMedica) {
        this.fkSicCitaMedica = fkSicCitaMedica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSicExamenCita != null ? idSicExamenCita.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SicExamenCita)) {
            return false;
        }
        SicExamenCita other = (SicExamenCita) object;
        if ((this.idSicExamenCita == null && other.idSicExamenCita != null) || (this.idSicExamenCita != null && !this.idSicExamenCita.equals(other.idSicExamenCita))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uesocc.model.entity.SicExamenCita[ idSicExamenCita=" + idSicExamenCita + " ]";
    }
    
}
