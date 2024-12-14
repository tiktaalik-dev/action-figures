package dev.tiktaalik.actionfigures

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.findNavController
import dev.tiktaalik.actionfigures.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // Declarar la variable para View Binding
    private lateinit var mainView: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflar la vista utilizando View Binding
        mainView = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainView.root)
//        enableEdgeToEdge()

        // Implementar Navegación. Primero capturar el controlador de navegación
        val navController = findNavController(R.id.nav_host_fragment) // Replace with your NavHostFragment ID
        navController.navigate(R.id.action_FirstFragment_to_SecondFragment)

        ViewCompat.setOnApplyWindowInsetsListener(mainView.mainActivity) { v, insets ->
        val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
        v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
        insets
}
    }
}