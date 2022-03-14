package casemodules4.controller;

import casemodules4.model.Group;
import casemodules4.model.GroupMembers;
import casemodules4.service.IGroupMembersService;
import casemodules4.service.IGroupService;
import casemodules4.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/group")
public class GroupController {
    @Autowired
    private IGroupService groupService;

    @Autowired
    private IGroupMembersService groupMembersService;

    @Autowired
    private IUserService userService;

    @GetMapping
    public ResponseEntity<Iterable<GroupMembers>> getAll() {
        Iterable<GroupMembers> groupMembers = groupMembersService.findAll();
        if (!groupMembers.iterator().hasNext()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(groupMembers, HttpStatus.OK);
    }

    @PostMapping("/create-group/{userinfo_id}")
    public ResponseEntity<Group> createGroup(@PathVariable("idUser") Long idUser, @RequestBody Group group) {
        Group groupCreate = groupService.save(group);
        GroupMembers groupMembers = new GroupMembers(0, userService.findById(idUser), group);
        groupMembersService.save(groupMembers);
        return new ResponseEntity<>(groupCreate, HttpStatus.CREATED);
    }
}
