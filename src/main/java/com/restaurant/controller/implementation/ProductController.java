package com.restaurant.controller.implementation;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.controller.intefac.ProductControllerInterface;

@RestController
@RequestMapping("product")
public class ProductController implements ProductControllerInterface {

}
