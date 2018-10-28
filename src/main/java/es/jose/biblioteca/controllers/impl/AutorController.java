package es.jose.biblioteca.controllers.impl;

import es.jose.biblioteca.controllers.ControllerImpl;
import es.jose.biblioteca.entities.Autor;
import es.jose.biblioteca.services.impl.AutorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controlador para la clase Autor
 * @since 28-oct-2018
 * @author joseb85
 */
@Controller
@RequestMapping("/autor")
public class AutorController implements ControllerImpl<Autor, Long> {

    @Autowired
    private AutorService autorService;
    
    /**
     * Solicita todos los autores
     * @return Lista de autores
     */
    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    @Override
    public ResponseEntity<List<Autor>> findAll() {
        List<Autor> result = autorService.findAll();
        return new ResponseEntity(result, HttpStatus.OK);
    }
    
    /**
     * Solicita un autor por su id
     * @param id Id del autor
     * @return Autor solicitado
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    @Override
    public ResponseEntity<Autor> findById(@PathVariable("id") Long id) {
        Autor result = autorService.findById(id);
        return new ResponseEntity(result, HttpStatus.OK);
    }

}
