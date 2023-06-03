import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class WSSolver{
    public static void main(String args[]) throws FileNotFoundException{
        Scanner sc= new Scanner(System.in);  
        String inputString = args[0];
        File file = new File(inputString);
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
    char [][] sopa=BuildSopa.SopaBuilder(word, all, up);
    Solver.solve(all, up, sopa, palavrasCap, palavras);
    
        

        
        sc.close();
        sc2.close();
        sc1.close();
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
            }else if (l>40){
                System.out.println("Sopa de letras não pode ser maior que 40x40");
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
    static class BuildSopa{
        static char[][] SopaBuilder(String [] word,int all,int up){
            char [][] sopa = new char [all][all];
            
            for(int u = 0 ; u <= up; u++){
                if (word[u].equals(word[u].toUpperCase())){
                    for(int j = 0 ; j < up; j++){
                        sopa[u][j] = word[u].charAt(j);
                    }
                }
            }
            return sopa;
        }
    }
    static class Solver{
        static void solve(int all,int up,char [][] sopa,ArrayList<String> palavrasCap,ArrayList<String> palavras) throws FileNotFoundException{
            Scanner sc= new Scanner(System.in);
            char [][] showsopa = new char [all][all];
            System.out.printf("Nome do ficheiro para escrever:"); 
            String output = sc.nextLine();
            PrintWriter pw = new PrintWriter(output);
            for (int m = 0; m < up; m++) {  
                for (int v = 0; v < up; v++){  
                    showsopa[m][v] = '.';
                }
            } 
            String position = ""; 
            int flag=0;
            int count =0;
            for (int y = 0; y < palavrasCap.size(); y++) {
                for (int d = 0; d < up; d++) {  
                    for (int j = 0; j < up; j++){           // percorre a matriz toda elemneto a elemento ate encontrar a letra igual
                          if (palavrasCap.get(y).charAt(0) == sopa[d][j]){  // caso a primeira letra da palavra for igual ao elemento da matriz, vemos se existe a palavra em alguma direçao: direita, esquerda ...
                               //right
                               for(int a = 0; a <palavrasCap.get(y).length(); a++){
                                   if (j+palavrasCap.get(y).length() <= up){
                                       if (palavrasCap.get(y).charAt(a) == sopa [d][j+a]){
                                            //print 1st letter position
                                            //System.out.printf("%-10s %7d  %-30s  Rigth",palavras.get(y),palavras.get(y).length(),a,d+1);
                                            //System.out.println("");  
                                           flag+=1;//contador que aumenta no caso das palavras serem igual que imprime no fim na matriz final
                                       } else break;
                                   } else break;
                                   if (palavrasCap.get(y).length()==flag){
                                        int b=0;
                                        int t=0;
                                        for(int u = j ; u < j+palavrasCap.get(y).length(); u++){
                                           showsopa[d][u] = palavrasCap.get(y).charAt(b);
                                           b++;
                                           t=u;
                                        }
                                        //System.out.println(t);
                                        position="Right";
                                        count++;
                                        System.out.printf("%-15s %-15s %-1s %-1s %-1s %-1s %-15s %-15s\n",palavras.get(y),palavras.get(y).length(),"(",d+1,",",t+2-palavras.get(y).length(),")",position);
                                        pw.printf("%-15s %-15s %-1s %-1s %-1s %-1s %-15s %-15s\n",palavras.get(y),palavras.get(y).length(),"(",d+1,",",t+2-palavras.get(y).length(),")",position);                                   
                                    } 
                               }
                               flag=0;
                               //left
                                for(int a = 0; a <palavrasCap.get(y).length(); a++){
                                   if (j-palavrasCap.get(y).length() +1 >= 0){    //comfirmar se o array ta dentro do index caso nao da break 
                                        if (palavrasCap.get(y).charAt(a) == sopa [d][j-a]){
                                           flag+=1;//contador que aumenta no caso das palavras serem igual que imprime no fim na matriz final
                                        } else break;
                                  } else break;
                                  if (palavrasCap.get(y).length()==flag){
                                        int b=0;
                                        int t=0;
                                        for(int u = j ; u > j-palavrasCap.get(y).length(); u--){
                                            showsopa[d][u] = palavrasCap.get(y).charAt(b);
                                            b++;
                                            t=u;
                                        }
                                        position="Left";
                                        count++;
                                        System.out.printf("%-15s %-15s %-1s %-1s %-1s %-1s %-15s %-15s\n",palavras.get(y),palavras.get(y).length(),"(",d+1,",",t+palavras.get(y).length(),")",position);
                                        pw.printf("%-15s %-15s %-1s %-1s %-1s %-1s %-15s %-15s\n",palavras.get(y),palavras.get(y).length(),"(",d+1,",",t+palavras.get(y).length(),")",position);
                                    }
                                }
                              flag=0;                           
                                // down
                                for(int a = 0; a <palavrasCap.get(y).length(); a++){
                                   //comfirmar se o array ta dentro do index caso nao da break 
                                        if (palavrasCap.get(y).charAt(a) == sopa [d+a][j]){
                                            flag+=1;//contador que aumenta no caso das palavras serem igual que imprime no fim na matriz final
                                        } else break;
                                        if (palavrasCap.get(y).length()==flag){
                                            int b=0;
                                            int t=0;
                                            int e=0;
                                            for(int u = d ; u < d+palavrasCap.get(y).length(); u++){
                                                showsopa[u][j] = palavrasCap.get(y).charAt(b);
                                                b++;
                                                t=j;
                                                e=u;
                                            }
                                            position="Down";
                                            count++;
                                            System.out.printf("%-15s %-15s %-1s %-1s %-1s %-1s %-15s %-15s\n",palavras.get(y),palavras.get(y).length(),"(",e+2-palavras.get(y).length(),",",t+1,")",position);
                                            pw.printf("%-15s %-15s %-1s %-1s %-1s %-1s %-15s %-15s\n",palavras.get(y),palavras.get(y).length(),"(",e+2-palavras.get(y).length(),",",t+1,")",position);
                                        }
                                }
                                flag=0;
                                // up
                                for(int a = 0; a <palavrasCap.get(y).length(); a++){
                                    if (d-palavrasCap.get(y).length() + 1 >= 0){    //comfirmar se o array ta dentro do index caso nao da break 
                                        if (palavrasCap.get(y).charAt(a) == sopa [d-a][j]){
                                            flag+=1;//contador que aumenta no caso das palavras serem igual que imprime no fim na matriz final
                                        } else break;
                                    } else break;
                                    if (palavrasCap.get(y).length()==flag){
                                        int b=0;
                                        int t=0;
                                        int e=0;
                                        for(int u = d ; u > d-palavrasCap.get(y).length(); u--){
                                            showsopa[u][j] = palavrasCap.get(y).charAt(b);
                                            b++;
                                            t=j;
                                            e=u;
                                        }
                                        position="Up";
                                        count++;
                                        System.out.printf("%-15s %-15s %-1s %-1s %-1s %-1s %-15s %-15s\n",palavras.get(y),palavras.get(y).length(),"(",e+palavras.get(y).length(),",",t+1,")",position);
                                        pw.printf("%-15s %-15s %-1s %-1s %-1s %-1s %-15s %-15s\n",palavras.get(y),palavras.get(y).length(),"(",e+palavras.get(y).length(),",",t+1,")",position);                    
                                    }
                                }
                                flag=0;
                                //downright
                                for(int a = 0; a <palavrasCap.get(y).length(); a++){
                                    //comfirmar se o array ta dentro do index caso nao da break 
                                    if (palavrasCap.get(y).charAt(a) == sopa [d+a][j+a]){
                                        flag+=1;//contador que aumenta no caso das palavras serem igual que imprime no fim na matriz final
                                    } else break;
                                    if (palavrasCap.get(y).length()==flag){
                                        int b=0;
                                        int c=j;
                                        int t=0;
                                        int o=0;
                                        for(int u = d ; u < d+palavrasCap.get(y).length(); u++){
                                            showsopa[u][c] = palavrasCap.get(y).charAt(b);
                                            c++;
                                            b++;
                                        }
                                        position="Down,Rigth";
                                        count++;
                                        System.out.printf("%-15s %-15s %-1s %-1s %-1s %-1s %-15s %-15s\n",palavras.get(y),palavras.get(y).length(),"(",t+palavrasCap.get(y).length(),",",o+palavrasCap.get(y).length(),")",position);
                                        pw.printf("%-15s %-15s %-1s %-1s %-1s %-1s %-15s %-15s\n",palavras.get(y),palavras.get(y).length(),"(",t+palavrasCap.get(y).length(),",",o+palavrasCap.get(y).length(),")",position);                            }
                                }
                                flag=0;
                                //downleft
                                for(int a = 0; a <palavrasCap.get(y).length(); a++){
                                    if (j-palavrasCap.get(y).length() +1 >= 0){ //comfirmar se o array ta dentro do index caso nao da break 
                                        if (palavrasCap.get(y).charAt(a) == sopa [d+a][j-a]){
                                            flag+=1;//contador que aumenta no caso das palavras serem igual que imprime no fim na matriz final
                                        } else break;
                                    } else break;
                                    if (palavrasCap.get(y).length()==flag){
                                        int b=0;
                                        int c=j;
                                        int t=0;
                                        int o=0;
                                        for(int u = d ; u < d+palavrasCap.get(y).length(); u++){                                      
                                            showsopa[u][c] = palavrasCap.get(y).charAt(b);
                                            t=u;
                                            o=c;
                                            c--;
                                            b++;
                                        }
                                        position="Down,Left";
                                        count++;
                                        System.out.printf("%-15s %-15s %-1s %-1s %-1s %-1s %-15s %-15s\n",palavras.get(y),palavras.get(y).length(),"(",t-palavrasCap.get(y).length(),",",o+palavrasCap.get(y).length(),")",position);
                                        pw.printf("%-15s %-15s %-1s %-1s %-1s %-1s %-15s %-15s\n",palavras.get(y),palavras.get(y).length(),"(",t-palavrasCap.get(y).length(),",",o+palavrasCap.get(y).length(),")",position);
                                    }
                                }
                                flag=0;
                                //upright
                                
                                for(int a = 0; a <palavrasCap.get(y).length(); a++){
                                    if (d-palavrasCap.get(y).length() + 1 >= 0){    //comfirmar se o array ta dentro do index caso nao da break 
                                        if (palavrasCap.get(y).charAt(a) == sopa [d-a][j+a]){
                                            flag+=1;//contador que aumenta no caso das palavras serem igual que imprime no fim na matriz final
                                        } else break;
                                    } else break;
                                    if (palavrasCap.get(y).length()==flag){
                                        int b=0;
                                        int c=j;
                                        int t=0;
                                        int o=0;
                                        for(int u = d ; u > d-palavrasCap.get(y).length(); u--){
                                            showsopa[u][c] = palavrasCap.get(y).charAt(b);
                                            t=u;
                                            o=c;
                                            c++;
                                            b++;
                                        }
                                        position="Up,Rigth";
                                        count++;
                                        System.out.printf("%-15s %-15s %-1s %-1s %-1s %-1s %-15s %-15s\n",palavras.get(y),palavras.get(y).length(),"(",t-palavrasCap.get(y).length(),",",o+palavrasCap.get(y).length(),")",position);
                                        pw.printf("%-15s %-15s %-1s %-1s %-1s %-1s %-15s %-15s\n",palavras.get(y),palavras.get(y).length(),"(",t-palavrasCap.get(y).length(),",",o+palavrasCap.get(y).length(),")",position);      
                                    }
                                } 
                                flag=0;
                                //upleft
                                for(int a = 0; a <palavrasCap.get(y).length(); a++){
                                    if (d-palavrasCap.get(y).length() + 1 >= 0 && j-palavrasCap.get(y).length() +1 >= 0){    //comfirmar se o array ta dentro do index caso nao da break 
                                        if (palavrasCap.get(y).charAt(a) == sopa [d-a][j-a]){
                                            flag+=1;//contador que aumenta no caso das palavras serem igual que imprime no fim na matriz final
                                        } else break;
                                    } else break;
                                    if (palavrasCap.get(y).length()==flag){
                                        int b=0;
                                        int c=j;
                                        int t=0;
                                        int o=0;
                                        for(int u = d ; u > d-palavrasCap.get(y).length(); u--){
                                            showsopa[u][c] = palavrasCap.get(y).charAt(b);
                                            t=u;
                                            o=c;
                                            c--;
                                            b++;
                                        }
                                        position="Up,Left";
                                        count++;
                                        System.out.printf("%-15s %-15s %-1s %-1s %-1s %-1s %-15s %-15s\n",palavras.get(y),palavras.get(y).length(),"(",t+palavrasCap.get(y).length(),",",o+palavrasCap.get(y).length(),")",position);
                                        pw.printf("%-15s %-15s %-1s %-1s %-1s %-1s %-15s %-15s\n",palavras.get(y),palavras.get(y).length(),"(",t+palavrasCap.get(y).length(),",",o+palavrasCap.get(y).length(),")",position);                           
                                    }
                                } 
                                
                        }   
                    }
                } 
            }
            for (int q = 0; q < up; q++) { 
                for (int w = 0; w < up; w++){
                    System.out.printf("%2s",showsopa[q][w]);
                    pw.printf("%2s",showsopa[q][w]);
                }
                System.out.printf("\n");
                pw.printf("\n");
            }
            if (count!=palavrasCap.size()){
                System.out.printf("Nao encontrou todas as palavras\n");
                pw.printf("Nao encontrou todas as palavras\n");
            }
            sc.close();
            pw.close();   
        }
    }
}

