package com.example.bengkel.data.api

data class LoginResponse(
    val status: String,
    val message: String?,
    val data: UserData? // Sesuaikan dengan struktur respons server Anda
)
data class UserData(
    val userId: Int, // Untuk mencocokkan "userId" dari JSON
    val name: String, // Untuk mencocokkan "name" dari JSON
    val email: String, // Untuk mencocokkan "email" dari JSON
    val role: String // Untuk mencocokkan "role" dari JSON
)