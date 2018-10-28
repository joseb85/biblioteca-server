package es.jose.biblioteca.services.impl;

import es.jose.biblioteca.entities.Tag;
import es.jose.biblioteca.entities.Tag;
import es.jose.biblioteca.repositories.TagRepository;
import es.jose.biblioteca.services.ServiceInterface;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Servicio para la clase Tag
 * @since 28-oct-2018
 * @author joseb85
 */
@Service
public class TagService implements ServiceInterface<Tag, Long> {
    
    @Autowired
    private TagRepository tagRepository;

    @Override
    public List<Tag> findAll() {
        return (List<Tag>) tagRepository.findAll();
    }

    @Override
    public Tag findById(Long id) {
        Optional<Tag> result = tagRepository.findById(id);
        return result.isPresent() ? result.get() : null;
    }
    
}
