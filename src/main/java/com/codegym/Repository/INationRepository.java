package com.codegym.Repository;

import com.codegym.Model.Nation;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface INationRepository extends PagingAndSortingRepository<Nation,Long> {
}
