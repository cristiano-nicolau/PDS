package _T1;

public class Armazenamento {

        private String tipo;
        private String tamanho;
    
        public Armazenamento(String tipo, String tamanho) {
            this.tipo = tipo;
            this.tamanho = tamanho;
        }
    
        @Override
        public String toString() {
            return "Armazenamento [tipo=" + tipo + ", tamanho=" + tamanho + "]";
        }
    }
    

