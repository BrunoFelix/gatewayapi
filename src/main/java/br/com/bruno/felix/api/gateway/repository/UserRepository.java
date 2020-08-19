package br.com.bruno.felix.api.gateway.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bruno.felix.api.gateway.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
