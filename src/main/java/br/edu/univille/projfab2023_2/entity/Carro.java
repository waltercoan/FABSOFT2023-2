package br.edu.univille.projfab2023_2.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String marca;
    private String modelo;
    private String placa;

    @OneToMany(cascade = {jakarta.persistence.CascadeType.ALL})
    @JoinColumn(name = "id_carro")
    private List<Manutencao> listaHistoricoManutencao =
        new ArrayList<>();


    public List<Manutencao> getListaHistoricoManutencao() {
        return listaHistoricoManutencao;
    }
    public void setListaHistoricoManutencao(List<Manutencao> listaHistoricoManutencao) {
        this.listaHistoricoManutencao = listaHistoricoManutencao;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    
}
