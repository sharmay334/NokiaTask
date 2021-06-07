ALTER TABLE `ems_t_user_master` ADD COLUMN `org_name` VARCHAR(255) NOT NULL AFTER `full_name`; 
UPDATE `ems_t_user_master` SET `org_name` = 'EMS INC.' WHERE `id` = '1'; 
ALTER TABLE `ems_t_user_master` ADD COLUMN `hierarchy_string` TEXT NOT NULL AFTER `parent_user_id`;  
 UPDATE `ems_t_user_master` SET `hierarchy_string` = '#1' WHERE `id` = '1'; 