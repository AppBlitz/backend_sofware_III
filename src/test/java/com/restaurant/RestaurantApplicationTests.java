package com.restaurant;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@SpringBootTest
class RestaurantApplicationTests {

	private WebDriver wDriver;

	@BeforeEach
	void getUp() {
		wDriver = new ChromeDriver();
	}

	@Test
	void contextLoads() {
		wDriver.get("https://github.com/naveenchr/SpringBoot-SeleniumFramework");

		wDriver.close();
	}

}
