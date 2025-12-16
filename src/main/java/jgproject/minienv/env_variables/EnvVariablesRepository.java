package jgproject.minienv.env_variables;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EnvVariablesRepository extends JpaRepository<EnvVariables, Long> {

	List<EnvVariables> findAllByProjectName(String name);

}
