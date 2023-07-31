/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.6.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package orla.digital.desafiobackend.controller.v1;

import orla.digital.desafiobackend.domain.dto.v1.GetHealth200ResponseV1DTO;
import orla.digital.desafiobackend.domain.dto.v1.SearchFuncionario400ResponseV1DTO;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-07-31T20:18:49.114273100-03:00[America/Fortaleza]")
@Validated
@RestController
@Tag(name = "Health", description = "Controles para vida da aplicação")
@RequestMapping("${openapi.desafioBackend.base-path:/desafio-backend/v1}")
public interface HealthApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /health : Verificar vida da aplicação
     * Detalhes sobre o estado da aplicação
     *
     * @return Sucesso (status code 200)
     *         or Não autorizado (status code 401)
     *         or Não permitido (status code 403)
     *         or Erro não identificado (status code 500)
     *         or Não implementado (status code 501)
     */
    @Operation(
        operationId = "getHealth",
        summary = "Verificar vida da aplicação",
        description = "Detalhes sobre o estado da aplicação",
        tags = { "Health" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Sucesso", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = GetHealth200ResponseV1DTO.class))
            }),
            @ApiResponse(responseCode = "401", description = "Não autorizado", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = SearchFuncionario400ResponseV1DTO.class))
            }),
            @ApiResponse(responseCode = "403", description = "Não permitido", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = SearchFuncionario400ResponseV1DTO.class))
            }),
            @ApiResponse(responseCode = "500", description = "Erro não identificado", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = SearchFuncionario400ResponseV1DTO.class))
            }),
            @ApiResponse(responseCode = "501", description = "Não implementado", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = SearchFuncionario400ResponseV1DTO.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/health",
        produces = { "application/json" }
    )
    @ResponseStatus(HttpStatus.OK)
    default GetHealth200ResponseV1DTO _getHealth(
        
    ) {
        return getHealth();
    }

    // Override this method
    default  GetHealth200ResponseV1DTO getHealth() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"status\" : \"UP\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        throw new IllegalArgumentException("Not implemented");

    }

}