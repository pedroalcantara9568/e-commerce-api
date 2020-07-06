package com.example.demo.dominio.comercio.cucumber.persistencia;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Configuration;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources")
@Configuration
public class TestesComPersistencia {
}
