package com.danimota.myfavoritebooks.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.danimota.myfavoritebooks.R
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.danimota.myfavoritebooks.databinding.FragmentHomeBinding
import com.danimota.myfavoritebooks.helper.BookConstants
import com.danimota.myfavoritebooks.ui.adapter.BookAdapter
import com.danimota.myfavoritebooks.ui.listener.BookListener
import com.danimota.myfavoritebooks.viewmodels.HomeViewModel

class HomeFragment : Fragment()  {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HomeViewModel by viewModels()
    //adapter - diz como a lista de livros vai se conectar com o layout
    private val adapter: BookAdapter = BookAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, b: Bundle?): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        // Atribui um layout que diz como a RecyclerView se comporta
        binding.recyclerviewBooks.layoutManager = LinearLayoutManager(context)

        // Define um adapater - Faz a ligação da RecyclerView com a listagem de itens
        binding.recyclerviewBooks.adapter = adapter
        // Atribui implementação de listener
        attachBookListener()

        // Cria os observadores
        observe()

        // Retorna elemento raiz
        return binding.root
    }
    override fun onResume() {
        super.onResume()
        viewModel.getAll()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun attachBookListener() {
        adapter.attachListener(object : BookListener {
            override fun onClick(id: Int) {

                // Passando a informação do livro para a Fragment
                val bundle = Bundle()
                bundle.putInt(BookConstants.KEY.BOOK_ID, id)

                // Inicializa fragment de detalhes
                findNavController().navigate(R.id.navigation_book_details, bundle)
            }

            override fun onFavorite(id: Int) {
                viewModel.favorite(id)
            }
        })
    }
    private fun observe() {
        viewModel.bookList.observe(viewLifecycleOwner) {
            adapter.updateBooks(it)
        }
    }
}