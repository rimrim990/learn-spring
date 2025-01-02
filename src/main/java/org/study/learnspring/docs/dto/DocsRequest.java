package org.study.learnspring.docs.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public class DocsRequest {

    private int price;
    private String name;

    // schema field example
    @Schema(example = "1000")
    public int getPrice() {
        return price;
    }

    // change field name, hide field
    @Schema(name="example name", accessMode = Schema.AccessMode.READ_ONLY)
    public String getName() {
        return name;
    }
}
