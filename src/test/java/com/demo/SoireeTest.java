package com.demo;

import com.dtos.SoireeDto;
import com.services.SoireeService;
import org.junit.jupiter.api.Test;
import org.springframework.data.crossstore.ChangeSetPersister;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class SoireeTest {

    @Test
    public void testSaveSoiree() throws ChangeSetPersister.NotFoundException {
        // Créer un objet SoireeDto
        SoireeDto soireeDto = new SoireeDto();
        soireeDto.setSoi_nom("Soiree A");
        soireeDto.setSal_id(5L);
        soireeDto.setSoi_id(7L);

        // Créer un objet SoireeService et appeler la méthode saveSoiree()
        SoireeService soireeService = mock(SoireeService.class);
        when(soireeService.saveSoiree(soireeDto)).thenReturn(soireeDto);
        SoireeDto savedSoireeDto = soireeService.saveSoiree(soireeDto);

        // Vérifier que la méthode a été appelée une fois avec l'objet SoireeDto en entrée
        verify(soireeService, times(1)).saveSoiree(soireeDto);

        // Vérifier que l'objet SoireeDto retourné par la méthode est non null
        assertNotNull(savedSoireeDto);
    }
}
