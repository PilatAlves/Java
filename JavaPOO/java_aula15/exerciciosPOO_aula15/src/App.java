import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Scanner;

public class App {

    public static void clearScreen() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

    }
    public static void main(String[] args) throws Exception {
        //clearScreen();
        //exercicio1();
        exercicio5();
        

    }

    public static void exercicio1(){
        System.out.println("Digite sua data de nascimento (dd/mm/aaaa): ");
        Scanner scan = new Scanner(System.in);
        String dataNacimentoDigitada = scan.nextLine();
        scan.close();

        //quebrando a STRING inserida em vetor e transformando em inteiros
        //OBS: método muito trabalhoso

        // String[] partesDataDigitada = dataNacimentoDigitada.split("/");
        // int dia = Integer.parseInt(partesDataDigitada[0]);
        // int mes = Integer.parseInt(partesDataDigitada[1]);
        // int ano = Integer.parseInt(partesDataDigitada[2]);
        // LocalDate dataNascimento = LocalDate.of(ano, mes, dia);
        // System.out.println(dataNascimento);

        //Utilizando o formatador modo muito mais prático 

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataNascimento = LocalDate.parse(dataNacimentoDigitada, dtf);

        //Calculo para decobrir quantidade de dias já vividos desde o nascimento

        long diasVividos = ChronoUnit.YEARS.between(dataNascimento, LocalDate.now());
        //long diasVividos = LocalDate.now().toEpochDay() - dataNascimento.toEpochDay();
        //long diasVividos = Duration.between(dataNascimento.atStartOfDay(), LocalDate.now().
            //atStartOfDay()).toDays();
        System.out.format("Você já viveu por %d dias.%n", diasVividos);

        //Period periodo = Period.between(dataNascimento, LocalDate.now());
        Period periodo = dataNascimento.until(LocalDate.now());
        System.out.format("Você ja viveiu por %d anos, %d meses e %d dias.%n",
            periodo.getYears(), periodo.getMonths(), periodo.getDays());
    }

    public static void exercicio2() {
        System.out.print("Digite a data de vencimento do boleto (dd/mm/aaaa): ");
        Scanner scan = new Scanner(System.in);
        String dataVencimentoDigitada = scan.nextLine();
        scan.close();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataVencimento = LocalDate.parse(dataVencimentoDigitada, dtf);

        

        if ((dataVencimento.getDayOfWeek() == DayOfWeek.SATURDAY || 
            dataVencimento.getDayOfWeek() == DayOfWeek.SUNDAY)) {
                dataVencimento = dataVencimento.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
            }

        System.out.format("O pagamento deve ser feito até %s.", dataVencimento.format(dtf));
  
    }

    public static void exercicio3(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Digite o ano desejado: ");
        int ano = scan.nextInt();
        scan.close();

        for (Month mes : Month.values()) {
            YearMonth mesAno = YearMonth.of(ano, mes);
            System.out.format("%s: %d dias%n", mes, mesAno.lengthOfMonth());
        }
    }

    public static void exercicio4(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite o ano desejado: ");
        int ano = scan.nextInt();
        System.out.println("Digite o mes desejado: ");
        int mes = scan.nextInt();
        scan.close();

        LocalDate dataInicioMes = LocalDate.of(ano, mes, 1);
        LocalDate primeiroDomingo = dataInicioMes.with(TemporalAdjusters.firstInMonth
        (DayOfWeek.SUNDAY));
        int mesReferencia = primeiroDomingo.getMonthValue();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        do {
            System.out.println(primeiroDomingo.format(dtf));
            primeiroDomingo = primeiroDomingo.plusWeeks(1);
        } while (primeiroDomingo.getMonthValue() == mesReferencia);
    }

    public static int obterQtdeSextas13doAno(int ano) {
        LocalDate dataInicio = LocalDate.of(ano, 1, 1);
        LocalDate primeiraSexta = dataInicio.with(TemporalAdjusters.
        firstInMonth(DayOfWeek.FRIDAY));
        int qtdeSextas13 = 0;
        do {
            if (primeiraSexta.getDayOfMonth() == 13){
                qtdeSextas13++;
            }
            primeiraSexta = primeiraSexta.plusWeeks(1);
        } while (primeiraSexta.getYear() == ano);
        return qtdeSextas13;
    }

    public static void exercicio5() {
        int anoVencedor = 0;
        int qtdeVencedora = 0;
        for (int i = 0; i < LocalDate.now().getYear(); i++){
            int qtde_i = obterQtdeSextas13doAno(i);
            if (qtde_i >= qtdeVencedora) {
                qtdeVencedora = qtde_i;
                anoVencedor = i;
            }
        }

        System.out.format("O ano mais recente com a maior quantidade de sextas-feiras "+
        "13 foi %d, com %d ocorrências.%n", anoVencedor, qtdeVencedora);
    }

}
