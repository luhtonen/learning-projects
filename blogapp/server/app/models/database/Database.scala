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
    def id = column[Long]("ID", O.PrimaryKey, O.AutoInc)
    def email = column[String]("EMAIL")
    def password = column[String]("SHA_PASSWORD")
    def * = (id.?, email, password) <> (User.tupled, User.unapply)

    def posts = TableQuery[BlogPosts].filter(_.userId === id)

    def userEmailIndex = index("UQ_USER_EMAIL", email, unique = true)
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

  private class BlogPosts(tag: Tag) extends Table[BlogPost](tag, "BLOG_POSTS") {
    def id = column[Long]("ID", O.PrimaryKey, O.AutoInc)
    def subject = column[String]("SUBJECT")
    def content = column[String]("CONTENT")
    def userId = column[Long]("USER_ID")
    def commentCount = column[Long]("COMMENT_COUNT")
    def * = (id.?, subject, content, userId, commentCount) <> (BlogPost.tupled, BlogPost.unapply)

    def user = foreignKey("FK_BLOG_POST_USER_1", userId, TableQuery[Users])(_.id)
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

  private class PostComments(tag: Tag) extends Table[PostComment](tag, "POST_COMMENTS") {
    def id = column[Long]("ID", O.PrimaryKey, O.AutoInc)
    def blogPostId = column[Long]("BLOG_POST_ID")
    def userId = column[Long]("USER_ID")
    def content = column[String]("CONTENT")
    def * = (id.?, blogPostId, userId, content) <> (PostComment.tupled, PostComment.unapply)

    def blogPost = foreignKey("fk_post_comment_blogpost_2", blogPostId, TableQuery[BlogPosts])(_.id)
    def user = foreignKey("FK_POST_COMMENT_USER_3", userId, TableQuery[Users])(_.id)
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
