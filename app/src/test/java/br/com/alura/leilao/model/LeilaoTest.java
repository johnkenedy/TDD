package br.com.alura.leilao.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class LeilaoTest {

    private final Leilao CONSOLE = new Leilao("console");
    private final Usuario JOHN = new Usuario("John");

    @Test
    public void getDescription_WhenReceiveDescription_ShouldReturnDescription() {
        String description = CONSOLE.getDescricao();

        assertEquals("console", description);
    }

    @Test
    public void getMaiorLance_WhenReceiveOneBid_ShouldReturnHighestBid() {
        CONSOLE.propoe(new Lance(JOHN, 200.0));

        double highestBid = CONSOLE.getMaiorLance();

        assertEquals(200.0, highestBid, 0.0001);

    }

    @Test
    public void getMaiorLance_WhenReceiveBidInAscendingOrder_ShouldReturnHighestBid() {
        CONSOLE.propoe(new Lance(new Usuario("Igor"), 300.0));
        CONSOLE.propoe(new Lance(JOHN, 700.0));

        double highestBid = CONSOLE.getMaiorLance();

        assertEquals(700.0, highestBid, 0.0001);
    }

    @Test
    public void getMaiorLance_WhenReceiveBidInDescendingOrder_ShouldReturnHighestBid() {
        CONSOLE.propoe(new Lance(new Usuario("Igor"), 3500.0));
        CONSOLE.propoe(new Lance(JOHN, 1500.0));

        double highestBid = CONSOLE.getMaiorLance();

        assertEquals(3500.0, highestBid, 0.0001);
    }

    @Test
    public void should_ReturnSmallestBid_WhenReceiveJustOneBid() {
        CONSOLE.propoe(new Lance(JOHN, 30.0));

        double smallestBid = CONSOLE.getMenorLance();

        assertEquals(30.0, smallestBid, 0.0001);
    }

    @Test
    public void should_ReturnReturnSmallestBid_WhenReceiveBidInAscendingOrder() {
        CONSOLE.propoe(new Lance(new Usuario("Igor"), 300.0));
        CONSOLE.propoe(new Lance(JOHN, 700.0));

        double smallestBid = CONSOLE.getMenorLance();

        assertEquals(300.0, smallestBid, 0.0001);
    }

    @Test
    public void should_ReturnReturnSmallestBid_WhenReceiveBidInDescendingOrder() {
        CONSOLE.propoe(new Lance(new Usuario("Igor"), 800.0));
        CONSOLE.propoe(new Lance(JOHN, 350.0));
        CONSOLE.propoe(new Lance(JOHN, 200.0));

        double smallestBid = CONSOLE.getMenorLance();

        assertEquals(200.0, smallestBid, 0.0001);
    }
}