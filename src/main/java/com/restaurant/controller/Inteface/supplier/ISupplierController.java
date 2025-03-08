package com.restaurant.controller.Inteface.supplier;

import com.restaurant.dto.supplier.SupplierDtoAdd;
import com.restaurant.dto.supplier.SupplierDtoEdit;
import com.restaurant.model.document.Supplier;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ISupplierController {
    /**
     * Method called by the frontend request
     * to add a supplier to the database
     * @param supplierdtoadd
     * @return A response indicating if the request was successfully or if an error occurred.
     * @throws Exception
     */
    public ResponseEntity<Supplier> addSupplier(@Valid SupplierDtoAdd supplierdtoadd) throws Exception;

    /**
     * Method called by the frontend request
     * to modify the data of an existing supplier
     * @param supplierdtoedit
     * @return A response indicating if the request was successfully or if an error occurred.
     * @throws Exception
     */
    public ResponseEntity<Supplier> editSupplier(@Valid SupplierDtoEdit supplierdtoedit) throws Exception;

    /**
     * Method called by the frontend request
     * to load the existing supplier required
     * @param id
     * @return A response indicating if the request was successfully or if an error occurred.
     * @throws Exception
     */
    public ResponseEntity<Supplier> getSupplier(@PathVariable String id) throws Exception;

    /**
     * Method called by the frontend request
     * to load all existing supplier
     * @return A response indicating if the request was successfully or if an error occurred.
     * @throws Exception
     */
    public ResponseEntity<List<Supplier>> getSuppliers() throws Exception;

    /**
     * Method called by the frontend request
     * to change the activity status of a supplier to inactive
     * @param id
     * @return A response indicating if the request was successfully or if an error occurred.
     * @throws Exception
     */
    public ResponseEntity<Supplier> deleteSupplier(@PathVariable String id) throws Exception;



}
