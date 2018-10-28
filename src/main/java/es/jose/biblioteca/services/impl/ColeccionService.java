package es.jose.biblioteca.services.impl;

import es.jose.biblioteca.entities.Autor;
import es.jose.biblioteca.entities.Coleccion;
import es.jose.biblioteca.repositories.ColeccionRepository;
import es.jose.biblioteca.services.ServiceInterface;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Servicio para la clase Coleccion
 * @since 28-oct-2018
 * @author joseb85
 */
@Service
public class ColeccionService implements ServiceInterface<Coleccion, Integer>{
    
    @Autowired
    private ColeccionRepository coleccionRepository;

    @Override
    public List<Coleccion> findAll() {
        return (List<Coleccion>) coleccionRepository.findAll();
    }

    @Override
    public Coleccion findById(Integer id) {
        Optional<Coleccion> result = coleccionRepository.findById(id);
        return result.isPresent() ? result.get() : null;
    }
}
