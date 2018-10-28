package es.jose.biblioteca.repositories;

import es.jose.biblioteca.entities.LibroColeccion;
import es.jose.biblioteca.entities.LibroColeccionPK;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Repositorio para la clase LibroColeccion
 * @since 28-oct-2018
 * @author joseb85
 */
public interface LibroColeccionRepository extends PagingAndSortingRepository<LibroColeccion, LibroColeccionPK>{

}
