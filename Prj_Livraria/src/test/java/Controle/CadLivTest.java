package Controle;

import org.junit.jupiter.api.*;
import javax.swing.table.DefaultTableModel;
import static org.junit.jupiter.api.Assertions.*;

class CadLivTest {

    private CadLiv form;

    @BeforeEach
    void setUp() {
        form = new CadLiv();
    }

    @Test
    void testNovoRegistro() {
        form.limpar.doClick();

        assertEquals("", form.tcodigo.getText());
        assertEquals("", form.ttitulo.getText());
        assertEquals("", form.tcategoria.getText());
        assertEquals("", form.tisbn.getText());
        assertEquals("", form.tidioma.getText());
        assertEquals("", form.tpaginas.getText());
        assertEquals("", form.tpreco.getText());
        assertEquals("", form.tqtdest.getText());
    }

    @Test
    void testGravarRegistro() {
        form.limpar.doClick();
        form.ttitulo.setText("Livro Teste");
        form.tcategoria.setText("Ficção");
        form.tisbn.setText("123-4567890123");
        form.tidioma.setText("Português");
        form.tpaginas.setText("300");
        form.tpreco.setText("29.90");
        form.tqtdest.setText("10");

        form.Gvr.doClick();

        assertNotNull(form.tcodigo.getText());
        assertEquals("Livro Teste", form.ttitulo.getText());
        assertEquals("Ficção", form.tcategoria.getText());
        assertEquals("123-4567890123", form.tisbn.getText());
        assertEquals("Português", form.tidioma.getText());
        assertEquals("300", form.tpaginas.getText());
        assertEquals("29.90", form.tpreco.getText());
        assertEquals("10", form.tqtdest.getText());
    }

    @Test
    void testAlterarRegistro() {
        form.limpar.doClick();
        form.ttitulo.setText("Livro Teste");
        form.tcategoria.setText("Ficção");
        form.tisbn.setText("123-4567890123");
        form.tidioma.setText("Português");
        form.tpaginas.setText("300");
        form.tpreco.setText("29.90");
        form.tqtdest.setText("10");

        form.Gvr.doClick();

        form.ttitulo.setText("Livro Teste Alterado");
        form.alt.doClick();

        assertEquals("Livro Teste Alterado", form.ttitulo.getText());
    }

    @Test
    void testExcluirRegistro() {
        form.limpar.doClick();
        form.ttitulo.setText("Livro Teste");
        form.tcategoria.setText("Ficção");
        form.tisbn.setText("123-4567890123");
        form.tidioma.setText("Português");
        form.tpaginas.setText("300");
        form.tpreco.setText("29.90");
        form.tqtdest.setText("10");

        form.Gvr.doClick();
        String codigo = form.tcodigo.getText();

        form.Exc.doClick();

        assertEquals("", form.tcodigo.getText());
    }

    @Test
    void testPesquisarRegistro() {
        form.limpar.doClick();
        form.ttitulo.setText("Livro Teste");
        form.tcategoria.setText("Ficção");
        form.tisbn.setText("123-4567890123");
        form.tidioma.setText("Português");
        form.tpaginas.setText("300");
        form.tpreco.setText("29.90");
        form.tqtdest.setText("10");

        form.Gvr.doClick();

        form.filtro.setText("Livro Teste");
        form.pesquisar.doClick();

        DefaultTableModel model = (DefaultTableModel) form.tblClientes.getModel();
        assertTrue(model.getRowCount() > 0);
        assertEquals("Livro Teste", model.getValueAt(0, 1));
    }

    @Test
    void testPreencherTabela() {
        form.preencherTabela();

        DefaultTableModel model = (DefaultTableModel) form.tblClientes.getModel();
        assertTrue(model.getRowCount() > 0);
    }

    @Test
    void testPosicionarRegistro() {
        form.posicionarRegistro();

        assertNotNull(form.tcodigo.getText());
        assertNotNull(form.ttitulo.getText());
    }

    @AfterEach
    void tearDown() {
        form.dispose();
    }
}
