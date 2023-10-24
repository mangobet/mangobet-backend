package org.ignisus.mangobetbackend;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MangobetBackendApplicationTests {

	@Test
	void contextLoads() {
		Coche opel = new Coche("Opel", 150);

		assertEquals(opel.arracncar(),"brum brum");
	}

}
