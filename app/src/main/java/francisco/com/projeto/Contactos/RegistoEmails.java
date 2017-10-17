package francisco.com.projeto.Contactos;

/**
 * Created by ftoma on 15/05/2017.
 */

public class RegistoEmails {

    private static RegistoEmails instance;

    public static  synchronized RegistoEmails getInstance(){
        if(instance == null) {
            instance = new RegistoEmails();
        }
        return instance;
    }

    private String email_Utilizadora;
    private String email_Contacto;
    private String resposta;
    private String tipoUtilizador;



    public String getEmail_Utilizadora() {
        return email_Utilizadora;
    }

    public void setEmail_Utilizadora(String email_Utilizadora) {
        this.email_Utilizadora = email_Utilizadora;
    }

    public String getEmail_Contacto() {
        return email_Contacto;
    }

    public void setEmail_Contacto(String email_Contacto) {
        this.email_Contacto = email_Contacto;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public String getTipoUtilizador() {
        return tipoUtilizador;
    }

    public void setTipoUtilizador(String tipoUtilizador) {
        this.tipoUtilizador = tipoUtilizador;
    }
}
