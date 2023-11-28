package com.erick.PrjEmpresa.Entities;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_funcionario")
public class Funcionario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long funCodigo;
	
	private String funNome;
	
	private LocalDate funNascimento;
	
	 private double funSalario;
	
	public Funcionario(Long funCodigo, String funNome, LocalDate funNascimento, double funSalario) {
		super();
		this.funCodigo = funCodigo;
		this.funNome = funNome;
		this.funNascimento = funNascimento;
		this.funSalario = funSalario;
		
	}
	
	@ManyToOne
	private Departamento departamento;

//inserir os metodos get e o set
public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	public Long getfunCodigo() {
		return funCodigo;
	}

	public void setfunCodigo(Long funCodigo) {
		this.funCodigo = funCodigo;
	}

	public String getfunNome() {
		return funNome;
	}

	public void setfunNome(String funNome) {
		this.funNome = funNome;
	}

	public LocalDate getfunNascimento() {
		return funNascimento;
	}

	public void setfunNascimento(LocalDate funNascimento) {
		this.funNascimento = funNascimento;
	}
	
	public double getfunSalario() {
		return funSalario;
	}

	public void setfunSalario(double funSalario) {
		this.funSalario = funSalario;
	}

}
