package com.restaurant.service.implementation.inventory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.restaurant.dto.product.MovementDto;
import com.restaurant.exceptions.product.ExceptionUpdateProduct;
import com.restaurant.model.Enum.Estate;
import com.restaurant.model.Enum.MovementAction;
import com.restaurant.model.document.Supplier;
import com.restaurant.model.vo.MovementProduct;
import com.restaurant.repository.MovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.dto.product.ProductDtoAdd;
import com.restaurant.dto.product.ProductUpdateDto;
import com.restaurant.exceptions.product.ExceptioAddedProduct;
import com.restaurant.exceptions.product.ProductFetchException;
import com.restaurant.model.document.Product;
import com.restaurant.repository.ProductRepository;
import com.restaurant.service.Interface.inventory.ProductServiceInterface;
import com.restaurant.validators.product.ProductValidators;

@Service
public class ProductService implements ProductServiceInterface {

  @Autowired
  public ProductRepository productRepository;

  @Autowired
  public ProductValidators productValidators;

  @Autowired
  public SupplierServices supplierServices;

  @Autowired
  public MovementRepository movementRepository;

  @Override
  public Product addProduct(ProductDtoAdd ProductDtoAdd) throws ExceptioAddedProduct {
    if (productValidators.identificationSupplierForName(ProductDtoAdd.supplier())) {
      if (productValidators.verificationProductName(ProductDtoAdd.nameProduct())) {
        if (productValidators.validatorSupplier(ProductDtoAdd.nameProduct(),
            productValidators.searchSupplierName((ProductDtoAdd.supplier())).getId())) {
          return updateProductAmount(ProductDtoAdd);
        } else {
          return updateProductListsSUpplier(ProductDtoAdd);
        }
      } else {
        return createProduct(ProductDtoAdd);
      }
    } else {
      throw new ExceptioAddedProduct("es necesario ingresar un proveedor que exista para el producto");
    }
  }

  @Override
  public Product updateProductAmount(ProductDtoAdd productDtoAdd) {
    Optional<Product> product = productRepository.findByNameProduct(productDtoAdd.nameProduct());
    Product aux = product.get();
    Product updateProduct = product.get();
    updateProduct.setWeightProduct(aux.getWeightProduct());
    updateProduct.setStock(aux.getStock() + productDtoAdd.amount());
    updateProduct.setSuppliers(aux.getSuppliers());
    updateProduct.setPriceProduct(productDtoAdd.priceProduct());
    updateProduct.setWeightProduct(productDtoAdd.weightProduct());
    return productRepository.save(updateProduct);

  }

  @Override
  public Product updateProductListsSUpplier(String nameProduct, String supplier, int amount) {
    return null;
  }

  @Override
  public Product updateProductListsSUpplier(ProductDtoAdd productDtoAdd) {
    Optional<Product> product = productRepository.findByNameProduct(productDtoAdd.nameProduct());
    Product aux = product.get();
    ArrayList<String> suppliers = aux.getSuppliers();
    suppliers.add(productValidators.searchSupplierName(productDtoAdd.supplier()).getId());
    Product updateProduct = product.get();
    updateProduct.setWeightProduct(productDtoAdd.weightProduct());
    updateProduct.setStock(aux.getStock() + productDtoAdd.amount());
    updateProduct.setSuppliers(suppliers);
    updateProduct.setPriceProduct(productDtoAdd.priceProduct());

    return productRepository.save(updateProduct);
  }

  @Override
  public List<Product> getAvailableProducts() throws ProductFetchException {
    List<Product> products = productRepository.findByStockGreaterThan(0);
    if (products.isEmpty()) {
      throw new ProductFetchException("No products available");
    }
    return products;
  }

  @Override
  public Product createProduct(ProductDtoAdd productDtoAdd) {
    ArrayList<String> listSupplier = new ArrayList<>();
    ArrayList<byte[]> listImages = new ArrayList<>();

    listSupplier.add(productValidators.searchSupplierName(productDtoAdd.supplier()).getId());
    Product product = Product.builder()
        .nameProduct(productDtoAdd.nameProduct())
        .suppliers(listSupplier)
        .stock(productDtoAdd.amount())
        // .dateExpiration.add(productDtoAdd.dateExpiration())
        .dateRegister(productDtoAdd.dateAdd())
        .weightProduct(productDtoAdd.weightProduct())
        .priceProduct(productDtoAdd.priceProduct())
        .images(listImages)
        .typeStock(productDtoAdd.typeStock())
        .build();
    product.setDateExpiration(new ArrayList<>());
    product.setControldateExpiration(new ArrayList<>());
    Product p = productRepository.save(product);
    verification_product_supplier(p.getId(), p.getSuppliers());
    return p;
  }

