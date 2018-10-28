package es.jose.biblioteca.services.impl;

import es.jose.biblioteca.entities.Autor;
import es.jose.biblioteca.repositories.AutorRepository;
import es.jose.biblioteca.services.ServiceInterface;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Servicio para la clase Autor
 * @since 28-oct-2018
 * @author joseb85
 */
@Service
public class AutorService implements ServiceInterface<Autor, Long>{
    
    @Autowired
    private AutorRepository autorRepository;

    /**
     * Obtiene y devuelve todos los autores
     * @return Lista de autores
     */
    @Override
    public List<Autor> findAll() {
        return (List<Autor>) autorRepository.findAll();
    }

    /**
     * Obtiene y devuelve un autor por su id
     * @param id Id del autor
     * @return Autor solicitado
     */
    @Override
    public Autor findById(Long id) {
        Optional<Autor> result = autorRepository.findById(id);
        return result.isPresent() ? result.get() : null;
    }

}
