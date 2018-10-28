package es.jose.biblioteca.services.impl;

import es.jose.biblioteca.entities.Lectura;
import es.jose.biblioteca.entities.Lectura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import es.jose.biblioteca.repositories.LecturaRepository;
import es.jose.biblioteca.services.ServiceInterface;
import java.util.List;
import java.util.Optional;

/**
 * Servicio para la clase Lectura
 * @since 28-oct-2018
 * @author joseb85
 */
@Service
public class LecturaService implements ServiceInterface<Lectura, Integer> {
    
    @Autowired
    private LecturaRepository lecturaRepository;

    @Override
    public List<Lectura> findAll() {
        return (List<Lectura>) lecturaRepository.findAll();
    }

    @Override
    public Lectura findById(Integer id) {
        Optional<Lectura> result = lecturaRepository.findById(id);
        return result.isPresent() ? result.get() : null;
    }
    
}
