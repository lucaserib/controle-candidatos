package candidatura;
import java.sql.SQLOutput;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        String [] candidatos = {"FELIPE", "MARCIA", "LUANA","LUCAS", "ITALO"};
        for(String candidato: candidatos) {
            entrandoEmContado(candidato);
        }
    }
    static void entrandoEmContado(String candidato){
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do {
            atendeu = atender();
            continuarTentando = !atendeu;
            if(continuarTentando)
                tentativasRealizadas++;
            else
                System.out.println("CONTATO REALIZADO COM SUCESSO");

        }while(continuarTentando && tentativasRealizadas < 3);

        if (atendeu)
            System.out.println("CONSEGUIMOS CONTATO COM " + candidato + " NA " + tentativasRealizadas + " TENTATIVA");
        else
            System.out.println("NAO CONSEGUIMOS CONTATO COM " + candidato + ", NUMERO MÁXIMOS DE TENTATIVAS" + tentativasRealizadas + "REALIZADAS");
    }
    static boolean atender(){
        return new Random().nextInt(3)==1;
    }

    static void imprimirSelecionados(){
        String [] candidatos = {"FELIPE", "MARCIA", "LUANA","LUCAS", "ITALO"};

        System.out.println("Imprimindo a lista de candidatos informando o indice do elemento");

        for(int indice = 0; indice < candidatos.length; indice ++){
            System.out.println("O candidato de número " + (indice +1) + "é: " + candidatos[indice]);
        }
    }


    static void selecaoCandidatos() {
        String [] candidatos = {"FELIPE", "MARCIA", "LUANA","LUCAS", "ITALO", "CARLOS", "JULIA", "MARIA","JOAO", "ARTHUR"};

        int candidatosSelecionados = 0;
        int candidatosAtual = 0;
        double salarioBase = 2000.0;
        while (candidatosSelecionados < 5 && candidatosAtual < candidatos.length){
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato + " Solicitou este valor de salário " + salarioPretendido);
            if(salarioBase >= salarioPretendido) {
                System.out.println("O candidato " + candidato + " Foi selecionado para a vaga ");
                candidatosSelecionados++;
            }
            candidatosAtual++;
        }
    }
    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }
    static void analisarCandidato(double salarioPretendido){
        double salarioBase = 2000.0;
         if (salarioBase > salarioPretendido) {
             System.out.println("LIGAR PARA CANDIDATO");
         } else if (salarioBase == salarioPretendido) {
             System.out.println("LIGAR PARA O CANDIDATO COM CONTRA PROPOSTA");
         }else {
             System.out.println("AGUARDANDO O RESULTADO DOS DEMAIS CANDIDATOS");
         }
    }
}
