import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class WallTest {
    @Test
    fun addOne() {
        val original3 = Post(
            id = null,
            ownerId = 1,
            fromId = 1,
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
        val service3 = WallService
        assertTrue((service3.add(original3)).id != 0)
    }

    @Test
    fun updateNotFound() {
        val original = Post(
            id = null,
            ownerId = 1,
            fromId = 1,
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
        val forUpdate = Post(
            id = 5,
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
        WallService.add(original)
        val result = WallService.update(forUpdate)
        println(result)
        assertEquals(false, result)
    }

    @Test
    fun updateFound() {
        val original2 = Post(
            id = null,
            ownerId = 1,
            fromId = 1,
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
        val forUpdate2 = Post(
            id = 1,
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
        WallService.add(original2)
        val result = WallService.update(forUpdate2)
        println(result)
        assertEquals(true, result)
    }
}