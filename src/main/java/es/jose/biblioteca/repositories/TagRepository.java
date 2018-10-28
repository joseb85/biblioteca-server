package es.jose.biblioteca.repositories;

import es.jose.biblioteca.entities.Tag;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Repositorio para la clase Tag
 * @since 28-oct-2018
 * @author joseb85
 */
public interface TagRepository extends PagingAndSortingRepository<Tag, Long>{
}
