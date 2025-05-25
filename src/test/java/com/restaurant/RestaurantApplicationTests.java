package com.restaurant;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.restaurant.service.implementation.cart.ShoppinCartServiceIm;
import com.testrail.junit.customjunitxml.annotations.TestRail;

@SpringBootTest
class RestaurantApplicationTests {

	private WebDriver wDriver;

	@Autowired
	ShoppinCartServiceIm sService;

	@BeforeEach
	public void getUp() {
		wDriver = new ChromeDriver();
	}

	@Test
	void contextLoads() throws InterruptedException {
		wDriver.get("http://localhost:5173/");
		wDriver.findElement(By.id("email")).sendKeys("a@gmail.com");
		wDriver.findElement(By.id("password")).sendKeys("123456789");
		wDriver.findElement(By.id("login")).click();

		wDriver.close();
	}

	@Test
	@DisplayName("Buscar carrito de compras por id")
	@TestRail(id = "C35")
	public void searchCartForId() {
		assertNotNull(sService.searchShoppingCartId("681b61aa1e710924d1408dd6"));
	}
}
