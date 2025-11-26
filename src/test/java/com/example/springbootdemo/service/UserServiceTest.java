package com.example.springbootdemo.service;

import com.example.springbootdemo.api.model.User;
import com.example.springbootdemo.dto.UpdateUserDTO;
import com.example.springbootdemo.dto.ResponseUserDTO;
import com.example.springbootdemo.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

//@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    private User user1;
    private User user2;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        user1 = new User("Eric", 22, "user1@mail.cz", "heslo123");
        user1.setId(1);

        user2 = new User("Alice", 30, "user2@mail.cz", "heslo456");
        user2.setId(2);

    }

    @Test
    void testGetUser_Success() {
        when(userRepository.findById(1)).thenReturn(Optional.of(user1));

        ResponseUserDTO dto = userService.getUser(1);

        assertEquals("Eric", dto.getName());
        assertEquals(22, dto.getAge());
        assertEquals("user1@mail.cz", dto.getEmail());
    }

    @Test
    void testGetUser_NotFound() {
        when(userRepository.findById(3)).thenReturn(Optional.empty());

        assertThrows(ResponseStatusException.class, () -> userService.getUser(3));
    }

    @Test
    void testGetAllUsers() {
        when(userRepository.findAll()).thenReturn(Arrays.asList(user1, user2));

        List<ResponseUserDTO> users = userService.getAllUsers();

        assertEquals(2, users.size());
        assertEquals("Eric", users.get(0).getName());
        assertEquals("Alice", users.get(1).getName());
    }

    @Test
    void testAddUser() {
        when(userRepository.save(user1)).thenReturn(user1);

        User saved = userService.addUser(user1);

        assertEquals("Eric", saved.getName());
        assertEquals(22, saved.getAge());
    }

    @Test
    void testDeleteUser_Success() {
        when(userRepository.existsById(1)).thenReturn(true);
        doNothing().when(userRepository).deleteById(1);

        assertDoesNotThrow(() -> userService.deleteUser(1));
        verify(userRepository, times(1)).deleteById(1);
    }

    @Test
    void testDeleteUser_NotFound() {
        when(userRepository.existsById(3)).thenReturn(false);

        assertThrows(ResponseStatusException.class, () -> userService.deleteUser(3));
    }

    @Test
    void testUpdateUser_Success() {
        UpdateUserDTO updateDTO = new UpdateUserDTO();
        updateDTO.setName("Eric Updated");
        updateDTO.setAge(23);
        updateDTO.setEmail("eric_updated@mail.cz");
        updateDTO.setPassword("newpass");

        when(userRepository.findById(1)).thenReturn(Optional.of(user1));
        when(userRepository.save(any(User.class))).thenReturn(user1);

        User updated = userService.updateUser(1, updateDTO);

        assertEquals("Eric Updated", updated.getName());
        assertEquals(23, updated.getAge());
        assertEquals("eric_updated@mail.cz", updated.getEmail());
    }

    @Test
    void testUpdateUser_NotFound() {
        UpdateUserDTO updateDTO = new UpdateUserDTO();
        updateDTO.setName("NoUser");


        when(userRepository.findById(3)).thenReturn(Optional.empty());

        assertThrows(ResponseStatusException.class, () -> userService.updateUser(3, updateDTO));
    }
}
