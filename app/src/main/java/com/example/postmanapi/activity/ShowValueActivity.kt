package com.example.postmanapi.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.postmanapi.adapter.ShowValueActivityAdapter
import com.example.postmanapi.databinding.ActivityMainBinding
import com.example.postmanapi.databinding.ActivityShowValueBinding
import com.example.postmanapi.model.Response
import com.example.postmanapi.util.RetrofitInstance
import retrofit2.Call

class ShowValueActivity : AppCompatActivity() {
    private lateinit var binding: ActivityShowValueBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        binding = ActivityShowValueBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.rcvw.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        RetrofitInstance.retrofit.postData(435643653467655).enqueue(object : retrofit2.Callback<Response>{

            override fun onResponse(call: Call<Response>, response: retrofit2.Response<Response>) {
                var showitemslists = response.body()?.data
                val adapter = ShowValueActivityAdapter(this@ShowValueActivity, showitemslists)
                binding.rcvw.adapter = adapter
            }
            override fun onFailure(call: Call<Response>, t: Throwable) {
                Toast.makeText(this@ShowValueActivity,"Failure", Toast.LENGTH_LONG).show()
            }
        })
    }
}