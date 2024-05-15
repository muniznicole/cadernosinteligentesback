package org.acme.dto;

import jakarta.validation.constraints.NotBlank;

public record CorRequest(

@NotBlank
String cor

) {
    
}
