package com.example.smkcodingproject1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit_profile.*
import android.content.Intent
import android.app.Activity
import android.view.View
import android.widget.Toast

class EditProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        val intentData = intent.extras
        val namaUser = intentData?.getString("name")

        editNama.setText(namaUser)
        save_btn.setOnClickListener {saveData()}
    }

    private fun saveData () {
        val nameEdit = editNama.text.toString()
        if (!nameEdit.isEmpty()) {

            val result = Intent()
            result.putExtra("name", nameEdit)
            setResult(Activity.RESULT_OK,result)
        } else {
            setResult(Activity.RESULT_CANCELED)
        }
            finish()
    }

}
