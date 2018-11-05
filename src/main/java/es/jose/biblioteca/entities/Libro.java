package es.jose.biblioteca.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.Set;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Representa un libro
 *
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
    @Size(max = 255)
    @Column(length = 255)
    private String observaciones;

    @JsonManagedReference
    @JoinTable(name = "libro_tag", joinColumns = {
        @JoinColumn(name = "id_libro", referencedColumnName = "id", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "id_tag", referencedColumnName = "id", nullable = false)})
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Tag> tags;
    @JsonManagedReference
    @JoinTable(name = "libro_autor", joinColumns = {
        @JoinColumn(name = "id_libro", referencedColumnName = "id", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "id_autor", referencedColumnName = "id", nullable = false)})
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Autor> autores;
    @JoinColumn(name = "id_genero", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Genero genero;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "libro", fetch = FetchType.EAGER)
    private Set<LibroColeccion> colecciones;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "libro", fetch = FetchType.EAGER)
    private Set<Lectura> lecturas;

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

    public boolean isArchivo() {
        return archivo;
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

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public Set<Autor> getAutores() {
        return autores;
    }

    public void setAutores(Set<Autor> autores) {
        this.autores = autores;
    }

    public Set<LibroColeccion> getColecciones() {
        return colecciones;
    }

    public void setColecciones(Set<LibroColeccion> colecciones) {
        this.colecciones = colecciones;
    }

    public Set<Lectura> getLecturas() {
        return lecturas;
    }

    public void setLecturas(Set<Lectura> lecturas) {
        this.lecturas = lecturas;
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
