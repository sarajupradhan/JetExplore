package ga.awsapps.jetexplore.ui.home

import androidx.compose.Composable
import androidx.ui.core.ContentScale
import androidx.ui.core.Modifier
import androidx.ui.core.tag
import androidx.ui.foundation.Image
import androidx.ui.foundation.Text
import androidx.ui.foundation.shape.corner.CircleShape
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.Card
import androidx.ui.material.MaterialTheme
import androidx.ui.res.imageResource
import androidx.ui.text.font.FontWeight
import androidx.ui.unit.dp
import ga.awsapps.jetexplore.R

@Composable
fun titleBox( ) {
    ConstraintLayout(
        modifier = Modifier.fillMaxWidth().padding(start = 16.dp, top = 32.dp, bottom= 16.dp, end = 16.dp),
        constraintSet = ConstraintSet {
            val heading = tag("heading")
            val subHeading = tag("subHeading")
            val profile = tag("profile")

            heading.apply {
                left constrainTo parent.left
                top constrainTo parent.top
                right constrainTo profile.left
                horizontalBias = 0f
            }

            subHeading.apply {
                left constrainTo parent.left
                top constrainTo heading.bottom
            }

            profile.apply {
                top constrainTo parent.top
                right constrainTo parent.right
                bottom constrainTo subHeading.bottom
            }
        }
    ) {

        Text(
            text = "Explore",
            style = MaterialTheme.typography.h5.copy( fontWeight = FontWeight.Bold),
            modifier =      Modifier.tag("heading")
        )
        Text(
            text = "Trending Activities around",
            style = MaterialTheme.typography.h6.copy(color = Color.Gray),
            modifier =      Modifier.tag("subHeading")
        )

        Card(  modifier = Modifier.preferredSize(48.dp).tag("profile"), shape = CircleShape)
        {

            Image(imageResource(id = R.drawable.ic_profile),contentScale =  ContentScale.Crop, modifier = Modifier.fillMaxSize())

        }

    }

}