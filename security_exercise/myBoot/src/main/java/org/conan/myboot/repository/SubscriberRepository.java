package org.conan.myboot.repository;

import org.apache.ibatis.annotations.Param;
import org.conan.myboot.domain.Subscriber;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SubscriberRepository extends JpaRepository<Subscriber, String> {
    @EntityGraph(attributePaths = {"subscriberRoleList"})
    @Query("select s from Subscriber s where s.email = :email")
    Subscriber getWithRoles(@Param("email") String email);
}
