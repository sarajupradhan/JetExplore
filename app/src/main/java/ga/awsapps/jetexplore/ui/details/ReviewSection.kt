package ga.awsapps.jetexplore.ui.details

import android.icu.text.CaseMap
import android.util.Log
import androidx.compose.Composable
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.core.clip
import androidx.ui.foundation.Icon
import androidx.ui.foundation.Image
import androidx.ui.foundation.Text
import androidx.ui.foundation.shape.corner.CircleShape
import androidx.ui.graphics.Color
import androidx.ui.graphics.ColorFilter
import androidx.ui.layout.*
import androidx.ui.layout.ColumnScope.weight
import androidx.ui.layout.RowScope.weight
import androidx.ui.material.*
import androidx.ui.material.icons.Icons
import androidx.ui.material.icons.filled.Favorite
import androidx.ui.material.icons.filled.Star
import androidx.ui.res.imageResource
import androidx.ui.res.vectorResource
import androidx.ui.unit.dp
import ga.awsapps.jetexplore.R
import ga.awsapps.jetexplore.model.FeedBack
import ga.awsapps.jetexplore.model.Review

@Composable
fun Reviews ( feedBack:FeedBack)
{

    Column( modifier = Modifier.fillMaxWidth() , verticalArrangement = Arrangement.Bottom) {

        Text(text = "Overall Ratting", style = MaterialTheme.typography.body1, modifier = Modifier.gravity(
            Alignment.CenterHorizontally).padding(top = 16.dp))
        Text(text = "${feedBack.overallRatting}/5", style = MaterialTheme.typography.h4, modifier = Modifier.gravity(
            Alignment.CenterHorizontally).padding(8.dp))
        Text(text = "based on  ${feedBack.totalNoOfReview} reviews", style = MaterialTheme.typography.body1, modifier = Modifier.gravity(
            Alignment.CenterHorizontally).padding(bottom = 24.dp))


        RattingPercentage(
            "Excellent",
            feedBack.ratting.one.percentage
        )
        RattingPercentage(
            "Above Good",
            feedBack.ratting.two.percentage
        )
        RattingPercentage(
            "Good",
            feedBack.ratting.three.percentage
        )
        RattingPercentage(
            "Average",
            feedBack.ratting.four.percentage
        )

        RattingPercentage(
            "Poor",
            feedBack.ratting.five.percentage
        )

        for(review in feedBack.reviews)
        {
            ReviewCard(review)
        }

    }

}

@Composable
fun RattingPercentage(tittle :String, percentage : Int )
{
    Row( modifier = Modifier.fillMaxWidth().padding(8.dp) , horizontalArrangement = Arrangement.Start,
        verticalGravity = Alignment.CenterVertically ) {

        Text(text = tittle, style = MaterialTheme.typography.body1, modifier = Modifier.weight(0.3f))

        LinearProgressIndicator(progress = (percentage.toFloat()/100),modifier = Modifier.weight(0.5f))

        Text(text = "$percentage%", style = MaterialTheme.typography.body1, maxLines = 1, modifier = Modifier.padding(start=8.dp).weight(0.2f))
    }

}


@Composable
fun ReviewCard( review:Review ) {

    Card( modifier = Modifier.padding(8.dp)) {
        Column(modifier = Modifier.padding( 16.dp))

        {

            ReviewHeader(review)

            Divider(
                modifier = Modifier.padding(start = 14.dp, top = 8.dp,  bottom = 8.dp, end = 14.dp),
                color = MaterialTheme.colors.onSurface.copy(alpha = 0.08f))

            ReviewBody(review)

            ReviewBottom(review)

        }

    }
}

@Composable
fun ReviewHeader(review: Review)
{
    Row( verticalGravity = Alignment.CenterVertically) {

        Image(
            imageResource(id = review.user.icon) , modifier =  Modifier.preferredSize(40.dp, 40.dp).clip(CircleShape))


        Column( modifier = Modifier.weight(1f)) {

            Text(review.user.name, style = MaterialTheme.typography.body2)
            Text(review.date, style = MaterialTheme.typography.caption, color = Color.Gray)

        }

        Icon(Icons.Filled.Star, Modifier.padding(4.dp).preferredSize(24.dp), tint = Color(0xFFFDD835))
        Text(text = review.ratting.toString(),
            style = MaterialTheme.typography.subtitle1)
    }
}

@Composable
fun ReviewBody(review: Review)
{
    Text(text = review.text,
        style = MaterialTheme.typography.subtitle1)
}


@Composable
fun ReviewBottom(review: Review)
{
    Row( modifier = Modifier.fillMaxWidth().padding(top = 8.dp), horizontalArrangement = Arrangement.End ) {

        Image(
            vectorResource(id = R.drawable.ic_thumb_up),  modifier = Modifier.padding(end = 4.dp).preferredSize(16.dp)
            ,colorFilter = ColorFilter.tint(Color.DarkGray))
        Text(text = review.likes.toString(), style = MaterialTheme.typography.body2, color = Color.DarkGray)

        Image(
            vectorResource(id = R.drawable.ic_thumb_down),  modifier = Modifier.padding(start = 16.dp, end = 4.dp).preferredSize(16.dp)
            , colorFilter = ColorFilter.tint(Color.DarkGray))
        Text(text = review.noOfReply.toString(), style = MaterialTheme.typography.body2,color = Color.DarkGray)

    }
}

