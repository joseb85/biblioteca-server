package es.jose.biblioteca.support;

import java.util.List;
import org.springframework.data.domain.Pageable;

/**
 * Propiedades de los libros a filtrar
 * @since 04-nov-2018
 * @author joseb85
 */
public class FiltroLibro {
    /* Título de los libros para filtrar */
    private String titulo;
    /* Géneros de los libros para filtrar */
    private List<Long> generos;
    /* Año de los libros (desde este año) para filtrar */
    private Integer desdeAgno;
    /* Año de los libros (hasta este año) para filtrar */
    private Integer hastaAgno;
    /* Páginas de los libros (desde esta página) para filtrar */
    private Integer desdePaginas;
    /* Páginas de los libros (hasta esta página) para filtrar */
    private Integer hastaPaginas;
    /* Autores de los libros para filtrar */
    private List<Long> autores;
    /* Sexo de los autores para filtrar */
    private List<String> sexos;
    /* País de los autores para filtrar */
    private List<Long> paises;
    /* Continentes de los autores para filtrar */
    private List<String> continentes;
    /* Tags de los libros para filtrar */
    private List<Long> tags;
    /* Colecciones de los libros para filtrar */
    private List<Long> colecciones;
    /* Año de lectura de los libros (desde este año) para filtrar */
    private String desdeLectura;
    /* Año de lectura de los libros (hasta este año) para filtrar */
    private String hastaLectura;
    /* Operador para encadenar los filtros. True: 'or', False: 'and'. Por defecto 'and'. */
    private Boolean or = false;
    Pageable pageable;
    public List<String> getSexos() {
        return sexos;
    }

    public void setSexos(List<String> sexos) {
        this.sexos = sexos;
    }

    public List<String> getContinentes() {
        return continentes;
    }

    public void setContinentes(List<String> continentes) {
        this.continentes = continentes;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public String getTituloForBd() {
        String result = titulo != null ? titulo : "";
        return result;
    }

    public Integer getDesdePaginas() {
        return desdePaginas;
    }

    public void setDesdePaginas(Integer desdePaginas) {
        this.desdePaginas = desdePaginas;
    }

    public Integer getHastaPaginas() {
        return hastaPaginas;
    }

    public void setHastaPaginas(Integer hastaPaginas) {
        this.hastaPaginas = hastaPaginas;
    }

    public Integer getDesdeAgno() {
        return desdeAgno;
    }

    public void setDesdeAgno(Integer desdeAgno) {
        this.desdeAgno = desdeAgno;
    }

    public Integer getHastaAgno() {
        return hastaAgno;
    }

    public void setHastaAgno(Integer hastaAgno) {
        this.hastaAgno = hastaAgno;
    }

    public List<Long> getAutores() {
        return autores;
    }

    public void setAutores(List<Long> autores) {
        this.autores = autores;
    }

    public List<Long> getPaises() {
        return paises;
    }

    public void setPaises(List<Long> paises) {
        this.paises = paises;
    }

    public List<Long> getGeneros() {
        return generos;
    }

    public void setGeneros(List<Long> generos) {
        this.generos = generos;
    }

    public List<Long> getTags() {
        return tags;
    }

    public void setTags(List<Long> tags) {
        this.tags = tags;
    }

    public List<Long> getColecciones() {
        return colecciones;
    }

    public void setColecciones(List<Long> colecciones) {
        this.colecciones = colecciones;
    }

    public String getDesdeLectura() {
        return desdeLectura;
    }

    public void setDesdeLectura(String desdeLectura) {
        this.desdeLectura = desdeLectura;
    }

    public String getHastaLectura() {
        return hastaLectura;
    }

    public void setHastaLectura(String hastaLectura) {
        this.hastaLectura = hastaLectura;
    }

    public Boolean getOr() {
        return or;
    }

    public void setOr(Boolean or) {
        this.or = or;
    }
    
}
