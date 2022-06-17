package com.tasks.coursemanagment.common.service;


import com.sun.istack.NotNull;
import com.tasks.coursemanagment.common.model.dto.BaseDTO;
import com.tasks.coursemanagment.common.model.entity.BaseEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
public abstract class BaseController<E extends BaseEntity, D extends BaseDTO, S extends BaseService> {
    protected final S service;

    @GetMapping
    List<D> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    ResponseEntity<D> get(@PathVariable Long id) {
        D dtoById = (D) service.getDTOById(id);
        return ResponseEntity.ok(dtoById);
    }

    @PostMapping("/admin")
    ResponseEntity<String> create(@Validated @RequestBody D dto) {
        validateCreateBusiness(dto);
        service.create(dto);
        return ResponseEntity.accepted().body("CREATED");
    }

    @PutMapping("/admin/{id}")
    ResponseEntity<D> update(@NotNull Long id, @RequestBody D dto) {
        D update = (D) service.update(id, dto);
        return ResponseEntity.ok().body(dto);

    }

    @DeleteMapping("/{id}")
    ResponseEntity delete(@NotNull Long id){
        service.delete(id);
        return ResponseEntity.accepted().body("DELETED");
    }

    protected abstract void validateCreateBusiness(D dto);
}
