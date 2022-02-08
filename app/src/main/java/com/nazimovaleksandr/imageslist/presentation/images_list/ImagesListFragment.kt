package com.nazimovaleksandr.imageslist.presentation.images_list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.nazimovaleksandr.imageslist.R
import com.nazimovaleksandr.imageslist.constants.BUNDLE_KEY_IMAGE_PATH
import com.nazimovaleksandr.imageslist.databinding.FragmentImagesListBinding
import com.nazimovaleksandr.imageslist.presentation.PresentationViewModelFactory
import com.nazimovaleksandr.imageslist.presentation.images_list.rv.ImagesAdapter

class ImagesListFragment : Fragment() {
    private var _binding: FragmentImagesListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ImagesViewModel by viewModels {
        PresentationViewModelFactory()
    }

    private var adapter: ImagesAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentImagesListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViewModel()
        initListeners()
    }

    override fun onResume() {
        super.onResume()

        binding.rvImagesList.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }

    private fun initViewModel() {
        viewModel.imagesList.observe(viewLifecycleOwner) {
            if (it.isNotEmpty()) {
                if (adapter == null) {
                    adapter = ImagesAdapter(it, imageOnClick)
                    Log.e("imagesList", "size: ${it.size}")

                    binding.rvImagesList.adapter = adapter
                } else {
                    adapter?.setImageList(it)
                }

                binding.swipe.isRefreshing = false
            }
        }
    }

    private fun initListeners() {
        binding.swipe.setOnRefreshListener {
            viewModel.loadImagesList()
        }
    }

    private val imageOnClick = fun(path: String) {
        val bundle = Bundle().apply {
            putString(BUNDLE_KEY_IMAGE_PATH, path)
        }

        findNavController().navigate(R.id.action_imagesListFragment_to_imageFragment, bundle)
    }
}