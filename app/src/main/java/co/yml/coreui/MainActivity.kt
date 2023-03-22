package co.yml.coreui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import co.yml.coreui.ui.compositions.AppBar
import co.yml.coreui.ui.presentation.CoreUIComponents
import co.yml.coreui.ui.presentation.YTagActivity
import co.yml.coreui.ui.theme.CoreUICatalogTheme

/**
 * Main activity: Launcher Activity
 *
 * @constructor Create empty Main activity
 */
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoreUICatalogTheme {
                Scaffold(modifier = Modifier.fillMaxSize(),
                    containerColor = CoreUICatalogTheme.colors.background,
                    topBar = { AppBar() })
                {
                    Column(
                        modifier = Modifier
                            .padding(it)
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center
                    ) {
                        CoreUIComponents(title = getString(R.string.title_y_tag), onClick = {
                            startActivity(
                                Intent(
                                    this@MainActivity,
                                    YTagActivity::class.java
                                )
                            )
                        })
                    }
                }
            }
        }
    }
}
