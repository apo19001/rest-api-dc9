# Overview

I wanted to create a REST API that would allow users to
get information via JSON. This has several applications,
when people sign up for my website, their information
is stored within a database. This database can be
exported via JSON, and can get queried by other
applications.

This project exposed me to the language of kotlin, 
learning how to host my API's remotely, as well 
as JSON parsing. I used libaries such as
Klaxon for me to get information off the server,
and display them.

My program will allow me to verify if the user
exist(s), and notify the users current
status on my website.

The software was made to be build off my website, and
be able to serve as a possible boilerplate for me
to work on a more "comprehensive" API in the future.

It is worth to note that the actual user data used
in this project is not real (obviously), there 
was a security concern on posting personal emails
with their accompanying password hashes online. 

[Software Demo Video](https://youtu.be/TPgNCJJGOtc)

# Development Environment

* I used ngrok to host my api from a local port that I used on my PC. 

* I also used spring boot to help me develop my API.

* I also used klaxon (see link below) to parse the json that would be processed by my application.

* This program used Intellij in order to help me build projects for me.


# Useful Websites

* [DeepCloud9](http://dc9.x10host.com/)
* [ngrok - api hosting](https://ngrok.com/)
* [klaxon - json parser] (https://github.com/cbeust/klaxon)
* [REST API - How to make with kotlin] (https://kotlinlang.org/docs/jvm-spring-boot-restful.html)
* [Making HTTP requests using kotlin] (https://stackoverflow.com/questions/46177133/http-request-in-kotlin)
* [Kotlin tutorial that helped me] (https://www.youtube.com/watch?v=5flXf8nuq60)

# ADDITONAL SOURCES THAT HELPED ME
* [intellj idea spring boot plugin] (https://kotlinlang.org/docs/jvm-spring-boot-restful-db.html)

# Future Work
* Add token verification system in the future
* Add hash descryption module (get password hash -> decrypt in kotlin)
* Find a more permanent website to host REST API
* Expand API work -> add more modules to learn