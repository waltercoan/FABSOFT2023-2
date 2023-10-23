package br.edu.univille.projfab2023_2.service.impl;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandler;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.init.Jackson2ResourceReader;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParser;

import br.edu.univille.projfab2023_2.entity.Cliente;
import br.edu.univille.projfab2023_2.repository.ClienteRepository;
import br.edu.univille.projfab2023_2.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClienteRepository repository;
    @Override
    public List<Cliente> getAll() {
        return repository.findAll();
    }
    @Override
    public void save(Cliente cliente) {
        repository.save(cliente);
    }
    @Override
    public void delete(Cliente cliente) {
        repository.delete(cliente);
    }
    @Override
    public String consultaCEP(String CEP) {
        //Código para consultar o CEP de uma API
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = 
            HttpRequest.newBuilder().uri(
                URI.create("https://viacep.com.br/ws/"+CEP+"/json/"))
                .build();
        BodyHandler<String> bodyHandler = HttpResponse.BodyHandlers.ofString();
        try {
            client.send(request, bodyHandler);
            
            return bodyHandler.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }        
        return "OK";        
    }
    
    
}
