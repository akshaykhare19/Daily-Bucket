package com.akshay_apps.dailybucket

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.akshay_apps.dailybucket.databinding.FragmentUserInfoBinding
import java.lang.Boolean.getBoolean
import java.util.prefs.Preferences


class UserInfo : Fragment() {

    private var _binding: FragmentUserInfoBinding? = null
    private val binding get() = _binding

    val sharedPrefFile = "userNameFile"
    val completedUserInfo = "hasVisited"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val visitedPreferences: SharedPreferences = requireActivity().getSharedPreferences(completedUserInfo, Context.MODE_PRIVATE)
        val firstVisit = false
//        val visitEditor = visitedPreferences.edit()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentUserInfoBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sharedPreferences: SharedPreferences = requireActivity().getSharedPreferences(sharedPrefFile, Context.MODE_PRIVATE)

        val firstName = binding!!.firstName.text.toString()
        val lastName = binding!!.lastName.text.toString()

        val editor: SharedPreferences.Editor = sharedPreferences.edit()

        binding!!.submitBtn.setOnClickListener {

            if(firstName.isEmpty()) {
                binding!!.firstNameLayout.error = getString(R.string.mandatory_field_error)
            } else {
                editor.putString("FirstName", firstName)
            }

            editor.putString("LastName", lastName)
            editor.apply()                          //save the changes in background

        }
    }



}