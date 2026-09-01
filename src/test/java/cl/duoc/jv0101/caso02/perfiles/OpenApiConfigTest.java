package cl.duoc.jv0101.caso02.perfiles;

import org.junit.jupiter.api.Test;
import cl.duoc.jv0101.caso02.perfiles.config.OpenApiConfig;

import static org.assertj.core.api.Assertions.assertThat;

class OpenApiConfigTest {

    @Test
    void beanOpenApiGenerado() {
        assertThat(new OpenApiConfig().customOpenAPI()).isNotNull();
    }
}
