package jgproject.minienv.env_variables;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jgproject.minienv.env_variables.dto.CreateEnvVariableReq;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/env_variables")
@RequiredArgsConstructor
public class EnvVariablesController {

	@Autowired
	private EnvVariablesService envVariablesService;

	@PostMapping
	public ResponseEntity<String> create(@RequestBody CreateEnvVariableReq body) {
		envVariablesService.create(body);

		return ResponseEntity.ok("Created successfully");
	}

	@PatchMapping
	public ResponseEntity<String> update(@RequestBody CreateEnvVariableReq body, @RequestParam Long id_env) {

		envVariablesService.update(id_env, body);
		
		return ResponseEntity.ok("Updated successfully");
	}

	@GetMapping("/get_one")
	public ResponseEntity<EnvVariables> findOne(@RequestParam Long id_env) {
		EnvVariables env = envVariablesService.findOne(id_env);

		return ResponseEntity.ok(env);
	}

	@GetMapping
	public ResponseEntity<List<EnvVariables>> findAll() {

		List<EnvVariables> envs = envVariablesService.findAll();

		return ResponseEntity.ok(envs);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<String> delete(@RequestParam Long id_env) {
		envVariablesService.delete(id_env);

		return ResponseEntity.ok("Deleted successfully");
	}

	@GetMapping("/download")
	public ResponseEntity<byte[]> downloadEnv(@RequestParam String project_name) {

		byte[] env_byte = envVariablesService.downloadEnv(project_name);

		return ResponseEntity.ok()
            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=.env")
            .contentType(MediaType.TEXT_PLAIN)
            .body(env_byte);
	}
}
