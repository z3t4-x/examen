package examen.com.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "empresa")
public class Empresa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_empresa")
	private Integer idEmpresa;

	@Column(name = "ruc", nullable = true, length = 11, unique = true)
	private String ruc;

	@Column(name = " razon_social")
	private String razonSocial;

	@Column(name = "direccion")
	private String direccion;

	@Column(name = "estado")
	private Boolean estado;

	public Empresa() {

	}

	public Empresa(String ruc, String razonSocial, String direccion, Boolean estado) {

		this.ruc = ruc;
		this.razonSocial = razonSocial;
		this.direccion = direccion;
		this.estado = estado;
	}

	/**
	 * @return the idEmpresa
	 */
	public Integer getIdEmpresa() {
		return this.idEmpresa;
	}

	/**
	 * @param idEmpresa the idEmpresa to set
	 */
	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	/**
	 * @return the ruc
	 */
	public String getRuc() {
		return this.ruc;
	}

	/**
	 * @param ruc the ruc to set
	 */
	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	/**
	 * @return the razonSocial
	 */
	public String getRazonSocial() {
		return this.razonSocial;
	}

	/**
	 * @param razonSocial the razonSocial to set
	 */
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return this.direccion;
	}

	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * @return the estado
	 */
	public Boolean getEstado() {
		return this.estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

}
