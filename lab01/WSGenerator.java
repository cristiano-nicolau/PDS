import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Optional;
import java.util.*;
import java.lang.Object;

public class WSGenerator{
    public static void main(String args[]) throws FileNotFoundException{
        String output1="";
        String output2="";
        String output3="";
        Scanner sc= new Scanner(System.in);  
        //Getopt g = new Getopt("testprog", argv, "ab:c::d");
        for (int t = 0 ; t < 5; t++){
            switch(args[t]){
                case "-i":
                    output1=args[t+1];
                    t++;
                    break;
                case "-s":
                    output2=args[t+1];
                    t++;
                    break;
                case "-o":
                    output3=args[t+1];
                    t++;
                    break;
                default:
                    t++;
                    break;

            }
        }
        int tamanho=Integer.parseInt(output2);
        /*
        System.out.printf("Nome do ficheiro onde estão as palavras:"); 
        String output1 = sc.nextLine();
        System.out.printf("Tamanho da sopa de letras:"); 
        String output2 = sc.nextLine();
        int tamanho=Integer.parseInt(output2);
        System.out.printf("Nome do ficheiro para escrever:");
        String output3 = sc.nextLine();*/
        File file = new File(output1);
        Scanner sc1 = new Scanner(file);
        Scanner sc2 = new Scanner(file);
        int all=0;
        int up=0;
        int r=0;
        int i=0;

        while(sc1.hasNext()){
            String line = sc1.nextLine();
            if (line.equals(line.toUpperCase())){
                up++;
            }
            all++;
        }

        String [] word = new String[all];
        ArrayList<String>  palavras = new   ArrayList<String>();
        ArrayList<String> palavras1 = new  ArrayList<String>();
        //ArrayList<String>  palavrasCap = new   ArrayList<String>();

        while(sc2.hasNext()){
            String line = sc2.nextLine();
            word[i] = line;
            if(line.contains(";") || line.contains(" ") || line.contains(",")){
                String parts[] = line.split("[; ,]+");
                for (int f=0;parts.length>f;f++){
                    if(parts[f].length()>2){
                        palavras.add(parts[f]);
                        r++;
                    }
                    else{
                        System.out.println("Palvras tem que ser maior que 3");
                        System.exit(0);
                    }
                }
            }
            i++;
        }
        
        ArrayList<String>  palavrasCap =Words.builwordlist(word, palavras, palavras1, all, up);
        char [][] sopa=Sopa.buildSopa(tamanho);
        char [][] newSopa =Sopa.putWords(sopa,palavrasCap,tamanho);
        //write to file
        PrintWriter pw = new PrintWriter(output3);
        
        //print newSopa
        for (int j = 0; j < tamanho; j++) {
            for (int j2 = 0; j2 < tamanho; j2++) {
                System.out.print(newSopa[j][j2]);
                pw.print(newSopa[j][j2]);

            }
            System.out.println();
            pw.println();
        }
        //print palavras

        for (int j = 0; j < palavras.size(); j++) {
                System.out.printf(palavras.get(j)+";");
                pw.printf(palavras.get(j)+";");
        } 
        System.out.println();
        pw.println();
        sc.close();
        sc1.close();
        sc2.close();
        pw.close();

    }

