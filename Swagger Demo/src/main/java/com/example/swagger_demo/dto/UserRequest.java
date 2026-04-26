package com.example.swagger_demo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "Request payload for creating a user")
public class UserRequest {

    @Schema(
            description = "Full name of the user",
            example = "John Doe",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotBlank(message = "Name is required")
    private String name;

    @Schema(
            description = "Email address of the user",
            example = "johndoe@example.com",
            format = "email",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @Schema(
            description = "Age of the user",
            example = "25",
            minimum = "18",
            maximum = "100",
            requiredMode = Schema.RequiredMode.REQUIRED
    )

    @Min(value = 18, message = "Hey Kid, you are not allowed!")
    @Max(value = 100, message = "Users above 100 years of age are not allowed!")
    private int age;

    @Schema(
            description = "Role assigned to the user",
            example = "ADMIN",
            allowableValues = {"ADMIN", "USER", "GUEST"},
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotBlank(message = "Role is required")
    private String role;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Integer getAge() {
        return age;
    }

    public String getRole() {
        return role;
    }
}