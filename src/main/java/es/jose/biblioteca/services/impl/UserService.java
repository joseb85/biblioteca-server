package es.jose.biblioteca.services.impl;

import es.jose.biblioteca.entities.Usuario;
import es.jose.biblioteca.repositories.UserRepository;
import es.jose.biblioteca.services.ServiceInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @since 08-nov-2018
 * @author joseb85
 */
@Service(value = "userService")
public class UserService implements UserDetailsService, ServiceInterface<Usuario, Long>{

    @Autowired
    private UserRepository userDao;

    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        Usuario user = userDao.findByUsername(userId);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority());
    }

    private List<SimpleGrantedAuthority> getAuthority() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }
    
    @Override
    public List<Usuario> findAll() {
        List<Usuario> list = new ArrayList<>();
        userDao.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    public void delete(Long id) {
        userDao.deleteById(id);
    }

    public Usuario findOne(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public Usuario findById(Long id) {
        Optional<Usuario> result = userDao.findById(id);
        return result.isPresent() ? result.get() : null;
    }

    public Usuario save(Usuario user) {
        return userDao.save(user);
    }
}
