package com.ubaya.a160419111_kost_uts.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ubaya.a160419111_kost_uts.R
/**
 * A simple [Fragment] subclass.
 * Use the [FavoritFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FavoritFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorit, container, false)
    }
}