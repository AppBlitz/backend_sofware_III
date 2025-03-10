package com.restaurant.controller.implementation.supplier;

import com.restaurant.controller.Interface.supplier.ISupplierController;
import com.restaurant.dto.supplier.SupplierDtoAdd;
import com.restaurant.dto.supplier.SupplierDtoEdit;
import com.restaurant.model.document.Supplier;
import com.restaurant.service.implementation.SupplierServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("supplier")
public class SupplierController implements ISupplierController {

    @Autowired
    public SupplierServices supplierService;

    @Override
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Supplier> addSupplier(@RequestBody() SupplierDtoAdd supplierdtoadd) throws Exception {
        Supplier supplier = supplierService.addSupplier(supplierdtoadd);
        return ResponseEntity.status(200).body(supplier);
    }

    @Override
    @RequestMapping(value = "/edit", method = RequestMethod.PUT)
    public ResponseEntity<Supplier> editSupplier(@RequestBody() SupplierDtoEdit supplierdtoedit) throws Exception {
        Supplier supplier = supplierService.editSupplier(supplierdtoedit);
        return ResponseEntity.status(200).body(supplier);
    }

    @Override
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ResponseEntity<Supplier> getSupplier(@PathVariable String id) throws Exception {
        Supplier supplier = supplierService.getSupplier(id);
        return ResponseEntity.status(200).body(supplier);
    }
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @Override
    public ResponseEntity<List<Supplier>> getSuppliers() throws Exception {
        List<Supplier> supplier = supplierService.getSuppliers();
        return ResponseEntity.status(200).body(supplier);
    }

    @Override
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity<Supplier> deleteSupplier(@PathVariable String id) throws Exception {
        Supplier supplier = supplierService.deleteSupplier(id);
        return ResponseEntity.status((200)).body(supplier);
    }
}
