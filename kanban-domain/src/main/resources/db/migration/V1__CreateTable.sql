USE kanban;

CREATE TABLE `cards` (
  `id`          bigint(20)   NOT NULL AUTO_INCREMENT COMMENT '시퀀스',
  `title`       varchar(50)  NOT NULL COMMENT '작업명',
  `description` varchar(200) NOT NULL COMMENT '작업에 대한 상세 설명',
  `status`      varchar(15)  NOT NULL COMMENT '작업의 진행 상태 [TODO, IN-PROGRESS, IN-QA, DONE, CLOSE] ',
  `color`       varchar(45)  NOT NULL DEFAULT '#c9c9c9' COMMENT '카드 색상',
  `createdAt`   datetime     NOT NULL COMMENT '생성일시',
  `modifiedAt`  datetime     NOT NULL COMMENT '수정일시',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='작업정보';

CREATE TABLE `tasks` (
  `id`         bigint(20)   NOT NULL AUTO_INCREMENT COMMENT '시퀀스',
  `cardId`     bigint(20)   NOT NULL COMMENT '이 task를 가지고있는 card의 id',
  `name`       varchar(200) NOT NULL COMMENT '작업명',
  `done`       tinyint(1)   NOT NULL DEFAULT '0' COMMENT '작업 완료 여부',
  `createdAt`  datetime     NOT NULL COMMENT '생성일시',
  `modifiedAt` datetime     NOT NULL COMMENT '수정일시',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='작업상세정보';

