CREATE TABLE `uid_sequence` (
  `id` bigint(20) unsigned NOT NULL auto_increment,
  `stub` char(1) NOT NULL default '',
  PRIMARY KEY  (`id`),
  UNIQUE KEY `stub` (`stub`)
) ENGINE=MyISAM AUTO_INCREMENT=2;

REPLACE INTO uid_sequence (stub) VALUES ('a');
SELECT LAST_INSERT_ID();