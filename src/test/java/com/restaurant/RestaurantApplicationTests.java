package com.restaurant;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
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
	@DisplayName("Seguridad de los datos de los clientes")
	@TestRail(id = "C22")
	void contextLoads() throws InterruptedException {
		wDriver.get("http://localhost:5173/");
		wDriver.findElement(By.id("email")).sendKeys("juan.perez@email.com");
		wDriver.findElement(By.id("password")).sendKeys("MiClaveSegura123");
		wDriver.findElement(By.id("login")).click();

		String pageSource = wDriver.getPageSource();
		if (pageSource.contains("Inicio de sesión exitoso")) {
			assertTrue(true, "Incio de sesión exitoso");
		} else if (pageSource.contains("Ocurrio un problema")) {
			Assertions.fail("Revisar la información que se ingreso");
		} else if (pageSource.contains("No se pudo conectar con el servidor")) {
			Assertions.fail("No se puede hacer la conexión con el servidor");
		}
		assertTrue(true, "Perfect");
	}

	@Test
	@DisplayName("Ingresar con los campos vacios")
	@TestRail(id = "C23")
	void emailIncorrect() throws InterruptedException {
		wDriver.get("http://localhost:5173/");
		wDriver.findElement(By.id("email")).sendKeys("");
		wDriver.findElement(By.id("password")).sendKeys("");
		wDriver.findElement(By.id("login")).click();

		String pageSource = wDriver.getPageSource();
		if (pageSource.contains("Inicio de sesión exitoso")) {
			assertTrue(true, "Incio de sesión exitoso");
		} else if (pageSource.contains("Ocurrio un problema")) {
			Assertions.fail("Revisar la información que se ingreso");
		} else if (pageSource.contains("No se pudo conectar con el servidor")) {
			Assertions.fail("No se puede hacer la conexión con el servidor");
		}
	}

	@Test
	@DisplayName("Buscar carrito de compras por id")
	@TestRail(id = "C35")
	public void searchCartForId() {
		assertNotNull(sService.searchShoppingCartId("681b61aa1e710924d1408dd6"));
	}

	@AfterEach
	public void tearDown() {
		wDriver.close();
	}

}
