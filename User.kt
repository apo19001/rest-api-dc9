data class User(val id: Int, // id of the user we want
                val status: String, // away, null, etc.
                val rank: String,  // rank they have on the server
                val firstName: String,
                val lastName: String,
                val email: String,
                val password: String, // we will use the password "random"
                val permissions: String, // what places they can access on the website
                val hash: String, // haha, I'm posting the hash online (nice try)
                val active: Int,
                val reputation:Int)