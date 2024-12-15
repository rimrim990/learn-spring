package org.study.learnspring.request;

public class BasicRequest {

    private String id;
    private Long requestedAt;

    public void setId(String id) {
        this.id = id;
    }

    public void setRequestedAt(Long requestedAt) {
        this.requestedAt = requestedAt;
    }

    public String getId() {
        return id;
    }

    public Long getRequestedAt() {
        return requestedAt;
    }
}
