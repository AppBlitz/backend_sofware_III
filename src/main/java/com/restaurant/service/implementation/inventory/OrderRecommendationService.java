package com.restaurant.service.implementation.inventory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.restaurant.model.document.Product;
import com.restaurant.model.document.Supplier;
import com.restaurant.model.vo.OrderRecommendation;
import com.restaurant.model.vo.ProductRecommendation;
import com.restaurant.repository.ProductRepository;
import com.restaurant.repository.SupplierRepository;
import com.restaurant.service.Interface.inventory.IOrderRecommendationService;

@Service
public class OrderRecommendationService implements IOrderRecommendationService {

    @Autowired
    ProductRepository productoRepository;

    @Autowired
    SupplierServices supplierServices;
    /**
     * Generates an order recommendation for products with low stock.
     *
     * @param stockThreshold The stock level threshold below which a product is considered low stock.
     * @return An {@link OrderRecommendation} object containing recommended products and their suppliers.
     */
    public OrderRecommendation generateRecommendation(int stockThreshold) {

        // Retrieve products with stock below the threshold
        List<Product> lowStockProducts = productoRepository.findLowStockProducts(stockThreshold);
        List<ProductRecommendation> recommendedProducts = new ArrayList<>();

        // Process each low-stock product to generate recommendations
        for (Product product : lowStockProducts) {

            ProductRecommendation recommendation = new ProductRecommendation();
            recommendation.setProductName(product.getNameProduct());
            recommendation.setCurrentStock(product.getStock());
            recommendation.setRecommendedQuantity(product.getStock() * 3); // Arbitrary recommended quantity

            // Retrieve supplier names for the product
            for (String idSupplier : product.getSuppliers()) {
                Supplier supplier=supplierServices.getSupplier(idSupplier);
                recommendation.getSuppliersName().add(supplier.getNameSupplier());
            }

            recommendedProducts.add(recommendation);
        }

        // Create the final order recommendation object
        OrderRecommendation orderRecommendation = new OrderRecommendation();
        orderRecommendation.setDate(LocalDate.now());
        orderRecommendation.setProducts(recommendedProducts);

        return orderRecommendation;
    }
}