package com.laboratorio.config;


import com.laboratorio.entities.users.general.GenListaOpcion;
import com.laboratorio.repositories.general.GenListaOpcionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final GenListaOpcionRepository repo;

    @Override
    public void run(String... args) {

        if (repo.count() == 0) {
            // Tipos de resultados
            // Tipos de resultados
            repo.save(new GenListaOpcion(null, "TiposDeResultados", "N", "Numérico", "NUM", "Resultado numérico (valores cuantitativos)", true));
            repo.save(new GenListaOpcion(null, "TiposDeResultados", "O", "Opción predefinida", "OPT", "Resultado seleccionado de una lista de opciones", true));
            repo.save(new GenListaOpcion(null, "TiposDeResultados", "T", "Texto", "TXT", "Resultado ingresado como texto corto", true));
            repo.save(new GenListaOpcion(null, "TiposDeResultados", "M", "Memo", "MEM", "Notas o comentarios extensos sobre el resultado", true));


            // Tipos de identificación
            repo.save(new GenListaOpcion(null, "TiposDeIdentificación", "CC", "Cédula de ciudadanía", "CC", "Documento nacional", true));
            repo.save(new GenListaOpcion(null, "TiposDeIdentificación", "TI", "Tarjeta de identidad", "TI", "Documento de menores de edad", true));
            repo.save(new GenListaOpcion(null, "TiposDeIdentificación", "CE", "Cédula de extranjería", "CE", "Documento de extranjeros", true));
            repo.save(new GenListaOpcion(null, "TiposDeIdentificación", "PA", "Pasaporte", "PA", "Documento internacional", true));

            // Regímenes de seguridad social
            repo.save(new GenListaOpcion(null, "RegímenesDeSeguridadSocial", "C", "Contributivo", "CON", "Régimen contributivo", true));
            repo.save(new GenListaOpcion(null, "RegímenesDeSeguridadSocial", "S", "Subsidiado", "SUB", "Régimen subsidiado", true));
            repo.save(new GenListaOpcion(null, "RegímenesDeSeguridadSocial", "E", "Especial", "ESP", "Régimen especial", true));
            repo.save(new GenListaOpcion(null, "RegímenesDeSeguridadSocial", "P", "Particular", "PAR", "Régimen particular", true));

            // Sexos biológicos
            repo.save(new GenListaOpcion(null, "SexosBiológicos", "M", "Masculino", "M", "Sexo masculino", true));
            repo.save(new GenListaOpcion(null, "SexosBiológicos", "F", "Femenino", "F", "Sexo femenino", true));
        }

    }
}
