package francisco.com.projeto.Registo;

import android.util.SparseBooleanArray;

/**
 * Created by ftoma on 03/04/2017.
 */

public class UsuariaRegisto {

    private Integer idLogin;
    private Integer idUtilizadora;
    private String nomeUtilizadora;
    private String telUtilizadora;
    private String tipoDeUsuario;
    private String email;
    private String password;
    private String ids_sintomas;
    private String valores_sintomas;
    private String ids_humores;
    private String valores_humores;
    private String humores_checked;
    private String date1;
    private String date2;
    private String dataNascimento;

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

    public String getTelUtilizadora() {
        return telUtilizadora;
    }

    public void setTelUtilizadora(String telUtilizadora) {
        this.telUtilizadora = telUtilizadora;
    }


    public String getTipoDeUsuario() {
        return tipoDeUsuario;
    }

    public void setTipoDeUsuario(String tipoDeUsuario) {
        this.tipoDeUsuario = tipoDeUsuario;
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

    public String getIds_sintomas() {
        return ids_sintomas;
    }

    public void setIds_sintomas(String ids_sintomas) {
        this.ids_sintomas = ids_sintomas;
    }

    public String getValores_sintomas() {
        return valores_sintomas;
    }

    public void setValores_sintomas(String valores_sintomas) {
        this.valores_sintomas = valores_sintomas;
    }

    public String getIds_humores() {
        return ids_humores;
    }

    public void setIds_humores(String ids_humores) {
        this.ids_humores = ids_humores;
    }

    public String getValores_humores() {
        return valores_humores;
    }

    public void setValores_humores(String valores_humores) {
        this.valores_humores = valores_humores;
    }

    public String getHumores_checked() {
        return humores_checked;
    }

    public void setHumores_checked(String humores_checked) {
        this.humores_checked = humores_checked;
    }

    public String getDate1() {
        return date1;
    }

    public void setDate1(String date1) {
        this.date1 = date1;
    }

    public String getDate2() {
        return date2;
    }

    public void setDate2(String date2) {
        this.date2 = date2;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
