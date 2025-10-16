package com.example.profileapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.profileapp.ui.theme.ProfileAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProfileAppTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    Profile(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Profile(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(16.dp),
        shadowElevation = 8.dp,
        color = Color.White
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            // Imagen de perfil
            Box(modifier = Modifier.size(116.dp)) {

                Surface(
                    modifier = Modifier
                        .size(100.dp)
                        .align(Alignment.Center)
                        .clip(RoundedCornerShape(50.dp)),
                    color = Color(0xFFFFB74D) // Color naranja claro para el perro
                ) {
                    Text(
                        text = "🐕", // Emoji de perro
                        modifier = Modifier.align(Alignment.Center),
                        textAlign = TextAlign.Center,
                        fontSize = 40.sp
                    )
                }

                // Botón Editar
                Card(
                    onClick = { /* Handle edit */ },
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                ) {
                    Text(
                        text = "Edit",
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                        fontSize = 12.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Nombre
            Text(
                text = "Daniel Brand",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 16.dp)
            )

            // Descripción
            Text(
                text = "Mobile Developer | Dog Lover | Tech Enthusiast",
                fontSize = 16.sp,
                color = Color.Gray,
                modifier = Modifier.padding(vertical = 16.dp)
            )

            // Botones de acción
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(onClick = { /* TODO: Add follow action */ }) {
                    Text(text = "Follow")
                }
                Button(onClick = { /* TODO: Add message action */ }) {
                    Text(text = "Message")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
    ProfileAppTheme {
        Profile(modifier = Modifier.padding(20.dp))
    }
}