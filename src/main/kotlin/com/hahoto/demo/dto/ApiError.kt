package com.hahoto.demo.dto

import java.time.Instant

data class ApiError(
	val timestamp: Instant,
	val status: Int,
	val error: String,
	val message: String,
	val path: String,
)
