package br.com.store.magic.controller;

import br.com.store.magic.model.Card;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // com essa anotação, não precisa utilizar o ResponseBody
@RequestMapping(value = "/")
@ApiResponses(value = {
        @ApiResponse(code = 401,
        message = "Não autorizado!"),
        @ApiResponse(code = 403,
        message = "Acesso negado!"),
        @ApiResponse(code = 400,
        message = "Bad Request!"),
        @ApiResponse(code = 404,
        message = "Não encontrado!"),
        @ApiResponse(code = 500,
        message = "Internal Server Error")
})
@Api(value = "Controller padrão de exemplo", tags = {"init"})
public class InitController {
    private static final String URL_PLURAL = "inits";
    private static final String URL_SINGULAR = "init/{id}";

    @Autowired
    public InitController() {}


// Exemplo de um getmapping para hello world
//    @GetMapping(value = URL_PLURAL, produces = MediaType.APPLICATION_JSON_VALUE)
//    @ApiOperation("Exemplo de GET de uma lista de dados")
//    public String saida() {
//        return "Hello World!";
//    }
}
