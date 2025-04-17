package com.restaurant.service.implementation;

import com.restaurant.dto.supplier.SupplierDtoAdd;
import com.restaurant.dto.supplier.SupplierDtoEdit;
import com.restaurant.enums.StateEnum;
import com.restaurant.exceptions.supplier.*;
import com.restaurant.model.document.Product;
import com.restaurant.model.document.Supplier;
import com.restaurant.repository.SupplierRepository;
import com.restaurant.service.Interface.ISupplierServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierServices implements ISupplierServices {

    @Autowired
    SupplierRepository supplierRepository;

    @Autowired
    ProductService productService;

    @Override
    public Supplier getSupplier(String id) throws ExceptionGetSupplier {
        Optional<Supplier> supplier = supplierRepository.findById(id);
        return supplier.get();
    }

    @Override
    public List<Supplier> getSuppliers() {
        return supplierRepository.findAll();
    }

    @Override
    public Supplier addSupplier(SupplierDtoAdd supplierdtoadd) throws ExceptionAddedSupplier {
        Supplier supplier = supplierDtoToSupplier(supplierdtoadd);
        Supplier s1 =supplierRepository.save(supplier);
        verification_product_supplier(s1.getId(),s1.getOfferedProducts());
        return s1;

    }

    @Override
    public Supplier editSupplier(SupplierDtoEdit supplierdtoedit) throws ExceptionEditSupplier {
        Optional<Supplier> supplier = supplierRepository.findById(supplierdtoedit.id());
        Supplier supplier1 = supplierDtoToSupplier(supplier.get(), supplierdtoedit);
        return supplierRepository.save(supplier1);
    }

    @Override
    public Supplier deleteSupplier(String id) {
        Optional<Supplier> supplier = supplierRepository.findById(id);
        Supplier supplier1 = supplier.get();
        supplier1.setStateActivity(StateEnum.IDLE);
        supplierRepository.save(supplier1);
        return supplier1;
    }

    public Supplier supplierDtoToSupplier(SupplierDtoAdd supplierdtoadd) {
        Supplier supplier = Supplier.builder().nameSupplier(supplierdtoadd.nameSupplier())
                .location(supplierdtoadd.location()).offeredProducts(supplierdtoadd.offeredProducts())
                .orderDate(supplierdtoadd.orderDate()).stateActivity(supplierdtoadd.stateActivity()).build();

        return supplier;
    }

    public Supplier supplierDtoToSupplier(Supplier supplier, SupplierDtoEdit supplierdtoedit) {
        supplier.setNameSupplier(supplierdtoedit.nameSupplier());
        supplier.setLocation(supplierdtoedit.location());
        supplier.setOfferedProducts(supplierdtoedit.offeredProducts());
        supplier.setOrderDate(supplierdtoedit.orderDate());
        supplier.setStateActivity(supplierdtoedit.stateActivity());

        return supplier;
    }

    public void verification_product_supplier(String idSupplier, List<String> products) {
        for( String s: products){
            Product product =  productService.getProduct(s);
            if(!product.getSuppliers().contains(idSupplier)){
            product.getSuppliers().add(idSupplier);
            }
        }
    }
}
