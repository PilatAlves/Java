import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

public class App {

    public static void clearScreen() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }
    public static void main(String[] args) throws Exception {
        clearScreen();
        usarFusoHorario();
        
    }

    public static void usarFusoHorario(){
        //data e horário do pôr-do-sol do natal de 2020
        LocalDateTime porDoSolDeNatal = 
            LocalDateTime.of(2020, 12, 25, 17, 36);
        //capturar as regiões de fuso-horários disponíveis
        Set<String> regioes = ZoneId.getAvailableZoneIds();
        //mostra as regiões que contém a palavra "America"
        for (String regiao : regioes) {
            if (regiao.contains("America")){
                System.out.println(regiao);
            }
        }
        //mostra a quantidade de regiões disponíveis
        System.out.format("%d regiões disponíveis.%n", regioes.size());
        //cria um objeto para armazenar data e  horário com informações de região
        ZoneId norteBR = ZoneId.of("America/Manaus");
        ZonedDateTime fusoNorteBR = ZonedDateTime.of(porDoSolDeNatal, norteBR);
        System.out.println(fusoNorteBR);
    }
}
