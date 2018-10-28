package es.jose.biblioteca.controllers.impl;

import es.jose.biblioteca.services.impl.LecturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controlador para la clase Lectura
 * @since 28-oct-2018
 * @author joseb85
 */
@Controller
@RequestMapping("/lectura")
public class LecturaController {

    @Autowired
    private LecturaService lecturaService;

}
