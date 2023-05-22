package fr.iut.montreuil.S4_R4_02_2023.num_50.questionnaire_sme.impl;

import fr.iut.montreuil.S4_R4_02_2023.num_50.questionnaire_sme.entites.bo.QuestionnaireBO;
import fr.iut.montreuil.S4_R4_02_2023.num_50.questionnaire_sme.modeles.InterfaceQuestionnaire;
import fr.iut.montreuil.S4_R4_02_2023.num_50.questionnaire_sme.utilies.exeptions.*;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class serviceQuestionnaireBeanTest {

    InterfaceQuestionnaire serviceQuestionnaireBeanTest;

    //Correct One
    @Test
    public void chargerFileQuestionnaire(){


    }

    //DoubleQuestionException
    @Test
    public void chargerFileQuestionnaire(){
        try {
            QuestionnairesBo q = QuestionnairesBo;
            q.add(serviceQuestionnaireBeanTest.chargerFileQuestionnaire("blabla"));
            q.add(serviceQuestionnaireBeanTest.chargerFileQuestionnaire("blabla"));
        }catch DoubleQuestionException e{
            e.printStackTrace();
            assertTrue(e.equals(DoubleQuestionException));
        }
        return false;
    }

    //ErrorWhileLoadingException
    @Test
    public void chargerFileQuestionnaire(){
        try {
            QuestionnairesBo q = QuestionnairesBo;
            q.add(serviceQuestionnaireBeanTest.chargerFileQuestionnaire(null));
        }catch ErrorWhileLoadingException e{
            e.printStackTrace();
            assertTrue(e.equals(ErrorWhileLoadingException));
        }
        return false;
    }

    //FileNotFoundException
    @Test
    public void chargerFileQuestionnaire(){
        try {
            QuestionnairesBo q = QuestionnairesBo;
            q.add(serviceQuestionnaireBeanTest.chargerFileQuestionnaire("kllkfe,zef"));
        }catch FileNoteFoundExeption e{
            e.printStackTrace();
            assertTrue(e.equals(FileNoteFoundExeption));
        }
        return false;
    }

    //IncompleteQuestionException
    @Test
    public void chargerFileQuestionnaire(){
        try {
            QuestionnairesBo q = QuestionnairesBo;
            q.add(serviceQuestionnaireBeanTest.chargerFileQuestionnaire("QuestionnaireQuestionIncomplette"));
        }catch IncompleteQuestionException e{
            e.printStackTrace();
            assertTrue(e.equals(IncompleteQuestionException));
        }
        return false;
    }

    //QuestionnaireEmptyException
    @Test
    public void chargerFileQuestionnaire(){
        try {
            QuestionnairesBo q = QuestionnairesBo;
            q.add(serviceQuestionnaireBeanTest.chargerFileQuestionnaire("QuestionnaireEmpty"));
        }catch QuestionnaireEmptyException e{
            e.printStackTrace();
            assertTrue(e.equals(QuestionnaireEmptyException));
        }
        return false;
    }

    //WrongFileTypeException
    @Test
    public void chargerFileQuestionnaire(){
        try {
            QuestionnairesBo q = QuestionnairesBo;
            q.add(serviceQuestionnaireBeanTest.chargerFileQuestionnaire("QuestionnaireEmpty.pdf"));
        }catch WrongFileTypeException e{
            e.printStackTrace();
            assertTrue(e.equals(WrongFileTypeException));
        }
        return false;
    }
}
