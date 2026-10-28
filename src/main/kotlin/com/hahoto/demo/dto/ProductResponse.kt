package com.hahoto.demo.dto

import com.hahoto.demo.domain.Product
import java.math.BigDecimal

data class ProductResponse(
	val id: Long,
	val name: String,
	val description: String,
	val price: BigDecimal,
	val stock: Int,
	val inStock: Boolean,
)

fun Product.toResponse(): ProductResponse = ProductResponse(
	id = id,
	name = name,
	description = description,
	price = price,
	stock = stock,
	inStock = stock > 0,
)
