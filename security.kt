import com.beust.klaxon.*
import com.google.gson.Gson
import com.google.gson.JsonParser
import netscape.javascript.JSObject
import java.net.HttpURLConnection
import java.net.URL
import java.io.StringReader
import java.security.KeyStore


/*
    SOURCE(S)
    https://stackoverflow.com/questions/46177133/http-request-in-kotlin
    https://github.com/cbeust/klaxon#streaming-api
    https://developer.android.com/reference/android/util/JsonReader.html
*/

class security (  val email: String,
                  val password: String) {

    private var connectionCodeStatus: Int = 0
    private var jsonreading: String = "" // save the json variable
    private var klaxton = Klaxon() // our parser
    private var personCopy = arrayListOf<User>()

    private fun connecttodatabase() : String
    // how can I be able to parse this link as a json file
    // got from https://stackoverflow.com/questions/46177133/http-request-in-kotlin
    // https://developer.android.com/reference/android/util/JsonReader.html
    // Here I learned how to query a api base using the java,net.HTTPURLConnection

    /*
     This code over here sends an api request and saves the json file as a
     a string for it to be processed once.
     */
    {
        val url = URL("http://16aa1aabe2ad.ngrok.io/") // encrypt this
        with(url.openConnection() as HttpURLConnection) {
            connectionCodeStatus = responseCode
            if (responseCode == 200) { // check if the connection work
                inputStream.bufferedReader().use {
                    it.lines().forEach { line ->
                        jsonreading = line
                    }
                }
            }
            else
                print("CONNECTION FAILED $responseCode") // error checking
        }
        return jsonreading // the entire jsonstring for us to use
    }

    /*
       shovingUsersinArray()
       this saves all the users in the
       json file into personCopy - making
       a bunch of users
     */
    fun shovingUsersinArray(arrayParse: String)
    {
        // got help from the pasing method from https://github.com/cbeust/klaxon#streaming-api
        JsonReader(StringReader(arrayParse)).use { reader ->
            reader.beginArray {
                while (reader.hasNext()) {
                    var person = klaxton.parse<User>(reader) // parse it as a data class -> see project file
                    if (person != null) { // error checking
                        personCopy.add(person) // add it to the list of users that we can access (invisible to the person calling it
                    }
                }
            }
        }
    }

    // this returns the connection status of the file.
    fun connectionStatus() : Int
    {
        return connectionCodeStatus
    }

    // this will help find the email that does/does not exist
    private fun findEmail() : Boolean
    {
        for (i in 0 .. personCopy.size)
        {
            if (personCopy[i].email == this.email)
                return true
        }
        return false
    }

    // get the id of the user
    private fun getID() : Int{
        for (i in 0 .. personCopy.size)
        {
            if (personCopy[i].email == this.email)
                return i
        }
        return -1 // didn't find the id for the user
    }

    // will print out the information for the user
    fun getInformation(){
        val idForMe = getID()
        for (i in 0 .. personCopy.size)
        {
            if (personCopy[i].id == idForMe)
            {
                println(personCopy[i].firstName + " " + personCopy[i].lastName)
                println("-------------------------RANK/REPUTATION-----------------------------")
                println(personCopy[i].rank)
                println(personCopy[i].reputation)
                return
            }
        }
    }


    private fun findPassword() : Boolean
    {
        for (i in 0 .. personCopy.size)
        {
            if (personCopy[i].password == this.password)
                return true
        }
        return false
    }

    // check if the email and the password are good
    private fun canLogin() : Boolean
    {
        return findEmail() && findPassword()
    }

    // create getters and setters - use the security class in here to help access the user class
    // (see in project class)
    // add accessors for the rest of the program

    init {
        val jsonString: String = connecttodatabase()
        val parseString = shovingUsersinArray(jsonString) // run the api request, plug it into the user array once.
        if(canLogin()){
            println("you are logged in!") // you can now access the database
        }
        else {
            print("LOGIN FAILURE!")
        }
    }
}