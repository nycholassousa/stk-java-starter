package {{group}}.{{project_name|replace('-','')}}.adapter.rest.controller;

import {{group}}.{{project_name|replace('-','')}}.adapter.rest.handler.RestExceptionHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayName("Teste basico de controller e handler")
class BasicControllerTest {
    private MockMvc mockMvc;

    @Mock
    private BasicController controller;

    @BeforeEach
    void setup() {
        this.mockMvc = MockMvcBuilders
                .standaloneSetup(new RestExceptionHandler(), controller)
                .build();
    }

    @Test
    @DisplayName("Teste de chamada de endpoint com sucesso")
    void test01() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/v1/basic").contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @DisplayName("Teste de chamada de excecao via endpoint")
    void test02() throws Exception {

        var exception = new IllegalArgumentException();
        when(controller.helloWorld()).thenThrow(exception);

        mockMvc.perform(MockMvcRequestBuilders.get("/v1/basic").contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.exception_name").value(exception.getClass().getSimpleName()));
    }
}