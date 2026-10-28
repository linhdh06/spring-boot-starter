package com.hahoto.demo.controller

import com.hahoto.demo.dto.ProductResponse
import com.hahoto.demo.service.ProductService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/products")
class ProductController(private val productService: ProductService) {

	@GetMapping
	fun getProducts(): List<ProductResponse> = productService.getProducts()

	@GetMapping("/{id}")
	fun getProduct(@PathVariable id: Long): ProductResponse = productService.getProduct(id)
}
