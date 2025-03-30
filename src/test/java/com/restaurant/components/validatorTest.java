package com.restaurant.components;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.FileInputStream;
import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;

import com.restaurant.validators.product.ProductValidators;

@SpringBootTest
public class validatorTest {

  @Autowired
  private ProductValidators productValidators;

  @Test
  public void testValidatorImage() throws IOException {
    String filePath = "src/test/java/com/restaurant/images/images.webp";
    FileInputStream fileInputStream = new FileInputStream(filePath);

    MockMultipartFile mockFile = new MockMultipartFile(
        "image",
        "test-image.jpg",
        "image/jpeg",
        fileInputStream);

    byte[] result = productValidators.addImageProduct(mockFile);

    assertNotNull(result, "El resultado no debe ser nulo");
    assertEquals(mockFile.getBytes().length, result.length, "El tamaño de los bytes debe coincidir");
  }
}
