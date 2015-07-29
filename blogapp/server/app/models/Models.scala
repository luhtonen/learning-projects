package models

/** Created by luhtonen on 29/07/15. */
case class User(id: Long, email: String, password: String)

case class BlogPost(id: Option[Long], subject: String, content: String, userId: Long, commentCount: Long = 0)

case class PostComment(id: Option[Long], blogPostId: Long, userId: Long, content: String)
