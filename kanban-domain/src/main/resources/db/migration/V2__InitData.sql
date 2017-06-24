USE kanban;

INSERT INTO `cards` (`id`,`title`,`description`,`status`,`color`,`createdAt`,`modifiedAt`) VALUES (13,'Project Setting','프로젝트 환경설정','INPROGRESS','#c92148','2017-05-14 15:58:16','2017-06-20 20:16:52');
INSERT INTO `cards` (`id`,`title`,`description`,`status`,`color`,`createdAt`,`modifiedAt`) VALUES (14,'Apply Flyway','DB Scheme management','TODO','#c9c9c9','2017-05-14 15:59:25','2017-06-20 20:09:59');
INSERT INTO `cards` (`id`,`title`,`description`,`status`,`color`,`createdAt`,`modifiedAt`) VALUES (15,'Apply Sonar','CodeQuality management','TODO','#c9c9c9','2017-05-14 16:01:06','2017-06-20 20:10:04');
INSERT INTO `cards` (`id`,`title`,`description`,`status`,`color`,`createdAt`,`modifiedAt`) VALUES (16,'Apply JPA GenerateSource','Use queryDSL and Criteria','TODO','#c9c9c9','2017-05-14 16:01:47','2017-06-20 19:57:39');
INSERT INTO `cards` (`id`,`title`,`description`,`status`,`color`,`createdAt`,`modifiedAt`) VALUES (17,'Add README','Project description','TODO','#c9c9c9','2017-05-14 16:02:33','2017-05-14 16:02:33');
INSERT INTO `cards` (`id`,`title`,`description`,`status`,`color`,`createdAt`,`modifiedAt`) VALUES (18,'Remove React Warning','Bug fix','TODO','#c9c9c9','2017-05-14 16:02:58','2017-05-14 16:02:58');
INSERT INTO `cards` (`id`,`title`,`description`,`status`,`color`,`createdAt`,`modifiedAt`) VALUES (19,'Add UnitTest','Increase codeQuality','TODO','#c9c9c9','2017-05-14 16:24:36','2017-06-20 19:57:41');

INSERT INTO `tasks` (`id`,`cardId`,`name`,`done`,`createdAt`,`modifiedAt`) VALUES (66,13,'setup IDE',1,'2017-05-14 16:29:22','2017-05-14 16:29:22');
INSERT INTO `tasks` (`id`,`cardId`,`name`,`done`,`createdAt`,`modifiedAt`) VALUES (67,13,'setup JDK1.8',1,'2017-05-14 16:29:43','2017-05-14 16:29:43');
INSERT INTO `tasks` (`id`,`cardId`,`name`,`done`,`createdAt`,`modifiedAt`) VALUES (68,13,'download lib',1,'2017-05-14 16:30:31','2017-05-14 16:30:31');
INSERT INTO `tasks` (`id`,`cardId`,`name`,`done`,`createdAt`,`modifiedAt`) VALUES (69,13,'setup default configuration',0,'2017-05-14 16:31:25','2017-05-14 16:31:25');
INSERT INTO `tasks` (`id`,`cardId`,`name`,`done`,`createdAt`,`modifiedAt`) VALUES (70,13,'config domain',0,'2017-05-14 16:31:37','2017-05-14 16:31:37');
INSERT INTO `tasks` (`id`,`cardId`,`name`,`done`,`createdAt`,`modifiedAt`) VALUES (71,13,'config interfaces',0,'2017-05-14 16:32:35','2017-06-20 19:57:47');
INSERT INTO `tasks` (`id`,`cardId`,`name`,`done`,`createdAt`,`modifiedAt`) VALUES (72,14,'set initial db',0,'2017-05-14 16:33:27','2017-05-14 16:33:27');
INSERT INTO `tasks` (`id`,`cardId`,`name`,`done`,`createdAt`,`modifiedAt`) VALUES (73,14,'set create table query',0,'2017-05-14 16:33:38','2017-05-14 16:33:38');
INSERT INTO `tasks` (`id`,`cardId`,`name`,`done`,`createdAt`,`modifiedAt`) VALUES (74,14,'set initial data',0,'2017-05-14 16:33:49','2017-05-14 16:33:49');
INSERT INTO `tasks` (`id`,`cardId`,`name`,`done`,`createdAt`,`modifiedAt`) VALUES (75,15,'set sonar configuration',0,'2017-05-14 16:34:27','2017-05-14 16:34:27');
INSERT INTO `tasks` (`id`,`cardId`,`name`,`done`,`createdAt`,`modifiedAt`) VALUES (76,16,'set JPA gradle task',0,'2017-05-14 16:34:56','2017-05-14 16:34:56');
INSERT INTO `tasks` (`id`,`cardId`,`name`,`done`,`createdAt`,`modifiedAt`) VALUES (77,17,'write way of use',0,'2017-05-14 16:35:47','2017-05-14 16:35:47');
INSERT INTO `tasks` (`id`,`cardId`,`name`,`done`,`createdAt`,`modifiedAt`) VALUES (78,18,'apply latest propType',0,'2017-05-14 16:36:53','2017-05-14 16:36:53');
INSERT INTO `tasks` (`id`,`cardId`,`name`,`done`,`createdAt`,`modifiedAt`) VALUES (79,19,'add unit test',0,'2017-05-14 16:37:23','2017-05-14 16:37:23');
INSERT INTO `tasks` (`id`,`cardId`,`name`,`done`,`createdAt`,`modifiedAt`) VALUES (80,19,'remove sonar issue',1,'2017-05-14 16:37:35','2017-06-20 10:51:14');
