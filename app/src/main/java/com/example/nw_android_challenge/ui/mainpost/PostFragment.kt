package com.example.nw_android_challenge.ui.mainpost

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nw_android_challenge.commons.base.BaseFragment
import com.example.nw_android_challenge.databinding.FragmentPostBinding
import com.example.nw_android_challenge.ui.mainpost.adapter.PostAdapter
import kotlinx.android.synthetic.main.fragment_post.*


class PostFragment : BaseFragment() {

    private val viewModel: PostViewModel by viewModels{ viewModelFactory }
    private lateinit var binding: FragmentPostBinding
    private lateinit var adapter: PostAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPostBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = this@PostFragment.viewModel
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeViewModel()
        loadadapter()

        postListRefresh.setOnRefreshListener { handleRefreshData() }
    }

    private fun observeViewModel() {
        viewModel.postData.observe(viewLifecycleOwner, Observer { adapter.submitList(it) })
    }

    private fun handleRefreshData() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun loadadapter() {
        adapter = PostAdapter()
        postRecycler.layoutManager = LinearLayoutManager(requireContext())
        postRecycler.adapter = adapter

        adapter.onClickAction = { }
    }

}
