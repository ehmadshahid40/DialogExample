package com.example.dialogexample

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btnAlert = findViewById<Button>(R.id.btn)
         var fruits = arrayOf("apple", "Banana", "mango")

        btnAlert.setOnClickListener{
            val alertDialogBuilder = AlertDialog.Builder(this@MainActivity)
            alertDialogBuilder.setTitle("Title is here")

            alertDialogBuilder.setCancelable(false)

            alertDialogBuilder.setItems(fruits){_, which->
             when(which){
                 which ->{
                     Toast.makeText(this@MainActivity,fruits[which], Toast.LENGTH_LONG).show()
                 }
             }
            }
            alertDialogBuilder.setPositiveButton("Yes"){_, _ ->
                finish()
            }
            alertDialogBuilder.setNegativeButton("No"){_,_ ->
                Toast.makeText(this@MainActivity,"clicked No",Toast.LENGTH_LONG).show()

            }
            val alertDialogBox = alertDialogBuilder.create()
            alertDialogBox.show()
        }
    }
}