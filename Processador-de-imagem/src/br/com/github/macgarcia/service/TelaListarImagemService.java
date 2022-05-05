package br.com.github.macgarcia.service;

import br.com.github.macgarcia.componente.ModeloTabelaListarImagem;
import br.com.github.macgarcia.modelo.Imagem;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

/**
 *
 * @author macgarcia
 */
public class TelaListarImagemService {

    private final ModeloTabelaListarImagem modelo = new ModeloTabelaListarImagem();

    public TelaListarImagemService(final JInternalFrame tela) {
        tela.setTitle("Listar Imagens");
        tela.setResizable(false);
    }

    public void iniciarTabela(final JTable tabela) {
        tabela.setModel(modelo);
        tabela.getTableHeader().setReorderingAllowed(false);
    }

    public void acaoDeCliqueNaTabela(final JTable tabela, final JLabel lblSelecionado) {
        tabela.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Imagem imagem = modelo.getImagem(tabela.getSelectedRow());
                mostrarImagemNoPainel(imagem, lblSelecionado);
            }
        });
    }

    private void mostrarImagemNoPainel(final Imagem imagem, final JLabel lblSelecionado) {
        lblSelecionado.setIcon(null);
        ImageIcon icon = new ImageIcon(imagem.getImg());
        Image image = icon.getImage();
        
        Image readyImage = image.getScaledInstance(lblSelecionado.getWidth()
                , lblSelecionado.getHeight()
                , Image.SCALE_SMOOTH);
        
        ImageIcon readyIcon = new ImageIcon(readyImage);
        lblSelecionado.setIcon(readyIcon);
    }

}
