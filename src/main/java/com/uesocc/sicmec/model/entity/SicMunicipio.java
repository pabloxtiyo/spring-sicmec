/*
 * To change this template, choose Tools | Templates
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
@Table(name = "sic_municipio", catalog = "sicmec_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SicMunicipio.findAll", query = "SELECT s FROM SicMunicipio s"),
    @NamedQuery(name = "SicMunicipio.findByIdSicMunicipio", query = "SELECT s FROM SicMunicipio s WHERE s.idSicMunicipio = :idSicMunicipio"),
    @NamedQuery(name = "SicMunicipio.findByNombreMunicipio", query = "SELECT s FROM SicMunicipio s WHERE s.nombreMunicipio = :nombreMunicipio")})
public class SicMunicipio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_sic_municipio", nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idSicMunicipio;
    @Column(name = "nombre_municipio", length = 50)
    private String nombreMunicipio;
    @OneToMany(mappedBy = "fkSicMunicipio")
    private List<SicPaciente> sicPacienteList;
    @JoinColumn(name = "fk_sic_departamento", referencedColumnName = "id_sic_departamento")
    @ManyToOne
    private SicDepartamento fkSicDepartamento;

    public SicMunicipio() {
    }

    public SicMunicipio(Integer idSicMunicipio) {
        this.idSicMunicipio = idSicMunicipio;
    }

    public Integer getIdSicMunicipio() {
        return idSicMunicipio;
    }

    public void setIdSicMunicipio(Integer idSicMunicipio) {
        this.idSicMunicipio = idSicMunicipio;
    }

    public String getNombreMunicipio() {
        return nombreMunicipio;
    }

    public void setNombreMunicipio(String nombreMunicipio) {
        this.nombreMunicipio = nombreMunicipio;
    }

    @XmlTransient
    public List<SicPaciente> getSicPacienteList() {
        return sicPacienteList;
    }

    public void setSicPacienteList(List<SicPaciente> sicPacienteList) {
        this.sicPacienteList = sicPacienteList;
    }

    public SicDepartamento getFkSicDepartamento() {
        return fkSicDepartamento;
    }

    public void setFkSicDepartamento(SicDepartamento fkSicDepartamento) {
        this.fkSicDepartamento = fkSicDepartamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSicMunicipio != null ? idSicMunicipio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SicMunicipio)) {
            return false;
        }
        SicMunicipio other = (SicMunicipio) object;
        if ((this.idSicMunicipio == null && other.idSicMunicipio != null) || (this.idSicMunicipio != null && !this.idSicMunicipio.equals(other.idSicMunicipio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uesocc.sicmec.model.entity.SicMunicipio[ idSicMunicipio=" + idSicMunicipio + " ]";
    }
    
}
