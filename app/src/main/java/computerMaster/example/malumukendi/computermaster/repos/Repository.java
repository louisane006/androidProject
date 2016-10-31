package computerMaster.example.malumukendi.computermaster.repos;

import java.util.Set;

import computerMaster.example.malumukendi.computermaster.domain.Designer;

/**
 * Created by Malu.Mukendi on 2016-06-06.
 */
public interface Repository<E, ID> {

    E findById(ID id);

    E save(E entity);

    E update(E entity);

    Designer delete(E entity);

    Set<E> findAll();

    int deleteAll();

}
