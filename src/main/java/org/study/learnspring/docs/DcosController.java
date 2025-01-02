package org.study.learnspring.docs;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.study.learnspring.docs.dto.DocsRequest;
import org.study.learnspring.docs.model.Docs;

@RestController()
// [1] URL 매핑
@RequestMapping("/api/v1/docs")
// [2] API 그룹 태그 - Tag명 미지정 시, Controller 이름 사용
@Tag(name = "Docs API", description = "Docs API 입니다.")
public class DcosController {

    @GetMapping("/{id}")
    // [3] API 상세
    @Operation(summary = "Docs 조회", description = "Docs 정보를 조회합니다.")
    // [4] 응답 코드
    @ApiResponses(value = {
        @ApiResponse(description = "요청에 성공했습니다.", responseCode = "1000", content = @Content(mediaType = "application/json")),
        @ApiResponse(description= "이미 가입된 계정입니다.", responseCode = "1001", content = @Content(mediaType = "application/json"))
    })
    // [5] 파라미터
    @Parameters({
        @Parameter(name = "email", description="이메일", example="test@gmail.com")
    })
    public ResponseEntity<Docs> findDocs(@NotNull  @PathVariable long id, @RequestBody DocsRequest request) {
        Docs testBook = new Docs(id, request.getPrice(), request.getName());
        return ResponseEntity.ok(testBook);
    }

    @PostMapping(value = "/image", consumes= MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Docs> upload() {
        return ResponseEntity.ok(new Docs(1, 1000, "test"));
    }
}
