package fr.iut.montreuil.S4_R4_02_2023.num_50.questionnaire_sme.impl;

import fr.iut.montreuil.S4_R4_02_2023.num_50.questionnaire_sme.entites.bo.QuestionnaireBO;
import fr.iut.montreuil.S4_R4_02_2023.num_50.questionnaire_sme.mocks.*;
import fr.iut.montreuil.S4_R4_02_2023.num_50.questionnaire_sme.modeles.InterfaceQuestionnaire;
import fr.iut.montreuil.S4_R4_02_2023.num_50.questionnaire_sme.modeles.QuestionnaireLoader;
import fr.iut.montreuil.S4_R4_02_2023.num_50.questionnaire_sme.utilies.exeptions.*;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.URI;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class serviceQuestionnaireBeanTest {

    InterfaceQuestionnaire serviceQuestionnaireBeanTest;
    @BeforeEach
    public void init(){
        serviceQuestionnaireBeanTest = new QuestionnaireLoader();
    }


    //Correct One
    @Test
    public void chargerFileQuestionnaireNoException() {
       // serviceQuestionnaireBeanTest = new AjouterQuestionnaireCorrectMock();
        QuestionnaireBO questionnaire = null;
        try {
            questionnaire = serviceQuestionnaireBeanTest.chargerFileQuestionnaire(URI.create("src/test/java/fr/iut/montreuil/S4_R4_02_2023/num_50/questionnaire_sme/ressources/questionsTrue.csv"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertTrue(questionnaire instanceof QuestionnaireBO);
    }


    //DoubleQuestionException
    @Test
    public void chargerFileQuestionnaireDoubleQuestionException(){
       // serviceQuestionnaireBeanTest = new AjouterQuestionnaireDoubleQuestionExceptionMock();
        assertThrows(DoubleQuestionException.class, () -> {
            serviceQuestionnaireBeanTest.chargerFileQuestionnaire(URI.create("src/test/java/fr/iut/montreuil/S4_R4_02_2023/num_50/questionnaire_sme/ressources/questionDoubleQuestionException.csv"));
        });
    }



    //ErrorWhileLoadingException
    @Test
    public void chargerFileQuestionnaireErrorWhileLoadingException(){
      //  serviceQuestionnaireBeanTest = new AjouterQuestionnaireErrorWhileLoadingExceptionMock();
            assertThrows(ErrorWhileLoadingException.class, () -> {
                serviceQuestionnaireBeanTest.chargerFileQuestionnaire(URI.create("src/test/java/fr/iut/montreuil/S4_R4_02_2023/num_50/questionnaire_sme/ressources/questionsErrorWhileLoadingException.csv"));
            });
    }



    //FileNotFoundException
    @Test
    public void chargerFileQuestionnaireFileNotFoundException(){
       // serviceQuestionnaireBeanTest = new AjouterQuestionnaireFileNoteFoundExceptionMock();

        URI path = URI.create("src/test/java/fr/iut/montreuil/S4_R4_02_2023/num_50/questionnaire_sme/ressources/EtBahNon.csv");

        assertThrows(FileNoteFoundExeption.class, () -> {
            serviceQuestionnaireBeanTest.chargerFileQuestionnaire(path);
        });
    }

    //IncompleteQuestionException
    @Test
    public void chargerFileQuestionnaireIncompleteQuestionException(){
      //  serviceQuestionnaireBeanTest = new AjouterQuestionnaireIncompleteQuestionExceptionMock();
        assertThrows(IncompleteQuestionException.class, () -> {
            serviceQuestionnaireBeanTest.chargerFileQuestionnaire(URI.create("src/test/java/fr/iut/montreuil/S4_R4_02_2023/num_50/questionnaire_sme/ressources/questionsIncompleteQuestionException.csv"));
        });
    }

    //QuestionnaireEmptyException
    @Test
    public void chargerFileQuestionnaireQuestionnaireEmptyException(){
      //  serviceQuestionnaireBeanTest = new AjouterQuestionnaireQuestionnaireEmptyExceptionMock();
        assertThrows(QuestionnaireEmptyException.class, () -> {
            serviceQuestionnaireBeanTest.chargerFileQuestionnaire(URI.create("src/test/java/fr/iut/montreuil/S4_R4_02_2023/num_50/questionnaire_sme/ressources/questionsQuestionnaireEmptyException.csv"));
        });
    }

    //WrongFileTypeException
    @Test
    public void chargerFileQuestionnaireWrongFileTypeException(){
  //      serviceQuestionnaireBeanTest = new AjouterQuestionnaireWrongFileTypeExceptionMock();
        assertThrows(WrongFileTypeException.class, () -> {
            serviceQuestionnaireBeanTest.chargerFileQuestionnaire(URI.create("src/test/java/fr/iut/montreuil/S4_R4_02_2023/num_50/questionnaire_sme/ressources/questionsWrongFileTypeException.csv.pdf"));
        });
    }
}
