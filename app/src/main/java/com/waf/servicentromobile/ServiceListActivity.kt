package com.waf.servicentromobile

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * ServiceListActivity displays the registered maintenance services or
 * an empty state message if none are currently recorded.
 */
class ServiceListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service_list)

        // Aquí se podrá integrar el RecyclerView o la lógica de listado más adelante
    }
}