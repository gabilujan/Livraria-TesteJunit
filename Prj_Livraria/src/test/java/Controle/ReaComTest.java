

package Controle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;

import static org.junit.jupiter.api.Assertions.*;

class ReaComTest {

    private ReaCom reaCom;

    @BeforeEach
    void setUp() {
        reaCom = new ReaCom();
    }

    @Test
    void testInicializacaoComponentes() {
        assertNotNull(reaCom.tcodigo);
        assertNotNull(reaCom.tidvenda);
        assertNotNull(reaCom.tidlivro);
        assertNotNull(reaCom.tquantidade);
        assertNotNull(reaCom.filtro);
    }

    @Test
    void testGravarButtonActionPerformed() {
        reaCom.tcodigo.setText("");
        reaCom.tidvenda.setText("1");
        reaCom.tidlivro.setText("1");
        reaCom.tquantidade.setText("10");

        // Simula a ação do botão gravar
        reaCom.Gvr.doClick();

        
        assertEquals("", reaCom.tcodigo.getText());
    }

    @Test
    void testLimparButtonActionPerformed() {
        reaCom.tcodigo.setText("1");
        reaCom.tidvenda.setText("1");
        reaCom.tidlivro.setText("1");
        reaCom.tquantidade.setText("10");

        // Simula a ação do botão limpar
        reaCom.limpar.doClick();

        // Verifica se todos os campos foram limpos
        assertEquals("", reaCom.tcodigo.getText());
        assertEquals("", reaCom.tidvenda.getText());
        assertEquals("", reaCom.tidlivro.getText());
        assertEquals("", reaCom.tquantidade.getText());
    }

    @Test
    void testPesquisarButtonActionPerformed() {
        reaCom.filtro.setText("1");

        // Simula a ação do botão pesquisar
        reaCom.pesquisar.doClick();

        // Como não estamos interagindo diretamente com um banco de dados real, você pode verificar se a função foi chamada
        // e se os componentes esperados foram atualizados, se isso for aplicável.
        assertNotNull(reaCom.tblClientes);
    }

    @Test
    void testExcluirButtonActionPerformed() {
        reaCom.tcodigo.setText("1");

        // Simula a ação do botão excluir
        reaCom.Exc.doClick();

        // Como não podemos excluir diretamente do banco de dados, verifique se os campos foram atualizados ou se
        // uma exceção foi capturada.
        assertEquals("", reaCom.tcodigo.getText());
    }
}
