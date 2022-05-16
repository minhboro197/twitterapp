package com.example.demo.repository;

import com.example.demo.beans.SearchHistory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchRepository extends CrudRepository<SearchHistory, Integer> {

}
