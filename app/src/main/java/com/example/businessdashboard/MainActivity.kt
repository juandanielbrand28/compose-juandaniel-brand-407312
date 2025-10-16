package com.example.businessdashboard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businessdashboard.ui.theme.BusinessDashboardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessDashboardTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    DashboardScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

// Estados para las métricas
sealed class Metric {
    object Revenue : Metric()
    object Users : Metric()
    object Conversion : Metric()
    object Growth : Metric()
}

@Composable
fun DashboardScreen(modifier: Modifier = Modifier) {
    var selectedMetric by remember { mutableStateOf<Metric?>(null) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Header
        Text(
            text = "Business Dashboard",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp),
            textAlign = TextAlign.Center
        )

        // Grid de métricas (2x2)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Fila 1 - Columna izquierda
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                MetricTile(
                    title = stringResource(id = R.string.revenue),
                    value = "$1.2M",
                    isSelected = selectedMetric is Metric.Revenue,
                    onClick = { selectedMetric = Metric.Revenue },
                    modifier = Modifier.weight(1f)
                )

                MetricTile(
                    title = stringResource(id = R.string.users),
                    value = "45.6K",
                    isSelected = selectedMetric is Metric.Users,
                    onClick = { selectedMetric = Metric.Users },
                    modifier = Modifier.weight(1f)
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            // Fila 2 - Columna derecha
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                MetricTile(
                    title = stringResource(id = R.string.conversion),
                    value = "3.4%",
                    isSelected = selectedMetric is Metric.Conversion,
                    onClick = { selectedMetric = Metric.Conversion },
                    modifier = Modifier.weight(1f)
                )

                MetricTile(
                    title = stringResource(id = R.string.growth),
                    value = "12%",
                    isSelected = selectedMetric is Metric.Growth,
                    onClick = { selectedMetric = Metric.Growth },
                    modifier = Modifier.weight(1f)
                )
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Área de detalles
        MetricDetails(selectedMetric = selectedMetric)
    }
}

@Composable
fun MetricTile(
    title: String,
    value: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        onClick = onClick,
        modifier = modifier,
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (isSelected) Color(0xFFE3F2FD) else MaterialTheme.colorScheme.surface
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = title,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = value,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface
            )
        }
    }
}

@Composable
fun MetricDetails(selectedMetric: Metric?) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = "Metric Details",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            when (selectedMetric) {
                is Metric.Revenue -> {
                    Text(
                        text = stringResource(id = R.string.revenue_details),
                        fontSize = 16.sp,
                        lineHeight = 24.sp
                    )
                }
                is Metric.Users -> {
                    Text(
                        text = stringResource(id = R.string.users_details),
                        fontSize = 16.sp,
                        lineHeight = 24.sp
                    )
                }
                is Metric.Conversion -> {
                    Text(
                        text = stringResource(id = R.string.conversion_details),
                        fontSize = 16.sp,
                        lineHeight = 24.sp
                    )
                }
                is Metric.Growth -> {
                    Text(
                        text = stringResource(id = R.string.growth_details),
                        fontSize = 16.sp,
                        lineHeight = 24.sp
                    )
                }
                null -> {
                    Text(
                        text = stringResource(id = R.string.select_metric),
                        fontSize = 16.sp,
                        color = Color.Gray,
                        fontStyle = androidx.compose.ui.text.font.FontStyle.Italic
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DashboardScreenPreview() {
    BusinessDashboardTheme {
        DashboardScreen()
    }
}