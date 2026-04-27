package com.materiales.materiales;

import com.materiales.materiales.dto.materialRequestDTO;
import com.materiales.materiales.dto.materialResponseDTO;
import com.materiales.materiales.model.usuario;
import com.materiales.materiales.repository.usuarioRepository;
import com.materiales.materiales.service.MaterialService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MaterialesApplication {

    public static void main(String[] args) {
        SpringApplication.run(MaterialesApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(
            MaterialService materialService,
            usuarioRepository usuarioRepository) {

        return args -> {
            System.out.println("--- Agregando Datos Manualmente ---");

            // 1. Crear y guardar un usuario
            usuario u1 = new usuario();
            u1.setNombre("Juan Perez");
            u1.setDocumento("67676767");
            u1.setCorreo("juan67@email.com");
            usuarioRepository.save(u1);

            // 2. Crear un material usando el servicio
            materialRequestDTO request = new materialRequestDTO();
            request.setName("Lapith");
            request.setCondition("Bueno");
            request.setDate("2026-04-26");
            request.setReturndate("2026-05-10");

      materialResponseDTO response = materialService.guardar(request);

            System.out.println("--- MATERIAL GUARDADO ---");
            System.out.println("ID: " + response.getId());
            System.out.println("Nombre: " + response.getName());
            System.out.println("Condicion: " + response.getCondition());
        };
    }}