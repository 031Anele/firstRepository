package com.example.localop

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {


    //declare variables
    private lateinit var edtName: EditText
    private lateinit var edtAge: EditText
    private lateinit var cbStaff: CheckBox
    private lateinit var cbITStudent: CheckBox
    private lateinit var cbBanned: CheckBox
    private lateinit var btnCheck: Button
    private lateinit var tvResult: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        //Link the variables to the UI components using their ID's( Typecasting )

        edtName = findViewById(edtName)
        edtAge = findViewById (edtAge)
        cbStaff = findViewById (cbStaff)
        cbITStudent = findViewById (cbITStudent)
        cbBanned = findViewById (cbBanned)
        btnCheck = findViewById (btnCheck)
        tvResult = findViewById (tvResult)


        //button to run the code whe its clicked
        btnCheck.setOnClickListener {

            //get the user's name from the editText
            val name= edtName.text.toString()

            //convert the age entered into a number (Int)
            val age = edtAge.text.toString().toInt()

            //check if checkbox are selected (true of false)
            val isITstudent = cbITStudent.isChecked

            val isStaff = cbStaff.isChecked
            val isBanned = cbBanned.isChecked

            if (age >= 18 && isITstudent || isStaff) && !isBanned) {

                    //If the condition above  is true
                    tvResult.text = "congradulations $name! You qualify  for a student tech discount."

                } else {
                    //If the condition above is false
                tvResult.text = "Sorry $name, you dont qualify for the discount"

            }


            /*
            Logical condition explanation


                   Step 1: (age >= 18 && isITStudent)
                   >=means greater than or equal
                   && means AND (both cnditions must be true

               so this checks if the user is 18 or an IT student


            step2
            || means or (only one condition needs to be true
            this means the person can qualify if they are a staff member even if they are not an IT
            student

             step 3:&& !isBanned
             ! means NOT (it reverses the value)
            !isBanned means the person must NOT be banned

            example
            isBanned = false
            !false
             */





         }















        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}