package com.restaurant;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RestaurantApplicationTests {

	private WebDriver wDriver;

	@BeforeEach
	void getUp() {
		wDriver = new ChromeDriver();
	}

	@Test
	void contextLoads() throws InterruptedException {
		wDriver.get("http://localhost:5173/sale/login");
		wDriver.findElement(By.id("email")).sendKeys("a@gmail.com");
		wDriver.findElement(By.id("password")).sendKeys("123456789");
		wDriver.findElement(By.id("login")).click();

		wDriver.close();
	}

}
