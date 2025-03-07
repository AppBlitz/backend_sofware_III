package com.restaurant.service.Interface;

import com.restaurant.dto.supplier.SupplierDtoAdd;
import com.restaurant.dto.supplier.SupplierDtoEdit;
import com.restaurant.model.document.Supplier;

import java.util.List;

public interface ISupplierServices {
    /**
     * get supplier
     * @param id
     * @return
     */
    public Supplier getSupplier(String id);

    /**
     * gets the existing suppliers
     * @return
     */
    public List<Supplier> getSuppliers();

    /**
     * add Supplier to the DataBase
     * @param supplierdtoadd
     * @return
     */
    public Supplier addSupplier(SupplierDtoAdd supplierdtoadd);

    /**
     * edit the attributes of the supplier
     * @param supplierdtoedit
     * @return
     */
    public Supplier editSupplier(SupplierDtoEdit supplierdtoedit);

    /**
     * delete supplier of the DataBase
     * @param id
     * @return
     */
    public Supplier deleteSupplier(String id);

    /**
     * Convert the SupplierDto to a Supplier for later addition
     * @param supplierdtoadd
     * @return
     */
    public Supplier supplierDtoToSupplier(SupplierDtoAdd supplierdtoadd);

    /**
     * Take the existing supplier and update its data with the SupplierDto
     * to save it with the new information
     * @param supplier
     * @param supplierdtoedit
     * @return
     */
    public Supplier supplierDtoToSupplier(Supplier supplier, SupplierDtoEdit supplierdtoedit);
}
