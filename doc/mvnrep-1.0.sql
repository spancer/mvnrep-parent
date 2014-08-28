CREATE DATABASE /*!32312 IF NOT EXISTS*/`mvnrep` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `mvnrep`;

create table jarInfo(
  jarInfoId BIGINT not null AUTO_INCREMENT,
  groupId varchar(200) not null,
  artifactId varchar(200) not null,
  version varchar(100) not null,
  jartype varchar(100) not null comment'当前的jar版本，是release,release candidate,beta,alpha,milestone',
  builderTime varchar(200) not null,
  clickRatio bigint not null default 1,
  remark text,
  primary key (jarInfoId)
)ENGINE=MyISAM AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;

/*一类jar文件的描述*/
create table typejardes(
  tjdId bigint not null AUTO_INCREMENT,
  ga varchar(500) not null,
  des text,
  createDT varchar(100),
  author varchar(100),
  audit int default -1  comment '审核状态，-1未通过，0暂无，1通过',
  primary key (tjdId)
)ENGINE=MyISAM AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;
/*搜索关键字*/
create table searchKey(
  skId bigint not null AUTO_INCREMENT,
  skw  varchar(100) not null,
  stime varchar(100) not null,
  primary key (skId)
)ENGINE=MyISAM AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;
