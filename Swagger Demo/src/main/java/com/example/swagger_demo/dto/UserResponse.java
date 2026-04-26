package com.example.swagger_demo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;

@Schema(description = "Response payload after creating a user")
public class UserResponse {

    @Schema(description = "Auto-generated user ID", example = "USR-1001")
    private String userId;

    @Schema(description = "Full name of the user", example = "Siddharth Chordiya")
    private String name;

    @Schema(description = "Email address of the user", example = "siddharth@example.com")
    private String email;

    @Schema(description = "Timestamp of user creation", example = "2024-01-01T10:00:00Z")
    private LocalDateTime createdAt;

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}