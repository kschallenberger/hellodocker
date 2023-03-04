package br.com.cwi.tccredesocial.validator;

import br.com.cwi.tccredesocial.domain.Postagem;
import br.com.cwi.tccredesocial.security.domain.Usuario;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Component
public class RemoverCurtirPostagemValidator {

    public static void validar(Usuario usuarioLogado, Postagem post) {
        UsuarioTemAcessoPostValidator.validar(usuarioLogado, post);
        if (!post.getCurtidas().contains(usuarioLogado)) {
            throw new ResponseStatusException(BAD_REQUEST, "Usuário ainda não curtiu esse post");
        }
    }
}
