package com.tasks.coursemanagment.common.service;

import com.tasks.coursemanagment.common.constants.ErrorKeys;
import com.tasks.coursemanagment.common.model.dto.BaseDTO;
import com.tasks.coursemanagment.common.model.entity.BaseEntity;
import com.tasks.coursemanagment.common.model.mapper.BaseMapper;
import com.tasks.coursemanagment.common.repository.BaseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
public class BaseService<E extends BaseEntity, D extends BaseDTO, R extends BaseRepository<E>> {

    protected final BaseMapper<E, D> mapper;
    protected final R repository;


    public Optional<E> findById(Long id) {
        return repository.findById(id);
    }

    public E getEntityById(Long id) {
        Optional<E> optional = findById(id);
        if (!optional.isPresent())
            throw new RuntimeException(String.format(ErrorKeys.RECORD_NOT_FOUND));

        return optional.get();
    }
    public D getDTOById(Long id) {

        return mapper.toDTO(getEntityById(id));
    }
    public D update(Long id, D dto) {
        E entity = getEntityById(id);
        dto.setId(id);
        save(mapper.toEntity(dto));
        return dto;
    }

    public E save(E entity) {
        return repository.save(entity);
    }

    public E create(D dto) {
        dto.setId(null);
        E entity = mapper.toEntity(dto);
        entity = save(entity);
        return entity;
    }

    public void delete(Long id) {
        E entity = getEntityById(id);
        repository.delete(entity);

    }

    public void persist(D dto) {
        Optional<E> byId = findById(dto.getId());
        if (byId.isPresent())
            update(dto.getId(), dto);
        else
            create(dto);
    }

    public List<D> getAll(){
        return mapper.toDTOList(repository.findAll());
    }

    //TODO : add any basics service
}
