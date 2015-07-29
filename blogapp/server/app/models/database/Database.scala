package models.database

import javax.inject.Inject

import models._
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.driver.JdbcProfile

/** Created by luhtonen on 29/07/15. */
class Database @Inject()(protected val dbConfigProvider: DatabaseConfigProvider) extends HasDatabaseConfigProvider[JdbcProfile] {
  import driver.api._

  class Users(tag: Tag) extends Table[User](tag, "users") {
    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
    def email = column[String]("name")
    def password = column[String]("sha_password")
    def * = (id.?, email, password) <> (User.tupled, User.unapply)

    def posts = TableQuery[BlogPosts].filter(_.userId === id)

    def userEmailIndex = index("uq_user_email", email, unique = true)
  }
  val users = TableQuery[Users]

  // find by Id
  // findByEmailAndPassword - email to lower case
  // findByEmail - email to lower case
  def findUserByEmail(email: String) = db.run(users.filter(_.email === email.toLowerCase).result.head).map{_ => User.apply _}

  class BlogPosts(tag: Tag) extends Table[BlogPost](tag, "blog_posts") {
    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
    def subject = column[String]("subject")
    def content = column[String]("content")
    def userId = column[Long]("user_id")
    def commentCount = column[Long]("comment_count")
    def * = (id.?, subject, content, userId, commentCount) <> (BlogPost.tupled, BlogPost.unapply)

    def user = foreignKey("fk_blog_post_user_1", userId, TableQuery[Users])(_.id)
  }
  val blogPosts = TableQuery[BlogPosts]

  // find by id
  // findBlogPostsByUser
  // findBlogPostById

  class PostComments(tag: Tag) extends Table[PostComment](tag, "post_comments") {
    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
    def blogPostId = column[Long]("blog_post_id")
    def userId = column[Long]("user_id")
    def content = column[String]("content")
    def * = (id.?, blogPostId, userId, content) <> (PostComment.tupled, PostComment.unapply)

    def blogPost = foreignKey("fk_post_comment_blogPost_2", blogPostId, TableQuery[BlogPosts])(_.id)
    def user = foreignKey("fk_post_comment_user_3", userId, TableQuery[Users])(_.id)
  }
  val postComments = TableQuery[PostComments]

  // find by id
  // findAllCommentsByPost
  // findAllCommentsByUser
}
