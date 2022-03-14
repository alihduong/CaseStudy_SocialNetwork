package casemodules4.repository;

import casemodules4.model.GroupMembers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGroupMembersRepository extends JpaRepository<GroupMembers, Long> {
}
