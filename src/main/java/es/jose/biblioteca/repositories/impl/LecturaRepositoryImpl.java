package es.jose.biblioteca.repositories.impl;

import es.jose.biblioteca.entities.Lectura;
import es.jose.biblioteca.repositories.LecturaCustomRepository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Repositorio personalizado para las lecturas
 *
 * @since 04-nov-2018
 * @author joseb85
 */
@Repository
@Transactional(readOnly = true)
public class LecturaRepositoryImpl implements LecturaCustomRepository{

    @PersistenceContext
    EntityManager em;

    @Override
    public String minYear() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Integer> cq = cb.createQuery(Integer.class);
        Root<Lectura> root = cq.from(Lectura.class);
        cq.select(cb.min(root.<Integer>get("agno")));
        Query query = em.createQuery(cq);
        return (String) query.getSingleResult();
    }
    
}
