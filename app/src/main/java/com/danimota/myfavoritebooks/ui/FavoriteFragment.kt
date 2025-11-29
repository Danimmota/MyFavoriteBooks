package com.danimota.myfavoritebooks.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.danimota.myfavoritebooks.R
import com.danimota.myfavoritebooks.databinding.FragmentFavoriteBinding
import com.danimota.myfavoritebooks.helper.BookConstants
import com.danimota.myfavoritebooks.ui.adapter.BookAdapter
import com.danimota.myfavoritebooks.ui.listener.BookListener
import com.danimota.myfavoritebooks.viewmodels.FavoriteViewModel

class FavoriteFragment : Fragment() {

    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding!!

    private val viewModel: FavoriteViewModel by viewModels()
    private val adapter: BookAdapter = BookAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, b: Bundle?): View {

        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)

        // Atribui um layout que diz como a RecyclerView se comporta
        binding.recyclerFavoriteBooks.layoutManager = LinearLayoutManager(context)

        // Define um adapater - Faz a ligação da RecyclerView com a listagem de itens
        binding.recyclerFavoriteBooks.adapter = adapter

        // Atribui implementação de listener
        attachBookListener()

        // Cria os observadores
        setObservers()

        // Retorna elemento raiz
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        viewModel.getFavorites()
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

     // Cria os observadores
    private fun setObservers() {
        viewModel.bookList.observe(viewLifecycleOwner) {
            if (it.isEmpty()) {
                showNoBooksViews(true)
            } else {
                showNoBooksViews(false)
                adapter.updateBooks(it)
            }
        }
    }

     /* Controla a visibilidade dos elementos da UI relacionados a livros favoritos.
     Exibe ou oculta a mensagem e imagem de "sem livros" e a RecyclerView de livros favoritos,
     com base no valor de "show". */
    private fun showNoBooksViews(show: Boolean) {
        binding.textviewNoBooks.visibility = if (show) View.VISIBLE else View.INVISIBLE
        binding.imageviewNoBooks.visibility = if (show) View.VISIBLE else View.INVISIBLE
        binding.recyclerFavoriteBooks.visibility = if (show) View.INVISIBLE else View.VISIBLE
    }
}
