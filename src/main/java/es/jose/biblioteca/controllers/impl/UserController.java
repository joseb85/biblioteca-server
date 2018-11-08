package es.jose.biblioteca.controllers.impl;

import es.jose.biblioteca.entities.Usuario;
import es.jose.biblioteca.services.impl.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @since 08-nov-2018
 * @author joseb85
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    
    /**
     * Solicita todos los usuarios
     * @return Lista de usuarios
     */
    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Usuario>> findAll() {
        List<Usuario> result = userService.findAll();
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public Usuario getOne(@PathVariable(value = "id") Long id){
        return userService.findById(id);
    }
}
