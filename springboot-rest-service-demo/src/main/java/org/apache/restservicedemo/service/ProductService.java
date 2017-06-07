package org.apache.restservicedemo.service;

import java.util.Random;

import org.apache.restservicedemo.model.Product;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/product")
public class ProductService {
	@ApiOperation(value = "Get a product details", response = Product.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Successfully retrieved"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
    @RequestMapping(value="/show/{productId}", method = RequestMethod.GET)
    public Product getProduct(@PathVariable int productId) {
        return new Product(productId, "name"+productId, new Random().nextInt());
    }

}

