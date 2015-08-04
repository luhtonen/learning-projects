package models.database

import javax.inject.{Inject, Singleton}

import models._
import play.api.db.slick.DatabaseConfigProvider
import slick.driver.JdbcProfile

import scala.concurrent.Future

/** Created by luhtonen on 29/07/15. */
@Singleton
class Database @Inject()(protected val dbConfigProvider: DatabaseConfigProvider) {
  private val dbConfig = dbConfigProvider.get[JdbcProfile]

  import dbConfig._
  import driver.api._

  private class Users(tag: Tag) extends Table[User](tag, "users") {
    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
    def email = column[String]("email")
    def password = column[String]("sha_password")
    def * = (id.?, email, password) <> (User.tupled, User.unapply)

    def posts = TableQuery[BlogPosts].filter(_.userId === id)

    def userEmailIndex = index("uq_user_email", email, unique = true)
  }
  private val users = TableQuery[Users]

  // findByEmailAndPassword - email to lower case
  def findUserByEmailAndPassword(email: String, password: String): Future[Seq[User]] = db.run {
    users.filter(_.email === email.toLowerCase).filter(_.password === password).result
  }

  // findByEmail - email to lower case
  def findUserByEmail(email: String): Future[Seq[User]] = db.run {
    users.filter(_.email === email.toLowerCase).result
  }

/*  def create(email: String, password: String): Future[User] = db.run {
    (users.map(u => (u.email, u.password))
      returning users.map(_.id)
      into((emailPass, id) => User(id, emailPass._1, emailPass._2))
      ) += (email, password)
  }*/

  def insert(user: User) = db.run(users += user)

  private class BlogPosts(tag: Tag) extends Table[BlogPost](tag, "blog_posts") {
    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
    def subject = column[String]("subject")
    def content = column[String]("content")
    def userId = column[Long]("user_id")
    def commentCount = column[Long]("comment_count")
    def * = (id.?, subject, content, userId, commentCount) <> (BlogPost.tupled, BlogPost.unapply)

    def user = foreignKey("fk_blog_post_user_1", userId, TableQuery[Users])(_.id)
  }
  private val blogPosts = TableQuery[BlogPosts]

  // findBlogPostsByUser
  def findBlogPostsByUser(user: User): Future[Seq[BlogPost]] = db.run {
    blogPosts.filter(_.userId === user.id).result
  }
  // findBlogPostById
  def findBlogPostById(id: Long): Future[Seq[BlogPost]] = db.run {
    blogPosts.filter(_.id === id).result
  }

  private class PostComments(tag: Tag) extends Table[PostComment](tag, "post_comments") {
    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
    def blogPostId = column[Long]("blog_post_id")
    def userId = column[Long]("user_id")
    def content = column[String]("content")
    def * = (id.?, blogPostId, userId, content) <> (PostComment.tupled, PostComment.unapply)

    def blogPost = foreignKey("fk_post_comment_blogpost_2", blogPostId, TableQuery[BlogPosts])(_.id)
    def user = foreignKey("fk_post_comment_user_3", userId, TableQuery[Users])(_.id)
  }
  private val postComments = TableQuery[PostComments]

  // findAllCommentsByPost
  def findAllCommentsByPost(post: BlogPost): Future[Seq[PostComment]] = db.run {
    postComments.filter(_.blogPostId === post.id).result
  }
  // findAllCommentsByUser
  def findAllCommentsByUser(user: User): Future[Seq[PostComment]] = db.run {
    postComments.filter(_.userId === user.id).result
  }
}
