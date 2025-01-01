package com.example.bengkel.data.api

data class SignUpResponse(
    val status: String,  // Status pendaftaran: success atau error
    val message: String  // Pesan dari server
)
