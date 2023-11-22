package org.ignisus.mangobetbackend.repositorys;


import org.ignisus.mangobetbackend.classes.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {

    org.apache.catalina.User findByUsername(String username);
    org.apache.catalina.User save(org.apache.catalina.User user);
}
