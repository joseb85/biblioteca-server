package es.jose.biblioteca.controllers;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @param <T> Clase
 * @param <U> Clave primaria
 * @since 28-oct-2018
 * @author joseb85
 */
public interface ControllerImpl<T, U> {

//    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    ResponseEntity<List<T>> findAll();

//    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    ResponseEntity<T> findById(@PathVariable("id") U id);
}
