package ru.netology

data class Comments(
    val count: Int = 0,
    val canPost: Boolean = false,
    val groupsCanPost: Boolean = false,
    val canClose: Boolean = false,
    val canOpen: Boolean = false
)

data class Post(
    val id: Int = 0,
    val ownerId: Int = 1,
    val fromId: Int = 1,
    val createdBy: Int = 0,
    val date: Int = 0,
    val text: String? = "text",
    val replyOwnerId: Int = 1,
    val replyPostId: Int = 1,
    val friendsOnly: Boolean = false,
    val copyright: String? = "copyright",
    val comments: Comments = Comments(),
    val attachment: Array<Attachment> = arrayOf(VideoAttachment(), AudioAttachment())
)

object WallService {
    private var posts = emptyArray<Post>()
    var comments = emptyArray<Comment>()
    private var id = 0

    fun createComment(postId: Int, comment: Comment): Comment {
        for (pos in posts) {
            if (pos.id == postId) {
                comments += comment.copy()
                return comment
            }
        }
        throw PostNotFoundException("PostNotFoundException")
    }

    fun add(post: Post): Post {
        posts += post.copy(id = ++id)
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for ((index, pos) in posts.withIndex()) {
            if (pos.id == post.id) {
                posts[index] = post
                return true
            }
        }
        return false
    }

    fun clear() {
        posts = emptyArray()
        id = 0
    }
}
