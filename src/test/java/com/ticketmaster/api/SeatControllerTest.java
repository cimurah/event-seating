package com.ticketmaster.api;

import com.ticketmaster.api.model.*;
import com.ticketmaster.api.repository.EventRepository;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static junit.framework.TestCase.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class SeatControllerTest {
    private MockMvc mockMvc;
     
    @Autowired
    private EventRepository eventRepository;
    
    @Autowired
    private WebApplicationContext webApplicationContext;
    
    private List<Event> eventList = new ArrayList<>();
    
    @Before
    public void setUp() throws Exception {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
        
        Event event1 = new Event();
        Seat seat1 = new Seat(Seat.SeatType.adult, true, false);
        seat1.setEvent(event1);
        Seat seat2 = new Seat(Seat.SeatType.adult, false, true);
        seat2.setEvent(event1);
        Seat seat3 = new Seat(Seat.SeatType.child, true, true);
        seat3.setEvent(event1);
        Seat seat4 = new Seat(Seat.SeatType.child, false, false);
        seat4.setEvent(event1);
        
        Set seatsSet = new HashSet<Seat>(){{
            add(seat1);
            add(seat2);
            add(seat3);
            add(seat4);
        }};
        
        event1.setSeats(seatsSet);
        this.eventList.add(eventRepository.save(event1));
    }
    
    @Test
    public void getEventSeatsTotalCount() throws Exception {
        MockHttpServletResponse response = this.mockMvc
            .perform(MockMvcRequestBuilders
            .get("/events/" + this.eventList.get(0).getId()  + "/seats"))
            .andReturn().getResponse();

        assertNotNull(response.getHeader("X-Total-Count"));
        assertTrue(response.getHeader("X-Total-Count").equals("4"));
    }
    
    @Test
    public void getEventSeatsAvailableTotalCount() throws Exception {
        MockHttpServletResponse response = this.mockMvc
            .perform(MockMvcRequestBuilders
            .get("/events/" + this.eventList.get(0).getId()  + "/seats?available=1"))
            .andReturn().getResponse();

        assertNotNull(response.getHeader("X-Total-Count"));
        assertTrue(response.getHeader("X-Total-Count").equals("2"));
    }
    
    @Test
    public void getEventSeatsFilteredTotalCount() throws Exception {
        MockHttpServletResponse response = this.mockMvc
            .perform(MockMvcRequestBuilders
            .get("/events/" + this.eventList.get(0).getId()  + "/seats?aisle=true&type=child"))
            .andReturn().getResponse();

        assertNotNull(response.getHeader("X-Total-Count"));
        assertTrue(response.getHeader("X-Total-Count").equals("1"));
    }   
}
