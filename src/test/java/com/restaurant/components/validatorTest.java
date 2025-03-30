package com.restaurant.components;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.FileInputStream;
import java.io.IOException;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;

import com.restaurant.validators.product.ProductValidators;

@SpringBootTest
public class validatorTest {

  @Autowired
  private ProductValidators productValidators;

  @ParameterizedTest
  @ValueSource(strings = { "src/test/java/com/restaurant/images/images.webp" })
  public void testValidatorImage(String route) throws IOException {
    FileInputStream fileInputStream = new FileInputStream(route);

    MockMultipartFile mockFile = new MockMultipartFile(
        "image",
        "test-image.jpg",
        "image/jpeg",
        fileInputStream);

    byte[] result = productValidators.addImageProduct(mockFile);

    assertNotNull(result, "the result not mull");
    // assertEquals(mockFile.getBytes().length, result.length, "El tamaño de los
    // bytes debe coincidir");
  }
}
