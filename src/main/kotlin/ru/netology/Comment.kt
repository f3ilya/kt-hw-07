package ru.netology

class PostNotFoundException(message: String) : Exception(message)

data class Donut(
    val isDon: Boolean = true,
    val placeholder: String = "placeholder"
)

data class Thread(
    val count: Int = 1,
    val items: Array<Int> = emptyArray(),
    val canPost: Boolean = false,
    val showReplyButton: Boolean = false,
    val groupsCanPost: Boolean = false
)

data class Comment(
    val id: Int = 0,
    val fromId: Int = 0,
    val date: Int = 1,
    val text: String = "text",
    val donut: Donut = Donut(),
    val replyToUser: Int = 1,
    val replyToComment: Int = 1,
    val attachments: Array<Attachment> = arrayOf(VideoAttachment(), AudioAttachment()),
    val parentsStack: Array<Int> = emptyArray(),
    val thread: Thread = Thread()
)
