package com.restaurant.service.implementation;

import com.restaurant.model.document.Supplier;
import com.restaurant.model.vo.OrderRecommendation;
import com.restaurant.model.vo.ProductRecommendation;
import com.restaurant.repository.ProductoRepository;
import com.restaurant.repository.SupplierRepository;
import com.restaurant.model.document.Product;
import com.restaurant.service.Interface.IOrderRecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderRecommendationService implements IOrderRecommendationService {

    @Autowired
    ProductoRepository productoRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    public OrderRecommendation generateRecommendation(int stockThreshold) {

        List<Product> lowStockProducts = productoRepository.findLowStockProducts(stockThreshold);
        List<ProductRecommendation> recommendedProducts = new ArrayList<>();

        for (Product product : lowStockProducts) {
               ProductRecommendation recommendation = new ProductRecommendation();
                recommendation.setProductName(product.getNameProduct());
                recommendation.setCurrentStock(product.getStock());
                recommendation.setRecommendedQuantity(product.getStock()*2); // Cantidad recomendada arbitraria
            for (String idSupplier : product.getSuppliers()) {
                Optional<Supplier> supplier=supplierRepository.findById(idSupplier);
                recommendation.getSuppliersName().add(supplier.get().getNameSupplier());
            }

                recommendedProducts.add(recommendation);
        }

        // Crear el objeto de recomendación final
        OrderRecommendation orderRecommendation = new OrderRecommendation();
        orderRecommendation.setDate(LocalDate.now());
        orderRecommendation.setProducts(recommendedProducts);

        return orderRecommendation;
    }
}
