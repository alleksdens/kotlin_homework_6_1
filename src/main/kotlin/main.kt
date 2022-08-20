fun main() {
    val original = Post(
        id = null,
        fromId = 1,
        ownerId = 1,
        createdBy = 1,
        date = System.currentTimeMillis(),
        text = "Новый пост",
        replyOwnerId = 1,
        replyPostId = 1,
        friendsOnly = false,
        comments = Comment(1, true, true, true, true),
        copyright = Copyright(1, "testLink", "testName", "testType"),
        likes = Likes(1, true, true, true),
        reposts = Reposts(1, true),
        views = Views(1),
        postType = "post",
        postSource = PostSource("vk", "android", "profile_activity", "vk.com"),
        geo = Geo("vkType", "55.667950, 35.369341", "home"),
        signerId = 1,
        copyHistory = null,
        canPin = true,
        canDelete = true,
        canEdit = true,
        isPinned = false,
        markedAsAds = false,
        isFavorite = false,
        donut = Donut(false, 1, Placeholder("testPlaceholder"), true, "all"),
        postponedId = 1
    )
    val original2 = Post(
        id = null,
        fromId = 1,
        ownerId = 1,
        createdBy = 1,
        date = System.currentTimeMillis(),
        text = "Новый пост2",
        replyOwnerId = 1,
        replyPostId = 1,
        friendsOnly = false,
        comments = Comment(1, true, true, true, true),
        copyright = Copyright(1, "testLink", "testName", "testType"),
        likes = Likes(1, true, true, true),
        reposts = Reposts(1, true),
        views = Views(1),
        postType = "post",
        postSource = PostSource("vk", "android", "profile_activity", "vk.com"),
        geo = Geo("vkType", "55.667950, 35.369341", "home"),
        signerId = 1,
        copyHistory = null,
        canPin = true,
        canDelete = true,
        canEdit = true,
        isPinned = false,
        markedAsAds = false,
        isFavorite = false,
        donut = Donut(false, 1, Placeholder("testPlaceholder"), true, "all"),
        postponedId = 1
    )
    val forUpdate = Post(
        id = 2,
        ownerId = 1,
        fromId = 1,
        createdBy = 2,
        date = System.currentTimeMillis(),
        text = "Новый обновленный пост",
        replyOwnerId = 2,
        replyPostId = 2,
        friendsOnly = true,
        comments = Comment(4, true, true, true, true),
        copyright = Copyright(4, "testLink", "testName", "testType"),
        likes = Likes(4, true, true, true),
        reposts = Reposts(4, true),
        views = Views(4),
        postType = "post",
        postSource = PostSource("vk", "android", "profile_activity", "vk.com"),
        geo = Geo("vkType", "55.667950, 35.369341", "home"),
        signerId = 4,
        copyHistory = null,
        canPin = true,
        canDelete = true,
        canEdit = true,
        isPinned = false,
        markedAsAds = true,
        isFavorite = false,
        donut = Donut(false, 4, Placeholder("testPlaceholder"), true, "all"),
        postponedId = 4
    )
    val forUpdate2 = Post(
        id = 4,
        ownerId = 1,
        fromId = 1,
        createdBy = 2,
        date = System.currentTimeMillis(),
        text = "Новый  необновленный пост",
        replyOwnerId = 2,
        replyPostId = 2,
        friendsOnly = true,
        comments = Comment(4, true, true, true, true),
        copyright = Copyright(4, "testLink", "testName", "testType"),
        likes = Likes(4, true, true, true),
        reposts = Reposts(4, true),
        views = Views(4),
        postType = "post",
        postSource = PostSource("vk", "android", "profile_activity", "vk.com"),
        geo = Geo("vkType", "55.667950, 35.369341", "home"),
        signerId = 4,
        copyHistory = null,
        canPin = true,
        canDelete = true,
        canEdit = true,
        isPinned = false,
        markedAsAds = true,
        isFavorite = false,
        donut = Donut(false, 4, Placeholder("testPlaceholder"), true, "all"),
        postponedId = 4
    )
    WallService.add(original)
    WallService.print()
    WallService.add(original2)
    WallService.print()
    WallService.update(forUpdate)
    WallService.print()
    WallService.update(forUpdate2)
    WallService.print()
}

object WallService {
    private var nextId = 0
    private var posts = emptyArray<Post>()
    fun add(post: Post): Post {
        nextId += 1
        posts += post.copy(id = nextId)
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for ((index) in posts.withIndex()) {
            if (post.id == posts[index].id) {
                posts[index] = post.copy(
                    fromId = post.fromId,
                    createdBy = post.createdBy,
                    text = post.text,
                    replyOwnerId = post.replyOwnerId,
                    replyPostId = post.replyPostId,
                    friendsOnly = post.friendsOnly,
                    comments = post.comments,
                    copyright = post.copyright,
                    likes = post.likes,
                    reposts = post.reposts,
                    views = post.views,
                    postType = post.postType,
                    postSource = post.postSource,
                    geo = post.geo,
                    signerId = post.signerId,
                    copyHistory = post.copyHistory,
                    canPin = post.canPin,
                    canDelete = post.canDelete,
                    canEdit = post.canEdit,
                    isPinned = post.isPinned,
                    markedAsAds = post.markedAsAds,
                    isFavorite = post.isFavorite,
                    donut = post.donut,
                    postponedId = post.postponedId
                )
            }
        }
        return post in posts
    }

    fun print() {
        for (post in posts) {
            println(post)
        }
    }
}