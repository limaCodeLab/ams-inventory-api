package com.skald.ats.inventory.api.repository;

import com.skald.ats.inventory.api.model.users.User;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Hidden
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
