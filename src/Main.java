public class Main {
  public static void main(String[] args) {
    /*
     * AFDNUMB validador = new AFDNUMB();
     * 
     * validador.validarNum("+12345678901"); // válido
     * validador.validarNum("+98765432101"); // válido
     * validador.validarNum("(12)345678901"); // válido
     * validador.validarNum("(98)765432101"); // válido
     * validador.validarNum("12345678901"); // válido
     * validador.validarNum("98765432101"); // válido
     * validador.validarNum("+11111111111"); // válido
     * validador.validarNum("(11)111111111"); // válido
     * validador.validarNum("11111111111"); // válido
     * validador.validarNum("+22222222222"); // válido
     * validador.validarNum("+12345"); // inválido (muito curto)
     * validador.validarNum("+1234567890123"); // inválido (muito longo)
     * validador.validarNum("(123)45678901"); // inválido (DDD com 3 dígitos)
     * validador.validarNum("(12)3456789"); // inválido (muito curto)
     * validador.validarNum("1234"); // inválido (muito curto)
     * validador.validarNum("abcdefghijk"); // inválido (contém letras)
     * validador.validarNum("(98)76543210a"); // inválido (contém letra no final)
     * validador.validarNum("+12 345678901"); // inválido (contém espaço)
     * validador.validarNum("(12)34567890."); // inválido (contém caractere
     * especial)
     * validador.validarNum("+ 12345678901"); // inválido (contém espaço após o +)
     * validador.validarNum("+1283345678901"); // válido
     * validador.validarNum("+98765432101"); // válido
     * validador.validarNum("(12)345678901"); // válido
     * validador.validarNum("(98)765432101"); // válido
     * validador.validarNum("12345678901"); // válido
     * validador.validarNum("98765432101"); // válido
     * validador.validarNum("+11111111111"); // válido
     * validador.validarNum("(11)111111111"); // válido
     * validador.validarNum("11111111111"); // válido
     * validador.validarNum("+22222222222"); // válido
     * validador.validarNum("+12345"); // inválido (muito curto)
     * validador.validarNum("+1234567890123"); // inválido (muito longo)
     * validador.validarNum("(123)45678901"); // inválido (DDD com 3 dígitos)
     * validador.validarNum("(12)3456789"); // inválido (muito curto)
     * validador.validarNum("1234"); // inválido (muito curto)
     * validador.validarNum("abcdefghijk"); // inválido (contém letras)
     * validador.validarNum("(98)76543210a"); // inválido (contém letra no final)
     * validador.validarNum("+12 345678901"); // inválido (contém espaço)
     * validador.validarNum("(12)34567890."); // inválido (contém caractere
     * especial)
     * validador.validarNum("+ 12345678901"); /
     */

    AFNeNUMB validador = new AFNeNUMB();
    validador.validarNum("+5583998608048");
    validador.validarNum("(83)998608048");
    validador.validarNum("+5583998608048");
    validador.validarNum("(83)998608048");
    validador.validarNum("83 9 98608048");
    validador.validarNum("83998608048");

  }
}
