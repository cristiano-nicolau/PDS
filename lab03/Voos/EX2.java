package Voos;
import java.util.*;
import java.io.*;
//import Voos.VSistema;


public class EX2 {
    public static void main(String[] args) throws FileNotFoundException{
        boolean b=true;
        while(b){
            Map<String, Voo> flights = new HashMap<String, Voo>();
            List<List<String>> reservations = new ArrayList<>();
            Scanner sc = null;

            if(args.length ==1){
                File file = new File(args[0]);
                sc = new Scanner(file);
            }
            else{
                sc = new Scanner(System.in);
            }

            System.out.println("Enter an option(H for help):");

            char option = sc.next().charAt(0); //1º caracter no argumento
            // restantes argumentos (sem o 1º caracter)
            String input = (sc.nextLine()).trim();
            String[] arguments = input.split(" ");
            boolean x=true; 
            while(x)
                switch(option){
                    case 'I':
                        if(arguments.length != 2){
                            System.err.println("Invalid number of arguments!");
                            break;
                        }else{
                            File file = new File(arguments[1]);
                            Scanner read = new Scanner(file);
                            // Tratamento da linha (1ª) que contem o código do voo e o número de lugares
                            String line1 = read.nextLine();
                            List<String> f_infos = List.of(line1.replace(">", "").split(" "));

                            String f_code = f_infos.get(0);
                            String nExSeats;
                            String nTurSeats;
                            Aviao plane;
                            String turistic = "T";
                            String executive = "E";

                            if(line1.charAt(0)!= '>'){
                                System.out.println("Invalid file format!");
                                break;
                            }
                            while (read.hasNextLine()){
                                reservations.add(List.of(read.nextLine().split(" ")));
                            }

                            if(f_infos.size()>2){
                                nExSeats = f_infos.get(1);
                                nTurSeats= f_infos.get(2);
                                int nSeatsExec[] = getClassSize(nExSeats);
                                int nSeatsTur[] = getClassSize(nTurSeats);
                                plane = new Aviao(nSeatsExec, nSeatsTur);
                                Reserva turReservation = new Reserva(turistic, nSeatsTur[0]*nSeatsTur[1]);
                                Reserva execReservation = new Reserva(executive, nSeatsExec[0]*nSeatsExec[1]);
                                // Reserva dos lugares
                                plane.marcarReserva(turReservation);
                                plane.marcarReserva(execReservation);
                            }
                            else{
                                nTurSeats = f_infos.get(1);
                                int nSeatsTur[] = getClassSize(nTurSeats);
                                plane = new Aviao(nSeatsTur);
                                Reserva turReservation = new Reserva(turistic, nSeatsTur[0]*nSeatsTur[1]);
                                //  Reserva dos lugares
                                plane.marcarReserva(turReservation);
                            }
                            Voo flight = new Voo(f_code, plane);
                            flights.put(f_code, flight);
                            read.close();

                            break;
                        }


                        //juntares os dois arrays numa list
                    case 'M':
                        if(flights.containsKey(arguments[0])){
                            flights.get(arguments[0]).getAviao().toString();
                        }
                        else if(arguments.length != 2){
                            System.err.println("Invalid number of arguments!");
                        }
                        else{
                        System.err.println("This flight doesn't exist!");
                      }
      
                        x=false;
                        break;
                    case 'F':
                        if(flights.containsKey(arguments[0])){
                            flights.get(arguments[0]).getAviao().toString();
                        }
                        else if(arguments.length != 2){
                            System.err.println("Invalid number of arguments!");
                        }
                        else{
                        //passa o código do voo, o nº de lugares executivos e turisticos. Cria um novo voo
                        Aviao plane;
                        Voo flight;
                        if(arguments.length > 2){
                            if (arguments[0].matches("[0-9a-zA-Z]+") && arguments[1].matches("[0-9]+x[0-9]+") && arguments[2].matches("[0-9]+x[0-9]+")) {
                              
                                plane = new Aviao(getClassSize(arguments[1]), getClassSize(arguments[2]));
                                flight = new Voo(arguments[0], plane);
                                flights.put(flight.getCodigoVoo(),flight);
                            }
                          }
                          else if(arguments.length == 2){
                            if (arguments[0].matches("[0-9a-zA-Z]+") && arguments[1].matches("[0-9]+x[0-9]+")) {
                              plane = new Aviao(getClassSize(arguments[1]));
                              flight = new Voo(arguments[0], plane);
                              flights.put(flight.getCodigoVoo(),flight);
                            }
                          } else{
                            System.out.println("Invalid arguments!");}}
                          break;
                    case 'R':
                        // pass o código do voo, a classe e o nº de lugares. Reserva os lugares (T ou E)
    
                        if(flights.containsKey(arguments[0])){
                            if(arguments[1].equals("T")){
                              Reserva turReservation = new Reserva("T", Integer.parseInt(arguments[2]));
                            }
                            else if(arguments[1].equals("E")){
                                Reserva execReservation = new Reserva("E", Integer.parseInt(arguments[2]));
                            }
                            else{
                                System.out.println("There are no available seats for this class!");
                            }
                          }
                          else{
                              System.err.println("There is no flight with this code!");
                          }
                        break;
                    case 'C':
                        // passa o nº da reserva. Cancela a reserva
                        if(flights.containsKey(arguments[0])) {
                            //cancelarReserva();
                          }
                          else{
                              System.err.println("There is no flight with this code!");
                          }
                        break;
                    case 'H':
                        System.out.println("I-Introduzir ficheiro cominformação de voos");
                        System.out.println("M-Mostrar mapa de reservas");
                        System.out.println("F-Acrescentar um novo voo");
                        System.out.println("R-Acrescenta reserva a um voo");
                        System.out.println("C-Cancelar reserva");
                        System.out.println("Q-Sair");
                        x=false;
                        break;
                    case 'Q':
                        x=false;
                        b=false;
                        break;
                        
                }
            
            //Aviao aviao = new Aviao();
            //aviao.lugares(1, 1);

            }
    }
    public static int[] getClassSize(String s){
        String[] classSize = s.split("x");
        int[] size = new int[2];
        size[0] = Integer.parseInt(classSize[0]);
        size[1] = Integer.parseInt(classSize[1]);
        return size;
    }
}