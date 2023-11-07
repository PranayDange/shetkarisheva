package com.example.shetkarisheva

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import com.example.shetkarisheva.databinding.FragmentShetkariDefaultBinding

class ShetkariDefaultFragment : Fragment() {
    private var _binding: FragmentShetkariDefaultBinding? = null
    private val binding get() = _binding!!

    val soilArray = listOf(
        Soil(1, "Red", "About soil Red"),
        Soil(2, "Black", "About soil Black"),
        Soil(3, "RedBlack", "About soil RedBlack"),
        Soil(4, "Moist", "About soil Moist"),
        Soil(5, "Loose", "About soil Loose"),
        Soil(6, "DarkBlack", "About soil DarkBlack")
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentShetkariDefaultBinding.inflate(inflater, container, false)
        val soil = context?.let { SoilAdapter(it, soilArray) }
        binding.soilSelector.adapter = soil
        binding.soilSelector.setSelection(5)
        binding.soilSelector.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedSoil = soilArray[position]
                Toast.makeText(requireContext(), "Selected soil: ${selectedSoil.name}", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                // Handle when nothing is selected
            }
        }

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
