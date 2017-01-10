package org.trello4j;

import static junit.framework.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.trello4j.core.CardOperations;
import org.trello4j.core.ListOperations;
import org.trello4j.core.TrelloTemplate;
import org.trello4j.model.Action;
import org.trello4j.model.Attachment;
import org.trello4j.model.Card;
import org.trello4j.model.Checklist;
import org.trello4j.model.Label;
import org.trello4j.model.Member;

public class CardServiceTest {

    private static final String USER = "guuilp";
    private static final String API_KEY = "b8a19fea9c86c56f92b47ba9841826c7";
    private static final String API_TOKEN = "a8379d5621ca307209024191609a5b39a972a3424cfe0c52952158e91c764117";
    private static final String LIST_ID = "TODO";
    private static final String CARD_ID = "58643da50130c162b124d9af";
    private static final String ID_LIST = "5830d2555ea447150f1f081b";

    @Test
    public void testCreateCard() {
        // GIVEN

        String name = "Trello4J CardService: Add Card using POST";
        String description = "Something awesome happened :)";

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("desc", description);

        // WHEN
        Card card = new TrelloTemplate(API_KEY, API_TOKEN).boundListOperations(ID_LIST).createCard(name, description,
                null, null, null, null, null, null);

        // THEN
        assertNotNull(card);
        assertThat(card.getName(), equalTo(name));
        assertThat(card.getDesc(), equalTo(description));
    }

    @Test
    public void testCommentOnCard() {
        // GIVEN
        String commentText = "Comment text from JUnit test.";

        // WHEN
        Action action = new TrelloTemplate(API_KEY, API_TOKEN).boundCardOperations(CARD_ID).comment(commentText);

        // THEN
        assertNotNull(action);
        assertThat(action.getType(), equalTo(Action.TYPE.COMMENT_CARD));
        assertThat(action.getData().getText(), equalTo(commentText));
        assertThat(action.getData().getCard().getId(), equalTo(CARD_ID));
    }

    @Test
    public void testSetDueDateOnCard() {
        // WHEN
        boolean action = new TrelloTemplate(API_KEY, API_TOKEN).boundCardOperations(CARD_ID)
                .addDueDate("10/03/2017 09:32 pm");

        // THEN
        assertNotNull(action);
        assertTrue(action);
    }

    @Test
    public void testSetDueDateCompleteOnCard() {
        // WHEN
        boolean action = new TrelloTemplate(API_KEY, API_TOKEN).boundCardOperations(CARD_ID).setDueDateComplete(false);

        // THEN
        assertNotNull(action);
        assertTrue(action);
    }

    @Test
    public void testAttachFileToCard() throws IOException {
        // GIVEN
        String fileContents = "foo bar text in file\n";
        File file = File.createTempFile("trello_attach_test", ".junit");
        if (file.exists()) {
            try {
                FileWriter fileWriter = new FileWriter(file);
                fileWriter.write(fileContents);
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                fail(e.toString());
            }
        }
        String fileName = file.getName();

        // WHEN
        Attachment attachment = new TrelloTemplate(API_KEY, API_TOKEN).boundCardOperations(CARD_ID).attach(file, null,
                fileName, null);

        file.deleteOnExit();

        // THEN
        assertNotNull(attachment);

        assertThat(attachment.getName(), equalTo(fileName));
    }

    @Test
    public void testAttachFileFromUrl() throws IOException {
        // GIVEN

        URL url = new URL("https://trello.com/images/reco/Taco_idle.png");

        // WHEN
        Attachment attachment = new TrelloTemplate(API_KEY, API_TOKEN).boundCardOperations(CARD_ID).attach(null, url,
                "Taco", null);

        // THEN
        assertNotNull(attachment);
        assertNotNull(attachment);
        assertThat(attachment.getName(), equalTo("Taco"));
        assertTrue(attachment.getUrl().startsWith("http"));
        assertTrue(attachment.getUrl().endsWith("Taco_idle.png"));
    }

    @Test
    public void testAddChecklistToCard() throws IOException {
        // GIVEN

        // WHEN
        Checklist checklist = new TrelloTemplate(API_KEY, API_TOKEN).boundCardOperations(CARD_ID).addChecklist(null,
                null, null);

        // THEN
        assertNotNull(checklist);

        assertThat(checklist.getName(), equalTo("Checklist"));
        assertThat(checklist.getCheckItems().size(), equalTo(0));
    }

    @Test
    public void testAddLabelToCard() throws IOException {
        // TODO: prepare for test by removing all labels when the delete method
        // becomes available.

        // GIVEN

        TrelloTemplate trello = new TrelloTemplate(API_KEY, API_TOKEN);

        // WHEN
        trello.boundCardOperations(CARD_ID).deleteLabel("5830d2e384e677fd36663aaf");
        Label label = trello.boundCardOperations(CARD_ID).createLabel("blue", "blue");

        // THEN
        assertNotNull(label);
        assertTrue(label.getColor().equals("blue"));

        trello.boundCardOperations(CARD_ID).deleteLabel("5830d2e384e677fd36663aaf");
    }

