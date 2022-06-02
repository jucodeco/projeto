package com.example.pokemon.favoritos

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokemon.ColorType
import com.example.pokemon.favoritos.room.FavoriteRepository
import com.example.pokemon.favoritos.room.PokemonFavorito
import com.example.pokemon.favoritos.usecase.ExibirListaDePokemonsFavoritos
import com.example.pokemon.lista.PokemonItem
import java.lang.IndexOutOfBoundsException

class FavoritePokemonViewModel(private val usecase: ExibirListaDePokemonsFavoritos) : ViewModel() {
    fun loadPokemons() {

        Thread(Runnable {
            pokemons.postValue(usecase.get().map {
                PokemonItem(
                    it.imageUrl,
                    it.name.replaceFirstChar { it.uppercase() },
                    "Nº ${it.number.toString().padStart(3, '0')}",
                    it.types[0].name,
                    ColorType.getcolortype(it.types[0].name),
                    try {
                        it.types[1].name

                    } catch (e: IndexOutOfBoundsException) {
                        null
                    },
                    try {
                        ColorType.getcolortype(it.types[1].name)

                    } catch (e: IndexOutOfBoundsException) {
                        null
                    },
                    it.number,
                    isfav = true


                )
            })


        }).start()





    }

    var pokemons = MutableLiveData<List<PokemonItem?>>()
}
