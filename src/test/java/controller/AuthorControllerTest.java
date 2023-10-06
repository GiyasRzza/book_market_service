package controller;

import com.example.book_market_service.controller.AuthorController;
import com.example.book_market_service.dao.AuthorDao;
import com.example.book_market_service.dto.AuthorDto;
import com.example.book_market_service.service.AuthorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class AuthorControllerTest {

    private MockMvc mockMvc;

    @Mock
    private AuthorService authorService;

    @InjectMocks
    private AuthorController authorController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(authorController).build();
    }

    @Test
    public void testCreateAuthor() throws Exception {
        AuthorDto authorDto = new AuthorDto();
        authorDto.setAuthorName("John Doe");

        mockMvc.perform(post("/save-author")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(authorDto)))
                .andExpect(status().isOk());

    }

    @Test
    public void testGetAuthor() throws Exception {
        long authorId = 1L;

        AuthorDao authorDao = new AuthorDao();
        authorDao.setId(authorId);
        authorDao.setAuthorName("John Doe");

        when(authorService.findAuthor(authorId)).thenReturn(authorDao);

        mockMvc.perform(get("/get-author")
                .header("id", String.valueOf(authorId)))
                .andExpect(status().isOk());

    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
