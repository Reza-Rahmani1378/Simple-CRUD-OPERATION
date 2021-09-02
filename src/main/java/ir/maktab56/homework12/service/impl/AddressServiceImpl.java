package ir.maktab56.homework12.service.impl;

import ir.maktab56.homework12.base.service.impl.BaseEntityServiceImpl;
import ir.maktab56.homework12.domain.Address;
import ir.maktab56.homework12.repository.AddressRepository;
import ir.maktab56.homework12.service.AddressService;
import ir.maktab56.homework12.service.dto.AddressDto;

public class AddressServiceImpl extends BaseEntityServiceImpl<Address, Long, AddressRepository>
        implements AddressService {
    public AddressServiceImpl(AddressRepository repository) {
        super(repository);
    }


    @Override
    public Address getAddress(AddressDto addressDto) {
        return new Address(
                addressDto.getPhoneNumber(),
                addressDto.getState(),
                addressDto.getCity(),
                addressDto.getPostalAddress(),
                addressDto.getPostalCode()
        );
    }
}
