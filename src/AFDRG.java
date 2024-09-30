import java.util.*;

public class AFDRG {

    // Tabela de transições (estado atual, símbolo lido) -> próximos estados
    Map<AbstractMap.SimpleEntry<String, Character>, List<String>> tabelaTransicoes = new HashMap<>();
    // Estados de aceitação
    Set<String> estadosDeAceitacao = new HashSet<>(Arrays.asList("q9"));

    // Construtor para definir as transições
    public AFDRG() {
        // Transições para dígitos (0-9)
        for (char digito = '0'; digito <= '9'; digito++) {
            tabelaTransicoes.put(new AbstractMap.SimpleEntry<>("q0", digito), Arrays.asList("q1"));
            tabelaTransicoes.put(new AbstractMap.SimpleEntry<>("q2", digito), Arrays.asList("q3"));
            tabelaTransicoes.put(new AbstractMap.SimpleEntry<>("q3", digito), Arrays.asList("q4"));
            tabelaTransicoes.put(new AbstractMap.SimpleEntry<>("q4", digito), Arrays.asList("q5"));
            tabelaTransicoes.put(new AbstractMap.SimpleEntry<>("q6", digito), Arrays.asList("q7"));
            tabelaTransicoes.put(new AbstractMap.SimpleEntry<>("q7", digito), Arrays.asList("q8"));
            tabelaTransicoes.put(new AbstractMap.SimpleEntry<>("q8", digito), Arrays.asList("q9"));
        }

        // Transições para os pontos literais
        tabelaTransicoes.put(new AbstractMap.SimpleEntry<>("q1", '.'), Arrays.asList("q2"));
        tabelaTransicoes.put(new AbstractMap.SimpleEntry<>("q5", '.'), Arrays.asList("q6"));
    }

    // Função recursiva que processa a fita (string de entrada)
    public void processarRecursivamente(String estadoAtual, int simboloAtual, char[] fita) {
        if (simboloAtual >= fita.length) {
            // Verifica se o estado final é de aceitação
            if (estadosDeAceitacao.contains(estadoAtual)) {
                System.out.println("RG válido!");
            } else {
                System.out.println("RG inválido.0");
            }
            return;
        }

        char simbolo = fita[simboloAtual];
        List<String> proximosEstados = tabelaTransicoes.get(new AbstractMap.SimpleEntry<>(estadoAtual, simbolo));
        if (proximosEstados != null) {
            for (String proximoEstado : proximosEstados) {
                processarRecursivamente(proximoEstado, simboloAtual + 1, fita);
            }
        } else {
            // Se não houver transição válida, o RG é inválido
            System.out.println("RG invalido.1");
        }
    }

    // Método principal para validar o RG
    public void validarRG(String rg) {
        // Convertendo a string em um array de caracteres (fita)
        char[] fita = rg.toCharArray();
        // Iniciando a validação a partir do estado inicial "q0"
        processarRecursivamente("q0", 0, fita);
    }

    public static void main(String[] args) {
        AFDRG validador = new AFDRG();
        validador.validarRG("1.234.567"); // Válido
        validador.validarRG("5.987.654"); // Válido
        validador.validarRG("9.876.543"); // Válido

        validador.validarRG("12.345.678"); // Inválido (mais dígitos)
        validador.validarRG("1.23.4567"); // Inválido (menos dígitos)
        validador.validarRG("123.456.7"); // Inválido (sem ponto adequado)
        validador.validarRG("509.567.7"); // Inválido (formato incorreto)

        validador.validarRG("0.000.000"); // Válido
        validador.validarRG("9.999.999"); // Válido
        validador.validarRG("3.456.789"); // Válido
        validador.validarRG("8.765.432"); // Válido

        validador.validarRG("12.345.67"); // Inválido (menos dígitos)
        validador.validarRG("1234567"); // Inválido (sem pontos)
        validador.validarRG("1.234,567"); // Inválido (vírgula ao invés de ponto)

    }
}
