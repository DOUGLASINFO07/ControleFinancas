package metodosAbstratos;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *
 * @author dougl
 */

public interface UsuarioInterface {
    
    public void bloquearCamposFormulario(
            TextField nomeUsuario,
            TextField telefoneUsuario,
            TextField emailUsusario,
            TextField loginUsuario,
            TextField senhaUsuario,
            Button salvar,
            Button atualizar,
            Button excluir
    );
    
}
