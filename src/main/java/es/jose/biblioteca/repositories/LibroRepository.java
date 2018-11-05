package es.jose.biblioteca.repositories;

import es.jose.biblioteca.entities.Libro;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Repositorio para la clase Libro
 * @since 28-oct-2018
 * @author joseb85
 */
public interface LibroRepository extends PagingAndSortingRepository<Libro, Long>, LibroCustomRepository{
    
}
