package com.sise.lengavanzado.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sise.lengavanzado.adapters.UsuarioAdapter;
import com.sise.lengavanzado.entities.Usuario;
import com.sise.lengavanzado.pyload.requests.UsuarioRequestInsert;
import com.sise.lengavanzado.pyload.requests.UsuarioRequestUpdate;
import com.sise.lengavanzado.pyload.requests.UsuarioRequestUpdateClave;
import com.sise.lengavanzado.services.UsuarioService;
import com.sise.lengavanzado.shared.BaseResponse;
import com.sise.lengavanzado.utils.ValidationUtil;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    private UsuarioAdapter usuarioAdapter;

    public UsuarioController(){
        usuarioAdapter = new UsuarioAdapter();
    }

    @GetMapping("")
    public ResponseEntity<BaseResponse> listarUsuarioes() {
        // Conversion de UsuarioEntity a UsuarioResponse
        try {
            List<Usuario> Usuarios = usuarioService.listarUsuarios();
            /*
             * List<UsuarioResponse> UsuarioResponseList = new ArrayList<>();
             * for (Usuario Usuario : Usuarioes){
             * UsuarioResponseList.add(MappedUtil.toUsuarioResponse(Usuario));
             * }
             */
            return new ResponseEntity<BaseResponse>(
                    BaseResponse.success(Usuarios),
                    HttpStatus.OK);
            // return BaseResponse.success(UsuarioResponseList);
        } catch (Exception e) {
            // return BaseResponse.error(e.getMessage());
            return new ResponseEntity<BaseResponse>(
                    BaseResponse.error(e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{idUsuario}")

    public ResponseEntity<BaseResponse> listarUsuarioPorId(@PathVariable Integer idUsuario) {

        try {
            Usuario usuario = usuarioService.listarUsuarioPorId(idUsuario);
            // return BaseResponse.success(MappedUtil.toUsuarioResponse(Usuario));
            if (usuario == null) {
                return new ResponseEntity<BaseResponse>(
                        BaseResponse.errorNotFound(),
                        HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<BaseResponse>(
                    BaseResponse.success(usuario),
                    HttpStatus.OK);
        } catch (Exception e) {
            // return BaseResponse.error(e.getMessage());
            return new ResponseEntity<BaseResponse>(
                    BaseResponse.error(e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("")
    public ResponseEntity<BaseResponse> insertarUsuario(
            @Valid @RequestBody UsuarioRequestInsert usuarioRequestInsert, Errors errors) {
        try {

            if (errors.hasErrors()) {
                return new ResponseEntity<BaseResponse>(
                        BaseResponse.error(ValidationUtil.getOneMessageFromErrors(errors.getFieldErrors())),
                        // BaseResponse.success("Errores en request"),
                        HttpStatus.BAD_REQUEST);
            }

            Usuario usuario = usuarioService.insertarUsuario(usuarioAdapter.insertToEntity(usuarioRequestInsert));
            // return BaseResponse.success(MappedUtil.toUsuarioResponse(Usuario));
            return new ResponseEntity<BaseResponse>(
                    BaseResponse.success(usuario),
                    HttpStatus.CREATED);
        } catch (Exception e) {
            // return BaseResponse.error(e.getMessage());
            return new ResponseEntity<BaseResponse>(
                    BaseResponse.error(e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{idUsuario}")
    public ResponseEntity<BaseResponse> actualizarUsuario(@PathVariable Integer idUsuario,
            @RequestBody UsuarioRequestUpdate usuarioRequestUpdate) {
        try {
            Usuario usuario = usuarioAdapter.updateToEntity(usuarioRequestUpdate);
            usuario.setIdUsuario(idUsuario);

            Usuario newUsuario = usuarioService.actualizarUsuario(usuario);

            return new ResponseEntity<BaseResponse>(
                    BaseResponse.success(newUsuario),
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<BaseResponse>(
                    BaseResponse.error(e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/cambiarClave/{idUsuario}")
    public ResponseEntity<BaseResponse> cambiarClaveUsuario(
            @PathVariable Integer idUsuario,
            @Valid @RequestBody UsuarioRequestUpdateClave usuarioRequestUpdateClave,
            Errors errors) {
        
        try {

            if (errors.hasErrors()){
                return new ResponseEntity<BaseResponse>(
                BaseResponse.error(ValidationUtil.getOneMessageFromErrors(errors.getFieldErrors())),
                HttpStatus.BAD_REQUEST
                );
            }

            Usuario usuario =  usuarioAdapter.updateClaveToEntity(usuarioRequestUpdateClave);
            usuario.setIdUsuario(idUsuario);
            
            usuarioService.cambiarClaveUsuario(usuario); 
            return new ResponseEntity<BaseResponse>(
                    BaseResponse.success(null),
                    HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<BaseResponse>(
                    BaseResponse.error(e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/darbaja/{idUsuario}")
    public ResponseEntity<BaseResponse> darBajaUsuario(@PathVariable Integer idUsuario) {
        try {
            usuarioService.darBajaUsuario(idUsuario); 
            return new ResponseEntity<BaseResponse>(
                    BaseResponse.success(null),
                    HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<BaseResponse>(
                    BaseResponse.error(e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
