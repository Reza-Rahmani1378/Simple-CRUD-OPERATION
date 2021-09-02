package ir.maktab56.homework12.repository.impl;

import ir.maktab56.homework12.base.repository.impl.BaseEntityRepositoryImpl;
import ir.maktab56.homework12.domain.Address;
import ir.maktab56.homework12.repository.AddressRepository;

import javax.persistence.EntityManager;

public class AddressRepositoryImpl extends BaseEntityRepositoryImpl<Address, Long>
        implements AddressRepository {

    public AddressRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Address> getEntityClass() {
        return Address.class;
    }

}
