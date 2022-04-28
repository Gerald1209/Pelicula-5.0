package ni.edu.uca.peliculas50

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import ni.edu.uca.peliculas50.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    /*private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupActionBarWithNavController(findNavController(R.id.selectBotonFragment)
        )
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.selectBotonFragment)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }*/

    private lateinit var  binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}