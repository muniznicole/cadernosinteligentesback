package org.acme.dto;

import java.time.LocalDateTime;
import java.util.List;

import org.acme.model.Usuario;

import io.smallrye.common.constraint.NotNull;
import jakarta.validation.constraints.NotBlank;

public record CompraRequest(

@NotBlank
LocalDateTime dateTime,
@NotBlank
Double totalcompra,
@NotNull
Long endereco,
@NotNull
Long usuario,
@NotNull
Long meioPagamento,
@NotNull
List<Long> itemCopras

) {
    
}
