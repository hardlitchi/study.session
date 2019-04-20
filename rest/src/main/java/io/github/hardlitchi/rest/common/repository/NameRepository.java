package io.github.hardlitchi.rest.common.repository;

import java.util.UUID;

import org.springframework.data.repository.PagingAndSortingRepository;

import io.github.hardlitchi.rest.common.entity.Name;

public interface NameRepository extends PagingAndSortingRepository<Name, UUID> {

}
