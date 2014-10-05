/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.uesocc.sicmec.model.entity;

import java.io.Serializable;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author xtiyo
 */
@Entity
@Table(name = "sic_tipo_patologia", catalog = "sicmec_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SicTipoPatologia.findAll", query = "SELECT s FROM SicTipoPatologia s"),
    @NamedQuery(name = "SicTipoPatologia.findByIdSicTipoPatologia", query = "SELECT s FROM SicTipoPatologia s WHERE s.idSicTipoPatologia = :idSicTipoPatologia"),
    @NamedQuery(name = "SicTipoPatologia.findByNombreTipoPatologia", query = "SELECT s FROM SicTipoPatologia s WHERE s.nombreTipoPatologia = :nombreTipoPatologia"),
    @NamedQuery(name = "SicTipoPatologia.findByDescripcionTipoPatologia", query = "SELECT s FROM SicTipoPatologia s WHERE s.descripcionTipoPatologia = :descripcionTipoPatologia")})
public class SicTipoPatologia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_sic_tipo_patologia")
    private Integer idSicTipoPatologia;
    @Column(name = "nombre_tipo_patologia")
    private String nombreTipoPatologia;
    @Column(name = "descripcion_tipo_patologia")
    private String descripcionTipoPatologia;
    @OneToMany(mappedBy = "fkSicTipoPatologia")
    private List<SicPaciente> sicPacienteList;
    @JoinColumn(name = "fk_sic_patologia", referencedColumnName = "id_sic_patologia")
    @ManyToOne(optional = false)
    private SicPatologia fkSicPatologia;

    public SicTipoPatologia() {
    }

    public SicTipoPatologia(Integer idSicTipoPatologia) {
        this.idSicTipoPatologia = idSicTipoPatologia;
    }

    public Integer getIdSicTipoPatologia() {
        return idSicTipoPatologia;
    }

    public void setIdSicTipoPatologia(Integer idSicTipoPatologia) {
        this.idSicTipoPatologia = idSicTipoPatologia;
    }

    public String getNombreTipoPatologia() {
        return nombreTipoPatologia;
    }

    public void setNombreTipoPatologia(String nombreTipoPatologia) {
        this.nombreTipoPatologia = nombreTipoPatologia;
    }

    public String getDescripcionTipoPatologia() {
        return descripcionTipoPatologia;
    }

    public void setDescripcionTipoPatologia(String descripcionTipoPatologia) {
        this.descripcionTipoPatologia = descripcionTipoPatologia;
    }

    @XmlTransient
    public List<SicPaciente> getSicPacienteList() {
        return sicPacienteList;
    }

    public void setSicPacienteList(List<SicPaciente> sicPacienteList) {
        this.sicPacienteList = sicPacienteList;
    }

    public SicPatologia getFkSicPatologia() {
        return fkSicPatologia;
    }

    public void setFkSicPatologia(SicPatologia fkSicPatologia) {
        this.fkSicPatologia = fkSicPatologia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSicTipoPatologia != null ? idSicTipoPatologia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SicTipoPatologia)) {
            return false;
        }
        SicTipoPatologia other = (SicTipoPatologia) object;
        if ((this.idSicTipoPatologia == null && other.idSicTipoPatologia != null) || (this.idSicTipoPatologia != null && !this.idSicTipoPatologia.equals(other.idSicTipoPatologia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uesocc.model.entity.SicTipoPatologia[ idSicTipoPatologia=" + idSicTipoPatologia + " ]";
    }
    
}
