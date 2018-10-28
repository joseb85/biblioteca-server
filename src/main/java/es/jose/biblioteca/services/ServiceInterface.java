package es.jose.biblioteca.services;

import java.util.List;

/**
 * @param <T> Clase
 * @param <U> Clave primaria
 * @since 28-oct-2018
 * @author joseb85
 */
public interface ServiceInterface<T, U> {

    List<T> findAll();

    T findById(U id);
    
//    void delete(T item);
//    
//    void deleteById(U id);
}
