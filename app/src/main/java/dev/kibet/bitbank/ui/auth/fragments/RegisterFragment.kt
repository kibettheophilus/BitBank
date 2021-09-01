package dev.kibet.bitbank.ui.auth.fragments

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import dev.kibet.bitbank.R
import dev.kibet.bitbank.databinding.FragmentRegisterBinding
import dev.kibet.bitbank.ui.auth.viewmodel.AuthViewModel


class RegisterFragment : Fragment() {
    private lateinit var binding: FragmentRegisterBinding
    private val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnRegister.setOnClickListener {
            val email = binding.emailInput.text?.trim().toString()
            val password = binding.passwordInput.text?.trim().toString()
            val progressBar = binding.registerProgress

            progressBar.visibility = View.VISIBLE
            if (email.isNullOrEmpty() || password.isNullOrEmpty()) {
                progressBar.visibility = View.GONE
                Toast.makeText(context, "All fields are required", Toast.LENGTH_LONG).show()
            } else {
                createUser(email, password)
            }
        }

        binding.loginTv.setOnClickListener {
            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }
    }

    private fun createUser(email: String, password: String) {
        val progressBar = binding.registerProgress
        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    progressBar.visibility = View.GONE
                    findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
                } else {
                    progressBar.visibility = View.GONE
                    Toast.makeText(context, "An error occured", Toast.LENGTH_LONG).show()
                }
            }
    }

}