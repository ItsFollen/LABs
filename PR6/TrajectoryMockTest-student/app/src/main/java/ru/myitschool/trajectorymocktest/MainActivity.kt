package ru.myitschool.trajectorymocktest

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.myitschool.trajectorymocktest.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    private val connectionURL: String = "https://gitee.com/"
    private lateinit var binding: ActivityMainBinding
    private lateinit var editTextLogin: EditText
    private lateinit var buttonSend: Button
    private lateinit var requestData: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        editTextLogin = findViewById(R.id.edit_text_login)
        buttonSend = findViewById(R.id.button_send)
        requestData = findViewById(R.id.requested_data)
        val retrofit = Retrofit.Builder()
            .baseUrl(connectionURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service: UserController = retrofit.create(UserController::class.java)
        buttonSend.setOnClickListener {
            requestData.text=""
            val call: Call<User> =
                service.getUser(editTextLogin.text.toString())
            call.enqueue(object : Callback<User> {
                override fun onResponse(call: Call<User>, response: Response<User>) {
                    if (response.code() == 200) {
                        val user: User? = response.body()
                        requestData.text = user?.public_repos.toString()
                        requestData.text = user?.name.toString()
                    }
                }
                override fun onFailure(call: Call<User>, t: Throwable) {
                    Log.d("TAG","Receive data from server problem: $t")
                }
            })
        }
    }
}

