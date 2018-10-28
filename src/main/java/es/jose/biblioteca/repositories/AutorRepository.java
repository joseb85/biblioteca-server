package es.jose.biblioteca.repositories;

import es.jose.biblioteca.entities.Autor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Repositorio para la clase Autor
 * @since 28-oct-2018
 * @author joseb85
 */
public interface AutorRepository extends PagingAndSortingRepository<Autor, Long>{
   
}
