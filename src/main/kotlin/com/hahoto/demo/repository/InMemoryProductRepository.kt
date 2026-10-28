package com.hahoto.demo.repository

import com.hahoto.demo.domain.Product
import org.springframework.stereotype.Repository
import java.math.BigDecimal

@Repository
class InMemoryProductRepository : ProductRepository {

	private val products = listOf(
		Product(
			id = 1,
			name = "Mechanical Keyboard",
			description = "Hot-swappable 75% keyboard with brown switches",
			price = BigDecimal("129.99"),
			stock = 42,
		),
		Product(
			id = 2,
			name = "Noise Cancelling Headphones",
			description = "Over-ear wireless headphones with 40h battery",
			price = BigDecimal("249.00"),
			stock = 17,
		),
		Product(
			id = 3,
			name = "USB-C Hub",
			description = "7-in-1 hub with HDMI 4K, Ethernet and SD reader",
			price = BigDecimal("59.50"),
			stock = 0,
		),
		Product(
			id = 4,
			name = "Ergonomic Mouse",
			description = "Vertical wireless mouse with adjustable DPI",
			price = BigDecimal("79.95"),
			stock = 88,
		),
		Product(
			id = 5,
			name = "4K Monitor",
			description = "27-inch IPS display with 99% sRGB coverage",
			price = BigDecimal("389.00"),
			stock = 6,
		),
	)

	override fun findAll(): List<Product> = products

	override fun findById(id: Long): Product? = products.firstOrNull { it.id == id }
}
