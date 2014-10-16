/*
 * To change this template, choose Tools | Templates
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author xtiyo
 */
@Entity
@Table(name = "sic_tratamiento_medicamento", catalog = "sicmec_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SicTratamientoMedicamento.findAll", query = "SELECT s FROM SicTratamientoMedicamento s"),
    @NamedQuery(name = "SicTratamientoMedicamento.findByIdSicTratamientoMedicamento", query = "SELECT s FROM SicTratamientoMedicamento s WHERE s.idSicTratamientoMedicamento = :idSicTratamientoMedicamento"),
    @NamedQuery(name = "SicTratamientoMedicamento.findByCantidadDosis", query = "SELECT s FROM SicTratamientoMedicamento s WHERE s.cantidadDosis = :cantidadDosis")})
public class SicTratamientoMedicamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_sic_tratamiento_medicamento", nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idSicTratamientoMedicamento;
    @Column(name = "cantidad_dosis", length = 100)
    private String cantidadDosis;
    @JoinColumn(name = "fk_sic_tratamiento", referencedColumnName = "id_sic_tratamiento", nullable = false)
    @ManyToOne(optional = false)
    private SicTratamiento fkSicTratamiento;
    @JoinColumn(name = "fk_sic_medicamento", referencedColumnName = "id_sic_medicamento", nullable = false)
    @ManyToOne(optional = false)
    private SicMedicamento fkSicMedicamento;

    public SicTratamientoMedicamento() {
    }

    public SicTratamientoMedicamento(Integer idSicTratamientoMedicamento) {
        this.idSicTratamientoMedicamento = idSicTratamientoMedicamento;
    }

    public Integer getIdSicTratamientoMedicamento() {
        return idSicTratamientoMedicamento;
    }

    public void setIdSicTratamientoMedicamento(Integer idSicTratamientoMedicamento) {
        this.idSicTratamientoMedicamento = idSicTratamientoMedicamento;
    }

    public String getCantidadDosis() {
        return cantidadDosis;
    }

    public void setCantidadDosis(String cantidadDosis) {
        this.cantidadDosis = cantidadDosis;
    }

    public SicTratamiento getFkSicTratamiento() {
        return fkSicTratamiento;
    }

    public void setFkSicTratamiento(SicTratamiento fkSicTratamiento) {
        this.fkSicTratamiento = fkSicTratamiento;
    }

    public SicMedicamento getFkSicMedicamento() {
        return fkSicMedicamento;
    }

    public void setFkSicMedicamento(SicMedicamento fkSicMedicamento) {
        this.fkSicMedicamento = fkSicMedicamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSicTratamientoMedicamento != null ? idSicTratamientoMedicamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SicTratamientoMedicamento)) {
            return false;
        }
        SicTratamientoMedicamento other = (SicTratamientoMedicamento) object;
        if ((this.idSicTratamientoMedicamento == null && other.idSicTratamientoMedicamento != null) || (this.idSicTratamientoMedicamento != null && !this.idSicTratamientoMedicamento.equals(other.idSicTratamientoMedicamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uesocc.sicmec.model.entity.SicTratamientoMedicamento[ idSicTratamientoMedicamento=" + idSicTratamientoMedicamento + " ]";
    }
    
}
