package co.yml.coreui.core.data.util

import co.yml.coreui.core.common.model.Post
import co.yml.coreui.core.database.model.PostEntity
import co.yml.coreui.core.network.model.PostDTO
import co.yml.coreui.core.network.model.PostRequest

/**
 * Map
 *
 * @return
 */
@JvmName("postDTOMapPost")
fun PostDTO.map(): Post {
    return Post(id, null, title, body)
}

/**
 * Map
 *
 * @return
 */
@JvmName("postMapPostEntity")
fun Post.map(): PostEntity {
    return PostEntity(id, userId ?: 0, title, body)
}

/**
 * To post entity list
 *
 * @return
 */
@JvmName("postListToPostEntityList")
fun List<Post>.toPostEntityList(): List<PostEntity> {
    val list = mutableListOf<PostEntity>()
    if (isNotEmpty()) {
        forEach {
            list.add(it.map())
        }
    }
    return list.toList()
}

/**
 * To post list
 *
 * @return
 */
@JvmName("postDTOListToPostList")
fun List<PostDTO>.toPostList(): List<Post> {
    val list = mutableListOf<Post>()
    if (isNotEmpty()) {
        forEach {
            list.add(it.map())
        }
    }
    return list.toList()
}

/**
 * Map
 *
 * @return
 */
@JvmName("postEntityMapPost")
fun PostEntity.map(): Post {
    return Post(id, null, title, body)
}

/**
 * To post request
 *
 * @return
 */
@JvmName("postToRequest")
fun Post.toPostRequest(): PostRequest {
    return PostRequest(title, body, userId ?: 0)
}

/**
 * To post list
 *
 * @return
 */
@JvmName("postEntityListToPostList")
fun List<PostEntity>.toPostList(): List<Post> {
    val list = mutableListOf<Post>()
    if (isNotEmpty()) {
        forEach {
            list.add(it.map())
        }
    }
    return list.toList()
}
