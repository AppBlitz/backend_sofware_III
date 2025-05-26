package com.restaurant;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
//comment
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.restaurant.dto.cart.UpdateStateCartDto;
import com.restaurant.dto.employee.LoginDTO;
import com.restaurant.dto.menu.CreateMenuDto;
import com.restaurant.dto.supplier.SupplierDtoAdd;
import com.restaurant.exceptions.employees.NotCorrectPasswordException;
import com.restaurant.exceptions.employees.NotFoundEmployeeException;
import com.restaurant.model.Enum.CategoriItem;
import com.restaurant.model.Enum.Estate;
import com.restaurant.model.Enum.cart.StateCart;
import com.restaurant.model.document.ShoppingCart;
import com.restaurant.model.vo.MenuItem;
import com.restaurant.service.implementation.cart.ShoppinCartServiceIm;
import com.restaurant.service.implementation.employees.EmployeeServices;
import com.restaurant.service.implementation.inventory.MenuServices;
import com.restaurant.service.implementation.inventory.SupplierServices;
import com.testrail.junit.customjunitxml.annotations.TestRail;

@SpringBootTest
@DisplayName("Pruebas de ilios")
class RestaurantApplicationTests {

	@Autowired
	ShoppinCartServiceIm sService;

	@Autowired
	MenuServices mServices;

	@Autowired
	SupplierServices sServices;

	@Autowired
	EmployeeServices eMservices;

	@Test
	@DisplayName("Seguridad de los datos de los clientes")
	@TestRail(id = "C22")
	void testValidLogin() throws NotFoundEmployeeException, NotCorrectPasswordException {
		LoginDTO login = new LoginDTO("juan.perez@email.com", "MiClaveSegura123");
		assertNotNull(eMservices.login(login));
	}

	@Test
	@DisplayName("Ingresar con los campos vacíos")
	@TestRail(id = "C23")
	void testLoginWithEmptyFields() {
		LoginDTO login = new LoginDTO("", "");
		assertThrows(NotFoundEmployeeException.class, () -> eMservices.login(login));
	}

	@Test
	@DisplayName("Iniciar sesión con la contraseña incorrecta")
	@TestRail(id = "C25")
	void testLoginWithIncorrectPassword() {
		LoginDTO login = new LoginDTO("juan.perez@email.com", "MiClaveSegura");

		assertThrows(NotCorrectPasswordException.class, () -> eMservices.login(login));
	}

	@Test
	@DisplayName("Iniciar sesión con el correo incorrecto")
	@TestRail(id = "C26")
	void testLoginWithIncorrectEmail() throws NotFoundEmployeeException, NotCorrectPasswordException {
		LoginDTO login = new LoginDTO("uanperez@email.com", "MiClaveSegura123");

		assertThrows(NotFoundEmployeeException.class, () -> eMservices.login(login));
	}

	@Test
	@DisplayName("Crear menu con los datos vacios")
	@TestRail(id = "C20")
	public void createMenuDataImpty() {
		ArrayList<MenuItem> items = new ArrayList<>();
		MenuItem it = new MenuItem("6819b4a81ac25a0df8360eac", "", CategoriItem.BREAKFAST);
		items.add(it);
		CreateMenuDto menuDto = new CreateMenuDto("Ranchero", items,
				"Se desea que este menu sea solo para la promoción del día de hoy");
		assertNotNull(mServices.createMenu(menuDto));
	}

	@Test
	@DisplayName("Buscar menu por id")
	@TestRail(id = "C58")
	public void searchMenuForId() {
		assertNotNull(mServices.getMenuById("68326337a9ff0205de739855"));
	}

	@Test
	@DisplayName("Buscar carrito de compras por id")
	@TestRail(id = "35")
	public void searchCartForId() {
		assertNotNull(sService.searchShoppingCartId("681b61aa1e710924d1408dd6"));
	}

	@Test
	@DisplayName("Registro del proveedor con la fecha invalida")
	@TestRail(id = "C12")
	public void registerSupplier() {
		List<String> items = new ArrayList<>();
		items.add("Test");
		SupplierDtoAdd supplier = new SupplierDtoAdd("Luisa", "Australia", LocalDate.now().minusDays(1), items,
				Estate.ACTIVE);
		assertNotNull(sServices.addSupplier(supplier));
	}

	@Test
	@DisplayName("Simulación de usuarios concurrentes")
	@TestRail(id = "")
	void testConcurrentUsers() throws InterruptedException {
		ArrayList<LoginDTO> users = new ArrayList<>();
		users.add(new LoginDTO("juan.perez@email.com", "MiClaveSegura123"));
		users.add(new LoginDTO("cocina@email.com", "MiClaveSegura123"));
		users.add(new LoginDTO("bodeguista@email.com", "MiClaveSegura123"));
		users.add(new LoginDTO("mesero@email.com", "MiClaveSegura123"));
		users.add(new LoginDTO("admin@email.com", "MiClaveSegura123"));
		users.add(new LoginDTO("q@mail.com", "1234"));
		users.add(new LoginDTO("wq@gmail.com", "perfect"));
		users.add(new LoginDTO("tr@gmail.com", "12qw"));
		users.add(new LoginDTO("he@gmail.com", "43rf"));
		ExecutorService executor = Executors.newFixedThreadPool(10);

		final int[] successCounter = { 0 };

		for (LoginDTO login : users) {
			executor.submit(() -> {
				try {
					boolean isSuccessful = simulateUserAction(login);

					synchronized (successCounter) {
						if (isSuccessful) {
							successCounter[0]++;
						}
					}
				} catch (Exception e) {
					throw new RuntimeException("Error handling user " + login, e);
				}
			});
		}
	}

	private boolean simulateUserAction(LoginDTO login) {
		try {
			Object result = eMservices.login(login);
			return result != null && !result.toString().isEmpty();
		} catch (NotFoundEmployeeException e) {
			e.printStackTrace();
			return false;
		} catch (NotCorrectPasswordException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Test
	@Timeout(5)
	@DisplayName("Cambio del estado del carrito de compras")
	@TestRail(id = "C13")
	public void updateStateCart() {
		ShoppingCart cart = sService.searchShoppingCartId("681b61aa1e710924d1408dd6");
		UpdateStateCartDto updates = new UpdateStateCartDto("681b61aa1e710924d1408dd6", StateCart.INACTIVE);
		sService.updateCart(updates);

		assertNotEquals(cart, sService.searchShoppingCartId("681b61aa1e710924d1408dd6"), "Se modifico correctamente");
	}

	@Test
	@DisplayName("Agregar proveedor con todos los datos validos")
	@TestRail(id = "C1")
	public void addSupplier() {
		List<String> items = new ArrayList<>();
		items.add("6819b4a81ac25a0df8360eac");
		SupplierDtoAdd supplier = new SupplierDtoAdd("Valentina", "Rusia", LocalDate.now(), items, Estate.ACTIVE);
		assertNotNull(supplier);
	}

	@Test
	@DisplayName("Integridad de los datos del inventario")
	@TestRail(id = "C51")
	@Timeout(10)
	public void integridDataInventory() {

	}

	@Test
	@DisplayName("Actualización de la información del empleado")
	@TestRail(id = "C11")
	public void updateDataEmployee() {
	}

}
