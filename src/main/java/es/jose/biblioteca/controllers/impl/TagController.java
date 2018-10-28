package es.jose.biblioteca.controllers.impl;

import es.jose.biblioteca.services.impl.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controlador para la clase Tag
 * @since 28-oct-2018
 * @author joseb85
 */
@Controller
@RequestMapping("/tag")
public class TagController {

    @Autowired
    private TagService tagService;

}
