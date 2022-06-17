package com.tasks.coursemanagment.common.model.mapper;

import com.tasks.coursemanagment.common.model.dto.BaseDTO;
import com.tasks.coursemanagment.common.model.entity.BaseEntity;

import java.util.List;
import java.util.Set;

public interface BaseMapper<E extends BaseEntity, D extends BaseDTO> {

    E toEntity(D dto);

    D toDTO(E entity);

    List<E> toEntityList(List<D> dtos);

    Set<E> toEntitySet(Set<D> dtos);

    List<D> toDTOList(List<E> entities);

    Set<D> toDTOSet(Set<E> entities);
}
