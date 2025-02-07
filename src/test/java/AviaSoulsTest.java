import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {
    Ticket ticket1 = new Ticket("MSK", "Sochi", 500, 7, 11); // время полета 4
    Ticket ticket2 = new Ticket("MSK", "Sochi", 700, 10, 13); // время полета 3
    Ticket ticket3 = new Ticket("Sochi", "Ufa", 1000, 16, 22); // время полета 6
    Ticket ticket4 = new Ticket("MSK", "Sochi", 100, 4, 9); // время полета 5
    Ticket ticket5 = new Ticket("Ufa", "MSK", 200, 7, 14); // время полета 7
    Ticket ticket6 = new Ticket("MSK", "Sochi", 500, 5, 14); // время полета 9

    AviaSouls avia = new AviaSouls();

    @Test
    public void shouldSortFewTickets() {
        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket3);
        avia.add(ticket4);
        avia.add(ticket5);
        avia.add(ticket6);

        Ticket[] actual = avia.search("MSK", "Sochi");
        Ticket[] expected = {ticket4, ticket1, ticket6, ticket2};
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void sortingNonExistentTickets() {
        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket3);
        avia.add(ticket4);
        avia.add(ticket5);
        avia.add(ticket6);

        Ticket[] actual = avia.search("MSK", "Omsk");
        Ticket[] expected = {};
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldSortOneTicket() {
        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket3);
        avia.add(ticket4);
        avia.add(ticket5);
        avia.add(ticket6);

        Ticket[] actual = avia.search("Sochi", "Ufa");
        Ticket[] expected = {ticket3};
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldSortTicketsWithComparator() {
        Comparator<Ticket> comparator = new TicketTimeComparator();
        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket3);
        avia.add(ticket4);
        avia.add(ticket5);
        avia.add(ticket6);

        Ticket[] actual = avia.search("MSK", "Sochi", comparator);
        Ticket[] expected = {ticket2, ticket1, ticket4, ticket6};
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void sortingNonExistentTicketsWithComparator() {
        Comparator<Ticket> comparator = new TicketTimeComparator();
        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket3);
        avia.add(ticket4);
        avia.add(ticket5);
        avia.add(ticket6);

        Ticket[] actual = avia.search("Omsk", "Sochi", comparator);
        Ticket[] expected = {};
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldSortOneTicketWithComparator() {
        Comparator<Ticket> comparator = new TicketTimeComparator();
        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket3);
        avia.add(ticket4);
        avia.add(ticket5);
        avia.add(ticket6);

        Ticket[] actual = avia.search("Ufa", "MSK", comparator);
        Ticket[] expected = {ticket5};
        Assertions.assertArrayEquals(actual, expected);
    }


}
