package com.grappim.walletobserver.ui.login.signup

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import com.grappim.walletobserver.R
import com.grappim.walletobserver.core.extensions.launchActivity
import com.grappim.walletobserver.core.extensions.setSafeOnClickListener
import com.grappim.walletobserver.databinding.ActivitySignUpBinding
import com.grappim.walletobserver.ui.MainActivity

class SignUpActivity : AppCompatActivity(R.layout.activity_sign_up) {

    private val viewBinding: ActivitySignUpBinding by viewBinding(
        ActivitySignUpBinding::bind,
        R.id.containerSignUp
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding.checkBoxTos.setOnCheckedChangeListener { buttonView, isChecked ->

        }
        viewBinding.buttonFacebook.setSafeOnClickListener {

        }
        viewBinding.buttonGoogle.setSafeOnClickListener {

        }
        viewBinding.buttonLogIn.setSafeOnClickListener {
            if (!viewBinding.checkBoxTos.isChecked) {
                showAlertDialog()
            } else {
                launchActivity<MainActivity> { }
            }
        }
    }

    private fun showAlertDialog() {
        val dialog = AlertDialog.Builder(this)
            .setMessage(getString(R.string.sign_up_accept_tos))
            .setCancelable(true)
            .setPositiveButton(getString(android.R.string.ok)) { dialog, which ->
                dialog.dismiss()
            }
            .create()
        dialog.show()
    }
}