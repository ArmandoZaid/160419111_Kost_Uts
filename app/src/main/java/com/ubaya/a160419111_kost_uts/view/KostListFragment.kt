package com.ubaya.a160419111_kost_uts.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ubaya.a160419111_kost_uts.viewModel.KostListViewModel
import com.ubaya.a160419111_kost_uts.GlobalData
import com.ubaya.a160419111_kost_uts.R
import kotlinx.android.synthetic.main.fragment_kost_list.*
/**
 * A simple [Fragment] subclass.
 * Use the [KostListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class KostListFragment : Fragment() {
    private lateinit var viewModel:KostListViewModel
    private val kostListAdapter = KostListAdapter(arrayListOf())
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kost_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        GlobalData.currentFragment = "listKost"
        viewModel = ViewModelProvider(this).get(KostListViewModel::class.java)
        viewModel.refresh()

        recKost.layoutManager = LinearLayoutManager(context)
        recKost.adapter = kostListAdapter

        observeViewModel()

        refreshKostList.setOnRefreshListener {
            recKost.visibility = View.GONE
            textViewErrorKost.visibility = View.GONE
            progressLoadKost.visibility = View.VISIBLE
            viewModel.refresh()
            refreshKostList.isRefreshing = false
        }
    }

    private fun observeViewModel() {
        viewModel.kostLD.observe(viewLifecycleOwner){
            kostListAdapter.updatekostlist(it)
        }
        viewModel.kostLoadErrorLD.observe(viewLifecycleOwner){
            textViewErrorKost.visibility = if(it) View.VISIBLE else View.GONE
        }
        viewModel.loadingLD.observe(viewLifecycleOwner){
            if(it){
                recKost.visibility = View.GONE
                progressLoadKost.visibility = View.VISIBLE
            }
            else
            {
                recKost.visibility = View.VISIBLE
                progressLoadKost.visibility = View.GONE
            }
        }
    }

}