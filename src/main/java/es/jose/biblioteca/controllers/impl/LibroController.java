package es.jose.biblioteca.controllers.impl;

import es.jose.biblioteca.services.impl.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controlador para la clase Libro
 * @since 28-oct-2018
 * @author joseb85
 */
@Controller
@RequestMapping("/libro")
public class LibroController {
    
    @Autowired
    private LibroService libroService;

}
