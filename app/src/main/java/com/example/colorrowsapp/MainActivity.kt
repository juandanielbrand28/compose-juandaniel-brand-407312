package com.example.colorrowsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.colorrowsapp.ui.theme.ColorRowsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ColorRowsAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ColorRowsScreen()
                }
            }
        }
    }
}

@Composable
fun ColorRowsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Título
        Text(
            text = "Color Rows App",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        // Fila 1 - Rojo
        ColorRow(
            colorName = "RED",
            color = Color.Red,
            arrangement = Arrangement.Start
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Fila 2 - Verde
        ColorRow(
            colorName = "GREEN",
            color = Color.Green,
            arrangement = Arrangement.Center
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Fila 3 - Azul
        ColorRow(
            colorName = "BLUE",
            color = Color.Blue,
            arrangement = Arrangement.End
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Fila 4 - Espaciado uniforme
        ColorRow(
            colorName = "YELLOW",
            color = Color.Yellow,
            arrangement = Arrangement.SpaceEvenly
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Fila 5 - Espaciado alrededor
        ColorRow(
            colorName = "MAGENTA",
            color = Color.Magenta,
            arrangement = Arrangement.SpaceAround
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Fila 6 - Espaciado entre elementos
        ColorRow(
            colorName = "CYAN",
            color = Color.Cyan,
            arrangement = Arrangement.SpaceBetween
        )
    }
}

@Composable
fun ColorRow(
    colorName: String,
    color: Color,
    arrangement: Arrangement.Horizontal
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp),
        horizontalArrangement = arrangement,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Primer cuadro de color
        ColorBox(
            colorName = "$colorName 1",
            color = color,
            modifier = Modifier
                .size(70.dp)
                .weight(1f)
        )

        // Segundo cuadro de color
        ColorBox(
            colorName = "$colorName 2",
            color = color,
            modifier = Modifier
                .size(70.dp)
                .weight(1f)
        )

        // Tercer cuadro de color
        ColorBox(
            colorName = "$colorName 3",
            color = color,
            modifier = Modifier
                .size(70.dp)
                .weight(1f)
        )
    }
}

@Composable
fun ColorBox(
    colorName: String,
    color: Color,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .background(color)
            .padding(8.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = colorName,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ColorRowsScreenPreview() {
    ColorRowsAppTheme {
        ColorRowsScreen()
    }
}