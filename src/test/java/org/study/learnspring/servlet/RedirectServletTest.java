package org.study.learnspring.servlet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClient;

class RedirectServletTest {

    @Test
    void whenRequest_redirectToUserServlet() {
        RestClient restClient = RestClient.create();

        ResponseEntity<String> response = restClient.get()
            .uri("http://localhost:8080/redirect")
            .retrieve()
            .toEntity(String.class);

        assertThat(response.getBody()).isEqualTo(null);
        assertThat(response.getStatusCode().is3xxRedirection()).isTrue();
    }
}