    static class Words{
        static ArrayList<String> builwordlist(String [] word,ArrayList<String>  palavras,ArrayList<String> palavras1,int all,int up){
            //see if a word is substring of another
            for (int j = 0; j < palavras.size(); j++){
                for (int j2 = 0; j2 < palavras.size(); j2++) {
                        if(palavras.get(j).contains(palavras.get(j2)) && j!=j2){
                            if(palavras.get(j).length()>palavras.get(j2).length()){
                                //remove palavras.get(j2)
                                palavras1.add(palavras.get(j2));
                            }
                        }
                }
            }
            //comapre palavras1 with palavras and remove the same words
            for (int j = 0; j < palavras.size(); j++) {
                for (int j2 = 0; j2 < palavras1.size(); j2++) {
                    if(palavras.get(j).equals(palavras1.get(j2))){
                        palavras.remove(j);
                    }
                }
            }

            int l=0;
            for(int p =0;p<word.length;p++){
                if (word[p].equals(word[p].toUpperCase())){
                    if(up == word[p].length()){
                        l++;
                    }
                }
            }
            if(l!=up){
                System.out.println("Não é quadrado");
                System.exit(0);
            }
            ArrayList<String>  palavrasCap = new   ArrayList<String>();
            for(int e = 0; e < palavras.size(); e++){
                palavrasCap.add(palavras.get(e).toUpperCase());
            }
            return palavrasCap;
            //return l;
        }
    }
    static class Sopa{
        static char[][] buildSopa(int tamanho){
            char[][] sopa = new char[tamanho][tamanho];
            for (int i = 0; i < tamanho; i++) {
                for (int j = 0; j < tamanho; j++) {
                    sopa[i][j] = (char) (Math.random() * 26 + 'A');
                }
            }
            return sopa;
        }
        static char[][] putWords(char [][] sopa,ArrayList<String> palavrasCap,int tamanho){
            Random rand =new Random();
            int low=1;
            int low1=0;
            int high=tamanho;
            int high1=8;
            for (int k=0;k<palavrasCap.size();k++){
                int x = rand.nextInt(high-low) + low;
                int y = rand.nextInt(high-low) + low;
                int u = rand.nextInt(high1-low1) + low1;
                for (int i = 0; i < palavrasCap.get(k).length(); i++) {
                    switch(u){
                        case 1:
                            while(y+palavrasCap.get(k).length()>tamanho){
                                 x = rand.nextInt(high-low) + low;
                                 y = rand.nextInt(high-low) + low;
                            }
                            sopa[x][y+i]=palavrasCap.get(k).charAt(i);
                            break;
                        case 2:
                            while(y-palavrasCap.get(k).length()<0){
                                 x = rand.nextInt(high-low) + low;
                                 y = rand.nextInt(high-low) + low;
                            }
                            sopa[x][y-i]=palavrasCap.get(k).charAt(i);
                            break;
                        case 3:
                            while(x+palavrasCap.get(k).length()>tamanho){
                                 x = rand.nextInt(high-low) + low;
                                 y = rand.nextInt(high-low) + low;
                            }
                            sopa[x+i][y]=palavrasCap.get(k).charAt(i);
                            break;
                        case 4:
                            while(x-palavrasCap.get(k).length()<0){
                                 x = rand.nextInt(high-low) + low;
                                 y = rand.nextInt(high-low) + low;
                            }
                            sopa[x-i][y]=palavrasCap.get(k).charAt(i);
                            break;
                        case 5:
                            while(x+palavrasCap.get(k).length()>tamanho || y+palavrasCap.get(k).length()>tamanho){
                                 x = rand.nextInt(high-low) + low;
                                 y = rand.nextInt(high-low) + low;
                            }
                            sopa[x+i][y+i]=palavrasCap.get(k).charAt(i);
                            break;
                        case 6:
                            while(x-palavrasCap.get(k).length()<0 || y-palavrasCap.get(k).length()<0){
                                 x = rand.nextInt(high-low) + low;
                                 y = rand.nextInt(high-low) + low;
                            }
                            sopa[x-i][y-i]=palavrasCap.get(k).charAt(i);
                            break;
                        case 7:
                            while(x+palavrasCap.get(k).length()>tamanho || y-palavrasCap.get(k).length()<0){
                                 x = rand.nextInt(high-low) + low;
                                 y = rand.nextInt(high-low) + low;
                            }
                            sopa[x+i][y-i]=palavrasCap.get(k).charAt(i);
                            break;
                        case 8:
                            while(x-palavrasCap.get(k).length()<0 || y+palavrasCap.get(k).length()>tamanho){
                                 x = rand.nextInt(high-low) + low;
                                 y = rand.nextInt(high-low) + low;
                            }
                            sopa[x-i][y+i]=palavrasCap.get(k).charAt(i);
                            break;
                    }
                }

            }
            return sopa;
        } 
    }
    
}