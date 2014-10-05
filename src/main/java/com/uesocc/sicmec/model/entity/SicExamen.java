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
@Table(name = "sic_examen", catalog = "sicmec_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SicExamen.findAll", query = "SELECT s FROM SicExamen s"),
    @NamedQuery(name = "SicExamen.findByIdSicExamen", query = "SELECT s FROM SicExamen s WHERE s.idSicExamen = :idSicExamen"),
    @NamedQuery(name = "SicExamen.findByNombreExamen", query = "SELECT s FROM SicExamen s WHERE s.nombreExamen = :nombreExamen"),
    @NamedQuery(name = "SicExamen.findByDescripcionExamen", query = "SELECT s FROM SicExamen s WHERE s.descripcionExamen = :descripcionExamen"),
    @NamedQuery(name = "SicExamen.findByFxCreado", query = "SELECT s FROM SicExamen s WHERE s.fxCreado = :fxCreado"),
    @NamedQuery(name = "SicExamen.findByCreadoPor", query = "SELECT s FROM SicExamen s WHERE s.creadoPor = :creadoPor"),
    @NamedQuery(name = "SicExamen.findByFxModificado", query = "SELECT s FROM SicExamen s WHERE s.fxModificado = :fxModificado"),
    @NamedQuery(name = "SicExamen.findByModifcadoPor", query = "SELECT s FROM SicExamen s WHERE s.modifcadoPor = :modifcadoPor")})
public class SicExamen implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_sic_examen")
    private Integer idSicExamen;
    @Column(name = "nombre_examen")
    private String nombreExamen;
    @Basic(optional = false)
    @Column(name = "descripcion_examen")
    private String descripcionExamen;
    @Column(name = "fx_creado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fxCreado;
    @Column(name = "creado_por")
    private String creadoPor;
    @Column(name = "fx_modificado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fxModificado;
    @Column(name = "modifcado_por")
    private String modifcadoPor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkSicExamen")
    private List<SicExamenCita> sicExamenCitaList;

    public SicExamen() {
    }

    public SicExamen(Integer idSicExamen) {
        this.idSicExamen = idSicExamen;
    }

    public SicExamen(Integer idSicExamen, String descripcionExamen) {
        this.idSicExamen = idSicExamen;
        this.descripcionExamen = descripcionExamen;
    }

    public Integer getIdSicExamen() {
        return idSicExamen;
    }

    public void setIdSicExamen(Integer idSicExamen) {
        this.idSicExamen = idSicExamen;
    }

    public String getNombreExamen() {
        return nombreExamen;
    }

    public void setNombreExamen(String nombreExamen) {
        this.nombreExamen = nombreExamen;
    }

    public String getDescripcionExamen() {
        return descripcionExamen;
    }

    public void setDescripcionExamen(String descripcionExamen) {
        this.descripcionExamen = descripcionExamen;
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

    public String getModifcadoPor() {
        return modifcadoPor;
    }

    public void setModifcadoPor(String modifcadoPor) {
        this.modifcadoPor = modifcadoPor;
    }

    @XmlTransient
    public List<SicExamenCita> getSicExamenCitaList() {
        return sicExamenCitaList;
    }

    public void setSicExamenCitaList(List<SicExamenCita> sicExamenCitaList) {
        this.sicExamenCitaList = sicExamenCitaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSicExamen != null ? idSicExamen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SicExamen)) {
            return false;
        }
        SicExamen other = (SicExamen) object;
        if ((this.idSicExamen == null && other.idSicExamen != null) || (this.idSicExamen != null && !this.idSicExamen.equals(other.idSicExamen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uesocc.model.entity.SicExamen[ idSicExamen=" + idSicExamen + " ]";
    }
    
}
