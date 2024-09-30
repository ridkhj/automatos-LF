import java.util.*;

public class AFDNUMB {
  Map<AbstractMap.SimpleEntry<String, Character>, List<String>> tabelaTransicoes = new HashMap<>();
  // Estados de aceitação
  Set<String> estadosDeAceitacao = new HashSet<>(Arrays.asList("q11", "q12", "q13"));

  // Construtor para definir as transições
  public AFDNUMB() {
    // +5583998608048
    tabelaTransicoes.put(new AbstractMap.SimpleEntry<>("q0", '+'), Arrays.asList("q1"));

    for (char digito = '0'; digito <= '9'; digito++) {
      tabelaTransicoes.put(new AbstractMap.SimpleEntry<>("q0", digito), Arrays.asList("q1"));
      tabelaTransicoes.put(new AbstractMap.SimpleEntry<>("q1", digito), Arrays.asList("q2"));
      tabelaTransicoes.put(new AbstractMap.SimpleEntry<>("q2", digito), Arrays.asList("q3"));
      tabelaTransicoes.put(new AbstractMap.SimpleEntry<>("q3", digito), Arrays.asList("q4"));
      tabelaTransicoes.put(new AbstractMap.SimpleEntry<>("q4", digito), Arrays.asList("q5"));
      tabelaTransicoes.put(new AbstractMap.SimpleEntry<>("q5", digito), Arrays.asList("q6"));
      tabelaTransicoes.put(new AbstractMap.SimpleEntry<>("q6", digito), Arrays.asList("q7"));
      tabelaTransicoes.put(new AbstractMap.SimpleEntry<>("q7", digito), Arrays.asList("q8"));
      tabelaTransicoes.put(new AbstractMap.SimpleEntry<>("q8", digito), Arrays.asList("q9"));
      tabelaTransicoes.put(new AbstractMap.SimpleEntry<>("q9", digito), Arrays.asList("q10"));
      tabelaTransicoes.put(new AbstractMap.SimpleEntry<>("q10", digito), Arrays.asList("q11"));
      tabelaTransicoes.put(new AbstractMap.SimpleEntry<>("q11", digito), Arrays.asList("q12"));
      tabelaTransicoes.put(new AbstractMap.SimpleEntry<>("q12", digito), Arrays.asList("q13"));
      tabelaTransicoes.put(new AbstractMap.SimpleEntry<>("q13", digito), Arrays.asList("q14"));
    }

    // (83)998608048
    tabelaTransicoes.put(new AbstractMap.SimpleEntry<>("q0", '('), Arrays.asList("q1"));
    tabelaTransicoes.put(new AbstractMap.SimpleEntry<>("q3", ')'), Arrays.asList("q3"));

    // 83998608048

    // Transições para entradas literais
    tabelaTransicoes.put(new AbstractMap.SimpleEntry<>("q0", '+'), Arrays.asList("q1"));
    // Transições para dígitos (0-9)

  }

  // Função recursiva que processa a fita (string de entrada)
  public void processarRecursivamente(String estadoAtual, int simboloAtual, char[] fita) {
    if (simboloAtual >= fita.length) {

      // Verifica se o estado final é de aceitação
      if (estadosDeAceitacao.contains(estadoAtual)) {
        System.out.println("RG válido!");
      } else {
        System.out.println("Numero inválido.0");
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
      System.out.println("Numero invalido.1");
    }
  }

  // Método principal para validar o RG
  public void validarNum(String num) {
    // Convertendo a string em um array de caracteres (fita)
    char[] fita = num.toCharArray();
    // Iniciando a validação a partir do estado inicial "q0"
    processarRecursivamente("q0", 0, fita);
  }

}
