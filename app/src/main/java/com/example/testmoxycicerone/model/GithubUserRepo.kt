package com.example.testmoxycicerone.model

class GithubUserRepo {
    private val repositories = listOf(
        User(null, "Jonny", null),
        User(null, "Fred", "https://github.com"),
        User(null, "Anna", null),
        User(null, "Elise", "https://github.com"),
        User(null, "John", null),
    )

    fun getUsers() : List<User>{
        return repositories
    }
}