package es.jose.biblioteca.repositories;

import es.jose.biblioteca.entities.Pais;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Repositorio para la clase Pais
 * @since 28-oct-2018
 * @author joseb85
 */
public interface PaisRepository extends PagingAndSortingRepository<Pais, Long>{
}
