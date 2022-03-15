package casemodules4.model;

import javax.persistence.*;

@Entity
@Table(name = "groupMembers")
public class GroupMembers {

    @EmbeddedId
    private EmbeddedGroupMembers id;

    @ManyToOne
    @MapsId("idGroup")
    @JoinColumn(name = "id_group")
    private Group group;

    @ManyToOne
    @MapsId("idUser")
    @JoinColumn(name = "id_user")
    private User user;

    private String role;

    public GroupMembers() {
    }

    public GroupMembers(EmbeddedGroupMembers id, Group group, User user, String role) {
        this.id = id;
        this.group = group;
        this.user = user;
        this.role = role;
    }

    public GroupMembers(int i, User user, Group group) {
    }

    public Long getId() {
        return id;
    }

    public void setId(EmbeddedGroupMembers id) {
        this.id = id;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setStatus(int i) {
    }
}
