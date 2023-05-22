package fr.iut.montreuil.S4_R4_02_2023.num_50.questionnaire_sme.impl;

import fr.iut.montreuil.S4_R4_02_2023.num_50.questionnaire_sme.entites.bo.QuestionBO;
import fr.iut.montreuil.S4_R4_02_2023.num_50.questionnaire_sme.entites.bo.QuestionnaireBO;
import fr.iut.montreuil.S4_R4_02_2023.num_50.questionnaire_sme.entites.dto.QuestionnaireDTO;
import fr.iut.montreuil.S4_R4_02_2023.num_50.questionnaire_sme.mocks.ajouterQuestionnaireCorrectMock;
import fr.iut.montreuil.S4_R4_02_2023.num_50.questionnaire_sme.mocks.ajouterQuestionnaireIncorectMock;
import fr.iut.montreuil.S4_R4_02_2023.num_50.questionnaire_sme.modeles.InterfaceQuestionnaire;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

public class serviceQuestionnaireBeanTest {

    InterfaceQuestionnaire serviceQuestionnaireBeanTest;

    //Correct One
    @Test
    public void chargerFileQuestionnaire(){

        try {
            QuestionnaireBo questionnaire = new QuestionnaireBO(10, new ArrayList<QuestionBO>());
            serviceQuestionnaireBeanTest = new ajouterQuestionnaireCorrectMock();
            QuestionnaireBO questionnaireResultat = new ajouterQuestionnaireCorrectMock().chargerFileQuestionnaire(10, new ArrayList<QuestionBO>());

            Assertions.assertSame(questionnaire, questionnaireResultat);

        }catch Exception e{
             e.printStackTrace();
        }
    }

    //Incorect one
    @Test
    public void chargerFileQuestionnaire(){

        try {
            QuestionnaireBo questionnaire = new QuestionnaireBO(10, new ArrayList<QuestionBO>());
            serviceQuestionnaireBeanTest = new ajouterQuestionnaireIncorectMock();
            QuestionnaireBO questionnaireResultat = new ajouterQuestionnaireIncorectMock().chargerFileQuestionnaire(10, new ArrayList<QuestionBO>());

            Assertions.assertSame(questionnaire, questionnaireResultat);

        }catch Exception e{
            e.printStackTrace();
        }
    }
}
