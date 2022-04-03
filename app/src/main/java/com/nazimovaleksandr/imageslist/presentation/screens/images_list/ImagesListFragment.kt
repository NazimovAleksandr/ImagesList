package com.nazimovaleksandr.imageslist.presentation.screens.images_list

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.nazimovaleksandr.imageslist.R
import com.nazimovaleksandr.imageslist.databinding.FragmentImagesListBinding
import com.nazimovaleksandr.imageslist.presentation.constants.BUNDLE_KEY_IMAGE_PATH
import com.nazimovaleksandr.imageslist.presentation.screens.factory.screen.BindingFactory
import com.nazimovaleksandr.imageslist.presentation.screens.factory.view_model.ViewModelFactory
import com.nazimovaleksandr.imageslist.presentation.screens.images_list.rv.ImagesAdapter
import javax.inject.Inject

class ImagesListFragment : BindingFactory<FragmentImagesListBinding>(
    FragmentImagesListBinding::inflate
) {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel: ImagesViewModel by viewModels { viewModelFactory }

    private var adapter: ImagesAdapter? = null

    override fun viewBindingCreated(savedInstanceState: Bundle?) {
        appComponent.inject(this)
        initViewModel()
        initListeners()
    }

    override fun onResume() {
        super.onResume()

        binding.rvImagesList.adapter = adapter
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

        viewModel.isInternetAvailable.observe(viewLifecycleOwner) {
            if (!it) {
                Toast.makeText(
                    requireContext(),
                    "Отсутствует интернет соединение",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        viewModel.getImagesList(context = requireContext())
    }

    private fun initListeners() {
        binding.swipe.setOnRefreshListener {
            viewModel.getImagesList(context = requireContext())
        }
    }

    private val imageOnClick = fun(path: String) {
        val bundle = Bundle().apply {
            putString(BUNDLE_KEY_IMAGE_PATH, path)
        }

        findNavController().navigate(R.id.action_imagesListFragment_to_imageFragment, bundle)
    }
}