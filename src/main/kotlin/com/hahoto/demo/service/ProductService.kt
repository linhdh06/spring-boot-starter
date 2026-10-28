package com.hahoto.demo.service

import com.hahoto.demo.dto.ProductResponse
import com.hahoto.demo.dto.toResponse
import com.hahoto.demo.exception.ProductNotFoundException
import com.hahoto.demo.repository.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductService(private val productRepository: ProductRepository) {

	fun getProducts(): List<ProductResponse> =
		productRepository.findAll().map { it.toResponse() }

	fun getProduct(id: Long): ProductResponse =
		(productRepository.findById(id) ?: throw ProductNotFoundException(id)).toResponse()
}
