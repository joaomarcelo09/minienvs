package jgproject.minienv.env_variables;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jgproject.minienv.env_variables.dto.CreateEnvVariableReq;

@Service
public class EnvVariablesService {

	@Autowired
	private EnvVariablesRepository envVariablesRepository;

	public void create(CreateEnvVariableReq body) {

		EnvVariables newEnv = new EnvVariables();

		newEnv.setProject_name(body.project_name());
		newEnv.setKey(body.key());
		newEnv.setValue(body.value());

		envVariablesRepository.save(newEnv);

	}

	public void update(Long id_env, CreateEnvVariableReq body) {

		EnvVariables env = envVariablesRepository.findById(id_env).orElseThrow();

		env.setProject_name(body.project_name());
		env.setKey(body.key());
		env.setKey(body.value());

		envVariablesRepository.save(env);

	}

	public EnvVariables findOne(Long id_env) {
		return envVariablesRepository.findById(id_env).orElseThrow();
	}

	public void delete(Long id_env) {
		envVariablesRepository.deleteById(id_env);
	}


	public List<EnvVariables> findAll() {
		return envVariablesRepository.findAll();
	}

}
