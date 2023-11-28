package com.erick.PrjEmpresa.Services;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erick.PrjEmpresa.Entities.Funcionario;
import com.erick.PrjEmpresa.Repositories.FunReposiory;


@Service
public class FunService {
	private final FunReposiory funReposiory;

	@Autowired
	private FunReposiory funRepository;

	public List<Funcionario> getAllFuncionarios() {
		return funRepository.findAll();
	}

	public Funcionario getFuncionarioById(long funCodigo) {
		return funRepository.findById(funCodigo).orElse(null);
	}

	public Funcionario saveFuncionario(Funcionario funcionario) {
		return funRepository.save(funcionario);
	}

	public List<Funcionario> getFuncionariosByFunnomeAproximado(String funNome) {
        return funRepository.findByNomeContaining(funNome);
    }

	public boolean deleteFuncionario(Long id) {
		Optional<Funcionario> funcionarioExistente = funRepository.findById(id);
		if (funcionarioExistente.isPresent()) {
			funRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	public Funcionario updateFuncionario(Long funcodigo, Funcionario novoFuncionario) {
		Optional<Funcionario> funcionarioOptional = funRepository.findById(funcodigo);
		if (funcionarioOptional.isPresent()) {
			Funcionario funcionarioExistente = funcionarioOptional.get();
			funcionarioExistente.setfunNome(novoFuncionario.getfunNome());
			funcionarioExistente.setfunNascimento(novoFuncionario.getfunNascimento());
			funcionarioExistente.setfunSalario(novoFuncionario.getfunSalario());

			// Atualize o departamento
			if (novoFuncionario.getDepartamento() != null) {
				funcionarioExistente.setDepartamento(novoFuncionario.getDepartamento());
			}		
			return funRepository.save(funcionarioExistente);
		} else {
			return null; // Ou lançar uma exceção indicando que o funcionário não foi encontrado
		}
	}
	}
	
