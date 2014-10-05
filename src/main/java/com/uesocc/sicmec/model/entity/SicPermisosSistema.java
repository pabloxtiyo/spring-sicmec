/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.uesocc.sicmec.model.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author xtiyo
 */
@Entity
@Table(name = "sic_permisos_sistema", catalog = "sicmec_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SicPermisosSistema.findAll", query = "SELECT s FROM SicPermisosSistema s"),
    @NamedQuery(name = "SicPermisosSistema.findByIdSicPermisosSistema", query = "SELECT s FROM SicPermisosSistema s WHERE s.idSicPermisosSistema = :idSicPermisosSistema")})
public class SicPermisosSistema implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_sic_permisos_sistema")
    private Integer idSicPermisosSistema;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkSicPermisosSistema")
    private List<SicAsignacionPermisos> sicAsignacionPermisosList;
    @JoinColumn(name = "fk_sic_rol", referencedColumnName = "id_sic_rol")
    @ManyToOne(optional = false)
    private SicRol fkSicRol;

    public SicPermisosSistema() {
    }

    public SicPermisosSistema(Integer idSicPermisosSistema) {
        this.idSicPermisosSistema = idSicPermisosSistema;
    }

    public Integer getIdSicPermisosSistema() {
        return idSicPermisosSistema;
    }

    public void setIdSicPermisosSistema(Integer idSicPermisosSistema) {
        this.idSicPermisosSistema = idSicPermisosSistema;
    }

    @XmlTransient
    public List<SicAsignacionPermisos> getSicAsignacionPermisosList() {
        return sicAsignacionPermisosList;
    }

    public void setSicAsignacionPermisosList(List<SicAsignacionPermisos> sicAsignacionPermisosList) {
        this.sicAsignacionPermisosList = sicAsignacionPermisosList;
    }

    public SicRol getFkSicRol() {
        return fkSicRol;
    }

    public void setFkSicRol(SicRol fkSicRol) {
        this.fkSicRol = fkSicRol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSicPermisosSistema != null ? idSicPermisosSistema.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SicPermisosSistema)) {
            return false;
        }
        SicPermisosSistema other = (SicPermisosSistema) object;
        if ((this.idSicPermisosSistema == null && other.idSicPermisosSistema != null) || (this.idSicPermisosSistema != null && !this.idSicPermisosSistema.equals(other.idSicPermisosSistema))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uesocc.model.entity.SicPermisosSistema[ idSicPermisosSistema=" + idSicPermisosSistema + " ]";
    }
    
}
