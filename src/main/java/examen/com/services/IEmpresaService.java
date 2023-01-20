package examen.com.services;

import java.util.List;

import examen.com.domain.Empresa;

public interface IEmpresaService {

	Empresa registrar(Empresa empresa) throws Exception;

	Empresa modificar(Empresa empresa) throws Exception;

	List<Empresa> listarEmpresas() throws Exception;

	Empresa lstPorId(Integer id) throws Exception;

	void eliminar(Integer id) throws Exception;

	List<Empresa> lstUltimosRegistro() throws Exception;

}
