/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigabem.calculaFretes.Model;

/**
 *
 * @author tasso
 */
import com.google.gson.Gson;
import com.sigabem.calculaFretes.Services.CepService;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Rodrigo
 */
@Entity
@Table(name = "PRODUTO")
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nomeDestinatario;
    private double peso;
    private String cepOrigem;
    private String cepDestino;
    private double vlTotalFrete;
    @Column(nullable = false)
    private String dataPrevistaEntraga;
    private String dataConsulta;

    @Transient
    CepService cepService = CepService.getInstance();

    public Produto() {
    }

    public Produto(String nomeDestinatario, double peso, String cepOrigem, String cepDestino) {
        this.nomeDestinatario = nomeDestinatario;
        this.peso = peso;
        this.cepOrigem = cepOrigem;
        this.cepDestino = cepDestino;
        dataConsulta = LocalDateTime.now().format(cepService.getDtf());

        calcVlTotalFrete(cepOrigem, cepDestino);
    }

    public void calcVlTotalFrete(String cepOrigem, String CepDestino) {
        Endereco origem = cepService.buscaCep(cepOrigem);
        Endereco destino = cepService.buscaCep(CepDestino);

        try{
            if (origem.getDdd().equals(destino.getDdd())) {
            vlTotalFrete = peso * 0.5;
            vlTotalFrete = Math.round(vlTotalFrete * 100);
            vlTotalFrete = vlTotalFrete / 100;
            dataPrevistaEntraga = LocalDateTime.now().plusDays(1).format(cepService.getDtf());

        } else if (origem.getUf().equals(destino.getUf())) {
            vlTotalFrete = peso - (peso * 0.75);
            vlTotalFrete = Math.round(vlTotalFrete * 100);
            vlTotalFrete = vlTotalFrete / 100;
            dataPrevistaEntraga = LocalDateTime.now().plusDays(3).format(cepService.getDtf());
        } else {
            vlTotalFrete = peso;
            dataPrevistaEntraga = LocalDateTime.now().plusDays(10).format(cepService.getDtf());

        }
        }catch(NullPointerException n){
            System.out.println("Erro ao buscar CEP " + n.getMessage());
        }
        

    }

    public double getVlTotalFrete() {
        return vlTotalFrete;
    }

    public void setVlTotalFrete(double vlTotalFrete) {
        this.vlTotalFrete = vlTotalFrete;
    }

    public String getDataPrevistaEntraga() {
        return dataPrevistaEntraga;
    }

    public void setDataPrevistaEntraga(String dataPrevistaEntraga) {
        this.dataPrevistaEntraga = dataPrevistaEntraga;
    }

    public String getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(String dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomeDestinatario() {
        return nomeDestinatario;
    }

    public void setNomeDestinatario(String nomeDestinatario) {
        this.nomeDestinatario = nomeDestinatario;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getCepOrigem() {
        return cepOrigem;
    }

    public void setCepOrigem(String cepOrigem) {
        this.cepOrigem = cepOrigem;
    }

    public String getCepDestino() {
        return cepDestino;
    }

    public void setCepDestino(String cepDestino) {
        this.cepDestino = cepDestino;
    }

    @Override
    public String toString() {
        return "Produto{" + "id=" + id + ", nomeDestinatario=" + nomeDestinatario + ", peso=" + peso + ", cepOrigem=" + cepOrigem + ", cepDestino=" + cepDestino + ", vlTotalFrete=" + vlTotalFrete + ", dataPrevistaEntraga=" + dataPrevistaEntraga + ", dataConsulta=" + dataConsulta + '}';
    }

  
}
