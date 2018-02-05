package com.application.repository;


import com.application.models.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Milos on 2/5/2018.
 */
public interface UserRepository extends CrudRepository<User, Long> {

}
