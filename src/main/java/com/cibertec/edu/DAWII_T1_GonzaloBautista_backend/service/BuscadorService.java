package com.cibertec.edu.DAWII_T1_GonzaloBautista_backend.service;

import com.cibertec.edu.DAWII_T1_GonzaloBautista_backend.dto.BuscadorRequestDTO;

import java.io.IOException;

public interface BuscadorService {

    String[] validarPlaca(BuscadorRequestDTO buscadorRequestDTO) throws IOException;

}
