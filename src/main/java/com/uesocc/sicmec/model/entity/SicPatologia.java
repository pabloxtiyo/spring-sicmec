/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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

/**
 *
 * @author xtiyo
 */
@Entity
@Table(name = "sic_patologia", catalog = "sicmec_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SicPatologia.findAll", query = "SELECT s FROM SicPatologia s"),
    @NamedQuery(name = "SicPatologia.findByIdSicPatologia", query = "SELECT s FROM SicPatologia s WHERE s.idSicPatologia = :idSicPatologia"),
    @NamedQuery(name = "SicPatologia.findByNombrePatologia", query = "SELECT s FROM SicPatologia s WHERE s.nombrePatologia = :nombrePatologia"),
    @NamedQuery(name = "SicPatologia.findByDescripcionPatologia", query = "SELECT s FROM SicPatologia s WHERE s.descripcionPatologia = :descripcionPatologia"),
    @NamedQuery(name = "SicPatologia.findByFxCreado", query = "SELECT s FROM SicPatologia s WHERE s.fxCreado = :fxCreado"),
    @NamedQuery(name = "SicPatologia.findByCreadoPor", query = "SELECT s FROM SicPatologia s WHERE s.creadoPor = :creadoPor"),
    @NamedQuery(name = "SicPatologia.findByFxModicado", query = "SELECT s FROM SicPatologia s WHERE s.fxModicado = :fxModicado"),
    @NamedQuery(name = "SicPatologia.findByModifcadoPor", query = "SELECT s FROM SicPatologia s WHERE s.modifcadoPor = :modifcadoPor")})
public class SicPatologia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_sic_patologia")
    private Integer idSicPatologia;
    @Column(name = "nombre_patologia")
    private String nombrePatologia;
    @Basic(optional = false)
    @Column(name = "descripcion_patologia")
    private String descripcionPatologia;
    @Column(name = "fx_creado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fxCreado;
    @Column(name = "creado_por")
    private String creadoPor;
    @Column(name = "fx_modicado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fxModicado;
    @Column(name = "modifcado_por")
    private String modifcadoPor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkSicPatologia")
    private List<SicTipoPatologia> sicTipoPatologiaList;

    public SicPatologia() {
    }

    public SicPatologia(Integer idSicPatologia) {
        this.idSicPatologia = idSicPatologia;
    }

    public SicPatologia(Integer idSicPatologia, String descripcionPatologia) {
        this.idSicPatologia = idSicPatologia;
        this.descripcionPatologia = descripcionPatologia;
    }

    public Integer getIdSicPatologia() {
        return idSicPatologia;
    }

    public void setIdSicPatologia(Integer idSicPatologia) {
        this.idSicPatologia = idSicPatologia;
    }

    public String getNombrePatologia() {
        return nombrePatologia;
    }

    public void setNombrePatologia(String nombrePatologia) {
        this.nombrePatologia = nombrePatologia;
    }

    public String getDescripcionPatologia() {
        return descripcionPatologia;
    }

    public void setDescripcionPatologia(String descripcionPatologia) {
        this.descripcionPatologia = descripcionPatologia;
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

    public String getModifcadoPor() {
        return modifcadoPor;
    }

    public void setModifcadoPor(String modifcadoPor) {
        this.modifcadoPor = modifcadoPor;
    }

    @XmlTransient
    public List<SicTipoPatologia> getSicTipoPatologiaList() {
        return sicTipoPatologiaList;
    }

    public void setSicTipoPatologiaList(List<SicTipoPatologia> sicTipoPatologiaList) {
        this.sicTipoPatologiaList = sicTipoPatologiaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSicPatologia != null ? idSicPatologia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SicPatologia)) {
            return false;
        }
        SicPatologia other = (SicPatologia) object;
        if ((this.idSicPatologia == null && other.idSicPatologia != null) || (this.idSicPatologia != null && !this.idSicPatologia.equals(other.idSicPatologia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uesocc.model.entity.SicPatologia[ idSicPatologia=" + idSicPatologia + " ]";
    }
    
}
