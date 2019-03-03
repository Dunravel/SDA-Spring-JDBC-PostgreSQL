package pl.sda.spring.otherbeans;

import org.springframework.stereotype.Service;

@Service
public class Converter {
    public String convert(String name){
        return name.toUpperCase();
    }
}
