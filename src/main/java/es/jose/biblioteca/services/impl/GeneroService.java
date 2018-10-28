package es.jose.biblioteca.services.impl;

import es.jose.biblioteca.entities.Coleccion;
import es.jose.biblioteca.entities.Genero;
import es.jose.biblioteca.repositories.GeneroRepository;
import es.jose.biblioteca.services.ServiceInterface;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Servicio para la clase Genero
 * @since 28-oct-2018
 * @author joseb85
 */
@Service
public class GeneroService implements ServiceInterface<Genero, Long>{
    
    @Autowired
    private GeneroRepository generoRepository;

    @Override
    public List<Genero> findAll() {
        return (List<Genero>) generoRepository.findAll();
    }

    @Override
    public Genero findById(Long id) {
        Optional<Genero> result = generoRepository.findById(id);
        return result.isPresent() ? result.get() : null;
    }

}
