package ba.ibu.gram.functions

import ba.ibu.gram.common.BaseFunction
import ba.ibu.gram.model.Post
import javax.inject.Inject

class CreatePost @Inject constructor() : BaseFunction<Post, Post?>() {
  override suspend fun call(input: Post): Post? = callFunction("createPost", input)

}