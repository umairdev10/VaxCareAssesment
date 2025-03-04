package com.vaco.vaxcareassesment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vaco.vaxcareassesment.presentation.BookDetailScreen
import com.vaco.vaxcareassesment.presentation.BookDetailView
import com.vaco.vaxcareassesment.presentation.BooksScreen
import com.vaco.vaxcareassesment.presentation.BooksView
import com.vaco.vaxcareassesment.ui.theme.VaxCareAssesmentTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VaxCareAssesmentTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController:NavHostController = rememberNavController()

                    NavHost(
                        navController= navController,
                        startDestination = BooksScreen
                    ) {
                        composable<BooksScreen>{
                         BooksView(navController = navController, paddingValues = innerPadding)
                        }
                        composable<BookDetailScreen> {
                            BookDetailView(paddingValues = innerPadding)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    VaxCareAssesmentTheme {
        Greeting("Android")
    }
}