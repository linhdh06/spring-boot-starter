package com.hahoto.demo.repository

import com.hahoto.demo.domain.Product

interface ProductRepository {

	fun findAll(): List<Product>

	fun findById(id: Long): Product?
}
