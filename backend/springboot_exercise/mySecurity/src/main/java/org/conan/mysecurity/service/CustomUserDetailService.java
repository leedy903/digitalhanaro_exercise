package org.conan.mysecurity.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.conan.mysecurity.dto.SubscriberDTO;
import org.conan.mysecurity.entity.Subscriber;
import org.conan.mysecurity.repository.SubscriberRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {
    private final SubscriberRepository subscriberRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("----loadUserByUsername----");

        Subscriber subscriber = subscriberRepository.getWithRoles(username);
        if (subscriber == null) {
            throw new UsernameNotFoundException("Not Found");
        }
        SubscriberDTO subscriberDTO = new SubscriberDTO(
                subscriber.getEmail(),
                subscriber.getPwd(),
                subscriber.getNickname(),
                subscriber.isSocial(),
                subscriber.getSubscriberRoleList().stream().map(Enum::name)
                        .collect(Collectors.toList()));
        log.info(subscriberDTO);
        return subscriberDTO;
    }
}
