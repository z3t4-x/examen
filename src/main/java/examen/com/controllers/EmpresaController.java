package examen.com.controllers;

import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import examen.com.domain.Empresa;
import examen.com.exception.ModeloNotFoundException;
import examen.com.services.IEmpresaService;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

	@Autowired
	private IEmpresaService service;

	@GetMapping
	public ResponseEntity<List<Empresa>> lstEmpresa() throws Exception {
		List<Empresa> lst = this.service.listarEmpresas();
		return new ResponseEntity<List<Empresa>>(lst, HttpStatus.OK);

	}

	@GetMapping("/registrosultimos")
	public ResponseEntity<List<Empresa>> lstUltimoRegistros() throws Exception {
		List<Empresa> lst = this.service.lstUltimosRegistro();
		return new ResponseEntity<List<Empresa>>(lst, HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Empresa> lstPorId(@PathVariable("id") Integer id) throws Exception {
		Empresa obj = this.service.lstPorId(id);

		if (Objects.isNull(obj)) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}

		return new ResponseEntity<Empresa>(obj, HttpStatus.OK);

	}

	@PostMapping
	public ResponseEntity<Empresa> registrar(@Valid @RequestBody Empresa empresa) throws Exception {
		Empresa obj = this.service.registrar(empresa);
		return new ResponseEntity<Empresa>(obj, HttpStatus.CREATED);

	}

	@PutMapping
	public ResponseEntity<Empresa> modificar(@Valid @RequestBody Empresa empresa) throws Exception {

		Empresa obj = this.service.modificar(empresa);

		return new ResponseEntity<Empresa>(obj, HttpStatus.OK);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception {
		Empresa obj = this.service.lstPorId(id);

		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}

		this.service.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
