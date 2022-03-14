package casemodules4.repository;

import casemodules4.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGroupRepository extends JpaRepository<Group, Long> {
    Iterable<Group> findAllByNameContaining(String name);
}
