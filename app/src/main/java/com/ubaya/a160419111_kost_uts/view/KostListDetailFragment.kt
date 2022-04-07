package com.ubaya.a160419111_kost_uts.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.ubaya.a160419046_ubayakost.util.loadImage
import com.ubaya.a160419111_kost_uts.R
import com.ubaya.a160419111_kost_uts.viewModel.KostDetailViewModel
import kotlinx.android.synthetic.main.fragment_detail_kamar_kost.*
import kotlinx.android.synthetic.main.fragment_profile.*
/**
 * A simple [Fragment] subclass.
 * Use the [KostListDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class KostListDetailFragment : Fragment() {
    private lateinit var viewModel: KostDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_kamar_kost, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var id = ""
        arguments?.let {
            id = KostListDetailFragmentArgs.fromBundle(requireArguments()).kostid
        }
        viewModel = ViewModelProvider(this).get(KostDetailViewModel::class.java)
        viewModel.fetch(id)

        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.kostLD.observe(viewLifecycleOwner){
            textViewNama.text = it.nama
            textViewJenisKos.text = it.jenis
            textViewHarga.text = it.harga
            textViewFasilitas.text = it.fasilitas
            textViewAlamat.text = it.alamat
            imageViewKostDetail.loadImage(it.foto,progressBarPhotoDetail)
        }
    }

}