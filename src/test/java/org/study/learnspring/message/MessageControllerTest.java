package org.study.learnspring.message;

import static org.assertj.core.api.Assertions.assertThat;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MessageControllerTest {

    @LocalServerPort
    int port;

    @BeforeEach
    void setUp() {
        RestAssured.port = port;
    }

    @Test
    void i18nMessage() {
        String msg = RestAssured
            .given().log().all()
            .when()
            .get("/message/default")
            .then().log().all()
            .statusCode(200)
            .extract()
            .body().jsonPath().getString("error");

        String enMsg = RestAssured
            .given().log().all()
            .when()
            .get("/message/en")
            .then().log().all()
            .statusCode(200)
            .extract()
            .body().jsonPath().getString("error");

        assertThat(msg).isEqualTo("기본 에러 메시지");
        assertThat(enMsg).isEqualTo("Default Error Message");
    }

    @Test
    void acceptLanguageHeader_parameterizedI18nMessage() {
        String msg = RestAssured
            .given().log().all()
            .when()
            .header("Accept-Language", "en")
            .get("/message/msg")
            .then().log().all()
            .statusCode(200)
            .extract()
            .body().jsonPath().getString("error");

        assertThat(msg).isEqualTo("Default Error Message ERROR_CODE: 0000");
    }

    @Test
    void notExistLocale_useDefaultMessageBundle() {
        String msg = RestAssured
            .given().log().all()
            .when()
            .header("Accept-Language", "fr")
            .get("/message/msg")
            .then().log().all()
            .statusCode(200)
            .extract()
            .body().jsonPath().getString("error");

        assertThat(msg).isEqualTo("기본 에러 메시지 ERROR_CODE: 0000");
    }
}
