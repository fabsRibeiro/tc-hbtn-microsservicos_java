package com.song.MegaSenaAPI;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value="/megasena")
public class MegaSenaController {

    @GetMapping("/simpleMessageWelcome")
    public String mensagemBoasVindas() {
        return "Bem vindo a API REST para geração de números para a loteria Mega Sena.";
    }

    @GetMapping("/getNumbers")
    public List<Integer> numerosMegaSena() {
        int min = 1;
        int max = 60;
        List<Integer> numerosSortiados = new ArrayList<>();
        for(int i = 0; i < 6; i++){
            int numero = (int)Math.floor(Math.random()*(max-min+1)+min);
            numerosSortiados.add(numero);
        }
        Collections.sort(numerosSortiados);
        return numerosSortiados;
    }
}
