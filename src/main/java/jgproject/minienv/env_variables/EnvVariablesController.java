package jgproject.minienv.env_variables;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/env_variables")
@RequiredArgsConstructor
public class EnvVariablesController {

	@Autowired
	private EnvVariablesService envVariablesService;

	@PostMapping
	public ResponseEntity<String> create() {
		envVariablesService.create();

		return ResponseEntity.ok("Create successfully");
	}
}
