package cl.duoc.foros.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import cl.duoc.foros.R
import cl.duoc.foros.viewmodel.UsuarioViewModel

@Composable
fun ListadoPosts(
    navController : NavController,
    viewModel : UsuarioViewModel,
) {
    val scrollState = rememberScrollState()
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
                    .clickable(onClick = {navController.navigate("Post")})
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