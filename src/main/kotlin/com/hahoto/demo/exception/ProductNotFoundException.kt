package com.hahoto.demo.exception

class ProductNotFoundException(id: Long) : RuntimeException("Product with id $id was not found")
