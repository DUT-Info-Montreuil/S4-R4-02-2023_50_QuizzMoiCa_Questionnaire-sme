package fr.iut.montreuil.S4_R4_02_2023.num_50.questionnaire_sme.impl;

import fr.iut.montreuil.S4_R4_02_2023.num_50.questionnaire_sme.entites.bo.QuestionnaireBO;
import fr.iut.montreuil.S4_R4_02_2023.num_50.questionnaire_sme.mocks.*;
import fr.iut.montreuil.S4_R4_02_2023.num_50.questionnaire_sme.utilies.exeptions.*;
import org.junit.Test;

import java.net.URI;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class serviceQuestionnaireBeanTest {


    //Correct One
    @Test
    public void chargerFileQuestionnaireNoException() {
        AjouterQuestionnaireCorrectMock i = new AjouterQuestionnaireCorrectMock();
        QuestionnaireBO questionnaire = null;
        try {
            questionnaire = i.chargerFileQuestionnaire(URI.create("../questionsTrue.csv"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertTrue(questionnaire instanceof QuestionnaireBO);
    }


    //DoubleQuestionException
    @Test
    public void chargerFileQuestionnaireDoubleQuestionException(){
        AjouterQuestionnaireDoubleQuestionExceptionMock doubleQuestionException = new AjouterQuestionnaireDoubleQuestionExceptionMock();
        assertThrows(DoubleQuestionException.class, () -> {
            doubleQuestionException.chargerFileQuestionnaire(URI.create("../questionsTrue.csv"));
        });
    }



    //ErrorWhileLoadingException
    @Test
    public void chargerFileQuestionnaireErrorWhileLoadingException(){
        AjouterQuestionnaireErrorWhileLoadingExceptionMock i1 = new AjouterQuestionnaireErrorWhileLoadingExceptionMock();
            assertThrows(ErrorWhileLoadingException.class, () -> {
                i1.chargerFileQuestionnaire(URI.create("../questionsErrorWhileLoadingException.csv"));
            });
    }



    //FileNotFoundException
    @Test
    public void chargerFileQuestionnaireFileNotFoundException(){
        AjouterQuestionnaireFileNoteFoundExceptionMock i2 = new AjouterQuestionnaireFileNoteFoundExceptionMock();
        assertThrows(FileNoteFoundExeption.class, () -> {
            i2.chargerFileQuestionnaire(URI.create("../EhBahNon.csv"));
        });
    }

    //IncompleteQuestionException
    @Test
    public void chargerFileQuestionnaireIncompleteQuestionException(){
        AjouterQuestionnaireIncompleteQuestionExceptionMock i3 = new AjouterQuestionnaireIncompleteQuestionExceptionMock();
        assertThrows(IncompleteQuestionException.class, () -> {
            i3.chargerFileQuestionnaire(URI.create("../questionIncompleteQuestionException.csv"));
        });
    }

    //QuestionnaireEmptyException
    @Test
    public void chargerFileQuestionnaireQuestionnaireEmptyException(){
        AjouterQuestionnaireQuestionnaireEmptyExceptionMock i4 = new AjouterQuestionnaireQuestionnaireEmptyExceptionMock();
        assertThrows(QuestionnaireEmptyException.class, () -> {
            i4.chargerFileQuestionnaire(URI.create("../questionQuestionnaireEmptyException.csv"));
        });
    }

    //WrongFileTypeException
    @Test
    public void chargerFileQuestionnaireWrongFileTypeException(){
        AjouterQuestionnaireWrongFileTypeExceptionMock i5 = new AjouterQuestionnaireWrongFileTypeExceptionMock();
        assertThrows(WrongFileTypeException.class, () -> {
            i5.chargerFileQuestionnaire(URI.create("../questionsWrongFileTypeException.csv.pdf"));
        });
    }
}
