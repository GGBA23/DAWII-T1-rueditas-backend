package com.cibertec.edu.DAWII_T1_GonzaloBautista_backend.controller;

import com.cibertec.edu.DAWII_T1_GonzaloBautista_backend.dto.BuscadorRequestDTO;
import com.cibertec.edu.DAWII_T1_GonzaloBautista_backend.dto.BuscadorResponseDTO;
import com.cibertec.edu.DAWII_T1_GonzaloBautista_backend.service.BuscadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/buscador")
public class BuscadorController {

    @Autowired
    BuscadorService buscadorService;


    @PostMapping("/buscar")
    public BuscadorResponseDTO buscar(@RequestBody BuscadorRequestDTO buscadorRequestDTO){

        try {
            String[] datosPlaca = buscadorService.validarPlaca(buscadorRequestDTO);
            if (datosPlaca == null){
                return new BuscadorResponseDTO("01","Error: Vehículo no encontrado","","","","","");
            }
            return new BuscadorResponseDTO("00","",datosPlaca[0],datosPlaca[1],datosPlaca[2],datosPlaca[3],datosPlaca[4]);


        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new BuscadorResponseDTO("99","Error: Ocurrio un prolema","","","","","");

        }

    }

}
