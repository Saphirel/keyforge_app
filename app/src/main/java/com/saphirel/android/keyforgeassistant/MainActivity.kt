package com.saphirel.android.keyforgeassistant

import android.app.Application
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.room.Room
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import com.saphirel.android.keyforgeassistant.database.Database
import com.saphirel.android.keyforgeassistant.database.DbUtils
import com.saphirel.android.keyforgeassistant.objects.House
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import java.io.BufferedReader


class MainActivity : AppCompatActivity() {

    private lateinit var prefs: SharedPreferences
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var db: Database

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        prefs = getSharedPreferences(applicationContext.packageName, Application.MODE_PRIVATE);
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()

        if (prefs.getBoolean("firstrun", true)) {
            initDb()
            prefs.edit().putBoolean("firstrun", false).apply()
        }

        initUi()
    }

    private fun initUi() {
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_brobnar, R.id.nav_dis,
                R.id.nav_logos, R.id.nav_mars, R.id.nav_sanctum,
                R.id.nav_shadow, R.id.nav_saurian, R.id.nav_staralliance,
                R.id.nav_untamed
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        navView.itemIconTintList = null
    }

    private fun initDb() {
        DbUtils.initDbWithJsonFiles(application as AppActivity)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}
