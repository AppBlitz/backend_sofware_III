package com.restaurant.service.Interface;

import com.restaurant.model.vo.OrderRecommendation;

public interface IOrderRecommendationService {

    public OrderRecommendation generateRecommendation(int stockThreshold);
}
