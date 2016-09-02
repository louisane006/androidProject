package computerMaster.example.malumukendi.computermaster.service;

import java.util.Set;
/**
 * Created by Malu.Mukendi on 2016-05-31.
 */
public interface Service<E, ID> {

    E findById(ID id);

    E save(E entity);

    E update(E entity);

    E delete(E entity);

    Set<E> findAll();

    int deleteAll();

}