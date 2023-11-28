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

import com.erick.PrjEmpresa.Entities.Departamento;
import com.erick.PrjEmpresa.Services.DepService;


@RestController
@RequestMapping("/Departamentos")
public class DepController {
	@GetMapping("/home")
    public String paginaInicial() {
        return "index";
    }
	private final DepService depService;
	
	@Autowired
	public DepController(DepService depService) {
		this.depService = depService;		
	}
	@GetMapping("/{id}")	
    public ResponseEntity<Departamento> getDepartamento(@PathVariable Long depCodigo) {
         Departamento departamento = depService.getDepartamentoById(depCodigo);
        if (departamento != null) {
            return ResponseEntity.ok(departamento);
        } else {
            return ResponseEntity.notFound().build();
        }
    }	
	@PostMapping
	public Departamento createDepartamento(@RequestBody Departamento departamento) {
		return depService.saveDepartamento(departamento);
	}

	@DeleteMapping("/{id}")
	public void deleteDepartamento(@PathVariable Long depCodigo) {
		depService.deleteDepartamento(depCodigo);
	}
	
	@GetMapping
	public ResponseEntity<List<Departamento>> getAllLivros(RequestEntity<Void> requestEntity) {
		String method = requestEntity.getMethod().name();
		String contentType = requestEntity.getHeaders().getContentType().toString();
		List<Departamento> Departamentos = depService.getAllDepartamento();
		return ResponseEntity.status(HttpStatus.OK).header("Method", method).header("Content-Type", contentType)
				.body(Departamentos);
	}
	
	@PutMapping("/{id}")
	public Departamento updateLivro(@PathVariable Long id, @RequestBody Departamento departamento) {
	    return depService.updateDepartamento(id, departamento);
	}

}
