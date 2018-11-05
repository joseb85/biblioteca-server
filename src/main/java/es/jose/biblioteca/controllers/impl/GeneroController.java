package es.jose.biblioteca.controllers.impl;

import es.jose.biblioteca.controllers.ControllerImpl;
import es.jose.biblioteca.entities.Genero;
import es.jose.biblioteca.services.impl.GeneroService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controlador para la clase Genero
 * @since 28-oct-2018
 * @author joseb85
 */
@Controller
@RequestMapping("/genero")
public class GeneroController implements ControllerImpl<Genero, Long>{

    @Autowired
    private GeneroService generoService;
    
    /**
     * Solicita todos los géneros
     * @return Lista de géneros
     */
    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    @Override
    public ResponseEntity<List<Genero>> findAll() {
        List<Genero> result = generoService.findAll();
        return new ResponseEntity(result, HttpStatus.OK);
    }
    
    /**
     * Solicita un género por su id
     * @param id Id del género
     * @return Género solicitado
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    @Override
    public ResponseEntity<Genero> findById(@PathVariable("id") Long id) {
        Genero result = generoService.findById(id);
        return new ResponseEntity(result, HttpStatus.OK);
    }

}
