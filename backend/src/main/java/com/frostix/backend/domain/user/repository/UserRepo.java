package com.frostix.backend.domain.user.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.frostix.backend.domain.user.VO.user;

public interface UserRepo extends MongoRepository<user, String> {
}
