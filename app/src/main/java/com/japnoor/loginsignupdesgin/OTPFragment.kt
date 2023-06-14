package com.japnoor.ecommerce

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import com.japnoor.ecommerce.databinding.FragmentOTPBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
class OTPFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding : FragmentOTPBinding
    lateinit var signUpActivity: SignUpActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentOTPBinding.inflate(layoutInflater,container,false)
        signUpActivity=activity as SignUpActivity

        binding.otp1.doOnTextChanged { text, start, before, count ->
            if (!binding.otp1.text.toString().isEmpty())
                binding.otp2.requestFocus()
            if(!binding.otp2.text.isEmpty())//Check temporary
                binding.otp2.requestFocus()
        }
        binding.otp2.doOnTextChanged { text, start, before, count ->
            if (!binding.otp2.text.toString().isEmpty())
                binding.otp3.requestFocus()
            else
                binding.otp1.requestFocus()
        }
        binding.otp3.doOnTextChanged { text, start, before, count ->
            if (!binding.otp3.text.toString().isEmpty())
                binding.otp4.requestFocus()
            else
                binding.otp2.requestFocus()
        }
        binding.otp4.doOnTextChanged { text, start, before, count ->
            if (!binding.otp4.text.toString().isEmpty())
                binding.otp5.requestFocus()
            else
                binding.otp3.requestFocus()
        }
        binding.otp5.doOnTextChanged { text, start, before, count ->
            if (binding.otp5.text.toString().isEmpty()) {
                binding.otp5.requestFocus()
            }

        }




        return binding.root
    }

}