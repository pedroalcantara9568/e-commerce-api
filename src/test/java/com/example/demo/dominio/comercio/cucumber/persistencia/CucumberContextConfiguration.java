package com.example.demo.dominio.comercio.cucumber.persistencia;

import com.example.demo.DddDasAlagoas;
import io.cucumber.java.Before;
import org.springframework.boot.test.context.SpringBootTest;
import javax.transaction.Transactional;

@SpringBootTest(classes = DddDasAlagoas.class)
public class CucumberContextConfiguration {

    @Before
    @Transactional
    public void setup_cucumber_spring_context() {

    }
}
