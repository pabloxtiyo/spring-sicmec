/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uesocc.sicmec.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 *
 * @author xtiyo
 */
@Entity
@Table(name = "sic_rol", catalog = "sicmec_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SicRol.findAll", query = "SELECT s FROM SicRol s"),
    @NamedQuery(name = "SicRol.findByIdSicRol", query = "SELECT s FROM SicRol s WHERE s.idSicRol = :idSicRol"),
    @NamedQuery(name = "SicRol.findByNombreRol", query = "SELECT s FROM SicRol s WHERE s.nombreRol = :nombreRol"),
    @NamedQuery(name = "SicRol.findByDescripcionRol", query = "SELECT s FROM SicRol s WHERE s.descripcionRol = :descripcionRol"),
    @NamedQuery(name = "SicRol.findByFxCreado", query = "SELECT s FROM SicRol s WHERE s.fxCreado = :fxCreado"),
    @NamedQuery(name = "SicRol.findByCreadoPor", query = "SELECT s FROM SicRol s WHERE s.creadoPor = :creadoPor"),
    @NamedQuery(name = "SicRol.findByFxModicado", query = "SELECT s FROM SicRol s WHERE s.fxModicado = :fxModicado"),
    @NamedQuery(name = "SicRol.findByModicadoPor", query = "SELECT s FROM SicRol s WHERE s.modicadoPor = :modicadoPor")})
public class SicRol implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_sic_rol", nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idSicRol;
    @Column(name = "nombre_rol", length = 30)
    private String nombreRol;
    @Basic(optional = false)
    @Column(name = "descripcion_rol", nullable = false, length = 100)
    private String descripcionRol;
    @Column(name = "fx_creado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fxCreado;
    @Column(name = "creado_por", length = 50)
    private String creadoPor;
    @Column(name = "fx_modicado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fxModicado;
    @Column(name = "modicado_por", length = 50)
    private String modicadoPor;
    @OneToMany(mappedBy = "fkSicRol")
    @JsonManagedReference
    private List<SicUsuario> sicUsuarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkSicRol")
    private List<SicPermisosSistema> sicPermisosSistemaList;

    public SicRol() {
    }

    public SicRol(Integer idSicRol) {
        this.idSicRol = idSicRol;
    }

    public SicRol(Integer idSicRol, String descripcionRol) {
        this.idSicRol = idSicRol;
        this.descripcionRol = descripcionRol;
    }

    public Integer getIdSicRol() {
        return idSicRol;
    }

    public void setIdSicRol(Integer idSicRol) {
        this.idSicRol = idSicRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public String getDescripcionRol() {
        return descripcionRol;
    }

    public void setDescripcionRol(String descripcionRol) {
        this.descripcionRol = descripcionRol;
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

    public Date getFxModicado() {
        return fxModicado;
    }

    public void setFxModicado(Date fxModicado) {
        this.fxModicado = fxModicado;
    }

    public String getModicadoPor() {
        return modicadoPor;
    }

    public void setModicadoPor(String modicadoPor) {
        this.modicadoPor = modicadoPor;
    }

    @XmlTransient
    public List<SicUsuario> getSicUsuarioList() {
        return sicUsuarioList;
    }

    public void setSicUsuarioList(List<SicUsuario> sicUsuarioList) {
        this.sicUsuarioList = sicUsuarioList;
    }

    @XmlTransient
    public List<SicPermisosSistema> getSicPermisosSistemaList() {
        return sicPermisosSistemaList;
    }

    public void setSicPermisosSistemaList(List<SicPermisosSistema> sicPermisosSistemaList) {
        this.sicPermisosSistemaList = sicPermisosSistemaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSicRol != null ? idSicRol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SicRol)) {
            return false;
        }
        SicRol other = (SicRol) object;
        if ((this.idSicRol == null && other.idSicRol != null) || (this.idSicRol != null && !this.idSicRol.equals(other.idSicRol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uesocc.sicmec.model.entity.SicRol[ idSicRol=" + idSicRol + " ]";
    }
    
}
