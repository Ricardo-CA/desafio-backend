package orla.digital.desafiobackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.NativeWebRequest;
import orla.digital.desafiobackend.controller.v1.HealthApi;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HealthService implements HealthApi {

    private final NativeWebRequest nativeWebRequest;

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(nativeWebRequest);
    }
}
