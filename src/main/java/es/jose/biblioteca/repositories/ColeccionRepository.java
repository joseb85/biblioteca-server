package es.jose.biblioteca.repositories;

import es.jose.biblioteca.entities.Coleccion;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * 
 * @author joseb85
 */
public interface ColeccionRepository extends PagingAndSortingRepository<Coleccion, Integer>{

}
