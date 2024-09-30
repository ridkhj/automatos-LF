import java.util.*;

public class AFNeNUMB {

  // Tabela de transições
  Map<AbstractMap.SimpleEntry<String, Character>, List<String>> tabelaTransicoes = new HashMap<>();
  // Estados de aceitação
  Set<String> estadosDeAceitacao = new HashSet<>(Arrays.asList("q31", "q16", "q44"));
  // Símbolo epsilon para transições vazias
  private static final Character EPSILON = null;

  // Construtor para definir as transições
  public AFNeNUMB() {

    // +55 83 998608048
    // +55 83998608048
    tabelaTransicoes.put(new AbstractMap.SimpleEntry<>("q0", '+'), Arrays.asList("q1"));
    tabelaTransicoes.put(new AbstractMap.SimpleEntry<>("q3", EPSILON), Arrays.asList("q4"));
    tabelaTransicoes.put(new AbstractMap.SimpleEntry<>("q6", EPSILON), Arrays.asList("q7"));

    for (char digito = '0'; digito <= '9'; digito++) {
      tabelaTransicoes.put(new AbstractMap.SimpleEntry<>("q0", digito), Arrays.asList("q1"));
      tabelaTransicoes.put(new AbstractMap.SimpleEntry<>("q1", digito), Arrays.asList("q2"));
      tabelaTransicoes.put(new AbstractMap.SimpleEntry<>("q2", digito), Arrays.asList("q3"));
      tabelaTransicoes.put(new AbstractMap.SimpleEntry<>("q3", digito), Arrays.asList("q5"));
      tabelaTransicoes.put(new AbstractMap.SimpleEntry<>("q4", digito), Arrays.asList("q5"));
      tabelaTransicoes.put(new AbstractMap.SimpleEntry<>("q5", digito), Arrays.asList("q6"));
      tabelaTransicoes.put(new AbstractMap.SimpleEntry<>("q6", digito), Arrays.asList("q8"));
      tabelaTransicoes.put(new AbstractMap.SimpleEntry<>("q7", digito), Arrays.asList("q8"));
      tabelaTransicoes.put(new AbstractMap.SimpleEntry<>("q8", digito), Arrays.asList("q9"));
      tabelaTransicoes.put(new AbstractMap.SimpleEntry<>("q9", digito), Arrays.asList("q10"));
      tabelaTransicoes.put(new AbstractMap.SimpleEntry<>("q10", digito), Arrays.asList("q11"));
      tabelaTransicoes.put(new AbstractMap.SimpleEntry<>("q11", digito), Arrays.asList("q12"));
      tabelaTransicoes.put(new AbstractMap.SimpleEntry<>("q12", digito), Arrays.asList("q13"));
      tabelaTransicoes.put(new AbstractMap.SimpleEntry<>("q13", digito), Arrays.asList("q14"));
      tabelaTransicoes.put(new AbstractMap.SimpleEntry<>("q14", digito), Arrays.asList("q15"));
      tabelaTransicoes.put(new AbstractMap.SimpleEntry<>("q15", digito), Arrays.asList("q16"));

    }

    // (83) 9 98608048
    tabelaTransicoes.put(new AbstractMap.SimpleEntry<>("q0", '('), Arrays.asList("q17"));
    tabelaTransicoes.put(new AbstractMap.SimpleEntry<>("q19", ')'), Arrays.asList("q20"));
    tabelaTransicoes.put(new AbstractMap.SimpleEntry<>("q20", EPSILON), Arrays.asList("q21"));
    tabelaTransicoes.put(new AbstractMap.SimpleEntry<>("q22", EPSILON), Arrays.asList("q23"));

    for (char digito = '0'; digito <= '9'; digito++) {

      tabelaTransicoes.put(new AbstractMap.SimpleEntry<>("q17", digito), Arrays.asList("q18"));
      tabelaTransicoes.put(new AbstractMap.SimpleEntry<>("q18", digito), Arrays.asList("q19"));
      tabelaTransicoes.put(new AbstractMap.SimpleEntry<>("q20", digito), Arrays.asList("q22"));
      tabelaTransicoes.put(new AbstractMap.SimpleEntry<>("q21", digito), Arrays.asList("q22"));
      tabelaTransicoes.put(new AbstractMap.SimpleEntry<>("q22", digito), Arrays.asList("q24"));
      tabelaTransicoes.put(new AbstractMap.SimpleEntry<>("q23", digito), Arrays.asList("q24"));
      tabelaTransicoes.put(new AbstractMap.SimpleEntry<>("q24", digito), Arrays.asList("q25"));
      tabelaTransicoes.put(new AbstractMap.SimpleEntry<>("q25", digito), Arrays.asList("q26"));
      tabelaTransicoes.put(new AbstractMap.SimpleEntry<>("q26", digito), Arrays.asList("q27"));
      tabelaTransicoes.put(new AbstractMap.SimpleEntry<>("q27", digito), Arrays.asList("q28"));
      tabelaTransicoes.put(new AbstractMap.SimpleEntry<>("q28", digito), Arrays.asList("q29"));
      tabelaTransicoes.put(new AbstractMap.SimpleEntry<>("q29", digito), Arrays.asList("q30"));
      tabelaTransicoes.put(new AbstractMap.SimpleEntry<>("q30", digito), Arrays.asList("q31"));

    }

    // 83 9 98608048

    tabelaTransicoes.put(new AbstractMap.SimpleEntry<>("q33", EPSILON), Arrays.asList("q34"));
    tabelaTransicoes.put(new AbstractMap.SimpleEntry<>("q35", EPSILON), Arrays.asList("q36"));

    for (char digito = '0'; digito <= '9'; digito++) {

      tabelaTransicoes.put(new AbstractMap.SimpleEntry<>("q0", digito), Arrays.asList("q32"));
      tabelaTransicoes.put(new AbstractMap.SimpleEntry<>("q32", digito), Arrays.asList("q33"));
      tabelaTransicoes.put(new AbstractMap.SimpleEntry<>("q33", digito), Arrays.asList("q35"));
      tabelaTransicoes.put(new AbstractMap.SimpleEntry<>("q34", digito), Arrays.asList("q35"));
      tabelaTransicoes.put(new AbstractMap.SimpleEntry<>("q35", digito), Arrays.asList("q37"));
      tabelaTransicoes.put(new AbstractMap.SimpleEntry<>("q36", digito), Arrays.asList("q37"));
      tabelaTransicoes.put(new AbstractMap.SimpleEntry<>("q37", digito), Arrays.asList("q38"));
      tabelaTransicoes.put(new AbstractMap.SimpleEntry<>("q38", digito), Arrays.asList("q39"));
      tabelaTransicoes.put(new AbstractMap.SimpleEntry<>("q39", digito), Arrays.asList("q40"));
      tabelaTransicoes.put(new AbstractMap.SimpleEntry<>("q40", digito), Arrays.asList("q41"));
      tabelaTransicoes.put(new AbstractMap.SimpleEntry<>("q41", digito), Arrays.asList("q42"));
      tabelaTransicoes.put(new AbstractMap.SimpleEntry<>("q42", digito), Arrays.asList("q43"));
      tabelaTransicoes.put(new AbstractMap.SimpleEntry<>("q43", digito), Arrays.asList("q44"));

    }

  }

