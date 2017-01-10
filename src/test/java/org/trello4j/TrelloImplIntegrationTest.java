package org.trello4j;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.trello4j.core.TrelloTemplate;
import org.trello4j.model.Action;
import org.trello4j.model.Board;
import org.trello4j.model.Board.PERMISSION_TYPE;
import org.trello4j.model.Card;
import org.trello4j.model.Checklist;
import org.trello4j.model.Member;
import org.trello4j.model.Organization;
import org.trello4j.model.TrelloType;
import org.trello4j.model.Type;

/**
 * The Class TrelloImplIntegrationTest.
 */
public class TrelloImplIntegrationTest {

    private static final String BOARD_ID = "5830d0b8694ae8f1cdeecb46";
    private static final String CARD_ID = "58643da50130c162b124d9af";
    private static final String API_KEY = "b8a19fea9c86c56f92b47ba9841826c7";
    private static final String API_TOKEN = "a8379d5621ca307209024191609a5b39a972a3424cfe0c52952158e91c764117";

    @Test(expected = TrelloException.class)
    public void missingApiKey_shouldThrowException() {
        new TrelloTemplate(null);
    }

    @Test(expected = TrelloException.class)
    public void testInvalidObjectId() {
        // GIVEN
        String boardId = "INVALID_ID";

        // WHEN
        Board board = new TrelloTemplate(API_KEY, null).boundBoardOperations(boardId).get();

        // THEN
        assertNull("Oops, board is null", board);
    }

    @Test
    public void test404_shouldReturnNull() {
        // GIVEN
        String boardId = "00000000000000000000000c";

        // WHEN
        Board board = new TrelloTemplate(API_KEY, null).boundBoardOperations(boardId).get();

        // THEN
        assertNull("Oops, board is null", board);
    }

    @Test
    public void shouldReturnPublicBoard() {
        // GIVEN
        String boardId = BOARD_ID; // ID of Trello Development

        // WHEN
        Board board = new TrelloTemplate(API_KEY, null).boundBoardOperations(boardId).get();

        // THEN
        assertNotNull("Oops, board is null", board);
        assertEquals("Incorrect board id", boardId, board.getId());
        assertEquals("Incorrect name of board", "Trello4jTestes", board.getName());
        assertEquals("Incorrect organization id", "5870f9d7c942a4c1608914f8", board.getIdOrganization());
        assertTrue("Incorrect url", board.getUrl().equals("https://trello.com/b/s1hJhcKD/trello4jtestes")
                || board.getUrl().equals("https://trello.com/b/s1hJhcKD/trello4jtestes/4d5ea62fd76aa1136000000c"));
        assertFalse("This should be an open board", board.getClosed());
        assertNotNull(board.getDesc());
        assertNotNull(board.getPrefs());
        assertEquals(PERMISSION_TYPE.PUBLIC, board.getPrefs().getVoting());
    }

    @Test
    public void shouldReturnAction() {
        // GIVEN
        String actionId = "5870fe1ed8f0363d5d336fd2";

        // WHEN
        Action action = new TrelloTemplate(API_KEY, API_TOKEN).boundActionOperations(actionId).get();

        // THEN
        assertNotNull("Oops, action is null", action);
        assertEquals("Incorrect action id", actionId, action.getId());
        assertNotNull("Date not set", action.getDate());
        assertNotNull("idMemberCreator not set", action.getIdMemberCreator());

        assertNotNull("memberCreator not set", action.getMemberCreator());
        assertNotNull("memberCreator.id not set", action.getMemberCreator().getId());
        assertNotNull("memberCreator.username not set", action.getMemberCreator().getUsername());
        assertNotNull("memberCreator.fullName not set", action.getMemberCreator().getFullName());
        assertNotNull("memberCreator.initials not set", action.getMemberCreator().getInitials());

        assertNotNull("data not set", action.getData());
        assertNotNull("data.board not set", action.getData().getBoard());
        assertNotNull("data.board.id not set", action.getData().getBoard().getId());
        assertNotNull("data.board.name not set", action.getData().getBoard().getName());

    }

    @Test
    public void shouldReturnOrganization() {
        // GIVEN
        String organizationName = "glpprojects";

        // WHEN
        Organization org = new TrelloTemplate(API_KEY, API_TOKEN).boundOrganizationOperations(organizationName).get();

        // THEN
        assertNotNull("Oops, organization is null", org);
        assertEquals("Incorrect organization name", organizationName, org.getName());
    }

    @Test
    public void shouldReturnMemberByUsername() {
        // GIVEN
        String username = "guuilp";

        // WHEN
        Member member = new TrelloTemplate(API_KEY, null).boundMemberOperations(username).get();

        // THEN
        assertNotNull("Oops, member is null", member);
        assertNotNull("Avatar hash not set", member.getAvatarHash());
        assertEquals("Incorrect full name", "Guilherme Lima Pereira", member.getFullName());
        assertNotNull("ID not set", member.getId());
        assertTrue("Invalid count of boards", member.getIdBoards().size() > 0);
        assertTrue("Invalid count of organizations", member.getIdOrganizations().size() > 0);
        assertEquals("Incorrect initials", "GLP", member.getInitials());
        assertNotNull("Status not set", member.getStatus());
        assertEquals("Incorrect URL", "https://trello.com/guuilp", member.getUrl());
        assertEquals("Incorrect username", username, member.getUsername());
    }

