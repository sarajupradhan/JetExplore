package ga.awsapps.jetexplore.ui.details

import androidx.compose.*
import androidx.ui.core.*
import androidx.ui.foundation.*
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.layout.ColumnScope.gravity
import androidx.ui.material.*
import androidx.ui.material.icons.Icons
import androidx.ui.material.icons.filled.ArrowBack
import androidx.ui.res.imageResource
import androidx.ui.text.font.FontWeight
import androidx.ui.unit.Dp
import androidx.ui.unit.dp
import ga.awsapps.jetexplore.ui.Screen
import ga.awsapps.jetexplore.model.Place
import ga.awsapps.jetexplore.ui.navigateTo

@Composable
fun PlaceDetails(place : Place)
{

    Stack(modifier = Modifier.fillMaxSize()) {
        Body(place)
        backButton( )
        findButton( )
    }
}

@Composable
fun  StackScope.backButton( )
{

    IconButton(onClick = {
        navigateTo(
            Screen.Home
        )
    }, modifier = Modifier.padding( top = 24.dp,  bottom = 24.dp)) {
        Modifier.preferredSize(24.dp).gravity(Alignment.Center)
        Icon(Icons.Filled.ArrowBack,tint =  Color.White)
    }
}

@Composable
fun  StackScope.findButton( )
{
    ExtendedFloatingActionButton(

        text = { Text("Find Place", color = Color.White) },
        onClick = {},
        modifier = Modifier.fillMaxWidth().padding(24.dp).gravity(Alignment.BottomCenter).tag("find_btn")
    )
}

 enum class Sections(val title: String) {
    About("About"),
    Gallery("Gallery"),
    Reviews("Reviews"),

}

@Composable
fun StackScope.Body(place: Place) {

    VerticalScroller( modifier = Modifier.gravity(Alignment.TopCenter)) {

        ConstraintLayout(
            modifier = Modifier.fillMaxSize(),
            constraintSet = ConstraintSet {
                val image = tag("image")
                val tittle = tag("tittle")
                val tab = tag("tab")
                val container = tag("container")

                image.apply {
                    left constrainTo parent.left
                    top constrainTo parent.top
                    right constrainTo parent.right
                }
                tittle.apply {
                    left constrainTo parent.left
                    bottom constrainTo image.bottom
                    bottom.margin =  24.dp
                    left.margin=  24.dp

                }

                tab.apply {
                    left constrainTo parent.left
                    top constrainTo image.bottom

                }
                container.apply {
                    left constrainTo parent.left
                    top constrainTo tab.bottom

                }
            }
        )
        {

            Image(imageResource(id = place.imageResources[0]),contentScale =  ContentScale.Crop, modifier = Modifier.preferredHeight(230.dp).fillMaxWidth().tag("image"))

            Title(place = place, modifier = Modifier.tag("tittle"))

            val sectionTitles = Sections.values().map { it.title }
            var section by state { Sections.About }


            TabRow(modifier =  Modifier.tag("tab") ,items = sectionTitles, selectedIndex = section.ordinal, indicatorContainer = IndicatorContainer(section),
                 backgroundColor = MaterialTheme.colors.surface, divider =  @Composable { Divider(thickness = 1.dp, color = contentColor().copy(alpha = 0f))}) { index, text ->
                Tab(
                    text = { Text(text) },
                    selected = section.ordinal == index,
                    onSelected = { section = Sections.values()[index] }
                )

            }

            Container( place , modifier  = Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 70.dp).tag("container"), section =  section )

        }

    }
}

@Composable
fun Title(place: Place, modifier: Modifier)
{
    Column(modifier = modifier) {

        Text(
            text = place.name,
            style = MaterialTheme.typography.h5.copy(fontWeight = FontWeight.Bold),
            color = Color.White,
            maxLines = 1

        )
        Text(
            text = place.address,
            style = MaterialTheme.typography.h6,
            color = Color.LightGray,
            maxLines = 1
        )


    }
}

fun IndicatorContainer(section: Sections ) = @Composable { tabPositions: List<TabRow.TabPosition> ->
    TabRow.IndicatorContainer(tabPositions = tabPositions, selectedIndex = section.ordinal) {

        val currentTabWidth = with(DensityAmbient.current) {
            tabPositions[section.ordinal].width.div(2).toDp()
        }
        TabIndicator(currentTabWidth)
    }
}


@Composable
fun Container(place: Place, modifier: Modifier, section : Sections)
{
    Box(modifier = modifier) {
        when (section) {

            Sections.About   -> About(place.descriptions)
            Sections.Gallery -> Gallery(place.imageResources.subList(1,place.imageResources.size))
            Sections.Reviews -> Reviews(place.feedBack)

        }
    }
}

@Composable
fun TabIndicator(width: Dp) {

    Row( horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth().gravity(Alignment.CenterHorizontally)) {
        Box( gravity =  ContentGravity.Center, modifier =  Modifier.preferredWidth(width).preferredHeight(2.dp).gravity(Alignment.CenterHorizontally).drawBackground(color = Color.Black))

    }
}




