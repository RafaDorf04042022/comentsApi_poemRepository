package com.example.coments_api.records;

import jakarta.validation.constraints.NotBlank;

public record ComentsRecordDto(@NotBlank String comentario, @NotBlank String title) {
}
