package examen.com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import examen.com.domain.Empresa;

public interface IEmpresaDAO extends JpaRepository<Empresa, Integer> {

	@Query(value = "select  top 3 * from empresa order by id_empresa desc", nativeQuery = true)
	List<Empresa> lstTresUltimosRegistros();

}
