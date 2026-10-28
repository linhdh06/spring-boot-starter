package com.hahoto.demo.exception

import com.hahoto.demo.dto.ApiError
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.time.Instant

@RestControllerAdvice
class GlobalExceptionHandler {

	@ExceptionHandler(ProductNotFoundException::class)
	fun handleProductNotFound(
		exception: ProductNotFoundException,
		request: HttpServletRequest,
	): ResponseEntity<ApiError> = ResponseEntity.status(HttpStatus.NOT_FOUND).body(
		ApiError(
			timestamp = Instant.now(),
			status = HttpStatus.NOT_FOUND.value(),
			error = HttpStatus.NOT_FOUND.reasonPhrase,
			message = exception.message ?: "Not found",
			path = request.requestURI,
		),
	)
}
