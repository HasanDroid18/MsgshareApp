package com.example.msgshareapp.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.msgshareapp.R
import com.example.msgshareapp.showToast


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btnShowToast: Button = findViewById(R.id.btnShowToast)
        btnShowToast.setOnClickListener {
            Log.i("MainActivity", "Button clicked!")
            showToast("Button Clicked!")
//            Toast.makeText(this, "Button clicked!", Toast.LENGTH_SHORT).show()
        }

        val sendMessage: Button = findViewById(R.id.sendbtn)
        sendMessage.setOnClickListener{
            val message: String = findViewById<EditText>(R.id.userMessage).text.toString()
//            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("user_message",message)
            startActivity(intent)

        }

        val shareTobtn: Button = findViewById(R.id.btnShareToOtherApps)
        shareTobtn.setOnClickListener {
            val message: String = findViewById<EditText>(R.id.userMessage).text.toString()

            val intent =Intent()
            intent.action =Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT,message)
            intent.type = "text/plain"
            startActivity(Intent.createChooser(intent,"Share to: "))

        }

        val btnRecyclerViewDemo: Button = findViewById(R.id.btnRecyclerViewDemo)
        btnRecyclerViewDemo.setOnClickListener {
            val intent = Intent(this, HobbiesActivity::class.java)
            startActivity(intent)
        }

    };
}