
package com.erick.PrjEmpresa.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erick.PrjEmpresa.Entities.Funcionario;
import com.erick.PrjEmpresa.Services.FunService;


@RestController
@RequestMapping("/Funcionarios")
public class FunController {
	@GetMapping("/home")
    public String paginaInicial() {
        return "index";
    }
	private final FunService funService;
	
	@Autowired
	public FunController(FunService funService) {
		this.funService = funService;		
	}
	@GetMapping("/{id}")	
    public ResponseEntity<Funcionario> getFuncionario(@PathVariable Long funCodigo) {
		Funcionario departamento = funService.getFuncionarioById(funCodigo);
        if (departamento != null) {
            return ResponseEntity.ok(departamento);
        } else {
            return ResponseEntity.notFound().build();
        }
    }	
	@PostMapping
	public Funcionario createFuncionario(@RequestBody Funcionario funcionario) {
		return funService.saveFuncionario(funcionario);
	}

	@DeleteMapping("/{id}")
	public void deleteFuncionario(@PathVariable Long funCodigo) {
		funService.deleteFuncionario(funCodigo);
	}
	
	@GetMapping
	public ResponseEntity<List<Funcionario>> getAllLivros(RequestEntity<Void> requestEntity) {
		String method = requestEntity.getMethod().name();
		String contentType = requestEntity.getHeaders().getContentType().toString();
		List<Funcionario> Funcionarios = funService.getAllFuncionarios();
		return ResponseEntity.status(HttpStatus.OK).header("Method", method).header("Content-Type", contentType)
				.body(Funcionarios);
	}
	
	@PutMapping("/{id}")
	public Funcionario updateLivro(@PathVariable Long id, @RequestBody Funcionario funcionario) {
	    return funService.updateFuncionario(id, funcionario);
	}


}
