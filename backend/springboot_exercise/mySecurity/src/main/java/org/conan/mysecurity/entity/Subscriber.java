package org.conan.mysecurity.entity;

import jakarta.persistence.*;
import lombok.*;
import org.conan.mysecurity.constant.SubscriberRole;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "subscriber")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = "subscriberRoleList")
public class Subscriber {
    @Id
    private String email;

    @Setter
    private String pwd;

    @Setter
    @Column(nullable = false)
    private String nickname;

    @Setter
    private boolean social;

    @ElementCollection(fetch = FetchType.LAZY)
    @Builder.Default
    private List<SubscriberRole> subscriberRoleList = new ArrayList<>();

    public void addRole(SubscriberRole subscriberRole) {
        subscriberRoleList.add(subscriberRole);
    }
    public void clearRole() {
        subscriberRoleList.clear();
    }

}
