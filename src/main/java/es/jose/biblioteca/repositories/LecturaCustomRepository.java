package es.jose.biblioteca.repositories;

/**
 * Repositorio personalizado para las lecturas
 *
 * @since 04-nov-2018
 * @author joseb85
 */
public interface LecturaCustomRepository {

    /**
     * Obtiene el año más antiguo de lectura
     *
     * @return Año más antiguo de lectura
     */
    String minYear();
}