    @Test
    public void testAddMemberToCard() throws IOException {
        // GIVEN

        TrelloTemplate trello = new TrelloTemplate(API_KEY, API_TOKEN);
        Member boardUser = trello.boundMemberOperations(USER).get();

        // PREPARE CARD
        List<Member> cardMembers = trello.boundCardOperations(CARD_ID).getMembers();
        if (!cardMembers.isEmpty()) {
            for (Member member : cardMembers) {
                trello.boundCardOperations(CARD_ID).deleteMember(member.getId());
            }
        }

        // WHEN
        trello.boundCardOperations(CARD_ID).addMember(boardUser.getId());

        List<Member> members = trello.boundCardOperations(CARD_ID).getMembers();

        // THEN
        assertNotNull(members);
        assertThat(members.size(), equalTo(1));
        Member resultMember = members.get(0);
        assertThat(resultMember.getId(), equalTo(boardUser.getId()));
    }

    @Test
    public void addMemberVote() throws IOException {
        TrelloTemplate trello = new TrelloTemplate(API_KEY, API_TOKEN);

        // GIVEN

        Member boardUser = trello.boundMemberOperations(USER).get();
        assertNotNull(boardUser);

        // CLEANUP
        List<Member> votedMembers = trello.boundCardOperations(CARD_ID).getMemberVotes();
        if (votedMembers != null && !votedMembers.isEmpty()) {
            for (Member member : votedMembers) {
                trello.boundCardOperations(CARD_ID).deleteVote(member.getId());
            }
        }
        // WHEN
        boolean voted = new TrelloTemplate(API_KEY, API_TOKEN).boundCardOperations(CARD_ID).vote(boardUser.getId());

        // THEN
        assertTrue(voted);
    }

    public void closeCard() {
        TrelloTemplate trello = new TrelloTemplate(API_KEY, API_TOKEN);

        ListOperations listOperations = trello.boundListOperations(LIST_ID);
        Card card = listOperations.createCard("CardServiceTest_closeCard", "", "", "", "", "", "", "");

        CardOperations cardOperations = trello.boundCardOperations(card.getId());

        try {
            cardOperations.setClosed(true);

            card = cardOperations.get();
            assertTrue(card.getClosed());
        } finally {
            cardOperations.delete();
        }
    }

    @Test
    public void deleteCard() {
        TrelloTemplate trello = new TrelloTemplate(API_KEY, API_TOKEN);

        // GIVEN

        Card card = trello.boundListOperations(ID_LIST).createCard("jUnitCard", null, null, null, null, null, null,
                null);

        // WHEN
        boolean deletedCard = trello.boundCardOperations(card.getId()).delete();

        // THEN
        assertTrue(deletedCard);
    }

    @Test
    public void deleteChecklistFromCard() {
        TrelloTemplate trello = new TrelloTemplate(API_KEY, API_TOKEN);

        // GIVEN

        Checklist checklist = trello.boundCardOperations(CARD_ID).addChecklist(null, null, null);

        // WHEN
        boolean deletedChecklist = trello.boundCardOperations(CARD_ID).deleteChecklist(checklist.getId());

        // THEN
        assertTrue(deletedChecklist);
    }

    @Test
    public void deleteLabelFromCard() {
        TrelloTemplate trello = new TrelloTemplate(API_KEY, API_TOKEN);

        // GIVEN

        // PREPARATION
        trello.boundCardOperations(CARD_ID).addLabel("5830d2e384e677fd36663aaf");

        // WHEN
        boolean deleted = trello.boundCardOperations(CARD_ID).deleteLabel("5830d2e384e677fd36663aaf");

        // THEN
        assertTrue(deleted);
    }

    // @Test
    // public void getCard() {
    // TrelloTemplate trello = new TrelloTemplate(API_KEY, API_TOKEN);
    //
    // // GIVEN
    //
    // // PREPARATION
    // Card card = trello.boundCardOperations(CARD_ID).get();
    //
    // // WHEN
    // boolean deleted =
    // trello.boundCardOperations(CARD_ID).deleteLabel("5830d2e384e677fd36663aaf");
    //
    // // THEN
    // assertTrue(deleted);
    // }

    @Test
    public void deleteMemberFromCard() throws IOException {
        TrelloTemplate trello = new TrelloTemplate(API_KEY, API_TOKEN);

        // GIVEN

        Member member = trello.boundMemberOperations(USER).get();

        // PREPARATION
        List<Member> members = trello.boundCardOperations(CARD_ID).getMembers();
        boolean needToAddMember = true;
        for (Member cardMember : members) {
            if (cardMember.getId().equals(member.getId()))
                needToAddMember = false;
        }
        if (needToAddMember)
            trello.boundCardOperations(CARD_ID).addMember(member.getId());

        // WHEN
        boolean removedMemberFromCard = trello.boundCardOperations(CARD_ID).deleteMember(member.getId());

        // THEN
        assertTrue(removedMemberFromCard);
    }

    @Test
    public void testDeleteMemberVoteFromCard() throws IOException {
        TrelloTemplate trello = new TrelloTemplate(API_KEY, API_TOKEN);

        // GIVEN

        Member boardUser = trello.boundMemberOperations(USER).get();
        assertNotNull(boardUser);

        List<Member> membersVoted = trello.boundCardOperations(CARD_ID).getMemberVotes();

        boolean needToAddVote = true;
        for (Member member : membersVoted) {
            if (member.getId().equals(boardUser.getId()))
                needToAddVote = false;
        }

        if (needToAddVote) {
            boolean addedVote = trello.boundCardOperations(CARD_ID).vote(boardUser.getId());
            assertTrue(addedVote);
        }

        // WHEN
        boolean removedFromCard = trello.boundCardOperations(CARD_ID).deleteVote(boardUser.getId());

        // THEN
        assertTrue(removedFromCard);
    }
}
