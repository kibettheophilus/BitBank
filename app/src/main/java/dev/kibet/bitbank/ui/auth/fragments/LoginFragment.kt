package dev.kibet.bitbank.ui.auth.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint
import dev.kibet.bitbank.R
import dev.kibet.bitbank.databinding.FragmentLoginBinding
import dev.kibet.bitbank.ui.auth.activities.AuthActivity
import dev.kibet.bitbank.ui.home.activities.HomeActivity
import kotlin.math.log


class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogin.setOnClickListener {
            val email = binding.emailAddress.text?.trim().toString()
            val password = binding.passwordLogin.text?.trim().toString()

            if (email.isNullOrEmpty() || password.isNullOrEmpty()) {
                Toast.makeText(context, "All fields are required", Toast.LENGTH_LONG).show()
            } else {
                loginUser(email, password)
            }
        }

        binding.registerTv.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
    }

    private fun loginUser(email: String, password: String) {
        val progressBar = binding.loginProgress
        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                progressBar.visibility = View.VISIBLE
                findNavController().navigate(R.id.action_loginFragment_to_homeActivity)
            } else {
                Toast.makeText(context, "Please try again", Toast.LENGTH_LONG).show()
                progressBar.visibility = View.GONE
            }
        }
    }
}