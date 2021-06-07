INSERT  INTO `ems_t_user_master`(`id`, `user_name`, `password`, `user_type`, `full_name`, `email_address`, `phone`, `address`, `gender`, `parent_user_id`, `status`, `creation_date`) VALUES 
(1, 'emsbomaster', '{SHA-256}8af120a87efdf3ff981aa78b38e1bb15bde67fafd755ecc759e46b357e3d2a50f9b4ad7dd47e6941','SUPER_ADMIN', 'EMS BOMASTER', 'emsbomaster@myems.com', '0000000000', 'Alwar', 'MALE', 0, 'ACTIVE', UTC_TIMESTAMP());

insert  into `ems_t_group_menu_master`(`group_id`,`group_name`,`is_alignment`,`previous_group_id`,`status`) values 
(1,'Menu Management','N',0,'Active'),
(2,'User Management','N',1,'Active');

insert  into `ems_t_parent_menu_master`(`menu_id`,`group_menu_id`,`is_alignment`,`menu_name`,`previous_menu_id`,`status`) values 
(1,1,'N','Nav Menus',0,'Active'),
(2,2,'N','Add Users',1,'Active');

insert  into `ems_t_child_menu_action_url_mapping`(`id`,`create_action`,`delete_action`,`edit_action`,`list_action`,`show_action`) values 
(1,'string','string','string','/ems/api/menu/groupmenu/get','string'),
(2,'string','string','string','/ems/api/menu/parentmenu/get','string'),
(3,'string','string','string','/ems/api/menu/childmenu/get','string'),
(4,'string','string','string','/ems/api/user/getUsers','string');

insert  into `ems_t_child_menu_master`(`child_menu_id`,`action_url`,`is_alignment`,`menu_name`,`parent_menu_id`,`previous_child_menu_id`,`status`,`action_id`) values 
(1,'/dashboard/menus/group','N','Group Menu',1,0,'Active',1),
(2,'/dashboard/menus/parent','N','Parent Menu',1,1,'Active',2),
(3,'/dashboard/menus/child','N','Child Menu',1,2,'Active',3),
(4,'/dashboard/users/user','N','Create User',2,0,'Active',4);

insert  into `ems_t_user_child_menu_mapping`(`id`,`status`,`user_id`,`menu_id`) values 
(1,'Active',1,1),
(2,'Active',1,2),
(3,'Active',1,3),
(4,'Active',1,4);