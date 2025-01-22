package com.webShop.back.controladores;

import com.webShop.back.modelo.DTO.*;
import com.webShop.back.services.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/v1/user")
@CrossOrigin(origins = "*")
public class UserController {
    
    @Autowired
    private UserService userService;

    @Operation(summary = "Obtener sesión de usuario", 
    description = "Endpoint para obtener la sesión de usuario con el token de autenticación", tags = {"User"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sesión de usuario obtenida con éxito",
                    content = @Content(schema = @Schema(implementation = AthAnswerDTO.class)))
    })
    @GetMapping("/userSession")
    public ResponseEntity<AthAnswerDTO> userSession(HttpServletRequest request) {
        
        AthAnswerDTO answer = userService.getUserSession(request);
        return ResponseEntity.ok(answer);
        
    }

    
    @PostMapping("/registro")
    public ResponseEntity<String> registro(@RequestBody RegisterDTO dtoRegistrer) {
        try {
            if (userService.existsEmail(dtoRegistrer.getEmail())) {
                return new ResponseEntity<>("Este correo electrónico ya está registrado.", 
                    HttpStatus.CONFLICT);
            }

            userService.createUser(dtoRegistrer);

            return ResponseEntity.status(HttpStatus.CREATED).body("Usuario registrado correctamente!");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(ex.getMessage());
        }
    }

    
    @PostMapping("/login")
    public ResponseEntity<AthAnswerDTO> login(@RequestBody LoginDTO LoginDto) {
        try {
            AthAnswerDTO answer = userService.authenticate(LoginDto);
            return new ResponseEntity<>(answer, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new AthAnswerDTO("Error al autenticar"), 
            HttpStatus.UNAUTHORIZED);
        }
    }

}

