CREATE TABLE `ems_t_user_master` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `user_type` enum('SUPER_ADMIN','ADMIN','USER') DEFAULT 'USER',
  `full_name` varchar(255) NOT NULL,
  `email_address` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `address` text,
  `gender` enum('MALE','FEMALE','OTHERS') NOT NULL,
  `parent_user_id` bigint NOT NULL,
  `status` enum('ACTIVE','INACTIVE','BLOCKED','DELETED') DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `created_by` bigint DEFAULT NULL,
  `validity_end_date` datetime DEFAULT NULL,
  `modification_date` datetime DEFAULT NULL,
  `modified_by` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_name` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;


CREATE TABLE `ems_t_user_sessions` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `access_token` text,
  `device_info` varchar(255) NOT NULL,
  `is_blacklisted` tinyint(1) NOT NULL,
  `refresh_token` text,
  `user_id` bigint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

CREATE TABLE `ems_t_group_menu_master` (
  `group_id` bigint NOT NULL AUTO_INCREMENT,
  `group_name` varchar(100) NOT NULL,
  `is_alignment` varchar(255) NOT NULL,
  `previous_group_id` bigint NOT NULL,
  `status` varchar(255) NOT NULL,
  PRIMARY KEY (`group_id`),
  UNIQUE KEY `UK_m8hwcvqmbksol5itt0xym52iv` (`group_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

CREATE TABLE `ems_t_parent_menu_master` (
  `menu_id` bigint NOT NULL AUTO_INCREMENT,
  `group_menu_id` bigint NOT NULL,
  `is_alignment` varchar(255) NOT NULL,
  `menu_name` varchar(100) NOT NULL,
  `previous_menu_id` bigint NOT NULL,
  `status` varchar(255) NOT NULL,
  PRIMARY KEY (`menu_id`),
  UNIQUE KEY `UK_agm7y1529abub09pv078s9fv8` (`menu_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

CREATE TABLE `ems_t_child_menu_master` (
  `child_menu_id` bigint NOT NULL AUTO_INCREMENT,
  `action_url` varchar(100) DEFAULT NULL,
  `is_alignment` varchar(255) NOT NULL,
  `menu_name` varchar(100) NOT NULL,
  `parent_menu_id` bigint NOT NULL,
  `previous_child_menu_id` bigint NOT NULL,
  `status` varchar(255) NOT NULL,
  `action_id` bigint DEFAULT NULL,
  PRIMARY KEY (`child_menu_id`),
  UNIQUE KEY `UK_kq7i9umtgqttwlj25x9aw6py6` (`menu_name`),
  KEY `FKx72q1c5q21mik2wn1f9262xn` (`action_id`)
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

CREATE TABLE `ems_t_child_menu_action_url_mapping` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `create_action` varchar(255) DEFAULT NULL,
  `delete_action` varchar(255) DEFAULT NULL,
  `edit_action` varchar(255) DEFAULT NULL,
  `list_action` varchar(255) DEFAULT NULL,
  `show_action` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

CREATE TABLE `ems_t_user_child_menu_mapping` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `status` varchar(255) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  `menu_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhckgxefdsuk801w69bo5rbgum` (`menu_id`),
  CONSTRAINT `FKhckgxefdsuk801w69bo5rbgum` FOREIGN KEY (`menu_id`) REFERENCES `ems_t_child_menu_master` (`child_menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

CREATE TABLE `ems_t_entity_audit_log_master` (
  `log_id` bigint NOT NULL AUTO_INCREMENT,
  `action_taken` varchar(255) DEFAULT NULL,
  `entity_id` bigint NOT NULL,
  `history` text,
  `performed_by` bigint DEFAULT NULL,
  `requested_on` datetime DEFAULT NULL,
  PRIMARY KEY (`log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

CREATE TABLE `ems_t_datatable_fields_visible_master` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `child_menu_id` bigint NOT NULL,
  `column_name` varchar(255) DEFAULT NULL,
  `field_order` bigint NOT NULL,
  `status` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

