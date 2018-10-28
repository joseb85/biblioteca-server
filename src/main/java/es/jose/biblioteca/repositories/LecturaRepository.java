package es.jose.biblioteca.repositories;

import es.jose.biblioteca.entities.Lectura;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Repositorio para la clase Lectura
 * @since 28-oct-2018
 * @author joseb85
 */
public interface LecturaRepository extends PagingAndSortingRepository<Lectura, Integer>{
}
