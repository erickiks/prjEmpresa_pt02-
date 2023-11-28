package com.erick.PrjEmpresa.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_departamento")
public class Departamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long depCodigo;
	
	private String depNome;

	public Departamento (Long depCodigo, String depNome) {
		super();
		this.depCodigo = depCodigo;
		this.depNome = depNome;
		
	}

	public Long getdepCodigo() {
		return depCodigo;
	}

	public void depCodigo(Long depCodigo) {
		this.depCodigo = depCodigo;
	}

	public String getdepNome() {
		return depNome;
	}

	public void setdepNome(String depNome) {
		this.depNome = depNome;
	}
}

