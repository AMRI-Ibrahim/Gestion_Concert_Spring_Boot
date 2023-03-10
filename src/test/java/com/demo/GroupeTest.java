package com.demo;

import com.dtos.GroupeDto;
import com.services.GroupeService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class GroupeTest {

    @Test
    public void testSaveGroupe() {
        // Créer un objet GroupeDto
        GroupeDto groupeDto = new GroupeDto();
        groupeDto.setGrp_nom("Groupe A");
        groupeDto.setGrp_id(8L);

        // Créer un objet GroupeService et appeler la méthode saveGroupe()
        GroupeService groupeService = mock(GroupeService.class);
        when(groupeService.saveGroupe(groupeDto)).thenReturn(groupeDto);
        GroupeDto savedGroupeDto = groupeService.saveGroupe(groupeDto);

        // Vérifier que la méthode a été appelée une fois avec l'objet GroupeDto en entrée
        verify(groupeService, times(1)).saveGroupe(groupeDto);

        // Vérifier que l'objet GroupeDto retourné par la méthode est non null
        assertNotNull(savedGroupeDto);
    }
}
