package jgproject.minienv.env_variables;

import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jgproject.minienv.env_variables.dto.CreateEnvVariableReq;

@Service
public class EnvVariablesService {

	@Autowired
	private EnvVariablesRepository envVariablesRepository;

	public void create(CreateEnvVariableReq body) {

		EnvVariables newEnv = new EnvVariables();

		newEnv.setProjectName(body.project_name());
		newEnv.setKey(body.key());
		newEnv.setValue(body.value());

		envVariablesRepository.save(newEnv);

	}

	public void update(Long id_env, CreateEnvVariableReq body) {

		EnvVariables env = envVariablesRepository.findById(id_env).orElseThrow();

		env.setProjectName(body.project_name());
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

	public byte[] downloadEnv(String project_name) {

		List<EnvVariables> envs = envVariablesRepository.findAllByProjectName(project_name);

		StringBuilder env_string = new StringBuilder();

		for (EnvVariables env : envs) {
			env_string.append(env.getKey())
                   .append("=")
                   .append(env.getValue())
                   .append("\n");
		}

		return env_string.toString().getBytes(StandardCharsets.UTF_8);
	}

}
