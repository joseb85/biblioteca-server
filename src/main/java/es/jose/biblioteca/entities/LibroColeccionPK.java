package es.jose.biblioteca.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 * Representa la clave primaria de LibroColeccion: libro y colección
 * @since 28-oct-2018
 * @author joseb85
 */
@Embeddable
public class LibroColeccionPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_libro", nullable = false)
    private int idLibro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_coleccion", nullable = false)
    private int idColeccion;

    public LibroColeccionPK() {
    }

    public LibroColeccionPK(int idLibro, int idColeccion) {
        this.idLibro = idLibro;
        this.idColeccion = idColeccion;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public int getIdColeccion() {
        return idColeccion;
    }

    public void setIdColeccion(int idColeccion) {
        this.idColeccion = idColeccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idLibro;
        hash += (int) idColeccion;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LibroColeccionPK)) {
            return false;
        }
        LibroColeccionPK other = (LibroColeccionPK) object;
        if (this.idLibro != other.idLibro) {
            return false;
        }
        if (this.idColeccion != other.idColeccion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.jose.biblioteca.entities.LibroColeccionPK[ idLibro=" + idLibro + ", idColeccion=" + idColeccion + " ]";
    }

}
