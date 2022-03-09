package br.com.alura.leilao.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class LeilaoTest {

    @Test
    public void getDescricaoWhenReceiveDescriptionShouldReturnDescriptio() {
        Leilao console = new Leilao("console");

        String description = console.getDescricao();

        assertEquals("console", description);
    }

    @Test
    public void getMaiorLanceWhenReceiveOneLanceShouldReturnHighestBid() {
        Leilao console = new Leilao("console");
        console.propoe(new Lance(new Usuario("John"), 200.0));

        double maiorLance = console.getMaiorLance();

        assertEquals(200.0, maiorLance, 0.0001);

    }

    @Test
    public void getMaiorLanceWhenReceiveBidInAscendingOrderShouldReturnHighestBid() {
        Leilao monitor = new Leilao("Monitor");
        monitor.propoe(new Lance(new Usuario("Igor"), 300.0));
        monitor.propoe(new Lance(new Usuario("Joh"), 700.0));

        double highestBidMonitor = monitor.getMaiorLance();

        assertEquals(700.0, highestBidMonitor, 0.0001);
    }

    @Test
    public void getMaiorLanceWhenReceiveBidInDescendingOrderShouldReturnHighestBid() {
        Leilao car = new Leilao("carro");
        car.propoe(new Lance(new Usuario("Igor"), 3500.0));
        car.propoe(new Lance(new Usuario("John"), 1500.0));
        car.propoe(new Lance(new Usuario("Tadeu"), 500.0));

        double highestBidCar = car.getMaiorLance();

        assertEquals(3500.0, highestBidCar, 0.0001);
    }

    @Test
    public void getMenorLance() {
        Leilao console = new Leilao("console");
        console.propoe(new Lance(new Usuario("John"), 30.0));

        double menorLance = console.getMenorLance();

        assertEquals(30.0, menorLance, 0.0001);
    }
}