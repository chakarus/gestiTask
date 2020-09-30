package comspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import comspring.models.Role;

public interface RolesRepository extends JpaRepository<Role, String> {

}
