package es.jose.biblioteca.repositories;

import es.jose.biblioteca.entities.Usuario;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.security.core.userdetails.User;

/**
 * @since 08-nov-2018
 * @author joseb85
 */
public interface UserRepository extends PagingAndSortingRepository<Usuario, Long> {

    public Usuario findByUsername(String username);

}
