package com.hahoto.demo.controller

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.server.LocalServerPort
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PageControllerTests {

	@LocalServerPort
	private var port: Int = 0

	private val client: HttpClient = HttpClient.newHttpClient()

	@ParameterizedTest
	@ValueSource(strings = ["/", "/app"])
	fun `serves the static page`(path: String) {
		val request = HttpRequest.newBuilder(URI.create("http://localhost:$port$path")).GET().build()
		val response = client.send(request, HttpResponse.BodyHandlers.ofString())

		assertEquals(200, response.statusCode())
		assertTrue(
			response.headers().firstValue("Content-Type").orElse("").startsWith("text/html"),
			"expected an HTML response",
		)
		assertTrue(response.body().contains("<title>Demo App</title>"), "expected the static page body")
	}
}
