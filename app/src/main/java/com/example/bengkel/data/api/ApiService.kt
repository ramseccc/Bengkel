package com.example.bengkel.data.api

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {

    @FormUrlEncoded
    @POST("login.php")  // URL login (gunakan URL yang sesuai untuk login)
    fun loginUser(
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("role") role: String
    ): Call<LoginResponse>

    @FormUrlEncoded
    @POST("register.php")  // Gantilah dengan endpoint yang sesuai untuk pendaftaran
    fun registerUser(
        @Field("email") email: String,
        @Field("password") password: String,
        password1: String
    ): Call<SignUpResponse>
}
