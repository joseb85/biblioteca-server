package es.jose.biblioteca.services.impl;

import es.jose.biblioteca.entities.Libro;
import es.jose.biblioteca.repositories.LibroRepository;
import es.jose.biblioteca.services.ServiceInterface;
import es.jose.biblioteca.support.FiltroLibro;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Servicio para la clase Libro
 * @since 28-oct-2018
 * @author joseb85
 */
@Service
public class LibroService implements ServiceInterface<Libro, Long> {

    @Autowired
    private LibroRepository libroRepository;

    @Override
    public List<Libro> findAll() {
        return (List<Libro>) libroRepository.findAll();
    }

    @Override
    public Libro findById(Long id) {
        Optional<Libro> result = libroRepository.findById(id);
        return result.isPresent() ? result.get() : null;
    }

    /**
     * Solicita una lista de libros filtrada a partir de unos parámetros de búsqueda
     * @param filtro Filtro con los parámetros de búsqueda
     * @return Lista de libros solicitada
     */
    public List<Libro> filter(FiltroLibro filtro) {
        return libroRepository.filter(filtro);
    }

}
