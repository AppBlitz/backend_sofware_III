package com.restaurant.service.Interface;

import com.restaurant.dto.supplier.supplierDtoAdd;
import com.restaurant.dto.supplier.supplierDtoEdit;
import com.restaurant.model.document.Supplier;

public interface ISupplierServices {
    /**
     * get supplier
     * @param id
     * @return
     */
    public Supplier getSupplier(String id);

    /**
     * add Supplier to the DataBase
     * @param supplierdtoadd
     * @return
     */
    public Supplier addSupplier(supplierDtoAdd supplierdtoadd);

    /**
     * edit the attributes of the supplier
     * @param supplierdtoedit
     * @return
     */
    public Supplier editSupplier(supplierDtoEdit supplierdtoedit);

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
    public Supplier supplierDtoToSupplier(supplierDtoAdd supplierdtoadd);

    /**
     * Take the existing supplier and update its data with the SupplierDto
     * to save it with the new information
     * @param supplier
     * @param supplierdtoedit
     * @return
     */
    public Supplier supplierDtoToSupplier(Supplier supplier, supplierDtoEdit supplierdtoedit);
}
