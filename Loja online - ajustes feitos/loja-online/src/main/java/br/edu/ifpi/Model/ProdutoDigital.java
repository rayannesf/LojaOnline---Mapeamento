package br.edu.ifpi.Model;
public class ProdutoDigital extends Produto {

    private String urlDownload;
    private int tamanhoArquivoMB;

    public String getUrlDownload() {
        return urlDownload;
    }

    public int getTamanhoArquivoMB() {
        return tamanhoArquivoMB;
    }

    public void setUrlDownload(String urlDownload) {
        this.urlDownload = urlDownload;
    }

    public void setTamanhoArquivoMB(int tamanhoArquivoMB) {
        this.tamanhoArquivoMB = tamanhoArquivoMB;
    }
}