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
        ajouterQuestionnaireCorrectMock i = new ajouterQuestionnaireCorrectMock();
        QuestionnaireBO q = null;
        try {
            q = i.chargerFileQuestionnaire(URI.create("../questionsTrue.csv"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertTrue(q instanceof QuestionnaireBO);
    }


    //DoubleQuestionException
    @Test
    public void chargerFileQuestionnaireDoubleQuestionException(){
        ajouterQuestionnaireDoubleQuestionExceptionMock i0 = new ajouterQuestionnaireDoubleQuestionExceptionMock();
        assertThrows(DoubleQuestionException.class, () -> {
            i0.chargerFileQuestionnaire(URI.create("../questionsTrue.csv"));
        });
    }



    //ErrorWhileLoadingException
    @Test
    public void chargerFileQuestionnaireErrorWhileLoadingException(){
        ajouterQuestionnaireErrorWhileLoadingExceptionMock i1 = new ajouterQuestionnaireErrorWhileLoadingExceptionMock();
            assertThrows(ErrorWhileLoadingException.class, () -> {
                i1.chargerFileQuestionnaire(URI.create("../questionsErrorWhileLoadingException.csv"));
            });
    }



    //FileNotFoundException
    @Test
    public void chargerFileQuestionnaireFileNotFoundException(){
        ajouterQuestionnaireFileNoteFoundExceptionMock i2 = new ajouterQuestionnaireFileNoteFoundExceptionMock();
        assertThrows(FileNoteFoundExeption.class, () -> {
            i2.chargerFileQuestionnaire(URI.create("../EhBahNon.csv"));
        });
    }

    //IncompleteQuestionException
    @Test
    public void chargerFileQuestionnaireIncompleteQuestionException(){
        ajouterQuestionnaireIncompleteQuestionExceptionMock i3 = new ajouterQuestionnaireIncompleteQuestionExceptionMock();
        assertThrows(IncompleteQuestionException.class, () -> {
            i3.chargerFileQuestionnaire(URI.create("../questionIncompleteQuestionException.csv"));
        });
    }

    //QuestionnaireEmptyException
    @Test
    public void chargerFileQuestionnaireQuestionnaireEmptyException(){
        ajouterQuestionnaireQuestionnaireEmptyExceptionMock i4 = new ajouterQuestionnaireQuestionnaireEmptyExceptionMock();
        assertThrows(QuestionnaireEmptyException.class, () -> {
            i4.chargerFileQuestionnaire(URI.create("../questionQuestionnaireEmptyException.csv"));
        });
    }

    //WrongFileTypeException
    @Test
    public void chargerFileQuestionnaireWrongFileTypeException(){
        ajouterQuestionnaireWrongFileTypeExceptionMock i5 = new ajouterQuestionnaireWrongFileTypeExceptionMock();
        assertThrows(WrongFileTypeException.class, () -> {
            i5.chargerFileQuestionnaire(URI.create("../questionsWrongFileTypeException.csv.pdf"));
        });
    }
}
