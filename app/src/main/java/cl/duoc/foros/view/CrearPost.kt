package cl.duoc.foros.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import cl.duoc.foros.viewmodel.PostViewModel

@Composable
fun CrearPost(
    navController: NavController,
    viewModel: PostViewModel
) {
    val estado by viewModel.estado.collectAsState()

    Column(
        Modifier
            .fillMaxSize()
    ) {
        OutlinedTextField(
            value = estado.titulo,
            onValueChange = viewModel::onTituloCHange,
            label = {Text("Titulo") },
            isError = estado.errores.titulo != null,
            supportingText = {
                estado.errores.titulo?.let {
                    Text(it, color = MaterialTheme.colorScheme.error)
                }
            }
        )
        OutlinedTextField(
            value = estado.contenido,
            onValueChange = viewModel::onContenidoChange,
            label = {Text("Contenido") },
            isError = estado.errores.contenido != null,
            supportingText = {
                estado.errores.contenido?.let {
                    Text(it, color = MaterialTheme.colorScheme.error)
                }
            }
        )
    }

}