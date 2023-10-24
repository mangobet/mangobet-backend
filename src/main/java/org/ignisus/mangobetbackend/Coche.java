package org.ignisus.mangobetbackend;

public class Coche {
    private String marca;
    private int caballos;
    
    public Coche(String marca,int caballos){
        this.marca=marca;
        this.caballos=caballos;
    }

    public String arracncar(){
        if(caballos>300){
            return "BRRRRRRRRUMMMMMMMMMM";
        }else if(caballos>200){
            return "Brrrrrrummmmmm";
        }else if(caballos>100){
            return "brum brum";
        }else{
            return "brum";
        }
    }

    public int getCaballos() {
        return caballos;
    }
    public void setCaballos(int caballos) {
        this.caballos = caballos;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getMarca() {
        return marca;
    }


}
