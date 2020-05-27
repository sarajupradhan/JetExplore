package ga.awsapps.jetexplore.ui.home

import androidx.compose.Composable
import androidx.ui.core.Alignment
import androidx.ui.core.ContentScale
import androidx.ui.core.Modifier
import androidx.ui.foundation.Image
import androidx.ui.foundation.Text
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.layout.*
import androidx.ui.layout.ColumnScope.gravity
import androidx.ui.material.Card
import androidx.ui.material.MaterialTheme
import androidx.ui.material.ripple.ripple
import androidx.ui.res.loadVectorResource
import androidx.ui.res.vectorResource
import androidx.ui.unit.dp
import ga.awsapps.jetexplore.R

@Composable
fun SearchBar() {

    Card( shape = RoundedCornerShape(25.dp), modifier = Modifier.padding(16.dp).ripple(), elevation = 1.dp ) {
        Row(  modifier = Modifier.fillMaxWidth().preferredHeight(48.dp).padding(16.dp) ) {


            Image(
                    asset = vectorResource(id = R.drawable.ic_search),
                    modifier = Modifier.preferredSize(24.dp),
                    contentScale = ContentScale.Fit
                )


            Text("Search ",modifier = Modifier.padding(start = 24.dp, end = 24.dp).weight(1f),
                style = MaterialTheme.typography.caption)


            Image(
                    asset = vectorResource(id = R.drawable.ic_mic),
                    modifier = Modifier.preferredSize(24.dp).gravity(Alignment.End),
                    contentScale = ContentScale.Fit,
                    alignment = Alignment.CenterEnd
                )


        }
    }
}