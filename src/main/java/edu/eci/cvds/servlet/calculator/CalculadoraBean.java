package edu.eci.cvds.servlet.calculator;

import java.util.ArrayList;
import java.util.Set;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;

@SessionScoped
@ManagedBean(name = "calculadoraBean")
public class CalculadoraBean {
    
    public String conjuntoD;
    public int cantidadNumeros;
    public Double moda;
    public Double media;
    public Double desviacion;
    public Double varianza;
    public ArrayList<String> valoresIngresados = new ArrayList<>();

    public CalculadoraBean(){

    }

    public void setConjuntoD(String conjuntoD) {
        this.conjuntoD = conjuntoD;
    }

    public void setCantidadNumeros(int cantidadNumeros) {
        this.cantidadNumeros = cantidadNumeros;
    }

    public void setDesviacion(Double desviacion) {
        this.desviacion = desviacion;
    }

    public void setMedia(Double media) {
        this.media = media;
    }

    public void setModa(Double moda) {
        this.moda = moda;
    }

    public void setVarianza(Double varianza) {
        this.varianza = varianza;
    }

    public void setValoresIngresados(ArrayList<String> valoresIngresados) {
        this.valoresIngresados = valoresIngresados;
    }

    public String getConjuntoD() {
        return conjuntoD;
    }

    public Double getDesviacion() {
        return desviacion;
    }

    public Double getMedia() {
        return media;
    }

    public Double getModa() {
        return moda;
    }

    public Double getVarianza() {
        return varianza;
    }

    public int getCantidadNumeros() {
        return cantidadNumeros;
    }

    public String getConjunto() {
        return conjuntoD;
    }

    public ArrayList<String> getValoresIngresados() {
        return valoresIngresados;
    }

    public double calculateMean(String conjunto) {
        double ans = 0;
        String[] conjuntoDatos = conjunto.split(";");

        for (int i = 0; i < conjuntoDatos.length; i++) {
            ans += Double.parseDouble(conjuntoDatos[i]);
        }

        ans = ans / conjuntoDatos.length;

        return ans;
    }

    public double calculateStandardDeviation(String conjunto){
        double ans = 0;
        double suma = 0;
        String[] conjuntoDatos = conjunto.split(";");
        double media = calculateMean(conjunto);

        for (String string : conjuntoDatos) {
            suma += Math.pow(Double.parseDouble(string) - media, 2);
        }
        ans = Math.sqrt(suma);

        return ans;
    }

    public double calculateVariance(String conjunto) {
        return Math.pow(calculateStandardDeviation(conjunto), 2);
    }

    public double calculateMode(String conjunto) {
        int maxRepeticiones = 0;
        double ans = 0;
        String[] conjuntoDatos = conjunto.split(";");

        for (int i = 0; i < conjuntoDatos.length; i++) {
            int nRepeticiones = 0;
            for (int j = 0; j < conjuntoDatos.length; j++) {
                if(Double.parseDouble(conjuntoDatos[i]) == Double.parseDouble(conjuntoDatos[j])){
                    nRepeticiones ++;
                }
                if(nRepeticiones > maxRepeticiones){
                    maxRepeticiones = nRepeticiones;
                }
            }
        }
        return ans;
    }

    public void calculateXXX() {
        moda = calculateMode(conjuntoD);
        media = calculateMean(conjuntoD);
        desviacion = calculateStandardDeviation(conjuntoD);
        varianza = calculateVariance(conjuntoD);
        String[] valores = conjuntoD.split(";");
        Double[] valoresD = new Double[valores.length];
        for (int i = 0; i < valoresD.length; i++) {
            valoresD[i] = Double.parseDouble(valores[i]);
        }
        valoresIngresados.add(conjuntoD);
    }

    public void restart() {
        conjuntoD = "";
        moda = 0.0;
        media = 0.0;
        desviacion = 0.0;
        varianza = 0.0;
    }

}
