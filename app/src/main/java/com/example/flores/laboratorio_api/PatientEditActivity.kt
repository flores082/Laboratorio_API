package com.example.flores.laboratorio_api

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.flores.laboratorio_api.entity.Patient

class PatientEditActivity : AppCompatActivity() {

    private lateinit var editTextName: EditText
    private lateinit var editTextEmail: EditText
    private lateinit var editTextRoom: EditText
    private lateinit var editTextAge: EditText
    private lateinit var buttonSaveChanges: Button

    private lateinit var patient: Patient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_patient_edit)

        // Initialize UI elements
        editTextName = findViewById(R.id.editTextName)
        editTextEmail = findViewById(R.id.editTextEmail)
        editTextRoom = findViewById(R.id.editTextRoom)
        editTextAge = findViewById(R.id.editTextAge)
        buttonSaveChanges = findViewById(R.id.buttonSave)

        patient = intent.getParcelableExtra("patient")!!

        editTextName.setText(patient.name)
        editTextEmail.setText(patient.email)
        editTextRoom.setText(patient.room)
        editTextAge.setText(patient.age.toString())

        buttonSaveChanges.setOnClickListener {

            val updatedName = editTextName.text.toString()
            val updatedEmail = editTextEmail.text.toString()
            val updatedRoom = editTextRoom.text.toString()
            val updatedAge = editTextAge.text.toString().toIntOrNull() ?: 0


            patient = patient.copy(
                name = updatedName,
                email = updatedEmail,
                room = updatedRoom,
                age = updatedAge
            )


            val resultIntent = Intent()
            resultIntent.putExtra("patient", patient)
            resultIntent.putExtra("position",intent.getIntExtra("position",0))
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }
}
