package org.study.learnspring.servlet;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestClient;

class ForwardServletTest {

    @Test
    void whenRequest_dispatchToUserServlet() {
        RestClient restClient = RestClient.create();

        String res = restClient.get()
            .uri("http://localhost:8080/dispatch")
            .retrieve()
            .toEntity(String.class)
            .getBody();

        assertThat(res).isEqualTo("username=hi");
    }
}
