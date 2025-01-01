package com.example.bengkel.presentation

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.bengkel.R
import com.example.bengkel.data.api.ApiClient
import com.example.bengkel.data.api.SignUpResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {

    private lateinit var nameEt: EditText
    private lateinit var emailEt: EditText
    private lateinit var passwordEt: EditText
    private lateinit var confirmPasswordEt: EditText
    private lateinit var btnRegisterSubmit: Button
    private lateinit var loginPrompt: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register) // Pastikan layout ini sesuai

        // Inisialisasi komponen UI
        nameEt = findViewById(R.id.etName)
        emailEt = findViewById(R.id.etRegisterEmail)
        passwordEt = findViewById(R.id.etRegisterPassword)
        confirmPasswordEt = findViewById(R.id.etConfirmPassword)
        btnRegisterSubmit = findViewById(R.id.btnRegisterSubmit)
        loginPrompt = findViewById(R.id.tvLoginPrompt)

        // Aksi klik tombol daftar
        btnRegisterSubmit.setOnClickListener {
            signUpUser()
        }

        // Aksi klik teks untuk menuju login
        loginPrompt.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }

    // Fungsi untuk mendaftar
    private fun signUpUser() {
        val name = nameEt.text.toString().trim()
        val email = emailEt.text.toString().trim()
        val password = passwordEt.text.toString().trim()
        val confirmPassword = confirmPasswordEt.text.toString().trim()

        // Validasi input
        if (name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            Toast.makeText(this, "Semua kolom harus diisi", Toast.LENGTH_SHORT).show()
            return
        }

        // Validasi password dan konfirmasi password
        if (password != confirmPassword) {
            Toast.makeText(this, "Password dan konfirmasi password tidak cocok", Toast.LENGTH_SHORT).show()
            return
        }

        // Kirim data ke server
        val apiService = ApiClient.apiService
        apiService.registerUser(name, email, password).enqueue(object : Callback<SignUpResponse> {
            override fun onResponse(call: Call<SignUpResponse>, response: Response<SignUpResponse>) {
                if (response.isSuccessful && response.body()?.status == "success") {
                    // Pendaftaran berhasil
                    Toast.makeText(this@SignUpActivity, "Pendaftaran berhasil", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this@SignUpActivity, HomeActivity::class.java))
                    finish()
                } else {
                    // Pendaftaran gagal
                    Toast.makeText(this@SignUpActivity, response.body()?.message ?: "Pendaftaran gagal", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<SignUpResponse>, t: Throwable) {
                // Kesalahan koneksi atau server
                Toast.makeText(this@SignUpActivity, "Gagal terhubung ke server", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
