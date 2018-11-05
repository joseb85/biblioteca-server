package es.jose.biblioteca.controllers.impl;

import es.jose.biblioteca.controllers.ControllerImpl;
import es.jose.biblioteca.entities.Lectura;
import es.jose.biblioteca.services.impl.LecturaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controlador para la clase Lectura
 * @since 28-oct-2018
 * @author joseb85
 */
@Controller
@RequestMapping("/lectura")
public class LecturaController implements ControllerImpl<Lectura, Integer>{

    @Autowired
    private LecturaService lecturaService;
    
    /**
     * Solicita todas las lecturas
     * @return Lista de lecturas
     */
    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    @Override
    public ResponseEntity<List<Lectura>> findAll() {
        List<Lectura> result = lecturaService.findAll();
        return new ResponseEntity(result, HttpStatus.OK);
    }
    
    /**
     * Solicita una lectura por su id
     * @param id Id de la lectura
     * @return Lectura solicitada
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    @Override
    public ResponseEntity<Lectura> findById(@PathVariable("id") Integer id) {
        Lectura result = lecturaService.findById(id);
        return new ResponseEntity(result, HttpStatus.OK);
    }
    
    /**
     * Solicita el primer año de lectura
     * @return Año más antiguo de lectura 
     */
    @RequestMapping(value = "minYear", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<String> minYear() {
        String result = lecturaService.minYear();
        return new ResponseEntity(result, HttpStatus.OK);
    }

}
