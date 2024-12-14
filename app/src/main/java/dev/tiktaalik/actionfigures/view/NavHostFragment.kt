package dev.tiktaalik.actionfigures.view

import androidx.fragment.app.viewModels
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import dev.tiktaalik.actionfigures.data.adapter.FigureListAdapter
import dev.tiktaalik.actionfigures.viewmodel.NavHostViewModel
import dev.tiktaalik.actionfigures.databinding.FragmentNavHostBinding

class NavHostFragment : Fragment() {

    companion object {
        fun newInstance() = NavHostFragment()
    }

    private val viewModel: NavHostViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Implementar View Binding
        val binding = FragmentNavHostBinding.inflate(inflater, container, false)
        val recyclerView = binding.myRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = FigureListAdapter(this)
        return binding.root
    }
}