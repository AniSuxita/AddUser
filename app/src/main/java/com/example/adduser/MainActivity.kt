package com.example.adduser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.adduser.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener{

            FirebaseAuth.getInstance()
                .createUserWithEmailAndPassword(binding.Email.text.toString(),binding.password.text.toString())
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful){
                        Toast.makeText(this,"წარმატებით შეიქმნა",Toast.LENGTH_LONG).show()

                    } else {

                        Toast.makeText(this,"მომხმარებელი ვერ შეიქმნა",Toast.LENGTH_LONG).show()

                    }

                }

        }




    }
}