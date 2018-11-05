package es.jose.biblioteca.support;

import java.util.List;

/**
 * Clase utilizada para filtrar libros según unos parámetros
 * @since 04-nov-2018
 * @author joseb85
 */
public class FiltroLibro {
    /* Filtro para el nombre del libro */
    private String titulo;
    /* Filtro para el género del libro */
    private List<Long> generos;
    /* Filtro para el año del libro(desde este año) */
    private Integer desdeAgno;
    /* Filtro para el año del libro (hasta este año) */
    private Integer hastaAgno;
    /* Filtro para las páginas del libro (desde esta página) */
    private Integer desdePaginas;
    /* Filtro para las páginas del libro (hasta esta página) */
    private Integer hastaPaginas;
    /* Filtro para los autores del libro */
    private List<Long> autores;
    private List<String> sexos;
    private List<Long> paises;
    private List<String> continentes;
    /* Filtro para los tags del libro */
    private List<Long> tags;
    private List<Long> colecciones;
    private String desdeLectura;
    private String hastaLectura;
    /* Operador para encadenar filtros. True: 'or', False: 'and'. Por defecto 'and'. */
    private Boolean or = false;

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
