package jgproject.minienv.env_variables;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnvVariablesService {

	@Autowired
	private EnvVariablesRepository envVariablesRepository;

	public void create() {

		EnvVariables newEnv = new EnvVariables();

		newEnv.setProject_name("New env test");
		newEnv.setKey("Env key test");
		newEnv.setValue("Env value test");

		envVariablesRepository.save(newEnv);

	}

}
