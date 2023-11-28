package com.erick.PrjEmpresa.Services;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erick.PrjEmpresa.Entities.Departamento;
import com.erick.PrjEmpresa.Repositories.DepRepository;

@Service
public class DepService {
	private final DepRepository depRepository;

	@Autowired
	public DepService(DepRepository depRepository) {
		this.depRepository = depRepository;
	}

	public Departamento getDepartamentoById(Long depCodigo) {
		return depRepository.findById(depCodigo).orElse(null);
	}

	public List<Departamento> getAllDepartamento() {
		return depRepository.findAll();
	}
	
	public Departamento saveDepartamento(Departamento departamento) {
		return depRepository.save(departamento);
	}

	public void deleteDepartamento(Long depCodigo) {
		depRepository.deleteById(depCodigo);
	}
	
		public Departamento updateDepartamento(Long depCodigo, Departamento novoDepartamento) {
			Optional<Departamento> departamentoOptional = depRepository.findById(depCodigo);
	        if (departamentoOptional.isPresent()) {
	        	Departamento departamentoExistente = departamentoOptional.get();
	        	departamentoExistente.setdepNome(novoDepartamento.getdepNome());         
	            return depRepository.save(departamentoExistente); 
	        } else {
	            return null; 
	        }
	    }
}
