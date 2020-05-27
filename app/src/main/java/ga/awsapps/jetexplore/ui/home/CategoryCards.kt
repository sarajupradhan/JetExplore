package ga.awsapps.jetexplore.ui.home

import androidx.compose.Composable
import androidx.ui.core.Alignment
import androidx.ui.core.ContentScale
import androidx.ui.core.Modifier
import androidx.ui.foundation.Image
import androidx.ui.foundation.Text
import androidx.ui.foundation.shape.corner.CircleShape
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.Card
import androidx.ui.material.EmphasisAmbient
import androidx.ui.material.MaterialTheme
import androidx.ui.material.ProvideEmphasis
import androidx.ui.material.ripple.ripple
import androidx.ui.res.imageResource
import androidx.ui.text.style.TextOverflow
import androidx.ui.unit.dp
import ga.awsapps.jetexplore.model.Type

@Composable
fun CategoryCard(type: Type, modifier: Modifier) {

    Column( modifier = modifier.preferredWidth(80.dp).fillMaxHeight().ripple()) {

        val image  = imageResource(id = type.imageResource)
        Card(  Modifier.wrapContentSize(Alignment.Center) , shape = CircleShape){
            Image(asset = image, modifier = Modifier.size(80.dp), contentScale = ContentScale.Crop)

        }

        Text(
            text = type.name,
            color = Color.Gray,
            modifier = Modifier.padding(top = 8.dp).gravity(Alignment.CenterHorizontally),
            style = MaterialTheme.typography.body2,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
    }
}
