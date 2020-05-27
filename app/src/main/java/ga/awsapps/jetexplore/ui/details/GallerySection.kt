package ga.awsapps.jetexplore.ui.details

import androidx.compose.Composable
import androidx.ui.core.ContentScale
import androidx.ui.core.Modifier
import androidx.ui.foundation.Image
import androidx.ui.layout.fillMaxWidth
import androidx.ui.layout.preferredHeight
import androidx.ui.res.imageResource
import androidx.ui.unit.dp

@Composable( )
fun  Gallery(places : List<Int> )
{
    TableRenderer(
        cols = 2,
        cellSpacing = 5.dp,
        items = places
    ) { cell ->
        Image(
            asset = imageResource(id = places[cell.index]),
            modifier = Modifier.fillMaxWidth().preferredHeight(100.dp),
            contentScale = ContentScale.Crop
        )
    }

}