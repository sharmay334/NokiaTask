ALTER TABLE `ems_t_user_child_menu_mapping` 
ADD COLUMN `access_level` ENUM('VIEWER','EDITOR','MASTER') DEFAULT 'VIEWER' NULL AFTER `menu_id`; 