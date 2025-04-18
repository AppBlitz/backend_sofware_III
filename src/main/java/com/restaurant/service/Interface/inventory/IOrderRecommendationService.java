package com.restaurant.service.Interface.inventory;

import com.restaurant.model.vo.OrderRecommendation;

public interface IOrderRecommendationService {
    /**
     * Generates an order recommendation based on the given stock threshold.
     *
     * @param stockThreshold The minimum stock level required to trigger a recommendation.
     * @return An OrderRecommendation object containing the recommended order details.
     */
    OrderRecommendation generateRecommendation(int stockThreshold);
}
