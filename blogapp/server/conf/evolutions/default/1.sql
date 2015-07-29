
# --- !Ups

create table blog_posts (
  id                        bigint not null,
  subject                   varchar(255) not null,
  content                   TEXT,
  user_id                   bigint,
  comment_count             bigint,
  constraint pk_blog_post primary key (id))
;

create table post_comments (
  id                        bigint not null,
  blog_post_id              bigint,
  user_id                   bigint,
  content                   TEXT,
  constraint pk_post_comment primary key (id))
;

create table users (
  id                        bigint not null,
  email                     varchar(255) not null,
  sha_password              varchar(255) not null,
  constraint uq_user_email unique (email),
  constraint pk_user primary key (id))
;

create sequence blog_post_seq;

create sequence post_comment_seq;

create sequence user_seq;

alter table blog_posts add constraint fk_blog_post_user_1 foreign key (user_id) references users (id) on delete restrict on update restrict;
create index ix_blog_post_user_1 on blog_posts (user_id);
alter table post_comments add constraint fk_post_comment_blogPost_2 foreign key (blog_post_id) references blog_posts (id) on delete restrict on update restrict;
create index ix_post_comment_blogPost_2 on post_comments (blog_post_id);
alter table post_comments add constraint fk_post_comment_user_3 foreign key (user_id) references users (id) on delete restrict on update restrict;
create index ix_post_comment_user_3 on post_comments (user_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists blog_posts;

drop table if exists post_comments;

drop table if exists users;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists blog_post_seq;

drop sequence if exists post_comment_seq;

drop sequence if exists user_seq;
