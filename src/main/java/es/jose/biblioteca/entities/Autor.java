package es.jose.biblioteca.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Representa el autor de un libro
 * @since 28-oct-2018
 * @author joseb85
 */
@Entity
@Table(catalog = "biblioteca_test", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"nombre"})})
@XmlRootElement
public class Autor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(nullable = false, length = 64)
    private String nombre;
    @Size(max = 1)
    @Column(length = 1)
    private String sexo;
//    @JoinTable(name = "libro_autor", joinColumns = {
//        @JoinColumn(name = "id_autor", referencedColumnName = "id", nullable = false)}, inverseJoinColumns = {
//        @JoinColumn(name = "id_libro", referencedColumnName = "id", nullable = false)})
//    @ManyToMany(fetch = FetchType.EAGER)
//    private Collection<Libro> libroCollection;
    @JoinColumn(name = "pais", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Pais pais;

    public Autor() {
    }

    public Autor(Long id) {
        this.id = id;
    }

    public Autor(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

//    @XmlTransient
//    public Collection<Libro> getLibroCollection() {
//        return libroCollection;
//    }
//
//    public void setLibroCollection(Collection<Libro> libroCollection) {
//        this.libroCollection = libroCollection;
//    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Autor)) {
            return false;
        }
        Autor other = (Autor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.jose.biblioteca.entities.Autor[ id=" + id + " ]";
    }

}
