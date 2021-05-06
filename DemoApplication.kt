package demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.annotation.Id
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class DemoApplication

fun main(args: Array<String>) {
	runApplication<DemoApplication>(*args)
	println("hello world! - ran api code")
}

@RestController
class UserResource {
	@GetMapping

	// this is where we plug in our user database - see the json files that we have been makig
	fun index(): List<User> = listOf(
			User(0, "null", "admin", "Moses", "Apostol", "mapo3126@gmail.com", "random", "null", "random", 0, 1),
			User(1, "null", "VP", "Oaks", "Apostol", "oaks@gmail.com", "random", "null", "random", 0, 1),
			User(2, "null", "STO", "Joven", "Apostol", "japostol@gmail.com", "random", "null", "random", 0, 1),
			User(3, "null", "null", "Edna", "Apostol", "ednaapostol@gmail.com", "random", "null", "random", 0, 1),
			User(4, "null", "Artist", "Matthew", "Apostol", "mapo333@gmail.com", "random", "null", "random", 0, 1),
            User(5, "null", "Programmer", "Michelle", "Apostol", "miche@gmail.com", "random", "null", "random", 0, 1),
            User(6, "null", "Programming Manager", "Billy", "Dume", "dume.billy@gmail.com", "random", "null", "random", 0, 1),
            User(7, "null", "null", "Bill", "Apostol", "apostol.bill@gmail.com", "random", "null", "random", 0, 1),
            User(8, "null", "null", "Willy", "Apostol", "apostol.willy@gmail.com", "random", "null", "random", 0, 1),
            User(9, "null", "null", "Andrew", "Dume", "dume.andrew@gmail.com", "random", "null", "random", 0, 1),
            User(10, "null", "null", "Jess", "Facun", "facun.jess@gmail.com", "random", "null", "random", 0, 1),
            User(11, "null", "null", "Jessue", "Apostol", "apostol.jessue@gmail.com", "random", "null", "random", 0, 1),
            User(12, "null", "null", "Rex", "Charlies", "charles.rex@gmail.com", "random", "null", "random", 0, 1),
            User(13, "null", "null", "Aoi", "Apostol", "apostol.aoi@gmail.com", "random", "null", "random", 0, 1),
            User(14, "null", "null", "Ivan", "Facun", "facun.ivan@gmail.com", "random", "null", "random", 0, 1),
            User(15, "null", "null", "Richard", "Charles", "richard.charles@gmail.com", "random", "null", "random", 0, 1),
            User(16, "null", "null", "Joseph", "Charles", "charles.jospeh@gmail.com", "random", "null", "random", 0, 1),
            User(17, "null", "null", "Richie", "Apostol", "apostol.richie@gmail.com", "random", "null", "random", 0, 1),
            User(18, "null", "null", "Pol", "Facun", "facun.pol@gmail.com", "random", "null", "random", 0, 1),
            User(19, "null", "null", "Dike", "Apostol", "apostol.dike@gmail.com", "random", "null", "random", 0, 1),
            User(20, "null", "null", "Harvey", "Facun", "facun.harvey@gmail.com", "random", "null", "random", 0, 1),
            User(21, "null", "null", "Mike", "Apostol", "apostol.mike@gmail.com", "random", "null", "random", 0, 1),
            User(22, "null", "null", "Jeremy", "Apostol", "apostol.jeremy@gmail.com", "random", "null", "random", 0, 1),
            )
}




// our User Class - ready for us to put on a database for
// us to query and have fun with.
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

// lets say we want to read a post on our app on our smartphone
data class forumPost(
				val id: Int,
				val title: String,
				var answers: Int,
				val description: String,
				val user: String,
				val date: String,
				val source1: String,
				val source1Describe: String,
				val source2: String,
				val source2Describe: String,
				val source3: String,
				val source3Describe: String,
				val email: String,
				val firstName: String,
				val lastName: String,
				val tag: String)