package com.example.animation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.example.animation.databinding.FragmentBlankBinding
import java.lang.StringBuilder
import kotlin.math.PI
import kotlin.math.sin


class BlankFragment(private val list:ArrayList<String>,private val colors:MutableList<Int>,private val position:Int) : Fragment() {
    private  var _binding:FragmentBlankBinding?=null
    private val binding get() = _binding!!



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentBlankBinding.inflate(layoutInflater)
        binding.textView.text=list[position]
        binding.textView.textSize= (80+position*6).toFloat()
        binding.textView.setTextColor(ContextCompat.getColor(requireContext(),colors[position]))
        binding.textView.setBackgroundColor(ContextCompat.getColor(requireContext(),colors[position]))
        binding.textView.gravity=position

        // Inflate the layout for this fragment
        return binding.root
    }


}