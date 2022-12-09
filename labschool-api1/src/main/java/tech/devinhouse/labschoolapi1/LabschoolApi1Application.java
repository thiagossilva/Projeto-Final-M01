package tech.devinhouse.labschoolapi1;

import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import tech.devinhouse.labschoolapi1.enums.EnumEstadoProfessor;
import tech.devinhouse.labschoolapi1.enums.EnumExpProfessor;
import tech.devinhouse.labschoolapi1.enums.EnumFormacaoProfessor;
import tech.devinhouse.labschoolapi1.enums.EnumSituacaoAluno;
import tech.devinhouse.labschoolapi1.models.Aluno;
import tech.devinhouse.labschoolapi1.models.Pedagogo;
import tech.devinhouse.labschoolapi1.models.Professor;
import tech.devinhouse.labschoolapi1.services.AlunoService;
import tech.devinhouse.labschoolapi1.services.PedagogoService;
import tech.devinhouse.labschoolapi1.services.ProfessorService;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class LabschoolApi1Application {

	public static void main(String[] args) {
		SpringApplication.run(LabschoolApi1Application.class, args);
	}


	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:messages");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}

	@Bean
	public LocalValidatorFactoryBean validator() {
		LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
		bean.setValidationMessageSource(messageSource());
		return bean;
	}

	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}

	@Bean
	CommandLineRunner run(AlunoService alunoService, ProfessorService professorService, PedagogoService pedagogoService) {
		return args -> {
			List<Aluno> lista = alunoService.consultar();
			if (lista.isEmpty()) {
				alunoService.criar(new Aluno(null, "Bart Simpson", "11-11111-1212", LocalDate.of(2014, 10, 29), 11839750093L, EnumSituacaoAluno.IRREGULAR, 3.5F));
				alunoService.criar(new Aluno(null, "Lisa SImpson", "11-22222-2222", LocalDate.of(2012, 10, 29), 17158947076L, EnumSituacaoAluno.ATIVO, 10f));
				alunoService.criar(new Aluno(null, "Meggie Simpson", "12-20002-2200", LocalDate.of(2019, 10, 29), 63701210020L , EnumSituacaoAluno.ATIVO, 9F));
				alunoService.criar(new Aluno(null, "Milhouse Van Houten", "11-33333-2222", LocalDate.of(2014, 10, 29), 30119137062L, EnumSituacaoAluno.ATIVO, 8F));
				alunoService.criar(new Aluno(null, "Nelson Muntz", "11-44333-4444", LocalDate.of(2014, 10, 29), 95704094015L, EnumSituacaoAluno.ATIVO, 2F));
			}
			if (professorService.consultar().isEmpty()) {
				professorService.criar(new Professor(null, "Walter White", "14-22998-1882", LocalDate.of(1982, 10, 30), 40539019011L, EnumEstadoProfessor.ATIVO, EnumExpProfessor.FULL_STACK, EnumFormacaoProfessor.MESTRADO));
				professorService.criar(new Professor(null, "Jesse Pinkman", "44-11111-1992", LocalDate.of(1997, 10, 30), 96107295097L, EnumEstadoProfessor.ATIVO, EnumExpProfessor.BACK_END, EnumFormacaoProfessor.GRADUACAO_INCOMPLETA));
				professorService.criar(new Professor(null, "Hank Schrader", "44-11111-1002", LocalDate.of(1984, 10, 30), 70685977005L , EnumEstadoProfessor.ATIVO, EnumExpProfessor.FULL_STACK, EnumFormacaoProfessor.MESTRADO));
				professorService.criar(new Professor(null, "Gustavo Fring", "44-11001-1002", LocalDate.of(1977, 10, 30), 57408927085L, EnumEstadoProfessor.INATIVO, EnumExpProfessor.FRONT_END, EnumFormacaoProfessor.GRADUACAO_COMPLETA));
				professorService.criar(new Professor(null, "Saul Goodman", "44-11998-1882", LocalDate.of(1980, 10, 30), 86940162062L, EnumEstadoProfessor.ATIVO, EnumExpProfessor.FULL_STACK, EnumFormacaoProfessor.MESTRADO));
			}

			if (pedagogoService.consultar().isEmpty()) {
				pedagogoService.criar(new Pedagogo(null, "John Snow", "11-67333-4454", LocalDate.of(2000, 10, 30), 62316840086L));
				pedagogoService.criar(new Pedagogo(null, "Sansa Stark", "22-22333-4454", LocalDate.of(2004, 10, 30), 49850253053L));
				pedagogoService.criar(new Pedagogo(null, "Tyrion Lannister", "33-77333-4454", LocalDate.of(1990, 10, 30), 39125106015L));
				pedagogoService.criar(new Pedagogo(null, "Sandor Clegane", "11-33333-2222", LocalDate.of(1995, 10, 30), 89089606009L));

			}
		};
	}
}
