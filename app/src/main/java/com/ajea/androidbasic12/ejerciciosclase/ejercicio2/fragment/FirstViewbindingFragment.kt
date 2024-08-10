package com.ajea.androidbasic12.ejerciciosclase.ejercicio2.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ajea.androidbasic12.R
import com.ajea.androidbasic12.databinding.FragmentFirstViewbindingBinding


class FirstViewbindingFragment : Fragment() {

    private lateinit var binding : FragmentFirstViewbindingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFirstViewbindingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btNext.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment, SecondFragment.newInstance())
                .addToBackStack("SecondFragment")
                .commit()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = FirstViewbindingFragment()
    }
}