package io.gabo.schoolbridgeapi.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_school_follows", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"user_id", "school_id"})
})
public class UserSchoolFollow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private User user;

    @ManyToOne(optional = false)
    private School school;

    private LocalDateTime followedAt = LocalDateTime.now();

    public UserSchoolFollow() {}

    public UserSchoolFollow(User user, School school) {
        this.user = user;
        this.school = school;
        this.followedAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public LocalDateTime getFollowedAt() {
        return followedAt;
    }

    public void setFollowedAt(LocalDateTime followedAt) {
        this.followedAt = followedAt;
    }
}

