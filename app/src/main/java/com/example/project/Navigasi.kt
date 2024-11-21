package com.example.project

import MahasiswaViewModel
import android.view.View
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.project.model.ListGender
import com.example.project.model.ListGender.listJk
import com.example.project.ui.view.FormMahasiswaView
import com.example.simpleviewmodel.ui.view.DetailMahasiswaView

enum class Halaman{
    Form,
    Data
}

@Composable
fun Navigasi(
    modifier: Modifier = Modifier,
    viewModel: MahasiswaViewModel = viewModel(),
    navHostController: NavHostController = rememberNavController()

) {
    Scaffold { isipadding ->
        val uiState by viewModel.dataModel.collectAsState()
        NavHost(
            modifier = modifier.padding(isipadding),
            navController = navHostController, startDestination = Halaman.Form.name
        ) {
            composable(route = Halaman.Form.name) {
                val konteks = LocalContext.current
                FormMahasiswaView(
                    listGender = ListGender.listJk.map { isi ->
                        konteks.resources.getString(isi)
                    },
                    onSubmitClick = {
                        viewModel.saveDataMhs(it)
                        navHostController.navigate(Halaman.Data.name)
                    }
                )

            }
            composable(route = Halaman.Data.name) {
                DetailMahasiswaView(
                    uiStateMahasiswa = uiState,
                    onBackButtonClicked = {
                        navHostController.popBackStack()
                    }
                )
            }
        }
    }
}