  // Função recursiva que processa a fita (string de entrada)
  public void processarRecursivamente(Set<String> estadosAtuais, int simboloAtual, char[] fita) {
    if (simboloAtual >= fita.length) {
      // Verifica se algum dos estados atuais é de aceitação
      for (String estadoAtual : estadosAtuais) {
        if (estadosDeAceitacao.contains(estadoAtual)) {
          System.out.println("Numero válido!");
          return;
        }
      }
      System.out.println("Numero inválido.(sem estado final encontrado)");
      return;
    }

    char simbolo = fita[simboloAtual];
    Set<String> novosEstados = new HashSet<>();

    // Processar transições com o símbolo atual
    for (String estadoAtual : estadosAtuais) {
      List<String> proximosEstados = tabelaTransicoes.get(new AbstractMap.SimpleEntry<>(estadoAtual, simbolo));
      if (proximosEstados != null) {
        novosEstados.addAll(proximosEstados);
      }

      // Processar transições epsilon (sem consumir o símbolo)
      proximosEstados = tabelaTransicoes.get(new AbstractMap.SimpleEntry<>(estadoAtual, EPSILON));
      if (proximosEstados != null) {
        novosEstados.addAll(proximosEstados);
      }
    }

    if (!novosEstados.isEmpty()) {
      // Recursão com o próximo símbolo (incrementando o índice) e os novos estados
      processarRecursivamente(novosEstados, simboloAtual + 1, fita);
    } else {
      System.out.println("Numero inválido (transição não encontrada).");
    }
  }

  // Método principal para validar o número
  public void validarNum(String num) {
    // Convertendo a string em um array de caracteres (fita)
    char[] fita = num.toCharArray();
    // Iniciando a validação a partir do estado inicial "q0"
    Set<String> estadosIniciais = new HashSet<>();
    estadosIniciais.add("q0");

    // Processar a fita a partir do estado inicial e primeiro símbolo
    processarRecursivamente(estadosIniciais, 0, fita);
  }

}
