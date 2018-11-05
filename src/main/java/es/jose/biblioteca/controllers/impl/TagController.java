package es.jose.biblioteca.controllers.impl;

import es.jose.biblioteca.controllers.ControllerImpl;
import es.jose.biblioteca.entities.Tag;
import es.jose.biblioteca.services.impl.TagService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controlador para la clase Tag
 * @since 28-oct-2018
 * @author joseb85
 */
@Controller
@RequestMapping("/tag")
public class TagController implements ControllerImpl<Tag, Long>{

    @Autowired
    private TagService tagService;
    
    /**
     * Solicita todos los tags
     * @return Lista de tags
     */
    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    @Override
    public ResponseEntity<List<Tag>> findAll() {
        List<Tag> result = tagService.findAll();
        return new ResponseEntity(result, HttpStatus.OK);
    }
    
    /**
     * Solicita un tag por su id
     * @param id Id del tag
     * @return Tag solicitado
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    @Override
    public ResponseEntity<Tag> findById(@PathVariable("id") Long id) {
        Tag result = tagService.findById(id);
        return new ResponseEntity(result, HttpStatus.OK);
    }

}
