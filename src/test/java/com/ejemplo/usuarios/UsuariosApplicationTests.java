package com.ejemplo.productos;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UsuariosApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() {
	}

	@Test
	void listaCincoProductosIniciales() throws Exception {
		mockMvc.perform(get("/api/productos"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.length()").value(5))
				.andExpect(jsonPath("$[0].nombre").value("Laptop HP"))
				.andExpect(jsonPath("$[0].precio").value(2500.0))
				.andExpect(jsonPath("$[0].stock").value(10));
	}

	@Test
	void buscaProductoPorId() throws Exception {
		mockMvc.perform(get("/api/productos/1"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.nombre").value("Laptop HP"));
	}

	@Test
	void productoInexistenteDevuelve404() throws Exception {
		mockMvc.perform(get("/api/productos/999"))
				.andExpect(status().isNotFound())
				.andExpect(jsonPath("$.error").value("Producto no encontrado con id: 999"));
	}

}