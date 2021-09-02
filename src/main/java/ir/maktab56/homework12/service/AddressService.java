package ir.maktab56.homework12.service;

import ir.maktab56.homework12.base.service.BaseEntityService;
import ir.maktab56.homework12.domain.Address;
import ir.maktab56.homework12.service.dto.AddressDto;

public interface AddressService extends BaseEntityService<Address, Long> {
    Address getAddress(AddressDto addressDto);
}
