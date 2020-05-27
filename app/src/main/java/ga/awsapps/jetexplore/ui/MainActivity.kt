package ga.awsapps.jetexplore.ui


import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.ui.animation.Crossfade
import androidx.ui.core.*
import androidx.ui.material.*
import ga.awsapps.jetexplore.ui.details.PlaceDetails
import ga.awsapps.jetexplore.ui.home.Body


class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val w = window

        w.setFlags(
            WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
            WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
        )
        setContent {

            ExploreTheme() {
                Crossfade(JetExposeStatus.currentScreen) { screen ->
                    Surface(color = MaterialTheme.colors.background) {
                        when (screen) {
                            is Screen.Home -> Body()
                            is Screen.Details -> PlaceDetails(screen.place)

                        }
                    }
                }
            }
        }
    }
}











