package com.example.pets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    var mes: List<String> = listOf()

    fun text()= runBlocking {
        GlobalScope.launch{
            mes = RetrofitClient().service.getBreeds()?.body()?.message!!
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()

        val btn1 = findViewById<Button>(R.id.btn1)
        val txt1 = findViewById<TextView>(R.id.txt1)
        val image = findViewById<ImageView>(R.id.image)
        var breeds = ""
        text()
        btn1.setOnClickListener {
            Picasso.get().load(mes[0]).into(image)
            breeds = mes[0].substring(30).substringBefore('/').replaceFirstChar{it.titlecase()}
            for (i in 1..9) {
                breeds+="\n"+mes[i].substring(30).substringBefore('/').replaceFirstChar{it.titlecase()}
            }
            txt1.setText(breeds)
            text()
        }
    }
}