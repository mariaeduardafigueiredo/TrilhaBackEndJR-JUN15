package br.Maria.task.domain.dtos;

import br.Maria.task.domain.enums.Status;

public record TarefaRequestDto(
        Long idTarefa,
        String descricao,
        Status status) {
}
