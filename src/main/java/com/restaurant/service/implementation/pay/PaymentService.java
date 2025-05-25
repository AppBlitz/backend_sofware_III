package com.restaurant.service.implementation.pay;

import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.common.AddressRequest;
import com.mercadopago.client.common.IdentificationRequest;
import com.mercadopago.client.common.PhoneRequest;
import com.mercadopago.client.preference.*;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.payment.Payment;
import com.mercadopago.resources.preference.Preference;
import com.restaurant.model.document.Product;
import com.restaurant.model.document.Recipe;
import com.restaurant.model.vo.Items;
import com.restaurant.model.vo.MenuItem;
import com.restaurant.repository.ProductRepository;
import com.restaurant.repository.RecipeRepository;
import com.restaurant.service.implementation.inventory.ProductService;
import com.restaurant.service.implementation.inventory.RecipeServices;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PaymentService {

    @Value("${mercado_pago_sample_access_token}")
    String PROD_ACCESS_TOKEN;

    ProductService productService;

    RecipeServices recipeServices;

    public Preference createPayment(List<Items> itemspay) throws MPException, MPApiException {
        MercadoPagoConfig.setAccessToken(PROD_ACCESS_TOKEN);

        List<PreferenceItemRequest> items = new ArrayList<>();

        for (Items item : itemspay) {
            MenuItem menuItem = item.getMenuItem();

            boolean hasRecipe = menuItem.getRecipe() != null && !menuItem.getRecipe().isBlank();
            boolean hasProduct = menuItem.getProduct() != null && !menuItem.getProduct().isBlank();

            // Validación de campos mutuamente excluyentes
            if (hasRecipe == hasProduct) {
                throw new IllegalArgumentException("Cada MenuItem debe tener solo 'recipe' o 'product', no ambos ni ninguno.");
            }

            PreferenceItemRequest itemRequest;

            if (hasProduct) {
                Product producto = productService.getProduct(menuItem.getProduct());

                itemRequest = PreferenceItemRequest.builder()
                        .id(UUID.randomUUID().toString())
                        .title(producto.getNameProduct())
                        .description(" ")
                        .pictureUrl("") // podrías cargar aquí una URL si tienes imagen
                        .categoryId(menuItem.getCategoriItem().toString())
                        .quantity(item.getAmountServings())
                        .currencyId("COP")
                        .unitPrice(BigDecimal.valueOf(producto.getPriceProduct()))
                        .build();

            } else {
                Recipe recipe = recipeServices.getRecipeById(menuItem.getRecipe());

                itemRequest = PreferenceItemRequest.builder()
                        .id(UUID.randomUUID().toString())
                        .title(recipe.getName())
                        .description(recipe.getInstructions())
                        .pictureUrl("")
                        .categoryId(menuItem.getCategoriItem().toString())
                        .quantity(item.getAmountServings())
                        .currencyId("COP")
                        .unitPrice(BigDecimal.valueOf(recipe.getPrice()))
                        .build();
            }

            items.add(itemRequest);
        }

        PreferenceBackUrlsRequest backUrls = PreferenceBackUrlsRequest.builder()
                .success("https://ilios-application-web.netlify.app/home")
                .pending("https://ilios-application-web.netlify.app/")
                .failure("https://ilios-application-web.netlify.app/")
                .build();

        PreferenceRequest preferenceRequest = PreferenceRequest.builder()
                .backUrls(backUrls)
                .items(items)
                .build();

        return new PreferenceClient().create(preferenceRequest);
    }




}
