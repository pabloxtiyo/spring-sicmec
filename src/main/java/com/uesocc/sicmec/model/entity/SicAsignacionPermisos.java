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
@Table(name = "sic_asignacion_permisos", catalog = "sicmec_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SicAsignacionPermisos.findAll", query = "SELECT s FROM SicAsignacionPermisos s"),
    @NamedQuery(name = "SicAsignacionPermisos.findByIdSicAsignacionPermisos", query = "SELECT s FROM SicAsignacionPermisos s WHERE s.idSicAsignacionPermisos = :idSicAsignacionPermisos"),
    @NamedQuery(name = "SicAsignacionPermisos.findByAgregar", query = "SELECT s FROM SicAsignacionPermisos s WHERE s.agregar = :agregar"),
    @NamedQuery(name = "SicAsignacionPermisos.findByModificar", query = "SELECT s FROM SicAsignacionPermisos s WHERE s.modificar = :modificar"),
    @NamedQuery(name = "SicAsignacionPermisos.findByEliminar", query = "SELECT s FROM SicAsignacionPermisos s WHERE s.eliminar = :eliminar")})
public class SicAsignacionPermisos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_sic_asignacion_permisos", nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idSicAsignacionPermisos;
    @Basic(optional = false)
    @Column(name = "agregar", nullable = false)
    private boolean agregar;
    @Basic(optional = false)
    @Column(name = "modificar", nullable = false)
    private boolean modificar;
    @Basic(optional = false)
    @Column(name = "eliminar", nullable = false)
    private boolean eliminar;
    @JoinColumn(name = "fk_sic_recurso", referencedColumnName = "id_sic_recurso", nullable = false)
    @ManyToOne(optional = false)
    private SicRecurso fkSicRecurso;
    @JoinColumn(name = "fk_sic_permisos_sistema", referencedColumnName = "id_sic_permisos_sistema", nullable = false)
    @ManyToOne(optional = false)
    private SicPermisosSistema fkSicPermisosSistema;

    public SicAsignacionPermisos() {
    }

    public SicAsignacionPermisos(Integer idSicAsignacionPermisos) {
        this.idSicAsignacionPermisos = idSicAsignacionPermisos;
    }

    public SicAsignacionPermisos(Integer idSicAsignacionPermisos, boolean agregar, boolean modificar, boolean eliminar) {
        this.idSicAsignacionPermisos = idSicAsignacionPermisos;
        this.agregar = agregar;
        this.modificar = modificar;
        this.eliminar = eliminar;
    }

    public Integer getIdSicAsignacionPermisos() {
        return idSicAsignacionPermisos;
    }

    public void setIdSicAsignacionPermisos(Integer idSicAsignacionPermisos) {
        this.idSicAsignacionPermisos = idSicAsignacionPermisos;
    }

    public boolean getAgregar() {
        return agregar;
    }

    public void setAgregar(boolean agregar) {
        this.agregar = agregar;
    }

    public boolean getModificar() {
        return modificar;
    }

    public void setModificar(boolean modificar) {
        this.modificar = modificar;
    }

    public boolean getEliminar() {
        return eliminar;
    }

    public void setEliminar(boolean eliminar) {
        this.eliminar = eliminar;
    }

    public SicRecurso getFkSicRecurso() {
        return fkSicRecurso;
    }

    public void setFkSicRecurso(SicRecurso fkSicRecurso) {
        this.fkSicRecurso = fkSicRecurso;
    }

    public SicPermisosSistema getFkSicPermisosSistema() {
        return fkSicPermisosSistema;
    }

    public void setFkSicPermisosSistema(SicPermisosSistema fkSicPermisosSistema) {
        this.fkSicPermisosSistema = fkSicPermisosSistema;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSicAsignacionPermisos != null ? idSicAsignacionPermisos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SicAsignacionPermisos)) {
            return false;
        }
        SicAsignacionPermisos other = (SicAsignacionPermisos) object;
        if ((this.idSicAsignacionPermisos == null && other.idSicAsignacionPermisos != null) || (this.idSicAsignacionPermisos != null && !this.idSicAsignacionPermisos.equals(other.idSicAsignacionPermisos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uesocc.sicmec.model.entity.SicAsignacionPermisos[ idSicAsignacionPermisos=" + idSicAsignacionPermisos + " ]";
    }
    
}
