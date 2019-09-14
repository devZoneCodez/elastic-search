package com.example.es.repo;

import com.example.es.model.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends ElasticsearchRepository<User,Long> {
    public List<User> findByFirstName();
    public List<User> findByLastName();
    public List<User> findByPhone();
}
