package pt.com.restful.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Usuaria {
	
	private Integer idLogin;
	private Integer idUtilizadora;
	private String nomeUtilizadora;
	private Integer telUtilizadora;
	private String tipoDeUtilizador;
	private String email;
	private String password;
	
	
	public Integer getIdLogin() {
		return idLogin;
	}
	public void setIdLogin(Integer idLogin) {
		this.idLogin = idLogin;
	}
	public Integer getIdUtilizadora() {
		return idUtilizadora;
	}
	public void setIdUtilizadora(Integer idUtilizadora) {
		this.idUtilizadora = idUtilizadora;
	}
	public String getNomeUtilizadora() {
		return nomeUtilizadora;
	}
	public void setNomeUtilizadora(String nomeUtilizadora) {
		this.nomeUtilizadora = nomeUtilizadora;
	}
	public Integer getTelUtilizadora() {
		return telUtilizadora;
	}
	public void setTelUtilizadora(Integer telUtilizadora) {
		this.telUtilizadora = telUtilizadora;
	}
	public String getTipoDeUtilizador() {
		return tipoDeUtilizador;
	}
	public void setTipoDeUtilizador(String tipoDeUtilizador) {
		this.tipoDeUtilizador = tipoDeUtilizador;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	@Override
	public String toString() {
		return "Usuaria [idLogin=" + idLogin + ", idUtilizadora=" + idUtilizadora + ", nomeUtilizadora="
				+ nomeUtilizadora + ", telUtilizadora=" + telUtilizadora + ", tipoDeUtilizador=" + tipoDeUtilizador
				+ ", email=" + email + ", password=" + password + "]";
	}
	
	

}
