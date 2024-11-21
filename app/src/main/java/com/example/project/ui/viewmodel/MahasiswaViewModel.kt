package com.example.project.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.project.model.Mahasiswa
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MahasiswaViewModel : ViewModel() {
    val uiState: Any

    //only access internal
    private val _dataModel = MutableStateFlow(Mahasiswa())

    val dataModel:StateFlow<Mahasiswa> = _dataModel.asStateFlow()


