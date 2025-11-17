package cl.duoc.foros.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import cl.duoc.foros.viewmodel.UsuarioViewModel
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Button

// fun cajaCategoria(imagen : null, texto : String) {}
@Composable
fun ForosCategorias(
    navController : NavController,
    viewModel : UsuarioViewModel


) {
    val scrollState = rememberScrollState()
    val estado by viewModel.estado.collectAsState()
    Column(Modifier
        .padding(16.dp)
        .verticalScroll(scrollState),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Box(
            Modifier
                .fillMaxWidth()
                .shadow(elevation = 2.dp)
                .height(100.dp)
                .padding(horizontal = 20.dp, vertical = 20.dp)
            // .scrollable(orientation = v)
        ) {
            Text(
                // modifier = Modifier.offset(y = 20.dp),
                text = "🎵 Música",
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
        }
        Button(
            onClick = { navController.navigate("Post") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ir")
        }
        Box(
            Modifier
                .fillMaxWidth()
                .shadow(elevation = 2.dp)
                .height(100.dp)
                .padding(horizontal = 20.dp, vertical = 20.dp)
            // .scrollable(orientation = v)
        ) {
            Text(
                text = "🖌️ Arte",
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
        }
        Button(
            onClick = { navController.navigate("Post") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ir")
        }
        Box(
            Modifier
                .fillMaxWidth()
                .shadow(elevation = 2.dp)
                .height(100.dp)
                .padding(horizontal = 20.dp, vertical = 20.dp)
            // .scrollable(orientation = v)
        ) {
            Text(
                text = "📖 Literatura",
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
                // modifier = Modifier.offset(y = 20.dp),

            )
        }
        Button(
            onClick = { navController.navigate("Post") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ir")
        }
        Box(
            Modifier
                .fillMaxWidth()
                .shadow(elevation = 2.dp)
                .height(100.dp)
                .padding(horizontal = 20.dp, vertical = 20.dp)
            // .scrollable(orientation = v)
        ) {
            Text(
                text = "🎮 Juegos",
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
                // modifier = Modifier.offset(y = 20.dp),

            )
        }
        Button(
            onClick = { navController.navigate("Post") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ir")
        }
        Box(
            Modifier
                .fillMaxWidth()
                .shadow(elevation = 2.dp)
                .height(100.dp)
                .padding(horizontal = 20.dp, vertical = 20.dp)
            // .scrollable(orientation = v)
        ) {
            Text(
                text = "⌨️ Programación",
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
                // modifier = Modifier.offset(y = 20.dp),

            )
        }
        Button(
            onClick = { navController.navigate("Post") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ir")
        }
        Box(
            Modifier
                .fillMaxWidth()
                .shadow(elevation = 2.dp)
                .height(100.dp)
                .padding(horizontal = 20.dp, vertical = 20.dp)
            // .scrollable(orientation = v)
        ) {
            Text(
                text = "📺 TV",
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
                // modifier = Modifier.offset(y = 20.dp),

            )
        }
        Button(
            onClick = { navController.navigate("Post") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ir")
        }
        Box(
            Modifier
                .fillMaxWidth()
                .shadow(elevation = 2.dp)
                .height(100.dp)
                .padding(horizontal = 20.dp, vertical = 20.dp)
            // .scrollable(orientation = v)
        ) {
            Text(
                text = "🔧 Mecanica",
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
                // modifier = Modifier.offset(y = 20.dp),

            )
        }
        Button(
            onClick = { navController.navigate("Post") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ir")
        }
        Box(
            Modifier
                .fillMaxWidth()
                .shadow(elevation = 2.dp)
                .height(100.dp)
                .padding(horizontal = 20.dp, vertical = 20.dp)
            // .scrollable(orientation = v)
        ) {
            Text(
                text = "🥚 huevo",
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
                // modifier = Modifier.offset(y = 20.dp),

            )
        }
        Button(
            onClick = { navController.navigate("Post") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ir")
        }
        Box(
            Modifier
                .fillMaxWidth()
                .shadow(elevation = 2.dp)
                .height(100.dp)
                .padding(horizontal = 20.dp, vertical = 20.dp)
            // .scrollable(orientation = v)
        ) {
            Text(
                text = "🥚 huevo",
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
                // modifier = Modifier.offset(y = 20.dp),

            )
        }
        Button(
            onClick = { navController.navigate("Post") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ir")
        }
        Box(
            Modifier
                .fillMaxWidth()
                .shadow(elevation = 2.dp)
                .height(100.dp)
                .padding(horizontal = 20.dp, vertical = 20.dp)
            // .scrollable(orientation = v)
        ) {
            Text(
                text = "🥚 huevo",
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
                // modifier = Modifier.offset(y = 20.dp),

            )
        }
        Button(
            onClick = { navController.navigate("Post") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ir")
        }
    }

}
