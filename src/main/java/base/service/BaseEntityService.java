package base.service;

import base.domain.BaseEntity;

import java.io.Serializable;
import java.util.List;

public interface BaseEntityService<E extends BaseEntity<ID>, ID extends Serializable> {


    E save(E e);

    E findById(ID id);

    List<E> findAll();

    void delete(E e);

    Boolean existById(ID id);

}
