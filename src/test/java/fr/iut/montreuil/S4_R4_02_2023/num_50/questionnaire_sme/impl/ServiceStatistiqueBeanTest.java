package fr.iut.montreuil.S4_R4_02_2023.num_50.questionnaire_sme.impl;

//jupiter

import fr.iut.montreuil.S4_R4_02_2023.num_50.questionnaire_sme.mocks.serviceStat.*;
import fr.iut.montreuil.S4_R4_02_2023.num_50.questionnaire_sme.modeles.InterfaceQuestionStatistique;
import fr.iut.montreuil.S4_R4_02_2023.num_50.questionnaire_sme.modeles.InterfaceQuestionnaireStatistique;
import org.junit.jupiter.api.BeforeEach;
//import assertEqual
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class ServiceStatistiqueBeanTest {
    InterfaceQuestionStatistique serviceQuestionStatistiqueBeanTest;
    InterfaceQuestionnaireStatistique serviceQuestionnaireStatistiqueBeanTest;

    @BeforeEach
    public void init(){
        //serviceQuestionStatistiqueBeanTest = new aRemplacer();
        //serviceQuestionnaireStatistiqueBeanTest = new aRemplacer();
    }

    //test init  question
    @Test
    public void testIncrementNbrFoisJouer() {
        serviceQuestionStatistiqueBeanTest = new InitQuestionStatCorrectMock();
        //assertEqual

       assertEquals(0, serviceQuestionStatistiqueBeanTest.getNbReussi());
         assertEquals(0, serviceQuestionStatistiqueBeanTest.getNbRate());
    }
    //test init  questionnaire
    @Test
    public void testIncrementNbrFoisJouerQuestionnaire() {
        serviceQuestionnaireStatistiqueBeanTest = new InitQuestionnaireStatCorrectMock();
        //assertEqual
        assertEquals(0, serviceQuestionnaireStatistiqueBeanTest.getNbJouer());
    }

    //test increment reussi  question
    @Test
    public void testIncrementNbrFoisJouerCorrect() {
        serviceQuestionStatistiqueBeanTest = new IncrementReussiQuestionCorrectMock();
        //assertEqual

        serviceQuestionStatistiqueBeanTest.incrementNbrFoisReussi();
        assertEquals(1, serviceQuestionStatistiqueBeanTest.getNbReussi());

    }
    //test increment nbrFoisJouer  question
    @Test
    public void testIncrementNbrFoisJouerRate() {

        //assertEqual

        serviceQuestionStatistiqueBeanTest = new IncrementNbrFoisJouerQuestionCorrectMock();
        serviceQuestionStatistiqueBeanTest.incrementNbrFoisJouer();
        assertEquals(1, serviceQuestionStatistiqueBeanTest.getNbRate());

    }
    //test increment correct questionnaire
    @Test
    public void testIncrementNbrFoisJouerQuestionnaireCorrect() {
        serviceQuestionnaireStatistiqueBeanTest = new IncrementNbrFoisJouerQuestionnaireCorrectMock();
        //assertEqual
        serviceQuestionnaireStatistiqueBeanTest.incrementNbrFoisJouer();
        assertEquals(1, serviceQuestionnaireStatistiqueBeanTest.getNbJouer());
    }
    //test getStatistiqueReussi
    @Test
    public void testGetStatistiqueReussi() {
        serviceQuestionStatistiqueBeanTest = new GetStatistiqueReussiCorrectMock();
        //assertEqual
        try {
            assertEquals(0.5, serviceQuestionStatistiqueBeanTest.getStatistiqueReussi());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //test getStatistiqueQuestionPasJouer
    @Test
    public void testGetStatistiqueQuestionPasJouer() {
        serviceQuestionStatistiqueBeanTest = new GetStatistiqueReussiQuestionPasJouerExceptionMock();
        //assertEqual
        assertThrows(Exception.class, () -> {
            serviceQuestionStatistiqueBeanTest.getStatistiqueReussi();
        });
    }
}
