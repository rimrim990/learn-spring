package org.study.learnspring.servlet;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestClient;

class UserServletTest {

    @Test
    void whenRequest_responseUser() {
        RestClient restClient = RestClient.create();

        String res = restClient.get()
            .uri("http://localhost:8080/user")
            .retrieve()
            .body(String.class);

        assertThat(res).isEqualTo("username=hi");
    }

    @Test
    void whenRequest_increaseHitCount() {
        RestClient restClient = RestClient.create();

       List<String> hitCount = restClient.get()
            .uri("http://localhost:8080/user")
            .retrieve()
            .toEntity(String.class)
                .getHeaders()
                    .get("hitCount");

        assertThat(hitCount.get(0)).isEqualTo("2");
    }
}
