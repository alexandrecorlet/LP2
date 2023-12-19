package agenda;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AgendaTest {

    Agenda agenda;

    @BeforeEach
    void preparaAgenda() {
        this.agenda = new Agenda();
    }

    @Test
    void testCadastraContatoRealizado() {
        String msg = "Esperando cadastro realizado";
        boolean expected = true;
        boolean actual = this.agenda.cadastraContato(1, "Alexandre", "Corlet", 
                                "(83) 99999-2222", "(83) 99999-0000", "(83) 99999-1111");
        assertEquals(expected, actual, msg);
    }

    @Test
    void testCadastraContatoCadastrado1() {
        this.agenda.cadastraContato(52, "Alexandre", "Corlet", "(83) 99999-3333", 
                                    "(83) 99999-0000", "(83) 99999-1111");
        String msg = "Esperando contato ja cadastrado";
        boolean expected = false;
        boolean actual = this.agenda.cadastraContato(1, "Alexandre", "Corlet",  
                                "(83) 99999-3333", "(83) 99999-0000", "(83) 99999-1111");
        assertEquals(expected, actual, msg);
    }

    @Test
    void testCadastraContatoCadastrado2() {
        this.agenda.cadastraContato(13, "Alexandre", "Corlet", "(83) 99999-2222", "", "");
        String msg = "Esperando contato ja cadastrado";
        boolean expected = false;
        boolean actual = this.agenda.cadastraContato(13, "Alexandre", "Corlet", "", 
                                            "(83) 99999-1322", "");
        assertEquals(expected, actual, msg);
    }

    @Test
    void testCadastraContato3() {
        this.agenda.cadastraContato(21, "Google", "BR", "(83) 99999-0000", 
                            "(21) 91234-5678", "(11) 98765-4321");
        String msg = "Esperando contato ja cadastrado";
        boolean expected = false;
        boolean actual = this.agenda.cadastraContato(1, "Google", "BR", 
                            "(83) 99999-0000", "(21) 91234-5678", "(11) 98765-4321");
        assertEquals(expected, actual, msg);
    }

    @Test
    void testCadastraContato4() {
        this.agenda.cadastraContato(1, "Facebook", "BR", "(21) 99999-1234", "", "");
        String msg = "Esperando contato ja cadastrado";
        boolean expected = false;
        boolean actual = this.agenda.cadastraContato(10, "Facebook", "BR", "", "", "");
        assertEquals(expected, actual);
    }


    @Test
    void testCadastraContatoPosicaoLimite1() {
        String msg = "Esperando cadastro realizado";
        boolean expected = true;
        boolean actual = this.agenda.cadastraContato(100, "Cristina", "Barros", 
                                                "(83) 99999-1234", "", "");
        assertEquals(expected, actual, msg);
    }

    @Test
    void testCadastraContatoPosicaoLimite2() {
        String msg = "Esperando cadastro realizado";
        boolean expected = true;
        boolean actual = this.agenda.cadastraContato(1, "Mae", "Linda", "", 
                                                "(83) 99999-0000", "");
        assertEquals(expected, actual, msg);
    }

    @Test
    void testAdicionaFavorito1() {
        this.agenda.cadastraContato(1, "Pizza", "Hut", "(83) 99999-1111", "", "");
        String msg = "Esperando contato favoritado";
        boolean expected = true;
        boolean actual = this.agenda.adicionaFavorito(1, 3);
        assertEquals(expected, actual, msg);
    }

    @Test
    void testAdicionaFavorito2() {
        this.agenda.cadastraContato(100, "Cinepolis", "Manaira", "(83) 99999-5555", 
                                    "(83) 91234-5678", "");
        String msg = "Esperando contato favoritado";
        boolean expected = true;
        boolean actual = this.agenda.adicionaFavorito(100, 1);
        assertEquals(expected, actual, msg);
    }

    @Test
    void testAdicionaFavorito3() {
        this.agenda.cadastraContato(1, "Casa", "PB", "(83) 99999-1010", "", "");
        String msg = "Esperando contato favoritado";
        boolean expected = true;
        boolean actual = this.agenda.adicionaFavorito(1, 10);
        assertEquals(expected, actual, msg);
    }

    @Test
    void testAdicionaFavorito8() {
        this.agenda.cadastraContato(5, "Albert", "Einstein", 
                    "(21) 94444-3333", "(11) 92346-1249", "(83) 95879-9999");
        this.agenda.adicionaFavorito(5, 7);
        String msg = "Esperando posição inválida";
        boolean expected = false;
        boolean actual = this.agenda.adicionaFavorito(5, 7);
        assertEquals(expected, actual, msg);
    }

    @Test
    void testAdicionaFavorito9() {
        this.agenda.cadastraContato(6, "MC", "FIOTI", 
                    "(21) 95555-3333", "(11) 92316-1249", "(83) 95829-9999");
        this.agenda.adicionaFavorito(6, 8);
        String msg = "Esperando posição inválida";
        boolean expected = false;
        boolean actual = this.agenda.adicionaFavorito(6, 1);
        assertEquals(expected, actual, msg);
    }

}
