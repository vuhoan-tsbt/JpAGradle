package com.example.gradle.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@JsonTypeName("error")
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
@JsonPropertyOrder(value = {"code", "message", "details",})
public class ApplicationErrorResponseDto implements ApiResponse {
    private static final String KEY_CODE = "code";
    private static final String KEY_DETAIL = "details";
    private static final String KEY_ID = "id";
    private static final String KEY_MESSAGE = "message";

    @Positive
    @JsonProperty(KEY_CODE)
    private String code;

    @NotBlank
    @JsonProperty(KEY_MESSAGE)
    private String message;

    @JsonProperty(KEY_DETAIL)
    @Setter(value = AccessLevel.NONE)
    private final List<Map<String, Object>> details = new ArrayList<>();


    public ApplicationErrorResponseDto(String code, @NotBlank String message) {
        this.code = code;
        this.message = message;
    }

    public ApplicationErrorResponseDto(Integer codeInt, @NotBlank String message) {
        this.code = String.valueOf(codeInt);
        this.message = message;
    }

    public void addErrorCodeAndMessageDetail(@NotBlank String code, String message) {

        Map<String, Object> errorMap = new HashMap<String, Object>() {{
            put(KEY_ID, code);
            put(KEY_MESSAGE, message);
        }};
        details.add(errorMap);
    }

    public void addErrorKeyAndObjectDetail(@NotBlank String key, @NotNull Object value) {
        Map<String, Object> errorMap = new HashMap<>() {{
            put(key, value);
        }};
        details.add(errorMap);
    }

    public void addErrorKeyAndObjectDetail(@NotNull Map<String, Object> value) {
        details.add(value);
    }
}
