/*
 * To change this template, choose Tools | Templates
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
@Table(name = "sic_recurso", catalog = "sicmec_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SicRecurso.findAll", query = "SELECT s FROM SicRecurso s"),
    @NamedQuery(name = "SicRecurso.findByIdSicRecurso", query = "SELECT s FROM SicRecurso s WHERE s.idSicRecurso = :idSicRecurso"),
    @NamedQuery(name = "SicRecurso.findByUrlRecurso", query = "SELECT s FROM SicRecurso s WHERE s.urlRecurso = :urlRecurso"),
    @NamedQuery(name = "SicRecurso.findByDescripcionRecurso", query = "SELECT s FROM SicRecurso s WHERE s.descripcionRecurso = :descripcionRecurso")})
public class SicRecurso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_sic_recurso", nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idSicRecurso;
    @Column(name = "url_recurso", length = 100)
    private String urlRecurso;
    @Column(name = "descripcion_recurso", length = 300)
    private String descripcionRecurso;
    @JoinColumn(name = "fk_sic_cat_recurso", referencedColumnName = "id_sic_cat_recurso", nullable = false)
    @ManyToOne(optional = false)
    private SicCatRecurso fkSicCatRecurso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkSicRecurso")
    private List<SicAsignacionPermisos> sicAsignacionPermisosList;

    public SicRecurso() {
    }

    public SicRecurso(Integer idSicRecurso) {
        this.idSicRecurso = idSicRecurso;
    }

    public Integer getIdSicRecurso() {
        return idSicRecurso;
    }

    public void setIdSicRecurso(Integer idSicRecurso) {
        this.idSicRecurso = idSicRecurso;
    }

    public String getUrlRecurso() {
        return urlRecurso;
    }

    public void setUrlRecurso(String urlRecurso) {
        this.urlRecurso = urlRecurso;
    }

    public String getDescripcionRecurso() {
        return descripcionRecurso;
    }

    public void setDescripcionRecurso(String descripcionRecurso) {
        this.descripcionRecurso = descripcionRecurso;
    }

    public SicCatRecurso getFkSicCatRecurso() {
        return fkSicCatRecurso;
    }

    public void setFkSicCatRecurso(SicCatRecurso fkSicCatRecurso) {
        this.fkSicCatRecurso = fkSicCatRecurso;
    }

    @XmlTransient
    public List<SicAsignacionPermisos> getSicAsignacionPermisosList() {
        return sicAsignacionPermisosList;
    }

    public void setSicAsignacionPermisosList(List<SicAsignacionPermisos> sicAsignacionPermisosList) {
        this.sicAsignacionPermisosList = sicAsignacionPermisosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSicRecurso != null ? idSicRecurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SicRecurso)) {
            return false;
        }
        SicRecurso other = (SicRecurso) object;
        if ((this.idSicRecurso == null && other.idSicRecurso != null) || (this.idSicRecurso != null && !this.idSicRecurso.equals(other.idSicRecurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uesocc.sicmec.model.entity.SicRecurso[ idSicRecurso=" + idSicRecurso + " ]";
    }
    
}
