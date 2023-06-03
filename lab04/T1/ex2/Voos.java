package lab03.ex2;

import java.util.Scanner;

import javax.swing.plaf.synth.SynthStyle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.HashMap;

class Voos{

    private static String op, s, abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static String[] local;
    private static int filas_exec, filas_turis, lug_por_fila_exec, lug_por_fila_turis, num_reserva, num_e, num_t;
    private static Aviao aviao;
    private static HashMap<String, Aviao> voos = new HashMap<String, Aviao>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            // Menu
            System.out.print("\nEscolha uma opção: (H para ajuda): ");
            op = sc.nextLine();
            String[] splt;
            if (op.length() > 1){
                splt = op.split("\\s+");
                op = splt[0];
            }
            else{
                splt = new String[1];
            }
            switch (op){
                case "H":
                    System.out.println("I - lê um ficheiro de um voo; (EX: I filename)\nM - exibe um mapa das reservas de um voo; (EX: M flight_code)\nF - acrescenta um novo voo; (EX: F flight_code execSeats turisSeats)\nR - acrescenta uma nova reserva a um voo; (Ex: R flight_code class number_seats)\nC - cancela uma reserva; (EX: C reservation_code)\nQ - termina o programa.");
                    break;
                case "Q":
                    System.out.println("Programa encerrado.");
                    System.exit(0);
                    break;
                case "I":
                    if (!(splt.length == 2)){
                        System.out.println("Número de argumentos inválido para a determinada função!");
                    }
                    else{
                        readFile(splt[1]);
                    }
                    break;
                case "M":
                    if (!(splt.length == 2)){
                        System.out.println("Número de argumentos inválido para a determinada função!");
                    }
                    else{
                        showMap(splt[1]);
                    }
                    break;
                case "F":
                    if(splt.length<3 || splt.length > 4){
                        System.out.println("Número de argumentos inválido para a determinada função!");
                    }
                    else{
                        if(splt.length==4)
                            addFlight(splt[1], splt[2], splt[3]);
                        else
                            addFlight(splt[1], "0", splt[2]);
                    }
                    break;
                case "R":
                    if(!(splt.length == 4)){
                        System.out.println("Número de argumentos inválido para a determinada função!"); 
                    }
                    else{
                        if(splt[2].equals("T")){
                            reserva(Integer.parseInt(splt[3]), 1, voos.get(splt[1]));
                            System.out.print(s);
                        }
                        else{
                            reserva(Integer.parseInt(splt[3]), 0, voos.get(splt[1]));
                            System.out.print(s);
                        }
                    }
                    break;
                case "C":
                    if(!(splt.length == 2)){
                        System.out.println("Número de argumentos inválido para a determinada função!"); 
                    }
                    else{
                        removeReserva(splt[1]);
                    }
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    // Função para fazer remoção de reservas, Opção C
    public static void removeReserva(String codigo_reserva){
        String[] split = codigo_reserva.split(":");
        int reserva =Integer.parseInt(split[1]);
        int count=0;
        aviao = voos.get(split[0]);
        Integer[][] execmap = aviao.getExecMap();
        Integer[][] turismap = aviao.getTurisMap();
        for (int i=0; i<execmap.length; i++){
            for(int j=0; j<execmap[0].length; j++){
                if(execmap[i][j]==reserva){
                    execmap[i][j]=0;
                    count++;
                }
            }
        }
        int n= aviao.getExec() + count;
        aviao.setExec(n);
        count=0;
        for (int i=0; i<turismap.length; i++){
            for(int j=0; j<turismap[0].length; j++){
                if(turismap[i][j]==reserva){
                    turismap[i][j]=0;
                    count++;
                }
            }
        }
        n = aviao.getTuris() + count;
        aviao.setTuris(n);
        System.out.println("Reserva " + codigo_reserva + " foi anulada.");
    }

    // Função para adicionar voo, Opção F
    public static void addFlight(String codigo, String seatsExec, String seatsTuris){
        String[] countSplt;
        num_e=-1;
        if(!(seatsExec.equals("0"))){
            countSplt = seatsExec.split("x");
            filas_exec = Integer.parseInt(countSplt[0]);
            lug_por_fila_exec = Integer.parseInt(countSplt[1]);
            num_e = filas_exec * lug_por_fila_exec;
        }
        countSplt = seatsTuris.split("x");
        filas_turis = Integer.parseInt(countSplt[0]);
        lug_por_fila_turis = Integer.parseInt(countSplt[1]);
        num_t = filas_turis * lug_por_fila_turis;
        if(num_e != -1){
            aviao = new Aviao(codigo, num_e, num_t, filas_exec, lug_por_fila_exec, filas_turis, lug_por_fila_turis);
            System.out.println("Voo " + codigo + " foi criado, com " + num_e + " lugares executivos e " + num_t + " lugares turísticos");
        }
        else{
            aviao = new Aviao(codigo, num_t, filas_turis, lug_por_fila_turis);
            System.out.println("Voo " + codigo + " foi criado, com " + num_t + " lugares turísticos");
        }
        aviao.setNum_reserva(1);
        aviao.setMap();
        voos.put(codigo, aviao);

    }
    
    // Função para exibir o mapa de um voo, opção M
    public static void showMap(String codigo){
        if(!(voos.containsKey(codigo))){
            System.out.println("Código de voo inválido!");
        }
        else{
            aviao = voos.get(codigo);
            int tableSize, comprimento, val = 0;
            String table = "";
            Integer[][] execmap = aviao.getExecMap();
            Integer[][] turismap = aviao.getTurisMap();
            if(aviao.getFilas_Exec()!=0){
                val =1;
            }
            if (val == 1){
                comprimento = execmap[0].length + turismap[0].length;
                tableSize = execmap.length;
                if (tableSize < turismap.length){
                    tableSize = turismap.length;
                }
            }
            else{
                comprimento = turismap[0].length;
                tableSize = turismap.length;
            }
            table += "\n   ";
            if(comprimento>8){
                for (int i=1; i<= 8; i++){
                    table += i + "  ";
                }
                for (int i=9; i<= comprimento; i++){
                    table += i + " ";
                }
            }
            else{
                for (int i=1; i<= comprimento; i++){
                    table += i + "  ";
                }
            }
            table += "\n";
            for(int j=0; j<tableSize; j++){
                table+=abc.charAt(j)+ "  ";
                if(val == 1){
                    for(int n=0; n<execmap[0].length; n++){
                        if(execmap.length < j+1){
                            table += "   ";
                        }
                        else{
                            table += execmap[j][n]+ "  ";
                        }
                    }
                }
                for(int n=0; n<turismap[0].length; n++){
                    if(turismap.length < j+1){
                        table += "  ";
                    }
                    else{
                        table+=turismap[j][n] + "  ";
                    }
                }
                table += "\n";
            }
            System.out.print(table);
        }
    }

    // Função para ler ficheiro, função I
    public static void readFile(String file){
        BufferedReader reader;
        String[] countSplt;
        String[] lineSplt;
        String codigo;
        String ClasseE;
        String ClasseT;
        num_e = -1;
        num_t = -1;
        num_reserva=1;
        filas_exec = 0; 
        lug_por_fila_exec = 0;

        try{
            reader = new BufferedReader(new FileReader(file));
			String line = reader.readLine();
            char c = line.charAt(0);
            if (!(c == '>')){
                System.out.println("Ficheiro com leitura inválida.");
                reader.close();
                return;
            }
            lineSplt = line.split("\\s+");
            codigo = lineSplt[0].substring(1, lineSplt[0].length());
            if (lineSplt.length > 2){
                ClasseE = lineSplt[1];
                ClasseT = lineSplt[2];
                countSplt = ClasseE.split("x");
                filas_exec = Integer.parseInt(countSplt[0]);
                lug_por_fila_exec = Integer.parseInt(countSplt[1]);
                num_e = filas_exec * lug_por_fila_exec;
            }
            else{
                ClasseT = lineSplt[1];
            }
            countSplt = ClasseT.split("x");
            filas_turis = Integer.parseInt(countSplt[0]);
            lug_por_fila_turis = Integer.parseInt(countSplt[1]);
            num_t = filas_turis * lug_por_fila_turis;
            if (num_e != -1){
                System.out.printf("Código de voo %s. Lugares disponíveis: %d lugares em classe Executiva; %d lugares em classe Turística.", codigo, num_e, num_t);
                aviao = new Aviao(codigo, num_e, num_t, filas_exec, lug_por_fila_exec, filas_turis, lug_por_fila_turis);
                aviao.setMap();
            }
            else{
                System.out.printf("Código de voo %s. %d lugares em classe Turística.", codigo, num_t);
                aviao = new Aviao(codigo, num_t, filas_turis, lug_por_fila_turis);
                aviao.setMap();
            }
            aviao.setNum_reserva(num_reserva);
            voos.put(codigo, aviao);
            line = reader.readLine();
            while (line != null){
                countSplt = line.split("\\s+");
                if(countSplt[0].equals("T")){
                    if(aviao.getTuris() >= Integer.parseInt(countSplt[1])){
                        //aviao.setTuris(aviao.getTuris()-Integer.parseInt(countSplt[1]));
                        reserva(Integer.parseInt(countSplt[1]), 1, aviao);
                    }
                    else{
                        System.out.printf("Não foi possível obter lugares para a reserva: %s\n", line);
                    }
                }
                if(countSplt[0].equals("E")){
                    if(aviao.getExec() >= Integer.parseInt(countSplt[1])){
                        //aviao.setExec(aviao.getExec()-Integer.parseInt(countSplt[1]));
                        reserva(Integer.parseInt(countSplt[1]), 0, aviao);
                    }
                    else{
                        System.out.printf("Não foi possível obter lugares para a reserva: %s\n", line);
                    }
                }
                line = reader.readLine();
            }
            
        }
        catch (IOException e) {
			e.printStackTrace();
		}
    }

    // Função para fazer reservas, opção R
    public static void reserva(int seats, int check, Aviao aviao){
        int reserva = aviao.getNum_reserva();
        int lugares = seats;
        local = new String[seats];
        int index=0;
        int var;
        boolean bol;
        if (check == 1){
            if(aviao.getTuris() < seats){
                System.out.printf("Não foi possível obter lugares para a reserva: T %d\n", seats);
                s="";
            }
            else{
                var = 0;
                Integer[][] map1 = aviao.getTurisMap();
                bol = false;
                for(int j=0; j<aviao.getFilas_Turis(); j++){
                    var = 0;
                    if(bol ==  false){
                        for (int i=0; i<aviao.getLugTuris(); i++){
                            if( map1[i][j] != 0){
                                var = -1;
                                break;
                            }
                        }
                    }
                    if(var==0){
                        for (int i=0; i<aviao.getLugTuris(); i++){
                            if(!(seats == 0)){
                                if(map1[i][j]==0){
                                    map1[i][j] = reserva;
                                    local[index] = String.valueOf(i)+String.valueOf(j);
                                    index++;
                                    seats--;
                                }
                            }
                        }
                        if (seats == 0){
                            reserva++;
                            aviao.setNum_reserva(reserva);
                            aviao.setTuris(aviao.getTuris()-lugares);
                            aviao.setTurisMap(map1);
                            break;
                        }
                        else{
                            bol = true;
                        }
                    }
                }
                if(seats != 0){
                    for(int j=0; j<aviao.getFilas_Turis(); j++){
                        for (int i=0; i< aviao.getLugTuris(); i++){
                            if(seats!=0){
                                if(map1[i][j]==0){
                                    map1[i][j] = reserva;
                                    local[index] = String.valueOf(i)+String.valueOf(j);
                                    index++;
                                    seats--;
                                }
                            }
                            else{
                                break;
                            }
                        }
                        if(seats==0){
                            break;
                        }
                    }
                    reserva++;
                    aviao.setNum_reserva(reserva);
                    aviao.setTuris(aviao.getTuris()-lugares);
                    aviao.setTurisMap(map1);
                }
                else if(var == -1){
                    for(int j=0; j<aviao.getFilas_Turis(); j++){
                        for(int i=0; i<aviao.getLugTuris(); i++){
                            if(seats==0){
                                reserva++;
                                aviao.setNum_reserva(reserva);
                                aviao.setTuris(aviao.getTuris()-lugares);
                                aviao.setTurisMap(map1);
                                break;
                            }
                            else if(map1[i][j]==0){
                                map1[i][j] = reserva;
                                local[index] = String.valueOf(i)+String.valueOf(j);
                                index++;
                                seats--;
                            }
                        }
                        if(seats==0){
                            break;
                        }
                    }
                }
                s = aviao.getCodigo()+":"+(aviao.getNum_reserva()-1) + " = | ";
                for(int i=0; i< index; i++){
                    if(aviao.getFilas_Exec()!=0)
                        s += (Integer.parseInt(String.valueOf(local[i].charAt(1)))+1+aviao.getFilas_Exec());
                    else
                        s += (Integer.parseInt(String.valueOf(local[i].charAt(1)))+1);
                    s += abc.charAt(Integer.parseInt(String.valueOf(local[i].charAt(0))))+" | ";
                }
            }
        }
        else{
            if(aviao.getExec() < seats){
                System.out.printf("Não foi possível obter lugares para a reserva: E %d\n", seats);
                s="";
            }
            else{
                var = 0;
                bol = false;
                Integer[][] map2 = aviao.getExecMap();
                for(int j=0; j<aviao.getFilas_Exec(); j++){
                    var =0;
                    if (bol == false){
                        for (int i=0; i<aviao.getLugExec(); i++){
                            if( map2[i][j] != 0){
                                var = -1;
                            }
                        }
                    }
                    if(var==0){
                        for (int i=0; i<aviao.getLugExec(); i++){
                            if(!(seats == 0)){
                                if(map2[i][j]==0){
                                    map2[i][j] = reserva;
                                    local[index] = String.valueOf(i)+String.valueOf(j);
                                    index++;
                                    seats--;
                                }
                            }
                        }
                        if (seats == 0){
                            reserva++;
                            aviao.setNum_reserva(reserva);
                            aviao.setExec(aviao.getExec()-lugares);
                            aviao.setExecMap(map2);
                            break;
                        }
                        else{
                            bol = true;
                        }
                    }
                }
                if(seats !=0){
                    for(int j=0; j<aviao.getFilas_Exec(); j++){
                        for (int i=0; i< aviao.getLugExec(); i++){
                            if(!(seats==0)){
                                if(map2[i][j]==0){
                                    map2[i][j] = reserva;
                                    local[index] = String.valueOf(i)+String.valueOf(j);
                                    index++;
                                    seats--;
                                }
                            }
                            else{
                                break;
                            }
                        }
                        if(seats==0){
                            break;
                        }
                    }
                    reserva++;
                    aviao.setNum_reserva(reserva);
                    aviao.setExec(aviao.getExec()-lugares);
                    aviao.setExecMap(map2);
                }
                else if(var == -1){
                    for(int j=0; j<aviao.getFilas_Exec(); j++){
                        for(int i=0; i<aviao.getLugExec(); i++){
                            if(seats==0){
                                reserva++;
                                aviao.setNum_reserva(reserva);
                                aviao.setExecMap(map2);
                                aviao.setExec(aviao.getExec()-lugares);
                                break;
                            }
                            else if(map2[i][j]==0){
                                map2[i][j] = reserva;
                                local[index] = String.valueOf(i)+String.valueOf(j);
                                index++;
                                seats--;
                            }
                        }
                        if(seats==0){
                            break;
                        }
                    }
                }
                s = aviao.getCodigo()+":"+(aviao.getNum_reserva()-1) + " = ";
                for(int i=0; i< index; i++){
                    s += (Integer.parseInt(String.valueOf(local[i].charAt(1)))+1);
                    s += abc.charAt(Integer.parseInt(String.valueOf(local[i].charAt(0))))+" | ";
                }
            }
        }
    }
}