package cl.duoc.foros.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import cl.duoc.foros.viewmodel.PostViewModel

@Composable
fun PostFfnkjsfd(viewModel: PostViewModel, navController: NavController) {
    val estado by viewModel.estado.collectAsState()

    Column(Modifier.padding(16.dp)) {
        Text("Resúmen del registro", style = MaterialTheme.typography.headlineMedium)
        Text("Nombre: ${estado.titulo}")
        Text("Correo: ${estado.contenido}")
        // Text("¿Términos Aceptados? ${if (estado.aceptaTerminos) "Aceptados" else "Declinados"}")

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { navController.popBackStack() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("p")
        }
    }
}