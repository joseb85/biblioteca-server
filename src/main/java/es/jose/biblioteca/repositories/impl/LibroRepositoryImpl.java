package es.jose.biblioteca.repositories.impl;

import es.jose.biblioteca.entities.Genero;
import es.jose.biblioteca.entities.Libro;
import es.jose.biblioteca.entities.Libro_;
import es.jose.biblioteca.entities.Tag;
import es.jose.biblioteca.entities.Tag_;
import es.jose.biblioteca.repositories.LibroCustomRepository;
import es.jose.biblioteca.support.FiltroLibro;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Repositorio personalizado para los libros
 *
 * @since 04-nov-2018
 * @author joseb85
 */
@Repository
@Transactional(readOnly = true)
public class LibroRepositoryImpl implements LibroCustomRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<Libro> filter(FiltroLibro filtro) {
        //TODO Pageable y Valores nulos
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Libro> cq = cb.createQuery(Libro.class);

        List<Predicate> predicates = new ArrayList<>();

        //SELECT * FROM libro
        Root<Libro> root = cq.from(Libro.class);
        cq.select(root);
        //WHERE nombre LIKE '%...%'
        if (filtro.getTitulo() != null && !filtro.getTitulo().isEmpty()) {
            predicates.add(cb.like(cb.lower(root.get(Libro_.nombre)), "%" + filtro.getTitulo().toLowerCase() + "%"));
        }
        //WHERE genero IN ()
        if (filtro.getGeneros() != null && !filtro.getGeneros().isEmpty()) {
            predicates.add(root.get(Libro_.genero).in(filtro.getGeneros()));
        }
        //WHERE paginas BETWEEN ?1 AND ?2
        if (filtro.getDesdePaginas() != null && filtro.getHastaPaginas() != null) {
            predicates.add(cb.between(root.get(Libro_.paginas), filtro.getDesdePaginas(), filtro.getHastaPaginas()));
        }
        //WHERE agno BETWEEN ?1 AND ?2
        if (filtro.getDesdeAgno() != null && filtro.getHastaAgno() != null) {
            predicates.add(cb.between(root.get(Libro_.agno), filtro.getDesdeAgno(), filtro.getHastaAgno()));
        }
        //WHERE tags IN ()
        if(filtro.getTags() != null && !filtro.getTags().isEmpty()) {
            predicates.add(root.join(Libro_.tags, JoinType.LEFT).in(filtro.getTags()));
        }
        //WHERE autores IN ()
        if(filtro.getAutores() != null && !filtro.getAutores().isEmpty()) {
            predicates.add(root.join(Libro_.autores, JoinType.LEFT).in(filtro.getAutores()));
        }
        
        //Seleccionamos el OR o el AND en la cláusula WHERE
        if (filtro.getOr() != null && filtro.getOr()) {
            Predicate finalWhere = cb.or(predicates.toArray(new Predicate[]{}));
            cq.where(finalWhere);
        } else {
            cq.where(predicates.toArray(new Predicate[]{}));
        }

        //ORDER BY nombre
        cq.orderBy(cb.asc(root.get(Libro_.nombre)));
        //DISTINCT
        cq.distinct(true);
        //CONVERTIMOS A QUERY Y EJECUTAMOS
        Query query = em.createQuery(cq);
        System.out.println(em.createQuery(cq).unwrap(org.hibernate.Query.class).getQueryString());
        return query.getResultList();
    }

}
