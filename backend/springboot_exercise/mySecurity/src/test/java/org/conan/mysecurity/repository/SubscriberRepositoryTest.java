package org.conan.mysecurity.repository;

import lombok.extern.log4j.Log4j2;
import org.conan.mysecurity.constant.SubscriberRole;
import org.conan.mysecurity.entity.Subscriber;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Log4j2
class SubscriberRepositoryTest {
    @Autowired
    SubscriberRepository subscriberRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    void testInsertSubscriber() {
        for (int i = 0; i < 10; i++) {
            Subscriber subscriber = Subscriber.builder()
                    .email("user" + i + "@aaa.com")
                    .pwd(passwordEncoder.encode("1111"))
                    .nickname("USER" + i).build();
            subscriber.addRole(SubscriberRole.USER);
            if (i >= 5) {
                subscriber.addRole(SubscriberRole.MANAGER);
            }
            if (i >= 8) {
                subscriber.addRole(SubscriberRole.ADMIN);
            }
            subscriberRepository.save(subscriber);
        }
    }

    @Test
    void testRead() {
        String email = "user9@aaa.com";
        Subscriber member = subscriberRepository.getWithRoles(email);
        log.info("====================");
        log.info(member);
    }
}