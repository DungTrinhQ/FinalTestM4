package com.codegym.Repository;

import com.codegym.Model.City;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ICityRepository extends PagingAndSortingRepository<City,Long> {
}
