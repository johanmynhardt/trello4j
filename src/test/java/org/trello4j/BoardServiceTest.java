package org.trello4j;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.trello4j.core.TrelloTemplate;
import org.trello4j.model.Attachment;
import org.trello4j.model.Card;

public class BoardServiceTest {
    private static final String API_KEY = "b8a19fea9c86c56f92b47ba9841826c7";
    private static final String API_TOKEN = "a8379d5621ca307209024191609a5b39a972a3424cfe0c52952158e91c764117";
    private static final String ID_BOARD = "5830d0b8694ae8f1cdeecb46";

    @Test
    public void testGetAttachmentsFromCard() {
        List<Card> cards = new TrelloTemplate(API_KEY, API_TOKEN).boundBoardOperations(ID_BOARD).getCards();
        List<Attachment> attachments = cards.get(0).getAttachments();
        assertNotNull(attachments);
    }
}
