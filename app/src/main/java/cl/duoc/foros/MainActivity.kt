package cl.duoc.foros

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cl.duoc.foros.ui.theme.ForosTheme
import cl.duoc.foros.view.ForosCategorias
import cl.duoc.foros.view.Post
import cl.duoc.foros.view.Principal
import cl.duoc.foros.viewmodel.UsuarioViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            val usuarioViewModel : UsuarioViewModel = viewModel()

            NavHost(navController = navController, startDestination = "Principal") {
                composable("Principal") {
                    Principal(navController, usuarioViewModel)
                }
                composable("ForosCategorias") {
                    ForosCategorias(navController, usuarioViewModel)
                }
                composable("Post") {
                    Post(navController, usuarioViewModel)
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun Principal() {
    Image(
        painter = painterResource(id = R.drawable.user), "user",
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        contentScale = ContentScale.Fit
    )
}



@Preview(showBackground = true)
@Composable
fun ForosCategorias() {
    Column(Modifier.padding(16.dp)) {
        Box(
            Modifier
                .fillMaxWidth()
                .shadow(elevation = 2.dp)
                .height(100.dp)
                .padding(horizontal = 240.dp, vertical = 20.dp)
            // .scrollable(orientation = v)
        ) {
            Text(
                // modifier = Modifier.offset(y = 20.dp),
                text = "🎵 Categorias 1",
                fontSize = 30.sp,
                textAlign = TextAlign.Center
            )
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

                // modifier = Modifier.offset(y = 20.dp),
                text = "Categorias 2"

            )
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
                // modifier = Modifier.offset(y = 20.dp),
                text = "Categorias 3"
            )
        }
    }

}