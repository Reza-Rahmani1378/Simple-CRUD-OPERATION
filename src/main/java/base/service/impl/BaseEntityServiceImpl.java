package base.service.impl;

import base.domain.BaseEntity;
import base.repository.BaseEntityRepository;
import base.service.BaseEntityService;

import java.io.Serializable;
import java.util.List;

public class BaseEntityServiceImpl<E extends BaseEntity<ID>, ID extends Serializable,
        R extends BaseEntityRepository<E, ID>> implements BaseEntityService<E, ID> {

    protected final R repository;

    public BaseEntityServiceImpl(R repository) {
        this.repository = repository;
    }

    @Override
    public E save(E e) {
        repository.getEntityManger().getTransaction().begin();
        e = repository.save(e);
        repository.getEntityManger().getTransaction().commit();
        return e;
    }

    @Override
    public E findById(ID id) {
        return repository.findById(id);
    }

    @Override
    public List<E> findAll() {
        return repository.findAll();
    }

    @Override
    public void delete(E e) {
        repository.getEntityManger().getTransaction().begin();
        repository.delete(e);
        repository.getEntityManger().getTransaction().commit();
    }

    @Override
    public Boolean existById(ID id) {
        return repository.existById(id);
    }
}
