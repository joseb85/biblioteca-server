package es.jose.biblioteca.controllers.impl;

import es.jose.biblioteca.controllers.ControllerImpl;
import es.jose.biblioteca.entities.Libro;
import es.jose.biblioteca.services.impl.LibroService;
import es.jose.biblioteca.support.FiltroLibro;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controlador para la clase Libro
 * @since 28-oct-2018
 * @author joseb85
 */
@Controller
@RequestMapping("/libro")
public class LibroController implements ControllerImpl<Libro, Long>{
    
    @Autowired
    private LibroService libroService;
    
    /**
     * Solicita todos los libros
     * @return Lista de libros
     */
    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    @Override
    public ResponseEntity<List<Libro>> findAll() {
        List<Libro> result = libroService.findAll();
        return new ResponseEntity(result, HttpStatus.OK);
    }
    
    /**
     * Solicita un libro por su id
     * @param id Id del libro
     * @return Libro solicitado
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    @Override
    public ResponseEntity<Libro> findById(@PathVariable("id") Long id) {
        Libro result = libroService.findById(id);
        return new ResponseEntity(result, HttpStatus.OK);
    }
    
    /**
     * Solicita una lista de libros filtrada a partir de unos parámetros de búsqueda
     * @param filtro Filtro con los parámetros de búsqueda
     * @return Lista de libros solicitada
     */
    @RequestMapping(value = "/filter", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<List<Libro>> filter(@RequestBody FiltroLibro filtro) {
        List<Libro> result = libroService.filter(filtro);
        return new ResponseEntity(result, HttpStatus.OK);
    }

}
