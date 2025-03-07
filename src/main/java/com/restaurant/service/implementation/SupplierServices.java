package com.restaurant.service.implementation;

import com.restaurant.dto.supplier.supplierDtoAdd;
import com.restaurant.dto.supplier.supplierDtoEdit;
import com.restaurant.enums.StateEnum;
import com.restaurant.exceptions.supplier.*;
import com.restaurant.model.document.Supplier;
import com.restaurant.repository.SupplierRepository;
import com.restaurant.service.Interface.ISupplierServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SupplierServices implements ISupplierServices {

    @Autowired
    SupplierRepository supplierRepository;

    @Override
    public Supplier getSupplier(String id)  throws ExceptionGetSupplier {
        Optional<Supplier> supplier = supplierRepository.findById(id);
        return supplier.get();
    }

    @Override
    public Supplier addSupplier(supplierDtoAdd supplierdtoadd) throws ExceptionAddedSupplier {
        Supplier supplier = supplierDtoToSupplier(supplierdtoadd);
        return supplierRepository.save(supplier);

    }

    @Override
    public Supplier editSupplier(supplierDtoEdit supplierdtoedit) throws ExceptionEditSupplier {
        Optional<Supplier> supplier= supplierRepository.findById(supplierdtoedit.id());
        Supplier supplier1 = supplierDtoToSupplier(supplier.get(),supplierdtoedit);
        return supplierRepository.save(supplier1);
    }

    @Override
    public Supplier deleteSupplier(String id) {
        Optional<Supplier> supplier= supplierRepository.findById(id);
        Supplier supplier1 = supplier.get();
        supplier1.setStateAtivity(StateEnum.IDLE);
        supplierRepository.save(supplier1);
        return supplier1;
    }

    public Supplier supplierDtoToSupplier(supplierDtoAdd supplierdtoadd){
        Supplier supplier= Supplier.builder().
                name(supplierdtoadd.name()).
                location(supplierdtoadd.location()).
                offeredProducts(supplierdtoadd.offeredProducts()).
                orderDate(supplierdtoadd.orderDate()).
                stateAtivity(supplierdtoadd.stateAtivity()).build();

        return supplier;
    }

    public Supplier supplierDtoToSupplier(Supplier supplier, supplierDtoEdit supplierdtoedit){
        supplier.setName(supplierdtoedit.name());
        supplier.setLocation(supplierdtoedit.location());
        supplier.setOfferedProducts(supplierdtoedit.offeredProducts());
        supplier.setOrderDate(supplierdtoedit.orderDate());
        supplier.setStateAtivity(supplierdtoedit.stateAtivity());

        return supplier;
    }
}
