package es.iessoterohernandez.daw.endes.SerieVideojuegos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class SerieVideojuegosTest {
	private Videojuego vj;
	private Videojuego vj2;
	private Serie serie;
	private Serie serie2;

	@BeforeEach
	public void init() {
		vj = new Videojuego();
		vj2 = new Videojuego();
		serie = new Serie("Hora de aventuras", 2, "aventura", "Pendleton Ward");
		serie2 = new Serie("Historias corrientes", 4, "aventura", "J.G. Quintel");
	}
	
	@Test
	public void videojuegoIsEntregado() {
		vj.entregar();
		assertEquals(vj.isEntregado(), true);

		vj.devolver();
		assertEquals(vj.isEntregado(), false);
	}

	@Test
	public void VideojuegoCompareTo() {
		vj.setHorasEstimadas(2);
		vj2.setHorasEstimadas(3);
		assertEquals(vj.compareTo(vj2), vj.MENOR);

		vj.setHorasEstimadas(3);
		vj2.setHorasEstimadas(3);
		assertEquals(vj.compareTo(vj2), vj.IGUAL);

		vj.setHorasEstimadas(3);
		vj2.setHorasEstimadas(2);
		assertEquals(vj.compareTo(vj2), vj.MAYOR);
	}

	@Test
	public void videojuegoEquals() {
		vj.setTitulo("El senior de la noche");
		vj2.setTitulo("El gato con botas");
		assertEquals(vj.equals(vj2), false);

		vj.setTitulo("El gato con botas");
		assertEquals(vj.equals(vj2), true);
	}
	
	@Test
	public void serieIsEntregado() {
		serie.entregar();
		assertEquals(serie.isEntregado(), true);
		
		serie.devolver();
		assertEquals(serie.isEntregado(), false);
	}
	
	@Test
	public void serieCompareTo() {
		assertEquals(serie.compareTo(serie2), serie.MENOR);
		
		serie.setnumeroTemporadas(3);
		serie2.setnumeroTemporadas(2);
		assertEquals(serie.compareTo(serie2), serie.MAYOR);
		
		serie.setnumeroTemporadas(3);
		serie2.setnumeroTemporadas(3);
		assertEquals(serie.compareTo(serie2), serie.IGUAL);
	}

	@Test
	public void serieEquals() {
		assertEquals(serie.equals(serie2), false);
		
		serie2.setTitulo("Hora de aventuras");
		serie2.setcreador("Pendleton Ward");
		assertEquals(serie.equals(serie2), true);
	}
	
	@AfterEach
	public void finish() {
		Videojuego vj = null;
		Videojuego vj2 = null;
		Serie serie = null;
		Serie serie2 = null;
	}

}