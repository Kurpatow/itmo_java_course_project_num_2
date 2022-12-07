package kurpatow.itmo.java.course_work_2.app_elements.section;

import java.util.HashSet;

public class IndentUtils {
    private static HashSet<Indent> indents;

    private IndentUtils() {}

    static {indentsInitialization();}

    private static void indentsInitialization() {
        indents = new HashSet<>(IndentInfo.NUMBER_OF_INDENTS);

        Indent fox = new Indent(IndentInfo.FOX_HEADING, IndentInfo.FOX_TEXT,
                IndentInfo.FOX_FIRST_REPLY, IndentInfo.FOX_SECOND_REPLY);

        Indent comeBackHome = new Indent(IndentInfo.COME_BACK_HOME_HEADING,IndentInfo.COME_BACK_HOME_TEXT);

        Indent goToSearch = new Indent(IndentInfo.GO_TO_SEARCH_HEADING, IndentInfo.GO_TO_SEARCH_TEXT,
                IndentInfo.GET_HONEY_FIRST_REPLY, IndentInfo.GO_TO_SEARCH_SECOND_REPLY);

        Indent askForestDwellers = new Indent(IndentInfo.ASK_FOREST_DWELLERS_HEADING,
                IndentInfo.ASK_FOREST_DWELLERS_TEXT,
                IndentInfo.ASK_FOREST_DWELLERS_FIRST_REPLY,
                IndentInfo.ASK_FOREST_DWELLERS_SECOND_REPLY);

        Indent searchAlone = new Indent(IndentInfo.SEARCH_ALONE_HEADING, IndentInfo.SEARCH_ALONE_TEXT);

        Indent askOwl = new Indent(IndentInfo.ASK_OWL_HEADING, IndentInfo.ASK_OWL_TEXT,
                IndentInfo.ASK_OWL_FIRST_REPLY, IndentInfo.ASK_OWL_SECOND_REPLY);

        Indent askWolf = new Indent(IndentInfo.ASK_WOLF_HEADING, IndentInfo.ASK_WOLF_TEXT,
                IndentInfo.ASK_WOLF_FIRST_REPLY, IndentInfo.ASK_WOLF_SECOND_REPLY);

        Indent trustOwl = new Indent(IndentInfo.TRUST_OWL_HEADING, IndentInfo.TRUST_OWL_TEXT,
                IndentInfo.TRUST_OWL_FIRST_REPLY, IndentInfo.TRUST_OWL_SECOND_REPLY);

        Indent getHoney = new Indent(IndentInfo.GET_HONEY_HEADING, IndentInfo.GET_HONEY_TEXT,
                IndentInfo.GET_HONEY_FIRST_REPLY, IndentInfo.GET_HONEY_SECOND_REPLY);

        Indent waitBees = new Indent(IndentInfo.WAIT_BEES_HEADING, IndentInfo.WAIT_BEES_TEXT,
                IndentInfo.WAIT_BEES_FIRST_REPLY,IndentInfo.WAIT_BEES_SECOND_REPLY);

        Indent stealHoney = new Indent(IndentInfo.STEAL_HONEY_HEADING, IndentInfo.STEAL_HONEY_TEXT);

        Indent relax = new Indent(IndentInfo.RELAX_HEADING, IndentInfo.RELAX_TEXT);

        Indent takeHoneyToBear = new Indent(IndentInfo.TAKE_HONEY_TO_BEAR_HEADING, IndentInfo.TAKE_HONEY_TO_BEAR_TEXT,
                IndentInfo.TAKE_HONEY_TO_BEAR_FIRST_REPLY, IndentInfo.TAKE_HONEY_TO_BEAR_SECOND_REPLY);

        fox.setFirstReply(comeBackHome);
        fox.setSecondReply(goToSearch);

        goToSearch.setFirstReply(askForestDwellers);
        goToSearch.setSecondReply(searchAlone);

        askForestDwellers.setFirstReply(askOwl);
        askForestDwellers.setSecondReply(askWolf);

        askOwl.setFirstReply(trustOwl);
        askOwl.setSecondReply(searchAlone);

        askWolf.setFirstReply(comeBackHome);
        askWolf.setSecondReply(searchAlone);

        trustOwl.setFirstReply(searchAlone);
        trustOwl.setSecondReply(getHoney);

        getHoney.setFirstReply(waitBees);
        getHoney.setSecondReply(stealHoney);

        waitBees.setFirstReply(relax);
        waitBees.setSecondReply(takeHoneyToBear);

        takeHoneyToBear.setFirstReply(searchAlone);
        takeHoneyToBear.setSecondReply(comeBackHome);

        indents.add(fox);
        indents.add(comeBackHome);
        indents.add(goToSearch);
        indents.add(askForestDwellers);
        indents.add(searchAlone);
        indents.add(askOwl);
        indents.add(askWolf);
        indents.add(trustOwl);
        indents.add(getHoney);
        indents.add(waitBees);
        indents.add(stealHoney);
        indents.add(relax);
        indents.add(takeHoneyToBear);
    }
    public static Indent getIndentHeading(String heading) {
        return indents.stream().filter(indent -> heading.equals(indent.getHeading())).findFirst().get();
    }
}
