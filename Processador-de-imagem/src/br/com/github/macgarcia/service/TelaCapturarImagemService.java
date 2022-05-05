package br.com.github.macgarcia.service;

import br.com.github.macgarcia.componente.RegraSelecaoImagem;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamResolution;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author macgarcia
 */
public class TelaCapturarImagemService extends RegraSelecaoImagem {

    private Webcam webCam;

    private boolean cameraLigada;

    public TelaCapturarImagemService(final JInternalFrame tela) {
        tela.setTitle("Capturar imagem");
        tela.setResizable(false);
        configurarCamera();
    }

    private void configurarCamera() {
        Dimension size = WebcamResolution.VGA.getSize();
        webCam = Webcam.getDefault();
        webCam.setViewSize(size);
    }

    public void acaoDosBotoes(final List<JButton> botoes,
            final JLabel lblImagemCapturada) {

        //Desligar
        botoes.get(0).addActionListener(ae -> {
            cameraLigada = false;
            lblImagemCapturada.setIcon(null);
            desligarCamera();
        });

        //Ligar
        botoes.get(1).addActionListener(ae -> {
            //ligarCamera(lblImagemCapturada);
            new Thread() {
                @Override
                public void run() {
                    webCam.open();
                    cameraLigada = true;
                    iniciarThreadDeCaptura(lblImagemCapturada);
                }
            }.start();

        });

        botoes.get(2).addActionListener(ae -> {
            cameraLigada = false;
            desligarCamera();
            final String caminhoParaSalvar = caixaDeSalvamento();

        });
    }

    private void iniciarThreadDeCaptura(final JLabel lblImagemCapturada) {
        new Thread() {
            @Override
            public void run() {
                while (cameraLigada) {
                    BufferedImage image = webCam.getImage();
                    ImageIcon icon = new ImageIcon(image);
                    icon.setImage(image.getScaledInstance(lblImagemCapturada.getWidth(),
                            lblImagemCapturada.getHeight(),
                            100));

                    lblImagemCapturada.setIcon(icon);
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException ex) {

                    }
                }
            }
        }.start();
    }

    private void ligarCamera(final JLabel lblImagemCapturada) {
        new Thread() {
            @Override
            public void run() {
                webCam.open();
                cameraLigada = true;
                iniciarThreadDeCaptura(lblImagemCapturada);
            }
        }.start();
    }

    private void desligarCamera() {
        new Thread() {
            @Override
            public void run() {
                webCam.close();
            }
        }.start();
    }

    private String caixaDeSalvamento() {
        JFileChooser seletor = new JFileChooser();
        seletor.setVisible(true);
        seletor.setDialogTitle("Salvar em...");
        seletor.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        desabilitaCampoTexto(seletor);
        final int selecionado = seletor.showSaveDialog(null);
        if (JFileChooser.APPROVE_OPTION == selecionado) {
            try {
                return seletor.getSelectedFile().getCanonicalPath();
            } catch (IOException ex) {
                return "";
            }
        }
        return "";
    }

    public boolean desabilitaCampoTexto(Container container) {
        Component[] comps = container.getComponents();

        for (Component comp : comps) {

            if (comp instanceof JTextField) {
                ((JTextField) comp).setEnabled(false);
                return true;
            }

            if (comp instanceof Container) {
                if (desabilitaCampoTexto((Container) comp)) {
                    return true;
                }
            }
        }
        return false;
    }
}
