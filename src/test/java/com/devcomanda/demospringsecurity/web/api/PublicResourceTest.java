package com.devcomanda.demospringsecurity.web.api;

import com.devcomanda.demospringsecurity.config.SecurityConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Danil Kuznetsov (kuznetsov.danil.v@gmail.com)
 */
@RunWith(SpringRunner.class)
@WebMvcTest(PublicResource.class)
@Import(SecurityConfiguration.class)
// Spring uses default configuration and we import our config for test
public class PublicResourceTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void shouldDisplayListDemoModelsOverPublicApi() throws Exception {

        this.mvc.perform(
                get("/api/public/demomodels")
        )
                .andExpect(status().isOk())
                .andDo(print());
    }
}
