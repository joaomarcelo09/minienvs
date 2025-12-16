package jgproject.minienv.env_variables;

import java.time.Instant;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "env_variables")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnvVariables {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEnvVariable;
	
	private String projectName;

	private String key;

	private String value; 

	@UpdateTimestamp
	private Instant updatedAt;

}
