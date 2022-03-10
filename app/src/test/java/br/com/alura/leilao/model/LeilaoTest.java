package br.com.alura.leilao.model;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.List;

public class LeilaoTest {

    public static final double DELTA = 0.0001;
    private final Leilao CONSOLE = new Leilao("console");
    private final Usuario JOHN = new Usuario("John");

    @Test
    public void getDescription_WhenReceiveDescription_ShouldReturnDescription() {
        String description = CONSOLE.getDescricao();

        assertEquals("console", description);
    }

    @Test
    public void getHighestBidder_WhenReceiveOneBid_ShouldReturnHighestBidder() {
        CONSOLE.propoe(new Lance(JOHN, 200.0));

        double highestBidder = CONSOLE.getMaiorLance();

        assertEquals(200.0, highestBidder, DELTA);

    }

    @Test
    public void getHighestBidder_WhenReceiveBidInAscendingOrder_ShouldReturnHighestBidder() {
        CONSOLE.propoe(new Lance(new Usuario("Igor"), 300.0));
        CONSOLE.propoe(new Lance(JOHN, 700.0));

        double highestBidder = CONSOLE.getMaiorLance();

        assertEquals(700.0, highestBidder, DELTA);
    }

    @Test
    public void getHighestBidder_WhenReceiveBidInDescendingOrder_ShouldReturnHighestBidder() {
        CONSOLE.propoe(new Lance(new Usuario("Igor"), 3500.0));
        CONSOLE.propoe(new Lance(JOHN, 1500.0));

        double highestBidder = CONSOLE.getMaiorLance();

        assertEquals(3500.0, highestBidder, DELTA);
    }

    @Test
    public void should_ReturnLowestBid_WhenReceiveJustOneBid() {
        CONSOLE.propoe(new Lance(JOHN, 30.0));

        double lowestBid = CONSOLE.getMenorLance();

        assertEquals(30.0, lowestBid, DELTA);
    }

    @Test
    public void should_ReturnLowestBid_WhenReceiveBidInAscendingOrder() {
        CONSOLE.propoe(new Lance(new Usuario("Igor"), 300.0));
        CONSOLE.propoe(new Lance(JOHN, 700.0));

        double lowestBid = CONSOLE.getMenorLance();

        assertEquals(300.0, lowestBid, DELTA);
    }

    @Test
    public void should_ReturnLowestBid_WhenReceiveBidInDescendingOrder() {
        CONSOLE.propoe(new Lance(new Usuario("Igor"), 800.0));
        CONSOLE.propoe(new Lance(JOHN, 350.0));
        CONSOLE.propoe(new Lance(JOHN, 200.0));

        double lowestBid = CONSOLE.getMenorLance();

        assertEquals(200.0, lowestBid, DELTA);
    }

    @Test
    public void should_ReturnThreeHighestBidder_WhenReceiveExactlyThreeBids() {
        CONSOLE.propoe(new Lance(JOHN, 350.0));
        CONSOLE.propoe(new Lance(new Usuario("Igor"), 800.0));
        CONSOLE.propoe(new Lance(JOHN, 200.0));

        List<Lance> threeHighestBidder = CONSOLE.tresMaioresLances();

        assertEquals(3, threeHighestBidder.size());
        assertEquals(800.0, threeHighestBidder.get(0).getValor(), DELTA);
        assertEquals(350.0, threeHighestBidder.get(1).getValor(), DELTA);
        assertEquals(200.0, threeHighestBidder.get(2).getValor(), DELTA);
    }

    @Test
    public void should_ReturnThreeHighestBidder_WhenDoNotReceiveBids() {
        List<Lance> threeHighestBidder = CONSOLE.tresMaioresLances();

        assertEquals(0, threeHighestBidder.size());
    }

    @Test
    public void should_ReturnThreeHighestBidder_WhenReceiveOneBids() {
        CONSOLE.propoe(new Lance(JOHN, 350.0));

        List<Lance> threeHighestBidder = CONSOLE.tresMaioresLances();

        assertEquals(1, threeHighestBidder.size());
        assertEquals(350.0, threeHighestBidder.get(0).getValor(), DELTA);

    }

    @Test
    public void should_ReturnThreeHighestBidder_WhenReceiveTwoBids() {
        CONSOLE.propoe(new Lance(JOHN, 350.0));
        CONSOLE.propoe(new Lance(new Usuario("Igor"), 800.0));

        List<Lance> threeHighestBidder = CONSOLE.tresMaioresLances();

        assertEquals(2, threeHighestBidder.size());
        assertEquals(350.0, threeHighestBidder.get(1).getValor(), DELTA);
        assertEquals(800.0, threeHighestBidder.get(0).getValor(), DELTA);

    }

}