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
@Table(name = "sic_cat_recurso", catalog = "sicmec_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SicCatRecurso.findAll", query = "SELECT s FROM SicCatRecurso s"),
    @NamedQuery(name = "SicCatRecurso.findByIdSicCatRecurso", query = "SELECT s FROM SicCatRecurso s WHERE s.idSicCatRecurso = :idSicCatRecurso"),
    @NamedQuery(name = "SicCatRecurso.findByDescripcion", query = "SELECT s FROM SicCatRecurso s WHERE s.descripcion = :descripcion")})
public class SicCatRecurso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_sic_cat_recurso", nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idSicCatRecurso;
    @Column(name = "descripcion", length = 30)
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkSicCatRecurso")
    private List<SicRecurso> sicRecursoList;

    public SicCatRecurso() {
    }

    public SicCatRecurso(Integer idSicCatRecurso) {
        this.idSicCatRecurso = idSicCatRecurso;
    }

    public Integer getIdSicCatRecurso() {
        return idSicCatRecurso;
    }

    public void setIdSicCatRecurso(Integer idSicCatRecurso) {
        this.idSicCatRecurso = idSicCatRecurso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<SicRecurso> getSicRecursoList() {
        return sicRecursoList;
    }

    public void setSicRecursoList(List<SicRecurso> sicRecursoList) {
        this.sicRecursoList = sicRecursoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSicCatRecurso != null ? idSicCatRecurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SicCatRecurso)) {
            return false;
        }
        SicCatRecurso other = (SicCatRecurso) object;
        if ((this.idSicCatRecurso == null && other.idSicCatRecurso != null) || (this.idSicCatRecurso != null && !this.idSicCatRecurso.equals(other.idSicCatRecurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uesocc.sicmec.model.entity.SicCatRecurso[ idSicCatRecurso=" + idSicCatRecurso + " ]";
    }
    
}
