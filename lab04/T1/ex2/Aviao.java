package lab03.ex2;

import javax.lang.model.util.ElementScanner6;

public class Aviao{
    String codigo;          //código do avião
    int lug_exec;           // lugares da classe executiva
    int lug_turis;          // lugares da classe turistica
    int filas_exec;         // filas classe executiva
    int lug_por_fila_exec;  // lugar por fila executiva
    int filas_turis;        // filas classe turistica
    int lug_por_fila_turis; // lugar por fila turistica
    int num_reserva;        // reserva
    Integer [][] mapTuris;  // mapa de lugares turisticos
    Integer [][] mapExec;   // mapa de lugares executivos

    //Constructor para avião com lugares executivos 
    public Aviao (String codigo, int lug_exec, int lug_turis, int filas_exec, int lug_por_fila_exec, int filas_turis, int lug_por_fila_turis){
        this.codigo = codigo;
        this.lug_exec = lug_exec;
        this.lug_turis = lug_turis;
        this.filas_exec = filas_exec;
        this.lug_por_fila_exec = lug_por_fila_exec;
        this.filas_turis = filas_turis;
        this.lug_por_fila_turis = lug_por_fila_turis;
    }

    //Constructor para avião sem lugares executivos 
    public Aviao (String codigo, int lug_turis, int filas_turis, int lug_por_fila_turis){
        this.codigo = codigo;
        this.lug_turis = lug_turis;
        this.filas_turis = filas_turis;
        this.lug_por_fila_turis = lug_por_fila_turis;
        this.lug_exec=0;
        this.filas_exec=0;
        this.lug_por_fila_exec=0;
    }

    public String getCodigo(){
        return codigo;
    }

    public int getExec(){
        return lug_exec;
    }

    public int getTuris(){
        return lug_turis;
    }

    public int getFilas_Exec(){
        return filas_exec;
    }

    public int getFilas_Turis(){
        return filas_turis;
    }

    public int getLugTuris(){
        return lug_por_fila_turis;
    }

    public int getLugExec(){
        return lug_por_fila_exec;
    }

    public int getNum_reserva(){
        return num_reserva;
    }

    public void setExec(int e){
        this.lug_exec = e;
    }
    public void setTuris(int t){
        this.lug_turis = t;
    }

    public Integer[][] getTurisMap(){
        return mapTuris;
    }

    public Integer[][] getExecMap(){
        return mapExec;
    }

    public void setTurisMap(Integer[][] map){
        this.mapTuris = map;
    }

    public void setExecMap(Integer[][] map){
        this.mapExec = map;
    }

    public void setNum_reserva(int r){
        this.num_reserva = r;
    }

    public void setMap(){
        this.mapTuris = new Integer[getLugTuris()][getFilas_Turis()];
        for (int i=0; i<getLugTuris(); i++){
            for(int j=0; j<getFilas_Turis(); j++){
                this.mapTuris[i][j] = 0;
            }
        }
        this.mapExec = new Integer[getLugExec()][getFilas_Exec()];
        for (int i=0; i<getLugExec(); i++){
            for(int j=0; j<getFilas_Exec(); j++){
                this.mapExec[i][j] = 0;
            }
        }
    }

}