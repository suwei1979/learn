CREATE TABLE `tb_industry` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `code` bigint(20) unsigned NOT NULL,
  `name` varchar(60) NOT NULL,
  `level` int(10) unsigned NOT NULL,
  `parent_code` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_industry_code` (`code`),
  KEY `idx_industry_parent_code` (`parent_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tb_account` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(60) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

