package com.example.simpleviewmodel.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.project.model.Mahasiswa

@Composable
fun DetailMahasiswaView(
    uiStateMahasiswa: Mahasiswa,
    onBackButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
){
    val  listDataMhs = listOf(
        Pair("Nama", uiStateMahasiswa.nama),
        Pair("Nim", uiStateMahasiswa.nim),
        Pair("Gender", uiStateMahasiswa.gender),
        Pair("Alamat", uiStateMahasiswa.alamat),
    )
    Button(
        onClick = {onBackButtonClicked()}
    ) {
        Text(text = "Kembali")
    }

    Column (
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ){
        listDataMhs.forEach { data ->
            DetailMhs(judul = data.first,
                isi = data.second)
        }

    }
}

@Composable
fun DetailMhs(
    judul:String,isi:String
){
    Row (
        modifier = Modifier.fillMaxWidth()
            .padding( 10.dp)
    ){
        Text(text = judul,
            modifier = Modifier.weight(0.8f))
        Text(text = ":",
            modifier = Modifier.weight(0.2f))
        Text(text = isi,
            modifier = Modifier.weight(2f))
    }


}