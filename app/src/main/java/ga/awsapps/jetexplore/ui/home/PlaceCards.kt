package ga.awsapps.jetexplore.ui.home

import androidx.compose.Composable
import androidx.ui.core.Alignment
import androidx.ui.core.ContentScale
import androidx.ui.core.Modifier
import androidx.ui.core.clip
import androidx.ui.foundation.Clickable
import androidx.ui.foundation.Image
import androidx.ui.foundation.Text
import androidx.ui.foundation.drawBackground
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.graphics.ColorFilter
import androidx.ui.layout.*
import androidx.ui.material.Card
import androidx.ui.material.MaterialTheme
import androidx.ui.material.ripple.ripple
import androidx.ui.res.imageResource
import androidx.ui.res.loadVectorResource
import androidx.ui.text.font.FontWeight
import androidx.ui.text.style.TextOverflow
import androidx.ui.unit.dp
import ga.awsapps.jetexplore.R
import ga.awsapps.jetexplore.ui.Screen
import ga.awsapps.jetexplore.model.Place
import ga.awsapps.jetexplore.ui.navigateTo


@Composable
fun PlaceCardWrapContent(place: Place, modifier: Modifier) {

    Card( modifier. preferredSize(width = 150.dp, height =  200.dp).ripple(),color = Color.Black, shape= RoundedCornerShape(16.dp)) {
        Clickable(onClick = {
            navigateTo(
                Screen.Details(
                    place
                )
            )
        }) {

            ImagePlaceCardWrapContent(place)

            Column(verticalArrangement  = Arrangement.Bottom, modifier = Modifier.fillMaxWidth().wrapContentHeight(align = Alignment.Bottom).drawBackground(color = Color.Black.copy(alpha = 0.2f))){

                Text(place.name, modifier = Modifier.padding(start = 8.dp, top = 8.dp, end = 8.dp,bottom = 2.dp).fillMaxWidth(),
                    style = MaterialTheme.typography.body1.copy( fontWeight = FontWeight.Light), color = Color.LightGray)

                Text(place.address,modifier = Modifier.padding(start = 8.dp, end = 8.dp, bottom = 8.dp).fillMaxWidth(),
                    style = MaterialTheme.typography.overline.copy( fontWeight = FontWeight.Thin), color = Color.LightGray)

                Text(" ${place.elevation} m",modifier = Modifier.padding(start = 8.dp, end = 8.dp, bottom = 16.dp).fillMaxWidth(),
                    style = MaterialTheme.typography.body2.copy( fontWeight = FontWeight.Thin), color = Color.White)

            }


        }
    }
}


@Composable
fun PlaceCardFullWidth(place: Place, modifier: Modifier)
{
    Clickable(onClick = {
        navigateTo(
            Screen.Details(
                place
            )
        )
    },  modifier = modifier.fillMaxWidth().ripple()
    ) {

        Row( )
        {

            ImagePlaceCardFullWidth(place)

            Column( ) {

                Text(
                    modifier = Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp),
                    text = place.name,
                    maxLines = 1,
                    style = MaterialTheme.typography.body1.copy( fontWeight = FontWeight.SemiBold)
                )

                Text(
                    modifier = Modifier.padding(start = 16.dp, top = 4.dp, end = 16.dp),
                    text = place.descriptions,
                    style = MaterialTheme.typography.subtitle2,
                    maxLines = 3,
                    color = Color.DarkGray,
                    overflow = TextOverflow.Ellipsis
                   )

                Row(  modifier = Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp))
                {
                    val vectorAsset = loadVectorResource(R.drawable.ic_distance)
                    vectorAsset.resource.resource?.let {
                        Image(
                            asset = it,
                            modifier = Modifier.preferredSize(18.dp, 18.dp),
                            contentScale = ContentScale.Inside,
                            colorFilter = ColorFilter.tint(Color.DarkGray)
                             ) }

                    Text(
                        text = "${place.location.distance} mi away",
                        modifier = Modifier.padding(start = 8.dp, end = 8.dp),
                        style = MaterialTheme.typography.subtitle2,
                        maxLines = 1,
                        color = Color.DarkGray,
                        overflow = TextOverflow.Ellipsis
                       ) }
            }

        }

    }
}


@Composable
fun ImagePlaceCardWrapContent(place: Place)
{
                Image( modifier =  Modifier.preferredSize(24.dp),
                asset = imageResource(
                    place.imageResources[0]
                ),contentScale =  ContentScale.Crop)

}

@Composable
fun ImagePlaceCardFullWidth(place: Place)
{
    Image(asset = imageResource(id = place.imageResources[0]), contentScale =  ContentScale.Crop
        , modifier = Modifier.size(120.dp, 140.dp).clip(RoundedCornerShape(8.dp)))
}