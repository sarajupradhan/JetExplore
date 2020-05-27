package ga.awsapps.jetexplore.model

data class Place(
    val id :  Int,
    val name :String,
    val address: String,
    val location : Location,
    val descriptions: String,
    val difficulty:Int,
    val elevation : Long,
    val imageResources: List<Int>,
    val feedBack: FeedBack
   )


data class FeedBack(
    val totalNoOfReview: Int,
    val overallRatting : Float,
    val ratting: Ratting,
    val reviews : List<Review>)

data class Reply( val  user: User,  val text: String)

data class Location(
    val lat: Double ,
    val long: Double,
    val distance: Double)

data class Type(val  name:String, val imageResource: Int)


data class Ratting(
    val count: Int,
    val display: String,
    val value: Double,
    val one: States,
    val two: States,
    val three: States,
    val four: States,
    val five: States)

data class States(val percentage: Int)

data class Elevation(
    val ascent: Int,
    val descent: Int,
    val high: Int,
    val low: Int)


data class Review(
    val text: String,
    val date: String,
    val ratting: Float,
    val user: User,
    val noOfReply: Int,
    val likes : Int)


data class User(
    val id :  Int,
    val name: String ,
    val icon: Int)

data class Post(
    val id :  Int,
    val title: String ,
    val descriptions: String,
    val date: String,
    val author: User)

data class Event(
    val id: Int,
    val title: String,
    val imageResource : Int,
    val place: Place,
    val status: Int,
    val startDate : String,
    val endDate : String)




