package cl.duoc.foros.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import cl.duoc.foros.R
import cl.duoc.foros.viewmodel.UsuarioViewModel


@Composable
fun Post(
    navController : NavController,
    viewModel : UsuarioViewModel,
) {
    val scrollState = rememberScrollState()
    val estado by viewModel.estado.collectAsState()
    val hola = listOf(":v", "hola", "h", "o/", "hol", "efffgbf", "oa", "🫃", "olaaaaaaa", "ratio")
    val nombres = listOf("juan", "juan 2", "juan 3", "juan 4", "juan 5", "juan 6", "juan 7", "juan 8", "juan 9", "ratio")

    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Box(
            Modifier
                .fillMaxWidth()
                .shadow(elevation = 2.dp)
                .height(100.dp)
                .padding(horizontal = 20.dp, vertical = 20.dp)
            // .scrollable(orientation = v)
        ) {
            Row(
                Modifier
                    .fillMaxWidth()
            ) {
                Column(
                    Modifier
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
        Spacer(modifier = Modifier.height(29.dp))
        Column(
            Modifier
                .fillMaxSize()
                .padding(15.dp)
                .verticalScroll(scrollState),
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            for (i in 0..8) {
                Row(
                    Modifier
                        .fillMaxWidth()
                        .shadow(elevation = 2.dp)
                        .height(80.dp)
                        .padding(horizontal = 20.dp, vertical = 20.dp)
                ) {
                    Column(
                        Modifier
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
                    Row(
                        Modifier
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

            }
        }
    }
    }
