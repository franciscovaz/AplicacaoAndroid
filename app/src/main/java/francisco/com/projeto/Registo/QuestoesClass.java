package francisco.com.projeto.Registo;

/**
 * Created by ftoma on 05/04/2017.
 */

public class QuestoesClass {

    //Tabela PeriodoFertil
    private Integer idCaracteristicas_Pessoais;
    private String duracaoCicloMenstrual;
    private String duracaoUltimaMenstruacao;
    private String data_Inicio_Ultima_Menstruacao;
    private Integer FK_Usuaria;
    //Tabela login
    private Integer idLogin;
    private String email;
    //Tabela usuaria
    private Integer idUtilizadora;
    private Integer Login_idLogin;

    public String getData_Inicio_Ultima_Menstruacao() {
        return data_Inicio_Ultima_Menstruacao;
    }

    public void setData_Inicio_Ultima_Menstruacao(String data_Inicio_Ultima_Menstruacao) {
        this.data_Inicio_Ultima_Menstruacao = data_Inicio_Ultima_Menstruacao;
    }

    public Integer getIdCaracteristicas_Pessoais() {
        return idCaracteristicas_Pessoais;
    }

    public void setIdCaracteristicas_Pessoais(Integer idCaracteristicas_Pessoais) {
        this.idCaracteristicas_Pessoais = idCaracteristicas_Pessoais;
    }

    public String getDuracaoCicloMenstrual() {
        return duracaoCicloMenstrual;
    }

    public void setDuracaoCicloMenstrual(String duracaoCicloMenstrual) {
        this.duracaoCicloMenstrual = duracaoCicloMenstrual;
    }

    public String getDuracaoUltimaMenstruacao() {
        return duracaoUltimaMenstruacao;
    }

    public void setDuracaoUltimaMenstruacao(String duracaoUltimaMenstruacao) {
        this.duracaoUltimaMenstruacao = duracaoUltimaMenstruacao;
    }

    public Integer getFK_Usuaria() {
        return FK_Usuaria;
    }

    public void setFK_Usuaria(Integer FK_Usuaria) {
        this.FK_Usuaria = FK_Usuaria;
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

    public Integer getIdUtilizadora() {
        return idUtilizadora;
    }

    public void setIdUtilizadora(Integer idUtilizadora) {
        this.idUtilizadora = idUtilizadora;
    }

    public Integer getLogin_idLogin() {
        return Login_idLogin;
    }

    public void setLogin_idLogin(Integer login_idLogin) {
        Login_idLogin = login_idLogin;
    }
}
