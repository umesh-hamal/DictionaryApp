package com.umesh.dictionary.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.umesh.dictionary.model.DictionaryData
import com.umesh.dictionary.model.RetrofitInstance
import kotlinx.coroutines.launch

class DictionaryViewModel : ViewModel() {
    var isLoading by mutableStateOf(false)
        private set

    var wordData by mutableStateOf<DictionaryData?>(null)
        private set

    fun searchWord(word: String) {
        if (word.isBlank()) return
        viewModelScope.launch {
            isLoading = true
            try {
                val response = RetrofitInstance.api.getWordMeaning(word)
                wordData = response.firstOrNull()

            } catch (e: Exception) {

                wordData = null


            }
        }
        isLoading = false
    }
}