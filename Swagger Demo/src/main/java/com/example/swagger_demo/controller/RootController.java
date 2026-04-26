package com.example.swagger_demo.controller;

import com.example.swagger_demo.dto.UserRequest;
import com.example.swagger_demo.dto.UserResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "Root Controller", description = "Controller for the Swagger Demo APIs")
public class RootController {

    @Operation(
        summary = "Sample GET endpoint",
        description = "Returns a simple hello message from the root endpoint. Used to verify the API is running.",
        operationId = "getRoot"
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Successful response",
            content = @Content(
                mediaType = "text/plain",
                schema = @Schema(type = "string", example = "Hello from root")
            )
        ),
        @ApiResponse(
            responseCode = "500",
            description = "Internal server error",
            content = @Content(schema = @Schema(hidden = true))
        )
    })
    @GetMapping("/get")
    public String get() {
        System.out.println("Inside get()");
        return "Hello from get";
    }


    @Operation(
            summary = "Sample POST endpoint",
            description = "Requires a valid request body, id as a path variable, API key in headers, and source as a request param.",
            operationId = "post"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "resource created successfully",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = UserResponse.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Validation failed — invalid request body",
                    content = @Content(schema = @Schema(hidden = true))
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Unauthorized — missing or invalid API key",
                    content = @Content(schema = @Schema(hidden = true))
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error",
                    content = @Content(schema = @Schema(hidden = true))
            )
    })
    @PostMapping("/post/{id}")
    public ResponseEntity<UserResponse> createUser(

            @Parameter(
                    name = "id",
                    description = "Unique identifier of the resource",
                    required = true,
                    example = "ID-123",
                    in = ParameterIn.PATH
            )
            @PathVariable String id,

            @Parameter(
                    name = "X-API-KEY",
                    description = "API key for authentication",
                    required = true,
                    example = "abc123-secret-key",
                    in = ParameterIn.HEADER
            )
            @RequestHeader("X-API-KEY") String apiKey,

            @Parameter(
                    name = "X-Correlation-ID",
                    description = "Optional correlation ID for request tracing",
                    required = false,
                    example = "corr-xyz-789",
                    in = ParameterIn.HEADER
            )
            @RequestHeader(value = "X-Correlation-ID", required = false) String correlationId,

            @Parameter(
                    name = "source",
                    description = "Origin source of the request",
                    required = true,
                    example = "MOBILE",
                    in = ParameterIn.QUERY,
                    schema = @Schema(allowableValues = {"MOBILE", "WEB", "INTERNAL"})
            )
            @RequestParam String source,

            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Resource details to create",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = UserRequest.class)
                    )
            )
            @RequestBody @Valid UserRequest userRequest

    ) {
        System.out.println("Creating resource for id: " + id);

        UserResponse response = new UserResponse();
        response.setUserId(UUID.randomUUID().toString());
        response.setName(userRequest.getName());
        response.setEmail(userRequest.getEmail());
        response.setCreatedAt(LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


}