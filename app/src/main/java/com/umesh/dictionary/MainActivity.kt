package com.umesh.dictionary

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import com.umesh.dictionary.ui.theme.DictionaryTheme
import com.umesh.dictionary.view.DictionaryUI
import com.umesh.dictionary.viewmodel.DictionaryViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DictionaryTheme {
                val dictionaryViewModel: DictionaryViewModel = viewModel()
                DictionaryUI(dictionaryViewModel)
            }
        }
    }
}
