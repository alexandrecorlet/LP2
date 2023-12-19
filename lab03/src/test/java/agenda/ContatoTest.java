package agenda;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContatoTest {

    private Contato contato1;
    private Contato contato2;
    private Contato contato3;
    private Contato contato4;

    @BeforeEach
    void preparaContatos() {
        this.contato1 = new Contato("Alexandre", "Corlet", "(83) 99601-0928", "(83) 99999-0000", "(83) 99999-1111");
        this.contato2 = new Contato("Mariana", "Barbosa", "(83) 99999-3333", "(83) 99999-4444", "");
        this.contato3 = new Contato("Marina", "Barbosa", "", "", "");
        this.contato4 = new Contato("Alexandre", "Corlet", "", "(83) 99601-0928", "");
    }

    @Test
    void testGetNomeCompleto() {
        String msg = "Esperando obter o nome completo.";
        assertEquals("Alexandre Corlet", this.contato1.getNomeCompleto(), msg);
    }

    @Test
    void testEqualsIdenticos() {
        String msg = "Esperando que seja igual";
        boolean expected = true;
        boolean actual = this.contato1.equals(contato1);
        assertEquals(expected, actual, msg);
    }

    @Test
    void testEquals() {
        String msg = "Esperando que seja igual";
        boolean expected = true;
        boolean actual = this.contato1.equals(contato4);
        assertEquals(expected, actual, msg);
    }

    @Test
    void testEqualsNull() {
        String msg = "Esperando que seja diferente.";
        boolean unexpected = true;
        boolean actual = this.contato2.equals(null);
        assertNotEquals(unexpected, actual, msg);
    }

    @Test
    void testEqualFalse() {
        String msg = "Esperando que seja diferente";
        boolean unexpected = true;
        boolean actual = this.contato3.equals(contato1);
        assertNotEquals(unexpected, actual, msg);
    }

    @Test
    void testEqualDiffObj() {
        String msg = "Esperando que seja diferente";
        boolean unexpected = true;
        boolean actual = this.contato1.equals("Oi...");
        assertNotEquals(unexpected, actual, msg);
    }

    @Test
    void testToString() {
        String msg = "Esperando todos os dados do contato sejam exibidos.";
        String expected = "Alexandre Corlet\n" +
                            "(83) 99601-0928 (Prioritário)\n" +
                            "(83) 99999-0000 (Whatsapp)\n" +
                            "(83) 99999-1111 (Adicional)\n";
        String actual = this.contato1.toString();
        assertEquals(expected, actual, msg);
    }

    @Test
    void testToStringSemTelefoneAdicional() {
        String msg = "Esperando apenas nome, sobrenome e telefones cadastrados exbidos";
        String expected = "Mariana Barbosa\n" +
                            "(83) 99999-3333 (Prioritário)\n" + 
                            "(83) 99999-4444 (Whatsapp)\n";
        String actual = this.contato2.toString();
        assertEquals(expected, actual, msg);
    }

    @Test
    void testToStringNenhumTelefoneCadastrado() {
        String msg = "Esperando apenas o nome exibido";
        String expected = "Marina Barbosa\n";
        String actual = this.contato3.toString();
        assertEquals(expected, actual, msg);  
    }

    @Test
    void testNomeNull() {
        try {
            Contato contatoInvalido = new Contato(null, "Corlet", "99999-1111", "99999-5555", "99999-3333");
            fail("Era esperado exceção ao passar código nulo");
        } catch(NullPointerException npe) {
            
        }
    }

    @Test
    void testSobrenomeNull() {
        try {
            Contato contatoInvalido = new Contato("Yoda", null, "99999-0000", "99999-2222", "99999-4444");
            fail("Era esperado exceção ao passar código nulo");
        } catch(NullPointerException npe) {
            
        }
    }

    @Test
    void testPrioritarioNull() {
        try {
            Contato contatoInvalido = new Contato("Anakin", "Skywalker", null, "(21) 98311-4567", "(11) 97888-1200");
            fail("Era esperado exceção ao passar código nulo");
        } catch(NullPointerException npe) {

        }
    }

    @Test
    void testWhatsappNull() {
        try {
            Contato contatoInvalido = new Contato("Darth", "Vader", "90000-0000", null, "");
            fail("Era esperado exceção ao passar código nulo");
        } catch(NullPointerException npe) {

        }
    }

    @Test
    void testAdicionalNull() {
        try {
            Contato contatoInvalido = new Contato("Mestre", "Yoda", "", "", null);
            fail("Era esperado exceção ao passar código nulo");
        } catch(NullPointerException npe) {

        }
    }

    @Test
    void testSetTelefonePrioritario() {
        String expected = "Alexandre Corlet\n" +
            "(83) 99999-1010 (Prioritário)\n" +
            "(83) 99999-0000 (Whatsapp)\n" +
            "(83) 99999-1111 (Adicional)\n";
        this.contato1.setTelefonePrioritario("(83) 99999-1010");
        String actual = this.contato1.toString();
        assertEquals(expected, actual);
    }

}
