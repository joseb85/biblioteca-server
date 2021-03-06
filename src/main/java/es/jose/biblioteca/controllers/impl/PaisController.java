package es.jose.biblioteca.controllers.impl;

import es.jose.biblioteca.controllers.ControllerImpl;
import es.jose.biblioteca.entities.Pais;
import es.jose.biblioteca.services.impl.PaisService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controlador para la clase Pais
 * @since 28-oct-2018
 * @author joseb85
 */
@Controller
@RequestMapping("/pais")
public class PaisController implements ControllerImpl<Pais, Long>{

    @Autowired
    private PaisService paisService;
    
    /**
     * Solicita todos los países
     * @return Lista de países
     */
    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    @Override
    public ResponseEntity<List<Pais>> findAll() {
        List<Pais> result = paisService.findAll();
        return new ResponseEntity(result, HttpStatus.OK);
    }
    
    /**
     * Solicita un país por su id
     * @param id Id del país
     * @return Pais solicitado
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    @Override
    public ResponseEntity<Pais> findById(@PathVariable("id") Long id) {
        Pais result = paisService.findById(id);
        return new ResponseEntity(result, HttpStatus.OK);
    }

}
