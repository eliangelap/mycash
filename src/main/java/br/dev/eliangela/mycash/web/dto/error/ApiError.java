package br.dev.eliangela.mycash.web.dto.error;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(content = Include.NON_EMPTY)
public class ApiError {

	private HttpStatus status;
	private LocalDateTime dataHora;
	private String mensagem;
	private List<String> subErros = new ArrayList<String>();

	public ApiError(HttpStatus status) {
		this.status = status;
		this.dataHora = LocalDateTime.now();
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public List<String> getSubErros() {
		return subErros;
	}

	public void addValidationErrors(List<FieldError> fieldErrors) {
		this.subErros = fieldErrors.stream().map((err) -> {
			return err.getDefaultMessage();
		}).collect(Collectors.toList());
	}

}
