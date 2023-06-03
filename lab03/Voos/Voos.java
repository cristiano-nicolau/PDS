// package Voos;
// import java.io.File;
// import java.io.FileNotFoundException;
// import java.util.*;

// import java.util.List;
// public class Voos {
//     String codigo;
//     private Aviao aviao;
//     private int[][] lugares;


    
//     public Voos(String codigo, Aviao aviao, int[][] lugares){
//         this.codigo=codigo;
//         this.aviao=aviao;
//         this.lugares=lugares;
//     }
//     public String getCodigo(){
//         return this.codigo;
//     }
//     public Aviao getAviao(){
//         return this.aviao;
//     }
    
//     public static List read_data() throws FileNotFoundException{
//         Scanner sc = new Scanner (System.in);
//         String inputString = sc.nextLine();
//         String[] inputStringArray = inputString.split(" ");
//         System.out.println("Nome do ficheiro:");
//         String nomeFicheiro = sc.nextLine();
//         File file = new File(nomeFicheiro);
//         Scanner sc1 = new Scanner(file);
//         String inputString1 = sc1.nextLine();
//         String[] inputStringArray2 = inputString1.split(" ");
//         String code = inputStringArray2[0];
//         String[] vals1 = inputStringArray2[1].split("x");
//         String[] vals2 = inputStringArray2[2].split("x");
//         List<String> list = new ArrayList<String>();
//         while (sc1.hasNextLine()) {
//             String inputString2 = sc1.nextLine();
//             String[] inputStringArray3 = inputString2.split("\n");
//             for (int i = 0; i < inputStringArray3.length; i++) {
//                 list.add(inputStringArray3[i]);
//             }
//         }
//         List<String> list1= new ArrayList<String>();
//         list1.add(code);
//         list1.add(vals1[0]);
//         list1.add(vals1[1]);
//         list1.add(vals2[0]);
//         list1.add(vals2[1]);
//         List<List> list2= new ArrayList<List>();
//         list2.add(list);
//         list2.add(list1);
//         return list2;
//     }

//     public static String[][] create_matrix(List list2){
//         //get vals1 and vals2
//         /*List<String> list1 = (List<String>) list2.get(0);
//         String linhasex=list1.get(2);
//         String colunasex=list1.get(1);
//         String linhastur=list1.get(4);  
//         String colunastur=list1.get(3);
//         int r =Integer.parseInt(linhasex)+Integer.parseInt(colunasex)+1;
//         //System.out.println(r);
//         String[][] matrix = new String[Integer.parseInt(linhastur)+1][r];
//         //fill matrix with 0
//         for(int i=0;i<Integer.parseInt(linhastur)+1;i++){
//             for(int j=0;j<Integer.parseInt(linhasex)+Integer.parseInt(colunastur)+1;j++){
//                 matrix[i][j]="0";
//             }
//         }
//         //mudar valor de certas posições
//         for(int i=0;i<Integer.parseInt(colunastur)+1;i++){
//             for(int j=0;j<Integer.parseInt(linhasex)+Integer.parseInt(colunastur)+1;j++){
//                 if(i>Integer.parseInt(linhasex) && j<=Integer.parseInt(colunasex)){
//                     matrix[i][j]=" ";
//                 }
//             }
//         }

//         int c=0;
//         //insert c in matrix
//         for(int j=0;j<Integer.parseInt(colunasex)+Integer.parseInt(colunastur)+1;j++){
//             //
//             String t=String.valueOf(c);
//             matrix[0][j]=t;
//             c++;
//         }
//         String [] letters={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
//         //print matrix
//         //insert letters in matrix
//         for(int i=1;i<Integer.parseInt(linhastur)+1;i++){
//             matrix[i][0]=letters[i-1];
//         }
//         for(int i=0;i<Integer.parseInt(linhastur)+1;i++){
//             for(int j=0;j<Integer.parseInt(colunasex)+Integer.parseInt(colunastur)+1;j++){
//                 System.out.printf("%3s",matrix[i][j]);
//             }
//             System.out.println();
//         }
//         return matrix;*/
//         return null;
//     }


//     public static boolean isRowAllZeros(String[][] matrix, int row) {
//         for (String element : matrix[row]) {
//             if (element != "0") {
//                 return false;
//             }
//         }
//         return true;
//     }

//     public static String[][] reservatios(String[][] matrix,List list1){
//         /*List<String> list = (List<String>) list1.get(1);
//         List<String> list3 = (List<String>) list1.get(0);
//         String linhasex=list3.get(2);
//         String colunasex=list3.get(1);
//         String linhastur=list3.get(4);
//         String colunastur=list3.get(3);
//         int a=1;
//         for(int i=0;i<list.size();i++){
//             String f=list.get(i).split(" ")[0];
//             String l=list.get(i).split(" ")[1];
//             if(f.equals("E")){
//                 //check if there is a row with all zeros
//                 for(int k=0;k<Integer.parseInt(linhasex);k++){
//                     if(isRowAllZeros(matrix,k)){
//                         while(a<=Integer.parseInt(l)){
//                             for(int j=0;j<Integer.parseInt(colunasex);j++){
//                                 matrix[k][j]=String.valueOf(a);
//                             }
//                             a++;
//                         }
//                     }
//                 }
//             }
//             else if(f.equals("T")){
//                 for(int k=0;k<Integer.parseInt(linhastur);k++){
//                     if(isRowAllZeros(matrix,k)){
//                         while(a<=Integer.parseInt(l)){
//                             for(int j=Integer.parseInt(colunasex)+1;j<Integer.parseInt(colunasex)+Integer.parseInt(colunastur);j++){
//                                 matrix[k][j]=String.valueOf(a);
//                             }
//                             a++;
//                         }
//                     }
//                 }
//             }
//         }*/
//         return matrix;
//     }
// }
                    
 