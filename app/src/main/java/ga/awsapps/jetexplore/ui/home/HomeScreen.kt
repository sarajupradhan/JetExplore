package ga.awsapps.jetexplore.ui.home

import androidx.compose.Composable
import androidx.ui.core.*
import androidx.ui.foundation.*
import androidx.ui.layout.*
import androidx.ui.unit.dp
import ga.awsapps.jetexplore.model.Event
import ga.awsapps.jetexplore.model.FakeData
import ga.awsapps.jetexplore.model.Place
import ga.awsapps.jetexplore.model.Type


@Composable
fun  Body( )
{
    VerticalScroller( ) {
        Column() {
            titleBox()
            SearchBar()
            BreathTaking(FakeData().breathTaking)
            Categories(FakeData().types)
            Recommended(FakeData().recommended)
            UpcomingEvents(FakeData().upcomingEvents)
            Spacer(modifier = Modifier.preferredHeight(30.dp))

        }

    }
}



@Composable
private fun BreathTaking(places : List<Place>) {

    heading(
        "BreathTaking",
        modifier = Modifier.padding(start = 16.dp, top = 24.dp, end = 16.dp),
        onClick = {})
    HorizontalScroller( ) {
        Row(modifier = Modifier.padding(start=8.dp, top = 8.dp, end = 16.dp)){
            for (place in places)
            {
                PlaceCardWrapContent(
                    place,
                    Modifier.padding(start = 8.dp)
                )
            }
        }
    }

}

@Composable
fun Categories(types : List<Type>) {

    heading(
        "Categories",
        modifier = Modifier.padding(start = 16.dp, top = 40.dp, end = 16.dp),
        onClick = {})
    HorizontalScroller( ) {
        Row(modifier = Modifier.padding(start=8.dp, top = 8.dp, end = 16.dp)){
            for (type in types)
            {
                CategoryCard(
                    type,
                    Modifier.padding(start = 8.dp)
                )
            }
        }
    }

}

@Composable
fun Recommended(places:List<Place> )
{
    heading(
        "Recommended",
        modifier = Modifier.padding(start = 16.dp, top = 40.dp, end = 16.dp),
        onClick = {})
    VerticalScroller( ) {
        Column(modifier = Modifier.padding(start= 16.dp, top= 8.dp,end= 16.dp)){
            for (place in places)
            {
                PlaceCardFullWidth(place, Modifier)
            }
        }
    }


}

@Composable
private fun UpcomingEvents(events : List<Event>) {

    heading(
        "Upcoming Events",
        modifier = Modifier.padding(start = 16.dp, top = 40.dp, end = 16.dp),
        onClick = {})
    HorizontalScroller( ) {
        Row(modifier = Modifier.padding(start=8.dp, top = 8.dp, end = 16.dp)){
            for (event in events)
            {
                EventCard(
                    event,
                    Modifier.padding(start = 8.dp)
                )
            }
        }

    }

}



