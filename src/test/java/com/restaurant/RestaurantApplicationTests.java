package com.restaurant;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.restaurant.service.implementation.cart.ShoppinCartServiceIm;
import com.testrail.junit.customjunitxml.annotations.TestRail;

@SpringBootTest
class RestaurantApplicationTests {


	@Test
	void contextLoads() throws InterruptedException {
	}

	@Nested
	class CartTests{

	@Autowired
	ShoppinCartServiceIm sService;

	@Test
	@DisplayName("Buscar carrito de compras por id")
	@TestRail(id = "C35")
	public void searchCartForId() {
		assertNotNull(sService.searchShoppingCartId("681b61aa1e710924d1408dd6"));
	}
	}
}
