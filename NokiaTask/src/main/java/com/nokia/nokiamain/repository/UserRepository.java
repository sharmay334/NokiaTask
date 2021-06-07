package com.nokia.nokiamain.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.nokia.nokiamain.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

	
	/*@Query("from GroupMenu gm WHERE gm.groupName=:groupName")
	GroupMenu findGroupMenuByName(@Param("groupName")String groupName);

	@Query("from GroupMenu gm ORDER BY gm.previousGroupId ASC")
	List<GroupMenu> getAllGroupMenu();

	@Query("from GroupMenu gm WHERE gm.groupId=:groupId")
	GroupMenu findGroupById(@Param("groupId")Long groupId);

	@Query(value="SELECT COALESCE(MAX(group_id),0) AS latest_group_id FROM ems_t_group_menu_master",nativeQuery=true)
	Long findLastCreatedGroupMenu();

	@Modifying(clearAutomatically=true)
	@Query("UPDATE GroupMenu gm SET gm.previousGroupId=:newPreviousGroupId WHERE gm.previousGroupId=:oldPreviousGroupId")
	void updateAllRelatedGroupPreviousId(@Param("newPreviousGroupId")Long newPreviousGroupId,@Param("oldPreviousGroupId")Long oldPreviousGroupId);

	@Query("from GroupMenu gm WHERE gm.groupId IN (:menuIds) AND gm.status='Active' ORDER BY gm.previousGroupId ASC")
	List<GroupMenu> findAllGroupById(@Param("menuIds") List<Long> groupMenuIds);*/

	@Query("from User u WHERE u.id=:id")
	User findUserById(@Param("id")Long id);
}
