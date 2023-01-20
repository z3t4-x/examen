package examen.com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import examen.com.dao.IEmpresaDAO;
import examen.com.domain.Empresa;

@Service
public class EmpresaServiceImpl implements IEmpresaService {

	@Autowired
	private IEmpresaDAO dao;

	@Override
	public Empresa registrar(Empresa empresa) throws Exception {

		return this.dao.save(empresa);
	}

	@Override
	public Empresa modificar(Empresa empresa) throws Exception {

		return this.dao.save(empresa);
	}

	@Override
	public List<Empresa> listarEmpresas() throws Exception {

		return this.dao.findAll();
	}

	@Override
	public Empresa lstPorId(Integer id) throws Exception {
		return this.dao.findById(id).orElse(null);
	}

	@Override
	public void eliminar(Integer id) throws Exception {
		this.dao.deleteById(id);

	}

	@Override
	public List<Empresa> lstUltimosRegistro() throws Exception {

		return this.dao.lstTresUltimosRegistros();
	}

}
