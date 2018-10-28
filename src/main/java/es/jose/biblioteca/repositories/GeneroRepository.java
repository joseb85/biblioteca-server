package es.jose.biblioteca.repositories;

import es.jose.biblioteca.entities.Genero;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Repositorio para la clase Genero
 * @since 28-oct-2018
 * @author joseb85
 */
public interface GeneroRepository extends PagingAndSortingRepository<Genero, Long>{
}
