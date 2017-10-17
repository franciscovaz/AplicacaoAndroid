package francisco.com.projeto.EstadosUsuaria;


import android.util.SparseBooleanArray;

/**
 * Created by ftoma on 25/05/2017.
 */

public class EstadosClasse {

    private static EstadosClasse instance;

    public static  synchronized EstadosClasse getInstance(){
        if(instance == null) {
            instance = new EstadosClasse();
        }
        return instance;
    }

    private Integer idSintomas;
    private Integer idHumor;
    private String nome_sintoma;
    private String nome_humor;
    private SparseBooleanArray humores_checked;

    public Integer getIdSintomas() {
        return idSintomas;
    }

    public void setIdSintomas(Integer idSintomas) {
        this.idSintomas = idSintomas;
    }

    public Integer getIdHumor() {
        return idHumor;
    }

    public void setIdHumor(Integer idHumor) {
        this.idHumor = idHumor;
    }

    public String getNome_sintoma() {
        return nome_sintoma;
    }

    public void setNome_sintoma(String nome_sintoma) {
        this.nome_sintoma = nome_sintoma;
    }

    public String getNome_humor() {
        return nome_humor;
    }

    public void setNome_humor(String nome_humor) {
        this.nome_humor = nome_humor;
    }
}
