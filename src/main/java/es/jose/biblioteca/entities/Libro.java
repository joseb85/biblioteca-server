package es.jose.biblioteca.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Representa un libro
 * @since 28-oct-2018
 * @author joseb85
 */
@Entity
@Table(catalog = "biblioteca_test", schema = "")
@XmlRootElement
public class Libro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(nullable = false, length = 128)
    private String nombre;
    @Lob
    @Size(max = 65535)
    @Column(length = 65535)
    private String argumento;
    private Integer agno;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private boolean archivo;
    private Integer paginas;
    private Integer interes;
    @Size(max = 150)
    @Column(length = 150)
    private String fichero;
    @Size(max = 32)
    @Column(length = 32)
    private String genero;
    @Size(max = 255)
    @Column(length = 255)
    private String observaciones;
    
//    @JoinTable(name = "libro_tag", joinColumns = {
//        @JoinColumn(name = "id_libro", referencedColumnName = "id", nullable = false)}, inverseJoinColumns = {
//        @JoinColumn(name = "id_tag", referencedColumnName = "id", nullable = false)})
//    @ManyToMany(fetch = FetchType.EAGER)
//    private Collection<Tag> tagsCollection;
//    @ManyToMany(mappedBy = "libroCollection", fetch = FetchType.EAGER)
//    private Collection<Autor> autorCollection;
//    @JoinColumn(name = "id_genero", referencedColumnName = "id")
//    @ManyToOne(fetch = FetchType.EAGER)
//    private Genero idGenero;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "libro", fetch = FetchType.EAGER)
//    private Collection<LibroColeccion> libroColeccionCollection;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idLibro", fetch = FetchType.EAGER)
//    private Collection<Lectura> lecturaCollection;

    public Libro() {
    }

    public Libro(Long id) {
        this.id = id;
    }

    public Libro(Long id, String nombre, boolean archivo) {
        this.id = id;
        this.nombre = nombre;
        this.archivo = archivo;
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

    public String getArgumento() {
        return argumento;
    }

    public void setArgumento(String argumento) {
        this.argumento = argumento;
    }

    public Integer getAgno() {
        return agno;
    }

    public void setAgno(Integer agno) {
        this.agno = agno;
    }

    public boolean getArchivo() {
        return archivo;
    }

    public void setArchivo(boolean archivo) {
        this.archivo = archivo;
    }

    public Integer getPaginas() {
        return paginas;
    }

    public void setPaginas(Integer paginas) {
        this.paginas = paginas;
    }

    public Integer getInteres() {
        return interes;
    }

    public void setInteres(Integer interes) {
        this.interes = interes;
    }

    public String getFichero() {
        return fichero;
    }

    public void setFichero(String fichero) {
        this.fichero = fichero;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
//
//    @XmlTransient
//    public Collection<Tag> getTagsCollection() {
//        return tagsCollection;
//    }
//
//    public void setTagsCollection(Collection<Tag> tagsCollection) {
//        this.tagsCollection = tagsCollection;
//    }
//
//    @XmlTransient
//    public Collection<Autor> getAutorCollection() {
//        return autorCollection;
//    }
//
//    public void setAutorCollection(Collection<Autor> autorCollection) {
//        this.autorCollection = autorCollection;
//    }
//
//    public Genero getIdGenero() {
//        return idGenero;
//    }
//
//    public void setIdGenero(Genero idGenero) {
//        this.idGenero = idGenero;
//    }
//
//    @XmlTransient
//    public Collection<LibroColeccion> getLibroColeccionCollection() {
//        return libroColeccionCollection;
//    }
//
//    public void setLibroColeccionCollection(Collection<LibroColeccion> libroColeccionCollection) {
//        this.libroColeccionCollection = libroColeccionCollection;
//    }
//
//    @XmlTransient
//    public Collection<Lectura> getLecturaCollection() {
//        return lecturaCollection;
//    }
//
//    public void setLecturaCollection(Collection<Lectura> lecturaCollection) {
//        this.lecturaCollection = lecturaCollection;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Libro)) {
            return false;
        }
        Libro other = (Libro) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.jose.biblioteca.entities.Libro[ id=" + id + " ]";
    }

}
