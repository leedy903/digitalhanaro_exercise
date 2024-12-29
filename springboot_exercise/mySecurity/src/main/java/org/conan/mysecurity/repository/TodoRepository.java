package org.conan.mysecurity.repository;

import org.conan.mysecurity.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
}
