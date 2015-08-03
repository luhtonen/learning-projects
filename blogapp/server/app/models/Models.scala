package models

/** Created by luhtonen on 29/07/15. */
case class User(id: Option[Long] = None, email: String, password: String)

case class BlogPost(id: Option[Long] = None, subject: String, content: String, userId: Long, commentCount: Long = 0)

case class PostComment(id: Option[Long] = None, blogPostId: Long, userId: Long, content: String)
