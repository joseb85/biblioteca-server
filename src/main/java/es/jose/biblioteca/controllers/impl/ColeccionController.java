package es.jose.biblioteca.controllers.impl;

import es.jose.biblioteca.controllers.ControllerImpl;
import es.jose.biblioteca.entities.Coleccion;
import es.jose.biblioteca.services.impl.ColeccionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controlador para la clase Colección
 * @since 03-nov-2018
 * @author joseb85
 */
@Controller
@RequestMapping("/coleccion")
public class ColeccionController implements ControllerImpl<Coleccion, Long>{

    @Autowired
    private ColeccionService coleccionService;
    
    /**
     * Solicita todas las colecciones
     * @return Lista de colecciones
     */
    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    @Override
    public ResponseEntity<List<Coleccion>> findAll() {
        List<Coleccion> result = coleccionService.findAll();
        return new ResponseEntity(result, HttpStatus.OK);
    }
    
    /**
     * Solicita una colección por su id
     * @param id Id de la colección
     * @return Colección solicitada
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    @Override
    public ResponseEntity<Coleccion> findById(@PathVariable("id") Long id) {
        Coleccion result = coleccionService.findById(id);
        return new ResponseEntity(result, HttpStatus.OK);
    }

}
