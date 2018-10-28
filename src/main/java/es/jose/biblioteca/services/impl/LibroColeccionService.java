package es.jose.biblioteca.services.impl;

import es.jose.biblioteca.entities.LibroColeccion;
import es.jose.biblioteca.entities.LibroColeccion;
import es.jose.biblioteca.entities.LibroColeccionPK;
import es.jose.biblioteca.repositories.LibroColeccionRepository;
import es.jose.biblioteca.services.ServiceInterface;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Servicio para la clase LibroColeccion
 * @since 28-oct-2018
 * @author joseb85
 */
@Service
public class LibroColeccionService implements ServiceInterface<LibroColeccion, LibroColeccionPK> {
    
    @Autowired
    private LibroColeccionRepository libroColeccionRepository;

    @Override
    public List<LibroColeccion> findAll() {
        return (List<LibroColeccion>) libroColeccionRepository.findAll();
    }

    @Override
    public LibroColeccion findById(LibroColeccionPK id) {
        Optional<LibroColeccion> result = libroColeccionRepository.findById(id);
        return result.isPresent() ? result.get() : null;
    }

    
}
