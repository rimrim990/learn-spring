package org.study.learnspring.docs.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

public class Docs {

    // Jackson 설정되어야 Responses에 포함됨.
    @JsonProperty("id")
    // Responses.Schema 필드 description 정의.
    @Schema(description = "아이디")
    private long id;

    @JsonProperty("price")
    @Schema(description = "가격")
    private int price;

    @JsonProperty("name")
    @Schema(description = "이름")
    private String name;

    public Docs(long id, int price, String name) {
        this.id = id;
        this.price = price;
        this.name = name;
    }
}
