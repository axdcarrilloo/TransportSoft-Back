package transportSoft.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import transportSoft.domain.entities.BodegaEntity;
import transportSoft.repositories.BodegaRepository;

@SpringBootTest
public class BodegaServiceTest {
	
	@Mock
	private BodegaRepository bodegaRepository;
	
	@InjectMocks
	private BodegaService bodegaSvc;
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	private void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	private List<BodegaEntity> cargarBodegas() {
		List<BodegaEntity> bodegas = new ArrayList<>();
		bodegas.add(new BodegaEntity(1L, "La Central", "Mzn4 #43-67", "Azturia"));
		bodegas.add(new BodegaEntity(3L, "Sevilla", "lt90 #34-55", "Membrillal"));
		bodegas.add(new BodegaEntity(4L, "Verderal", "99-100", "Alzas"));		
		return bodegas;
	}
	
	@Test
	public void eliminarTest() {
		BodegaEntity bodega = new BodegaEntity(1L, "La Central", "Mzn4 #43-67", "Azturia");
		Optional<BodegaEntity> optional = Optional.of(bodega);
		when(bodegaRepository.findById(1L)).thenReturn(optional);
		
		Long idResponse = bodegaSvc.eliminar(1L);
		
		verify(bodegaRepository, atLeast(1)).findById(1L);
		assertNotNull(idResponse);
		assertEquals(idResponse, 1L);
	}
	
	@Test
	public void existenciaPorIdTest() {
		BodegaEntity bodega = new BodegaEntity(1L, "La Central", "Mzn4 #43-67", "Azturia");
		Optional<BodegaEntity> optional = Optional.of(bodega);
		when(bodegaRepository.findById(1L)).thenReturn(optional);
		
		Boolean validar = bodegaSvc.existenciaPorId(1L);
		
		verify(bodegaRepository, atLeast(1)).findById(1L);
		assertNotNull(validar);
		assertTrue(validar);
	}
	
	@Test
	public void consultarPorIdTest() {
		BodegaEntity bodega = new BodegaEntity(1L, "La Central", "Mzn4 #43-67", "Azturia");
		Optional<BodegaEntity> optional = Optional.of(bodega);
		when(bodegaRepository.findById(1L)).thenReturn(optional);
		
		BodegaEntity bodegaResponse = bodegaSvc.consultarPorId(1L);
		
		verify(bodegaRepository, atLeast(1)).findById(1L);
		assertNotNull(bodegaResponse);
		assertEquals(bodegaResponse.getCiudad(), "Azturia");
	}
	
	@Test
	public void consultarTodasTest() {
		when(bodegaRepository.findAll()).thenReturn(cargarBodegas());
		
		List<BodegaEntity> bodegasResponse = bodegaSvc.consultarTodas();
		
		verify(bodegaRepository, atLeast(1)).findAll();
		assertNotNull(bodegasResponse);
		assertEquals(bodegasResponse.size(), 3);
	}

}
