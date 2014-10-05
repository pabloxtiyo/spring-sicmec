/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.uesocc.sicmec.model.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author xtiyo
 */
@Entity
@Table(name = "sic_configuracion", catalog = "sicmec_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SicConfiguracion.findAll", query = "SELECT s FROM SicConfiguracion s"),
    @NamedQuery(name = "SicConfiguracion.findByIdSicConfiguracion", query = "SELECT s FROM SicConfiguracion s WHERE s.idSicConfiguracion = :idSicConfiguracion"),
    @NamedQuery(name = "SicConfiguracion.findByConTiempoAbandono", query = "SELECT s FROM SicConfiguracion s WHERE s.conTiempoAbandono = :conTiempoAbandono"),
    @NamedQuery(name = "SicConfiguracion.findByVerExamenes", query = "SELECT s FROM SicConfiguracion s WHERE s.verExamenes = :verExamenes")})
public class SicConfiguracion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_sic_configuracion")
    private Integer idSicConfiguracion;
    @Column(name = "con_tiempo_abandono")
    private Boolean conTiempoAbandono;
    @Column(name = "ver_examenes")
    private Boolean verExamenes;

    public SicConfiguracion() {
    }

    public SicConfiguracion(Integer idSicConfiguracion) {
        this.idSicConfiguracion = idSicConfiguracion;
    }

    public Integer getIdSicConfiguracion() {
        return idSicConfiguracion;
    }

    public void setIdSicConfiguracion(Integer idSicConfiguracion) {
        this.idSicConfiguracion = idSicConfiguracion;
    }

    public Boolean getConTiempoAbandono() {
        return conTiempoAbandono;
    }

    public void setConTiempoAbandono(Boolean conTiempoAbandono) {
        this.conTiempoAbandono = conTiempoAbandono;
    }

    public Boolean getVerExamenes() {
        return verExamenes;
    }

    public void setVerExamenes(Boolean verExamenes) {
        this.verExamenes = verExamenes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSicConfiguracion != null ? idSicConfiguracion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SicConfiguracion)) {
            return false;
        }
        SicConfiguracion other = (SicConfiguracion) object;
        if ((this.idSicConfiguracion == null && other.idSicConfiguracion != null) || (this.idSicConfiguracion != null && !this.idSicConfiguracion.equals(other.idSicConfiguracion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uesocc.model.entity.SicConfiguracion[ idSicConfiguracion=" + idSicConfiguracion + " ]";
    }
    
}
