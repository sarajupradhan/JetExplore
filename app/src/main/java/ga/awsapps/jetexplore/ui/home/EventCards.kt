package ga.awsapps.jetexplore.ui.home

import androidx.compose.Composable
import androidx.ui.core.Alignment
import androidx.ui.core.ContentScale
import androidx.ui.core.Modifier
import androidx.ui.foundation.Border
import androidx.ui.foundation.Icon
import androidx.ui.foundation.Image
import androidx.ui.foundation.Text
import androidx.ui.graphics.BlendMode
import androidx.ui.graphics.Color
import androidx.ui.graphics.ColorFilter
import androidx.ui.layout.*
import androidx.ui.material.Card
import androidx.ui.material.IconButton
import androidx.ui.material.MaterialTheme
import androidx.ui.material.OutlinedButton
import androidx.ui.res.imageResource
import androidx.ui.res.vectorResource
import androidx.ui.text.style.TextOverflow
import androidx.ui.unit.dp
import ga.awsapps.jetexplore.R
import ga.awsapps.jetexplore.ui.Screen
import ga.awsapps.jetexplore.Util
import ga.awsapps.jetexplore.model.Event
import ga.awsapps.jetexplore.ui.navigateTo

@Composable
fun  EventCard(event: Event, modifier: Modifier) {

    Column(modifier = modifier.preferredWidth(130.dp)) {
        Card() {

            Stack() {
                ImageEvent(event = event)

                OutlinedButton(
                    modifier = Modifier.gravity(Alignment.Center),
                    onClick = {},
                    contentColor = Color.White.copy(alpha = 0.8f),
                    backgroundColor = Color.Transparent,
                    border = Border(
                        1.dp, Color.White.copy(alpha = 0.12f)
                    )
                ) {
                    Text("Join")
                }

                Text(
                    text =    Util.getDate(event.startDate) +" - "+ Util.getDate(event.endDate),
                    modifier = Modifier.padding(8.dp).gravity(Alignment.BottomCenter),
                    style = MaterialTheme.typography.overline,
                    color = Color.LightGray,
                    overflow = TextOverflow.Ellipsis
                )
            }

        }

        Row()
        {

            Text(
                text = event.title,
                modifier = Modifier.padding(top = 8.dp).weight(9f),
                style = MaterialTheme.typography.body2,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            IconButton(onClick = {
                navigateTo(
                    Screen.Home
                )
            }, modifier = Modifier.weight(1f).padding(8.dp).size(18.dp)) {

                Icon(asset = vectorResource(id = R.drawable.ic_more), tint = Color.Gray)
            }

        }

        Text(
            text = event.place.address,
            style = MaterialTheme.typography.caption,
            maxLines = 1,
            color = Color.Gray,
            overflow = TextOverflow.Ellipsis
        )

    }

}


@Composable
fun  ImageEvent(event: Event)
{
    Image(
        imageResource(id = event.imageResource),
        modifier = Modifier.fillMaxWidth().preferredSize(120.dp),
        contentScale = ContentScale.Crop,
//        colorFilter = ColorFilter(Color.Black.copy(alpha = 0.5f ), blendMode = BlendMode.darken)
        colorFilter = ColorFilter.tint(Color.Black.copy(alpha = 0.5f )).copy(blendMode = BlendMode.darken )

    )
}