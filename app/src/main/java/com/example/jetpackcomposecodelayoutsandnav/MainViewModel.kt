package com.example.jetpackcomposecodelayoutsandnav

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    var topBarTitle by mutableStateOf("")

    fun onTitleChanged(newTitle: String) {
        topBarTitle = newTitle
    }
}
