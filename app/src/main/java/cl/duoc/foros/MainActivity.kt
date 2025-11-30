package cl.duoc.foros

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cl.duoc.foros.model.AppDatabase
import cl.duoc.foros.model.Usuario
import cl.duoc.foros.repository.PostRepository
import cl.duoc.foros.repository.UsuarioRepository
import cl.duoc.foros.ui.theme.CameraAppTheme
import cl.duoc.foros.view.CrearPost
import cl.duoc.foros.view.ForosCategorias
import cl.duoc.foros.view.ListadoPosts
import cl.duoc.foros.view.Post
import cl.duoc.foros.view.PostFfnkjsfd
import cl.duoc.foros.view.Principal
import cl.duoc.foros.viewmodel.PostViewModel
import cl.duoc.foros.viewmodel.UsuarioViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            val context = LocalContext.current
            val db = remember { AppDatabase.getDatabase(context) }
            val Usuariorepository = remember { UsuarioRepository(db.usuarioDao()) }
            val usuarioViewModel = remember { UsuarioViewModel(Usuariorepository) }
            val Postrepository = remember { PostRepository(db.publicacionDao()) }
            val PostViewModel = remember { PostViewModel(Postrepository) }
            CameraAppTheme {
                val viewModel: UsuarioViewModel = usuarioViewModel
                Principal(navController, viewModel)
            }


            NavHost(navController = navController, startDestination = "Principal") {
                composable("Principal") {
                    Principal(navController, usuarioViewModel)
                }
                composable("ForosCategorias") {
                    ForosCategorias(navController, usuarioViewModel)
                }
                composable("ListadoPosts") {
                    ListadoPosts(navController, usuarioViewModel)
                }
                composable("Post") {
                    Post(navController, usuarioViewModel)
                }
                composable("CrearPost") {
                    CrearPost(navController, PostViewModel)
                }
                composable("PostFfnkjsfd") {
                    PostFfnkjsfd(PostViewModel, navController)
                }
            }
        }
    }
}

/*
@Preview(showBackground = true)
@Composable
fun CajaPost() {
    Box(
        Modifier
            .fillMaxWidth()
            .shadow(elevation = 2.dp)
            .height(100.dp)
            .padding(horizontal = 20.dp, vertical = 20.dp)
        // .scrollable(orientation = v)
    ) {
        Row(Modifier
            .fillMaxWidth()
        ){
            Column(Modifier
                .fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.usericon), "Logo App",
                    modifier = Modifier
                        .width(50.dp)
                        .height(50.dp),
                    contentScale = ContentScale.Fit
                )
                Text(
                    text = "Usuario",
                    fontSize = 10.sp
                )
            }

            Spacer(modifier = Modifier.width(10.dp).fillMaxHeight())
            Text(
                text = "Lorem ipsum dolor sit amet consectetur adipiscing elit quisque faucibus ex sapien vitae pellentesque sem.",
                fontSize = 20.sp
            )
        }
    }
    Row(Modifier
        .fillMaxWidth()
        .offset(x = 28.dp, y = 82.dp),
        horizontalArrangement = Arrangement.spacedBy(7.dp)
    ) {
        Text(
            text = "Editar",
            fontSize = 12.sp
        )
        Text(
            text = "Reportar",
            fontSize = 12.sp
        )
        Text(
            text = "Eliminar",
            fontSize = 12.sp
        )
    }
}
*/
/*

@Preview(showBackground = true)
@Composable
fun listaRespuestas() {
    val scrollState = rememberScrollState()
    val hola = listOf(":v", "hola", "h", "o/", "hol", "efffgbf", "oa", "🫃", "olaaaaaaa", "ratio")
    val nombres = listOf("juan", "juan 2", "juan 3", "juan 4", "juan 5", "juan 6", "juan 7", "juan 8", "juan 9", "ratio")


    Column(
        Modifier
            .fillMaxSize()
            .padding(10.dp)
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        for (i in 0..8) {
            Row(Modifier
                .fillMaxWidth()
                .shadow(elevation = 2.dp)
                .height(80.dp)
                .padding(horizontal = 20.dp, vertical = 20.dp)
            ){
                Column(Modifier
                    .fillMaxHeight(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.usericon), "Logo App",
                        modifier = Modifier
                            .width(30.dp)
                            .height(30.dp),
                        contentScale = ContentScale.Fit
                    )
                    Text(
                        text = nombres[i],
                        fontSize = 10.sp
                    )
                }

                Spacer(modifier = Modifier.width(10.dp).fillMaxHeight())
                Text(
                    text = hola[i],
                    fontSize = 17.sp
                )
            }
            Row(Modifier
                .fillMaxWidth()
                .offset(x = 23.dp, y = 82.dp),
                horizontalArrangement = Arrangement.spacedBy(7.dp)
            ) {
                Text(
                    text = "Editar",
                    fontSize = 12.sp
                )
                Text(
                    text = "Reportar",
                    fontSize = 12.sp
                )
                Text(
                    text = "Eliminar",
                    fontSize = 12.sp
                )
            }
        }
    }
}


 */
/*
@Preview(showBackground = true)
@Composable
fun previewPost() {
    val scrollState = rememberScrollState()
    Column(
        Modifier
            .fillMaxSize()
            .padding(10.dp)
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        for (i in 0..20) {
            Box(
                Modifier
                    .fillMaxWidth()
                    .shadow(elevation = 1.dp)
                    .height(60.dp)
                    .padding(horizontal = 20.dp, vertical = 10.dp)
            ) {
                Column(Modifier
                    .fillMaxHeight()
                ){
                    Text(
                        text = "Titulo Post "+i,
                        fontSize = 18.sp
                    )
                    Text(
                        text = "Creado por Usuario",
                        fontSize = 12.sp
                    )
                }
            }
        }
    }
}
*/
/*
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

 */
/*
@Preview(showBackground = true)
@Composable
fun botonCrearPost() {
    Button(
        onClick = {
            // navController.navigate("CrearPost")
        },
        modifier = Modifier
            .width(16.dp)
            .height(16.dp)

    ) {
        // materialIcon()
        Text("+")
    }
}


 */