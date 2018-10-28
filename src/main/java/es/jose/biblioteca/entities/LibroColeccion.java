package es.jose.biblioteca.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Representa la relación entre un libro y una colección
 * @since 28-oct-2018
 * @author joseb85
 */
@Entity
@Table(name = "libro_coleccion", catalog = "biblioteca_test", schema = "")
@XmlRootElement
public class LibroColeccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LibroColeccionPK libroColeccionPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(nullable = false, length = 8)
    private String orden;
    @JoinColumn(name = "id_libro", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Libro libro;
    @JoinColumn(name = "id_coleccion", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Coleccion coleccion;

    public LibroColeccion() {
    }

    public LibroColeccion(LibroColeccionPK libroColeccionPK) {
        this.libroColeccionPK = libroColeccionPK;
    }

    public LibroColeccion(LibroColeccionPK libroColeccionPK, String orden) {
        this.libroColeccionPK = libroColeccionPK;
        this.orden = orden;
    }

    public LibroColeccion(int idLibro, int idColeccion) {
        this.libroColeccionPK = new LibroColeccionPK(idLibro, idColeccion);
    }

    public LibroColeccionPK getLibroColeccionPK() {
        return libroColeccionPK;
    }

    public void setLibroColeccionPK(LibroColeccionPK libroColeccionPK) {
        this.libroColeccionPK = libroColeccionPK;
    }

    public String getOrden() {
        return orden;
    }

    public void setOrden(String orden) {
        this.orden = orden;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Coleccion getColeccion() {
        return coleccion;
    }

    public void setColeccion(Coleccion coleccion) {
        this.coleccion = coleccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (libroColeccionPK != null ? libroColeccionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LibroColeccion)) {
            return false;
        }
        LibroColeccion other = (LibroColeccion) object;
        if ((this.libroColeccionPK == null && other.libroColeccionPK != null) || (this.libroColeccionPK != null && !this.libroColeccionPK.equals(other.libroColeccionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.jose.biblioteca.entities.LibroColeccion[ libroColeccionPK=" + libroColeccionPK + " ]";
    }

}