  // @Override
  // public ArrayList<ListProducts> getAllProducts() {
  // return productValidators.listAllProducts();
  // }

  public List<Product> getListProducts() {
    return productRepository.findAll();
  }

  public Product getProduct(String id) {
    Optional<Product> producto = productRepository.findById(id);
    return producto.get();
  }

  @Override
  public Product updateProduct(ProductUpdateDto productUpdateDto) {
    Optional<Product> product = productRepository.findById(productUpdateDto.id());
    if (product.isEmpty())
      throw new NoSuchElementException("This product not existe");
    else {
      Product productUpdate = product.get();
      productUpdate.setDateExpiration(productUpdateDto.dateExpiration());
      productUpdate.setNameProduct(productUpdate.getNameProduct());
      productUpdate.setPriceProduct(productUpdateDto.priceProduct());
      // productUpdate.setStock(productUpdateDto.amount() + productUpdate.getStock());
      productUpdate.setWeightProduct(productUpdateDto.weightProduct());
      productUpdate.setSuppliers(productUpdateDto.suppliers());
      productUpdate.setDateRegister(productUpdateDto.dateAdd());
      productUpdate.setTypeStock(productUpdateDto.typeStock());
      verification_product_supplier(productUpdate.getId(), productUpdate.getSuppliers());
      return productUpdate;
    }

  }

  public Product deleteProduct(String id) {
    Optional<Product> product = productRepository.findById(id);
    Product p1 = product.get();
    p1.setEstate(Estate.INACTIVE);
    productRepository.save(p1);
    return p1;
  }

  public MovementProduct updateAmount(String idProduct, MovementDto movementDto) throws ExceptionUpdateProduct {
    Product p = getProduct(idProduct);
    MovementProduct o = new MovementProduct(p.getNameProduct(),
        movementDto.action(),
        movementDto.amount(),
        movementDto.reason(),
        movementDto.timestamp(),
        movementDto.expiration());

    if (movementDto.action() == MovementAction.ENTRADA) {
      inputMovement(idProduct, movementDto.amount(), movementDto.expiration());
    } else {
      outputMovement(idProduct, movementDto.amount());
    }

    return movementRepository.save(o);
  }

  public Product inputMovement(String idProduct, int amount, LocalDate expiration) {
    Product p = getProduct(idProduct);

    p.setStock(p.getStock() + amount);
    p.getDateExpiration().add(expiration);
    p.getControldateExpiration().add(p.getStock());

    return productRepository.save(p);
  }

  public Product outputMovement(String idProduct, int amount) throws ExceptionUpdateProduct {

    Product p = getProduct(idProduct);
    if(!p.getDateExpiration().isEmpty()){
      if(p.getStock()-amount>=0){
        return changeOutput(p,amount);
      }else{
        throw new ExceptionUpdateProduct("el stock no cuenta con suficiente cantidad");
      }
    }
    else{
      throw new ExceptionUpdateProduct("no se registra stock existente");
    }

  }

  public Product changeOutput(Product p,int amount){
    for (int i = 0; i < p.getControldateExpiration().size(); i++) {
      if (p.getControldateExpiration().get(i) - amount <= 0) {
        p.getControldateExpiration().remove(i);
        p.getDateExpiration().remove(i);
      }
      else  {
        p.getControldateExpiration().set(i, p.getControldateExpiration().get(i) - amount);
      }
    }
    p.setStock(p.getStock() - amount);
    return productRepository.save(p);
  }

  public List<MovementProduct> consult_all_movements(){
    return movementRepository.findAll();
  }

  public List<MovementProduct> consult_movementsByDate(LocalDate date){
    LocalDateTime start = date.atStartOfDay();
    LocalDateTime end = date.plusDays(1).atStartOfDay();
    return movementRepository.findByTimestampBetween(start, end);

  }

  public List<MovementProduct> consult_movementsByHour(LocalDate date, int startHour,int endHour){
    LocalDateTime start = date.atTime(startHour, 0);
    LocalDateTime end = date.atTime(endHour, 0);
    return movementRepository.findByTimestampBetween(start, end);
  }



  public void verification_product_supplier(String idProduct, List<String> suppliers) {
    for (String s : suppliers) {
      Supplier supplier = supplierServices.getSupplier(s);
      if (!supplier.getOfferedProducts().contains(idProduct)) {
        supplier.getOfferedProducts().add(idProduct);
      }
    }
  }

}
