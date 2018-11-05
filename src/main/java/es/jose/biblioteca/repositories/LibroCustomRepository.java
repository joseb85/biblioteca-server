package es.jose.biblioteca.repositories;

import es.jose.biblioteca.entities.Libro;
import es.jose.biblioteca.support.FiltroLibro;
import java.util.List;

/**
 * Repositorio personalizado para los libros
 *
 * @since 04-nov-2018
 * @author joseb85
 */
public interface LibroCustomRepository {

    /**
     * Solicita una lista de libros filtrada a partir de unos parámetros de
     * búsqueda
     *
     * @param filtro Filtro con los parámetros de búsqueda
     * @return Lista de libros solicitada
     */
    List<Libro> filter(FiltroLibro filtro);
}
