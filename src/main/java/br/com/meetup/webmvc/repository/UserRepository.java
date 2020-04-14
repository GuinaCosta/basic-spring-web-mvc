package br.com.meetup.webmvc.repository;

import br.com.meetup.webmvc.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Repository
public class UserRepository {

    private final RestTemplate restTemplate;

    public List<User> findAllUsers() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity request = new HttpEntity<>(headers);

        ResponseEntity<User[]> userResponseEntity = restTemplate.exchange(
            UriComponentsBuilder
                .fromHttpUrl("http://www.mocky.io/v2")
                .path("/5e93df2a3000007400156c8b")
                .build()
                .toString(),
            HttpMethod.GET,
            request, User[].class);

        return Arrays.asList(Objects.requireNonNull(userResponseEntity.getBody()));
    }

    public User findUser() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity request = new HttpEntity<>(headers);

        ResponseEntity<User> userResponseEntity = restTemplate.exchange(
                UriComponentsBuilder
                        .fromHttpUrl("http://www.mocky.io/v2")
                        .path("/5e93d1c83000001f5a156c48")
                        .build()
                        .toString(),
                HttpMethod.GET,
                request, User.class);

        return userResponseEntity.getBody();
    }
}
