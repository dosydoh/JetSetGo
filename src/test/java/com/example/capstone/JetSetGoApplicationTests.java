package com.example.capstone;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.example.capstone.model.Booking;
import com.example.capstone.repository.BookingRepository;
import com.example.capstone.services.BookingServiceImpl;


@SpringBootTest
public class JetSetGoApplicationTests {

    @Mock
    private BookingRepository bookingRepository;

    @InjectMocks
    private BookingServiceImpl bookingService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateBooking() {
        // Given
        Booking booking = new Booking();
        booking.setFirstName("test");

        when(bookingRepository.save(any(Booking.class))).thenReturn(booking);

        // When
        Booking createdBooking = bookingService.createBooking(booking);

        // Then
        assertThat(createdBooking).isNotNull();
        assertThat(createdBooking.getFirstName()).isEqualTo("test");
        verify(bookingRepository, times(1)).save(booking);
    }
}

