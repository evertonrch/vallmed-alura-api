package med.voll.api.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import med.voll.api.domain.usuario.Usuario;
import med.voll.api.dto.DadosAutenticacao;
import med.voll.api.dto.DadosTokenJwtDTO;
import med.voll.api.security.TokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@AllArgsConstructor
public class AutenticacaoController {

    private final AuthenticationManager manager;
    private final TokenService tokenService;

    private final Logger LOGGER = LoggerFactory.getLogger(AutenticacaoController.class);

    @PostMapping
    public ResponseEntity<?> login(@RequestBody @Valid DadosAutenticacao dados) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());

        Authentication authenticate = manager.authenticate(authenticationToken);
        if (authenticate.isAuthenticated())
            LOGGER.info("AUTENTINCADO");

        var tokenJWT = tokenService.gerarToken((Usuario) authenticate.getPrincipal());

        return ResponseEntity.ok(new DadosTokenJwtDTO(tokenJWT));
    }
}
