package com.example.articlescleanarchitecture.data.remote.parsedata


data class InventoryResponse(
    val epcs: List<String>,
    val stock: List<RemoteStock>
)