package francisco.com.projeto.Global;

import android.app.Application;

/**
 * Created by ftoma on 06/04/2017.
 * class com variaveis globais
 */

public class Utils extends Application{

    private static Utils instance;

    public static  synchronized Utils getInstance(){
        if(instance == null) {
            instance = new Utils();
        }
        return instance;
    }


    private Integer idLogin;
    private String email = "";
    private String ip = "def";
    private String password = "";
    private String data;
    private String numeroAreceber;
    private String tipoDeUsuario = "";
    private String telemovel = "";
    private String diaInicioMenstruacao = "";
    private String duracaoCicloMenstrual = "";
    private String nome_metodo;
    private String relacoesSexuais;
    private String peso_diario;
    private String consumoAgua;

    public String getTelemovel() {
        return telemovel;
    }

    public void setTelemovel(String telemovel) {
        this.telemovel = telemovel;
    }

    public String getTipoDeUsuario() {
        return tipoDeUsuario;
    }

    public void setTipoDeUsuario(String tipoDeUsuario) {
        this.tipoDeUsuario = tipoDeUsuario;
    }

    public String getNumeroAreceber() {
        return numeroAreceber;
    }

    public void setNumeroAreceber(String numeroAreceber) {
        this.numeroAreceber = numeroAreceber;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(Integer idLogin) {
        this.idLogin = idLogin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaInicioMenstruacao() {
        return diaInicioMenstruacao;
    }

    public void setDiaInicioMenstruacao(String diaInicioMenstruacao) {
        this.diaInicioMenstruacao = diaInicioMenstruacao;
    }

    public String getDuracaoCicloMenstrual() {
        return duracaoCicloMenstrual;
    }

    public void setDuracaoCicloMenstrual(String duracaoCicloMenstrual) {
        this.duracaoCicloMenstrual = duracaoCicloMenstrual;
    }

    public String getNome_metodo() {
        return nome_metodo;
    }

    public void setNome_metodo(String nome_metodo) {
        this.nome_metodo = nome_metodo;
    }

    public String getRelacoesSexuais() {
        return relacoesSexuais;
    }

    public void setRelacoesSexuais(String relacoesSexuais) {
        this.relacoesSexuais = relacoesSexuais;
    }

    public String getPeso_diario() {
        return peso_diario;
    }

    public void setPeso_diario(String peso_diario) {
        this.peso_diario = peso_diario;
    }

    public String getConsumoAgua() {
        return consumoAgua;
    }

    public void setConsumoAgua(String consumoAgua) {
        this.consumoAgua = consumoAgua;
    }
}
