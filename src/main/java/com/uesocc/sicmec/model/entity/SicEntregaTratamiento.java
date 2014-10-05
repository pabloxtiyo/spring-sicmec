/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.uesocc.sicmec.model.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author xtiyo
 */
@Entity
@Table(name = "sic_entrega_tratamiento", catalog = "sicmec_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SicEntregaTratamiento.findAll", query = "SELECT s FROM SicEntregaTratamiento s"),
    @NamedQuery(name = "SicEntregaTratamiento.findByIdSicEntregaTratamiento", query = "SELECT s FROM SicEntregaTratamiento s WHERE s.idSicEntregaTratamiento = :idSicEntregaTratamiento"),
    @NamedQuery(name = "SicEntregaTratamiento.findByComentario", query = "SELECT s FROM SicEntregaTratamiento s WHERE s.comentario = :comentario"),
    @NamedQuery(name = "SicEntregaTratamiento.findByFxEntregaTratamiento", query = "SELECT s FROM SicEntregaTratamiento s WHERE s.fxEntregaTratamiento = :fxEntregaTratamiento")})
public class SicEntregaTratamiento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_sic_entrega_tratamiento")
    private Integer idSicEntregaTratamiento;
    @Basic(optional = false)
    private String comentario;
    @Column(name = "fx_entrega_tratamiento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fxEntregaTratamiento;
    @JoinColumn(name = "fk_sic_tratamiento", referencedColumnName = "id_sic_tratamiento")
    @ManyToOne(optional = false)
    private SicTratamiento fkSicTratamiento;

    public SicEntregaTratamiento() {
    }

    public SicEntregaTratamiento(Integer idSicEntregaTratamiento) {
        this.idSicEntregaTratamiento = idSicEntregaTratamiento;
    }

    public SicEntregaTratamiento(Integer idSicEntregaTratamiento, String comentario) {
        this.idSicEntregaTratamiento = idSicEntregaTratamiento;
        this.comentario = comentario;
    }

    public Integer getIdSicEntregaTratamiento() {
        return idSicEntregaTratamiento;
    }

    public void setIdSicEntregaTratamiento(Integer idSicEntregaTratamiento) {
        this.idSicEntregaTratamiento = idSicEntregaTratamiento;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getFxEntregaTratamiento() {
        return fxEntregaTratamiento;
    }

    public void setFxEntregaTratamiento(Date fxEntregaTratamiento) {
        this.fxEntregaTratamiento = fxEntregaTratamiento;
    }

    public SicTratamiento getFkSicTratamiento() {
        return fkSicTratamiento;
    }

    public void setFkSicTratamiento(SicTratamiento fkSicTratamiento) {
        this.fkSicTratamiento = fkSicTratamiento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSicEntregaTratamiento != null ? idSicEntregaTratamiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SicEntregaTratamiento)) {
            return false;
        }
        SicEntregaTratamiento other = (SicEntregaTratamiento) object;
        if ((this.idSicEntregaTratamiento == null && other.idSicEntregaTratamiento != null) || (this.idSicEntregaTratamiento != null && !this.idSicEntregaTratamiento.equals(other.idSicEntregaTratamiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uesocc.model.entity.SicEntregaTratamiento[ idSicEntregaTratamiento=" + idSicEntregaTratamiento + " ]";
    }
    
}
