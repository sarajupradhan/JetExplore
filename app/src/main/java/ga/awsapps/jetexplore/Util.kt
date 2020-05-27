package ga.awsapps.jetexplore

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

object Util {

    fun parseDate(
        inputDateString: String,
        inputDateFormat: SimpleDateFormat,
        outputDateFormat: SimpleDateFormat
    ): String? {
        var date: Date?
        var outputDateString: String? = null
        try {
            date = inputDateFormat.parse(inputDateString)
            outputDateString = outputDateFormat.format(date)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return outputDateString
    }

    fun getDate( inputDateStr : String  ) :String
    {
        val inputDateFormat = SimpleDateFormat("dd MMM yyyy, hh:mm a", Locale.US);
        val outputDateFormat = SimpleDateFormat("dd MMM yy", Locale.US);

        var outputDateStr: String?
        outputDateStr = parseDate(inputDateStr, inputDateFormat, outputDateFormat)

        if (outputDateStr != null) return outputDateStr else  return " -- "

    }
}