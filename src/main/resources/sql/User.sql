show databases ;
use jpa;
select database();
create table `user`(
    id bigint primary key  comment '主键，用户id',
    username varchar(255) comment '用户名',
    password varchar(255) comment '用户密码'
)engine=InnoDB charset =utf8 comment '用户表'