    @Test
    public void shouldReturnMemberById() {
        // GIVEN
        String memberId = "53ff0a355857f729ee3dc9d7";

        // WHEN
        Member member = new TrelloTemplate(API_KEY, null).boundMemberOperations(memberId).get();

        // THEN
        assertNotNull("Oops, member is null", member);
        assertEquals("Incorrect username", "guuilp", member.getUsername());
    }

    @Test
    public void shouldReturnBoardsByOrganization() {
        // GIVEN
        String organizationName = "glpprojects";
        String trelloDevBoardId = BOARD_ID;

        // WHEN
        List<Board> boards = new TrelloTemplate(API_KEY, API_TOKEN).boundOrganizationOperations(organizationName)
                .getBoards();

        // THEN
        assertTrue("Organization should have at least one board", boards.size() > 0);
        assertTrue("Organization FogCreek should have Trello Development board",
                hasBoardWithId(boards, trelloDevBoardId));
    }

    @Test
    public void shouldReturnActionsByBoard() {
        // GIVEN
        String trelloDevBoardId = BOARD_ID;

        // WHEN
        List<Action> actions = new TrelloTemplate(API_KEY, API_TOKEN).boundBoardOperations(trelloDevBoardId)
                .getActions();

        // THEN
        assertTrue("Board should have at least one action", actions.size() > 0);
        assertEquals("Board id and action.data.board.id should be equal", trelloDevBoardId,
                actions.get(0).getData().getBoard().getId());
    }

    @Test
    public void shouldReturnCard() {
        // WHEN
        Card card = new TrelloTemplate(API_KEY, API_TOKEN).boundCardOperations(CARD_ID).get();

        // THEN
        assertNotNull("Oops, card is null", card);
        assertEquals("Card id should be equal", CARD_ID, card.getId());
        assertNotNull(card.getDateLastActivity());

    }

    @Test
    public void shouldReturnList() {
        // GIVEN
        String listId = "4e7b86d7ce194786721560b8";

        // WHEN
        org.trello4j.model.List list = new TrelloTemplate(API_KEY, null).boundListOperations(listId).get();

        // THEN
        assertNotNull("Oops, list is null", list);
        assertEquals("Card id should be equal", listId, list.getId());
    }

    @Test
    public void shouldReturnBoardsByMember() {
        // GIVEN
        String userId = "guuilp";

        // WHEN
        List<Board> boards = new TrelloTemplate(API_KEY, API_TOKEN).boundMemberOperations(userId).getBoards();

        // THEN
        assertNotNull("Oops, board list is null", boards);
        assertTrue("Member should have at least one board", boards.size() > 0);
    }

    @Test
    public void shouldReturnActionsByOrganization() {
        // GIVEN
        String organizationName = "glpprojects";

        // WHEN
        List<Action> actions = new TrelloTemplate(API_KEY, API_TOKEN).boundOrganizationOperations(organizationName)
                .getActions();

        // THEN
        assertNotNull("Oops, action list is null", actions);
        assertTrue("Organization should have at least one action", actions.size() > 0);
    }

    @Test
    public void shouldReturnChecklist() {
        // GIVEN
        String checklistId = "4f92b89ea73738db6cdd4ed7";

        // WHEN
        Checklist checklist = new TrelloTemplate(API_KEY, API_TOKEN).boundChecklistOperations(checklistId).get();

        // THEN
        assertNotNull("Oops, checklist list is null", checklist);
        assertEquals("Checklist id should match", checklistId, checklist.getId());
    }

    @Test
    public void shouldReturnTypeById() {
        // GIVEN
        String typeId = "4eb3f3f1e679eb839b4c594b";

        // WHEN
        Type type = new TrelloTemplate(API_KEY, null).getType(typeId);

        // THEN
        assertNotNull("Oops, type is null", type);
        assertEquals("Incorrect id", typeId, type.getId());
        assertEquals("Incorrect trello type", TrelloType.ORGANIZATION, type.getType());
    }

    @Test
    public void shouldReturnTypeByName() {
        // GIVEN
        String typeName = "fogcreek";

        // WHEN
        Type type = new TrelloTemplate(API_KEY, null).getType(typeName);

        // THEN
        assertNotNull("Oops, type is null", type);
        assertEquals("Incorrect trello type", TrelloType.ORGANIZATION, type.getType());
    }

    /**
     * Checks for board with id.
     *
     * @param boards
     *            the boards
     * @param id
     *            the id
     * @return true, if successful
     */
    private boolean hasBoardWithId(List<Board> boards, String id) {
        boolean res = false;
        for (Board board : boards) {
            if (board.getId().equals(id)) {
                res = true;
                break;
            }
        }
        return res;
    }
}
