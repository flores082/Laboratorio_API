package com.example.flores.laboratorio_api.adapters

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.TextView
import com.example.flores.laboratorio_api.R
import com.example.flores.laboratorio_api.entity.Patient

class PatientDetailDialog(
    context: Context,
    private val patient: Patient
) : Dialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.dialog_patient_detail)

        val textViewName = findViewById<TextView>(R.id.textViewName)
        val textViewEmail = findViewById<TextView>(R.id.textViewEmail)
        val textViewRoom = findViewById<TextView>(R.id.textViewRoom)
        val textViewAge = findViewById<TextView>(R.id.textViewAge)
        val buttonGoBack = findViewById<Button>(R.id.buttonAddAndGoBack)

        // Set patient information in TextViews
        textViewName.text = patient.name
        textViewEmail.text = patient.email
        textViewRoom.text = patient.room
        textViewAge.text = patient.age.toString()

        // Set a click listener for the "Go Back" button to dismiss the dialog
        buttonGoBack.setOnClickListener {
            dismiss()
        }
    }
}
