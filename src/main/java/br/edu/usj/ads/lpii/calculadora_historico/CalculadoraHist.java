package br.edu.usj.ads.lpii.calculadora_historico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class CalculadoraHist {

    @Autowired
    HistoricoRepository historicoRepository;
    // List <String> historico = new ArrayList<>();

    @PostMapping(value="/calcular")
    public ModelAndView postSomar(@RequestParam String a, String b, String op) {
        ModelAndView modelAndView = new ModelAndView("index");
        
        Double aNum = Double.valueOf(a);
        Double bNum = Double.valueOf(b);
        String operacao = null;
        switch (op) {
            case "+":
                operacao = a + " + " + b +" = "+ (aNum+bNum);
                break;
            
            case "-":
                operacao = a + " - " + b +" = "+ (aNum-bNum);
                break;
            
            case "/":
                operacao = a + " / " + b +" = "+ (aNum/bNum);
                break;  
                
            case "*":
                operacao = a + " * " + b +" = "+ (aNum*bNum);
                break;
            default:
                operacao="Erro na digitação do símbolo de operação!";
                break;
        }
        // historico.add(operacao);
        Historico item = new Historico();
        item.setOperacao(operacao);
        historicoRepository.save(item);

        List<Historico> historico = historicoRepository.findAll();

        modelAndView.addObject("resultado", operacao);
        modelAndView.addObject("historico", historico);
        
        return modelAndView;
    }
    
}


