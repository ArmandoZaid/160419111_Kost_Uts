package com.ubaya.a160419111_kost_uts.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.ubaya.a160419111_kost_uts.GlobalData
import com.ubaya.a160419111_kost_uts.R
import com.ubaya.a160419111_kost_uts.model.Kost
import com.ubaya.a160419111_kost_uts.viewModel.KostListViewModel
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_kost_list.*
/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    private lateinit var viewModel: KostListViewModel
    private val kostListAdapter = KostListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        GlobalData.currentFragment = "home"
        viewModel = ViewModelProvider(this).get(KostListViewModel::class.java)
        viewModel.refresh()

        recViewKost.layoutManager = LinearLayoutManager(context)
        recViewKost.adapter = kostListAdapter

        observeViewModel()
        refreshHome.setOnRefreshListener {
            recViewKost.visibility = View.GONE
            textError.visibility = View.GONE
            progressLoad.visibility = View.VISIBLE
            viewModel.refresh()
            refreshHome.isRefreshing = false
        }
        buttonMore.setOnClickListener {
            val action = HomeFragmentDirections.actionItemHomeToKostList()
            Navigation.findNavController(it).navigate(action)
        }
    }

    private fun observeViewModel() {
        viewModel.kostLD.observe(viewLifecycleOwner){
            val arraykost:List<Kost> = it.slice(0..3)
            kostListAdapter.updatekostlist(ArrayList(arraykost))
        }
        viewModel.kostLoadErrorLD.observe(viewLifecycleOwner){
            textError.visibility = if(it) View.VISIBLE else View.GONE
        }
        viewModel.loadingLD.observe(viewLifecycleOwner){
            if(it){
                recViewKost.visibility = View.GONE
                progressLoad.visibility = View.VISIBLE
            }
            else
            {
                recViewKost.visibility = View.VISIBLE
                progressLoad.visibility = View.GONE
            }
        }
    }

}