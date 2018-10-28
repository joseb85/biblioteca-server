package es.jose.biblioteca.services.impl;

import es.jose.biblioteca.entities.Pais;
import es.jose.biblioteca.entities.Pais;
import es.jose.biblioteca.repositories.PaisRepository;
import es.jose.biblioteca.services.ServiceInterface;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Servicio para la clase Pais
 * @since 28-oct-2018
 * @author joseb85
 */
@Service
public class PaisService implements ServiceInterface<Pais, Long> {
    
    @Autowired
    private PaisRepository paisRepository;

    @Override
    public List<Pais> findAll() {
        return (List<Pais>) paisRepository.findAll();
    }

    @Override
    public Pais findById(Long id) {
        Optional<Pais> result = paisRepository.findById(id);
        return result.isPresent() ? result.get() : null;
    }

}
