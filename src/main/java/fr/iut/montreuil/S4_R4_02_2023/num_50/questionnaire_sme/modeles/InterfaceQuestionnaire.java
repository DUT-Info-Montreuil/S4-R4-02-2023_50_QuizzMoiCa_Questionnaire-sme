package fr.iut.montreuil.S4_R4_02_2023.num_50.questionnaire_sme.modeles;


import fr.iut.montreuil.S4_R4_02_2023.num_50.questionnaire_sme.entites.bo.QuestionnaireBO;
import fr.iut.montreuil.S4_R4_02_2023.num_50.questionnaire_sme.utilies.exeptions.*;


public interface InterfaceQuestionnaire {

    public QuestionnaireBO chargerFileQuestionnaire()throws FileNoteFoundExeption, ErrorWhileLoadingException, QuestionnaireEmptyException, DoubleQuestionException;
}
